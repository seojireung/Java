package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {

	
	
	/**
	 * @param jobName
	 * @return empList
	 */
	public List<Employee2> select(String inputJobName) {
		
		List<Employee2> empList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			// <셀프 오류 해결>
			// java.sql.SQLRecoverableException: IO 오류
			// 오타 수정으로 해결.
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_sjy";
			String pw = "oracle_sjy5599";
			
			conn = DriverManager.getConnection(type+ip+port+dbName,user,pw);
			
			String condition = null;
			
			if(inputJobName.toLowerCase().equals("null")) {
				condition = "WHERE JOB_NAME IS NULL";
			}else {
				condition = "WHERE JOB_NAME = '" + inputJobName + "'";
			}
			
			// <셀프 오류 해결>
			// 오류_존재하는 직급 입력해도 해당 직급 없다고 오류 뜸
			// 원인_sql문 작성 제대로 안됐음(job테이블 join 안함)
			// 해결_join job 수정
			String sql = "SELECT NVL(DEPT_TITLE,'부서 없음'), JOB_NAME, EMP_NAME, EMAIL "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "JOIN JOB USING (JOB_CODE) "
					+ condition
//					+ "WHERE JOB_NAME = '" + inputJobName + "' "
					+ "ORDER BY EMP_NAME";
					
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// <셀프 오류 해결>
				// 오류_ 순서 1,2,3,4 구분 1로만 해서 depTitle만 출력됨
				// 해결_ 1,2,3,4 구분
				String deptTitle = rs.getString(1);
				String jobName = rs.getString(2);
				String empName = rs.getString(3);
				String email = rs.getString(4);
				
				Employee2 emp = new Employee2(deptTitle, jobName, empName, email);
				
				empList.add(emp);
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		 return empList;
	}
	
}
