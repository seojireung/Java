package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	/** 사번이 일치하는 사원 조회 서비스
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
	public int retireEmployee(int input) throws SQLException {
		Connection conn = getConnection();
		int result = dao.retireEmployee(conn,input);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
}
