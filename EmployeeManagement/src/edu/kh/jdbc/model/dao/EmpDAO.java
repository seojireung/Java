package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;

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
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE\r\n"
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
				String phone = rs.getString(6);
				
				empList.add(new Emp(empId, empName, departmentTitle, jobName, salary, phone));
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}


	/**  퇴직한 사원 전체 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectRetirees(Connection conn) throws SQLException{
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, ENT_DATE\r\n"
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
				String entDate  = rs.getString(5); 
				
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
		Emp emp = new Emp();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME , DEPT_TITLE , JOB_NAME , SALARY, PHONE, EMAIL, HIRE_DATE, DECODE(ENT_YN, 'N','재직중','Y','퇴사')\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entYN = rs.getString(9);
				
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
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}


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
	public int retireEmployee(Connection conn, int input) throws SQLException {
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET ENT_YN = 'Y', ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
}
