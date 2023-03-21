package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO (Data Access Object) : DB 접근용 객체
public class EmployeeDAO {
	
	// JDBC 구문이 여러 번 작성될 예정
	// -> JDBC 객체 참조 변수가 계속 작성될 예정
	// 		-> 필드로 작성하여 재사용
	
	private Statement stmt;
	private ResultSet rs;
	
	
	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {
		
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입 (Connection은 매개변수 통해 값이 있음)
			
			// 1) SQL 작성
			// 사번, 이름, 부서명, 직급명, 전화번호
			// 직급코드 오름차순
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "NATURAL JOIN JOB "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "ORDER BY JOB_CODE";
					
			stmt = conn.createStatement(); // Statement 객체 생성
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
			while(rs.next()) {
				
				int empId = rs.getInt(1); //"EMP_ID"
				// DB에서 값을 얻어올 때
				//"숫자"(문자열로 된 숫자) 형태일 경우
				// getInt()를 작성하면 자동으로 int 형변환 진행
				String empName = rs.getString(2); //"EMP_NAME"
				String departmentName = rs.getString(4); //"DEPT_TITLE"
				String jobName = rs.getString(5); //"JOB_NAME"
				String phone = rs.getString(3); //"PHONE"
				
				Employee emp = new Employee(empId,
						empName, phone, departmentName, jobName);
				
				empList.add(emp); // 리스트 추가
			}
			
		} finally { // 예외 발생 하든 말든 무조건 수행
			// catch문 따로 작성x -> throws 구문 예외 처리
			
			// 4. JDBC 객체 자원 반환 (단, conn 빼고)
			close(stmt);
			close(rs);
			
		}
		// 5. 결과 반환
		return empList;
	}


	/** 사원 1명 정보 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException {
		
		// 1. 결과 저장을 위한 변수 / 객체 준비
		Employee emp = null;
		// -> 조회 결과가 있을 경우에 객체 생성한다고 생각.
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "NATURAL JOIN JOB "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과가 있는지 확인 후 == 1행 조회 성공
			//	  있으면 Employee 객체 생성 후 emp에 대입
			
			// if(조건식){true이면 수행} --> 1번 수행
			// while(조건식){true이면 수행} + 반복
			//	--> 1행만 조회되면 1번 수행
			// 	--> 불필요한 검사를 진행할 수 있음
			// 	 --> 1행 조회에서는 if문 권장!
			
			if(rs.next()) {
				
				int empId = rs.getInt(1); //"EMP_ID"
				String empName = rs.getString(2); //"EMP_NAME"
				String departmentName = rs.getString(3); //"DEPT_TITLE"
				String jobName = rs.getString(4); //"JOB_NAME"
				String phone = rs.getString(5); //"PHONE"
				
				emp = new Employee(empId, empName, phone, departmentName, jobName);
			}
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 빼고)
			close(rs);
			close(stmt);
		}
		
		// 5. 결과 반환
		return emp;
	}


	/** 글자 포함 이름 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param words
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectName(Connection conn, String words) throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
		String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "NATURAL JOIN JOB\r\n"
				+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "WHERE EMP_NAME LIKE '%" + words + "%' "
				+ "ORDER BY EMP_ID";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			
			int empId = rs.getInt(1); //"EMP_ID"
			String empName = rs.getString(2); //"EMP_NAME"
			String departmentName = rs.getString(3); //"DEPT_TITLE"
			String jobName = rs.getString(4); //"JOB_NAME"
			String phone = rs.getString(5); //"PHONE"
			
//			Employee emp = new Employee(empId,
//					empName, phone, departmentName, jobName);
//			empList.add(emp); 
			// 한 줄로 ↓
			empList.add(new Employee(empId,
					empName, phone, departmentName, jobName));
		}
		
		} finally {
			close(rs);
			close(stmt);
		}
		
		return empList;
	}


	/**
	 * @param conn
	 * @param minSal
	 * @param maxSal
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectSalaryRange(Connection conn, int minSal, int maxSal) throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE, SALARY\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "NATURAL JOIN JOB\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE SALARY BETWEEN '" + minSal + "' AND '" + maxSal + "'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1); //"EMP_ID"
				String empName = rs.getString(2); //"EMP_NAME"
				String departmentName = rs.getString(3); //"DEPT_TITLE"
				String jobName = rs.getString(4); //"JOB_NAME"
				String phone = rs.getString(5); //"PHONE"
				int salary = rs.getInt(6); //"SALARY"
				
				empList.add(new Employee(empId,
						empName, phone, departmentName, jobName, salary));
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return empList;
	}
	
	
	
	
	

}