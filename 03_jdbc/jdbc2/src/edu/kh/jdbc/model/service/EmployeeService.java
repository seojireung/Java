package edu.kh.jdbc.model.service;

// JDBCTemplate에 있는 static 메서드를 가져와 자신의 것처럼 사용
import static edu.kh.jdbc.common.JDBCTemplate.*;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmployeeDAO;
import edu.kh.jdbc.model.dto.Employee;

// Model : 데이터 논리 구조 제어 (트랜잭션 제어), 데이터 가공 처리 => *비즈니스 로직*
//		   DAO 수행 결과를 View / Controller 로 반환 등등의 역할
//	-> 프로그램(앱)에 포함되어야 할 데이터에 대한 정의

// Service : 비즈니스 로직
//	-> 요청에 따른 필요 데이터 반환
//   + 트랜잭션 제어 처리(Commit, Rollback)
public class EmployeeService {

	// dao에 여러 SQL을 수행하기 위한 메서드를 각각 작성하여 호출
	// service 하나가 dao 여러번(db 왔다갔다 필요한 만큼) 실행
	private EmployeeDAO dao = new EmployeeDAO();

	/** 전체 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll() throws SQLException {
		
		// DB에서 필요한 데이터를 조회하기 위해
		// DAO 메서드를 호출
		
		// 1. 커넥션 생성
		// -> Service가 트랜잭션 제어(commit/rollback) 처리를 하기 위해서는
		// Connection 객체가 service에 존재해야 함
		// --> 만약 DAO에서 Connection을 만들고 반환하면
		//     Service쪽에서 Connection을 사용할 수 없게 됨.
		
		// --> 커넥션이 서비스에 있음
		//	--> 다 쓰고 닫아주는 close() 구문이 필요하다.
		//  ==> 서비스에 conn.close()를 작성해야 함
		Connection conn = getConnection();
		
		// 2. DAO의 메서드를 호출하여
		//	  필요한 결과를 DB에서 조회해서 반환 받기
		List<Employee> empList = dao.selectAll(conn);
		
		// ** DML 구문인 경우 해당 위치에 commit / rollback 구문 작성 **
		// 지금은 DTL.
		
		// 3. Connection 반환
		close(conn); // JDBCTemplate 작성된 메서드 호출
		
		// 4. 결과 반환
		return empList;
		
	}

	/** 사원 1명 정보 반환
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Employee selectOne(int input) throws SQLException {
		
		// 1. Connection 생성 
		Connection conn = getConnection(); // JDBCTemplate에 만들어 논거
		
		// 2. DAO 메서드 호출(매개변수 2개 : 커넥션, input 값)
		Employee emp = dao.selectOne(conn, input);
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return emp;
	}

	/** 이름에 글자가 포함된 사원 조회 서비스
	 * @param words
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectName(String words) throws SQLException {
		
		Connection conn = getConnection();
		
		List<Employee> empList = dao.selectName(conn, words);
		
		close(conn);
		
		return empList;
		
	}

	/**
	 * @param minSal
	 * @param maxSal
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectSalary(int minSal, int maxSal) throws SQLException{
		
		Connection conn = getConnection();
		List<Employee> empList = dao.selectSalary(conn,minSal,maxSal);
		close(conn);
		
		return empList;
	}

	/** 사원 추가 서비스
	 * @param conn, emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmployee(Employee emp) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.insertEmployee(conn, emp);
		
		// DAO에서 DML(INSERT) 수행
		// -> 트랜잭션에 임시 저장
		// -> 수행 결과에 따라 commit, rollback 지정
		
		if(result>0) // 삽입 성공 시
			commit(conn);
		else // 삽입 실패 시
			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 반환
		return result;
	}

	/** 회원 정보 수정 서비스
	 * @param conn, emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmployee(Employee emp) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.updateEmployee(conn, emp);
		
		// DML 수행 -> 트랜잭션(COMMIT / ROLLBACK) 제어 처리
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사번으로 퇴사 처리 서비스
	 * @param conn, input
	 * @return result
	 * @throws Exception
	 */
	public int retireEmployee(int input) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.retireEmployee(conn, input);
		
		if(result>0) commit(conn);
		else 		 rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
}
