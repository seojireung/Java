package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/** 재직중인 사원 전체의 정보를 조회하는 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmployees() throws SQLException{
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectEmployees(conn);
		
		close(conn);
		
		return empList;
	}

	/** 퇴직한 사원 전체 조회 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetirees() throws SQLException {
		Connection conn = getConnection();
		List<Emp> empList = dao.selectRetirees(conn);
		close(conn);
		return empList;
	}

	/** 사번이 일치하는 사원 정보 반환 서비스
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectEmpId(int input) throws SQLException{
		Connection conn = getConnection();
		Emp emp = dao.selectEmpId(conn, input);
		close(conn);
		
		return emp;
	}

	/** 사원 추가 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmp(Emp emp)throws SQLException {
		Connection conn = getConnection();
		int result = dao.insertEmp(conn,emp);
		
		if(result>0)
			commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사번으로 검색하여 사원 정보 수정 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateInfo(Emp emp) throws SQLException {
		// **반환 자료형 int인 이유**
		// -> DML(update) 수행 결과는 반영된(성공) 행의 개수 반환
		// --> 행의 개수는 정수형 --> int 사용
		
		Connection conn = getConnection();
		int result = dao.updateInfo(conn, emp);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사번으로 사원 삭제 서비스
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteInfo(int input) throws SQLException {
		Connection conn = getConnection();
		int result = dao.deleteInfo(conn,input);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사번으로 사원 퇴직 처리 서비스
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public void retireEmployee(int input) throws SQLException {
		Connection conn = getConnection();
		dao.retireEmployee(conn,input); // 성공 또는 예외만 반환 -> 반환 받을 필요x
		
		// 트랜잭션 처리
		// 예외 발생 시 SQL 수행이 정상적으로 진행되지 않음
		commit(conn);
		
		close(conn);
		
	}

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * (필요에 의해 의미를 부여한 가상의 데이터)
	 * @param input
	 * @return check (0: 없는 사원, 1: 퇴직한 사원, 2: 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException {
		Connection conn = getConnection();
		int check = dao.checkEmployee(conn, input);
		close(conn);
		return check;
	}

	/** 가장 최근 입사한 사원 5명 조회
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> mostRecentFive() throws SQLException {
		Connection conn = getConnection();
		List<Emp> empList = dao.mostRecentFive(conn);
		close(conn);
		
		return empList;
	}
	
	/** 부서별 통계 조회 서비스
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment() throws SQLException{ 
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		
		close(conn);
		
		return mapList;
	}

	
}
