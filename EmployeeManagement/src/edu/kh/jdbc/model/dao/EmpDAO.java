package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/** 재직중인 사원의 정보 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmployees(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, "
					+ "NVL(DEPT_TITLE, '없음'), JOB_NAME, SALARY, EMAIL, "
					+ "NVL(PHONE, '없음')\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String email = rs.getString(6);
				String phone = rs.getString(7);
				
				empList.add(new Emp(empId, empName, departmentTitle, jobName, salary, email, phone));
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}


	/**  퇴직한 사원 전체 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetirees(Connection conn) throws SQLException{
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(PHONE, '없음'), EMAIL, TO_CHAR(ENT_DATE, 'YYYY\"년\" MM\"월\" DD\"일\"') ENT_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate  = rs.getString(5); // TO_CHAR로 형변환 해서 조회
				
				empList.add(new Emp(empId,empName,phone,email,entDate));
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}


	/** 사번이 일치하는 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectEmpId(Connection conn, int input) throws SQLException {
		
		Emp emp = null; // 조회 결과가 없으면 null 반환
	//  Emp emp = new Emp(); // 만 적으면 존재하지 않는 사번 입력해도 객체의 주소를 참조 하기 때문에 존재하지 않는 사번이란 걸 찾을 수 없음.
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME , NVL(DEPT_TITLE, '없음'), \r\n"
					+ "JOB_NAME , SALARY, NVL(PHONE, '없음'), EMAIL, HIRE_DATE, DECODE(ENT_YN, 'N','재직중','Y','퇴사')\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {// 가독성 때문에 아래처럼 변수 사용해서 사용하는 것 요즘 선호
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entYN = rs.getString(9);
				
				emp = new Emp(); // 조회 결과가 있으면 새 emp에 담음. 
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(departmentTitle);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setHireDate(hireDate);
				emp.setEntYN(entYN);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return emp;
	}


	/** 사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmp(Connection conn, Emp emp) throws SQLException {
		int result = 0;
		
		try {
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID2.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			result = pstmt.executeUpdate();			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 사원 정보를 수정하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateInfo(Connection conn, Emp emp) throws SQLException {
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET EMAIL = ?, PHONE = ?, SALARY = ?, BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			// 수행 후 결과 반환 받아 결과 저장용 변수에 저장
			// SELECT문 : executeQuery([SQL])
			// DML문 : executeUpdate([SQL])
			// [SQL] 작성하는 경우 : Statement 객체 사용 할 때
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}


	/** 사원을 삭제하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteInfo(Connection conn, int input) throws SQLException {
		int result = 0;
		
		try {
			String sql = "DELETE FROM EMPLOYEE\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}


	/** 퇴사 처리 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public void retireEmployee(Connection conn, int input) throws SQLException {
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET ENT_YN = 'Y', ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.executeQuery(); // 수행만.
			
		} finally {
			close(pstmt);
		}
	}


	/** 존재하는 사원인지, 퇴직한 사원인지 조회하는 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException {

		int check = 0;
		
		try {
			String sql = "SELECT CASE\r\n"
					+ "		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0\r\n"
					+ "		THEN 0\r\n"
					+ "		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1\r\n"
					+ "		THEN 1\r\n"
					+ "		ELSE 2\r\n"
					+ "	END \"CHECK\"\r\n"
					+ "FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return check;
	}


	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException{
		
		//1. 결과 저장용 객체 생성
		List<Map<String,Object>> mapList = new ArrayList<>();
		
		try {
			//2. SQL 작성 후 수행
			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String,Object> map = new LinkedHashMap<>();
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				mapList.add(map);
			}
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		//5. 결과 반환
		return mapList;
	}
	
	
	
	
	
	
	
	
}
