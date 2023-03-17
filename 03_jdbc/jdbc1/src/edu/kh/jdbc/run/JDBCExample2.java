package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // import sql꺼 하는 거 주의!!
import java.util.Scanner;

public class JDBCExample2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// [1단계] : JDBC 객체 참조 변수 선언
		
		Connection conn = null;
		// DB 연결 정보를 담은 객체, 이 정보를 이용해 Java-DB 연결 통로 생성
		Statement stmt = null;
		// Connection을 이용해서 SQL을 DB에 전달하여 수행 후 결과를 반환 받는 객체
		ResultSet rs = null;
		// SELECT 수행 결과를 자바에 저장하는 객체, ★커서를 이용해 1행씩 접근★
		
		try {
			// [2단계] : 참조 변수에 알맞은 객체 대입
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 예외처리 해야 함.
			// DB 연결에 필요한 JDBC 드라이버를 메모리 로드(= 객체로 생성)
			// -> DriverManager가 Connection 생성 시 자동으로 사용
			
			// Connection 생성 시 필요한 값을 미리 변수에 대입
			String type = "jdbc:oracle:thin:@"; // 오라클
			String ip = "localhost"; // ip 주소 (맥북 : 115.90.212.22)
			String port = ":1521"; // (맥북 : :9000)
			String dbName = ":ORCL"; // (학원컴 : :ORCL)
			String user = "kh_sjy"; // 아이디
			String pw = "oracle_sjy5599"; // 비번
			// Connection (통로) 생성 -> SQLException 발생 가능성 있음 (add Catch)
			// oracle.jdbc.driver.T4CConnection@6c40365c
			conn = DriverManager.getConnection( type+ip+port+dbName, user, pw);
			// Statement (통로를 이동하는 객체 : 전달, 반환) 생성
			stmt = conn.createStatement();
			
			System.out.print("급여 기준 입력 : ");
			int input = sc.nextInt();
			
			// SQL 작성  (""안에 ; 작성X)
			// 급여를 300만 이상 받는 사원의 
			// 이름, 급여, 직급코드, 입사일 조회 (급여 내림차순)
			String sql = ("SELECT EMP_NAME, SALARY, JOB_CODE, HIRE_DATE "
					+ "FROM EMPLOYEE "
					+ "WHERE SALARY >= " + input
					+ "ORDER BY SALARY DESC");
			// Statement 객체를 이용해
			// SQL(SELECT) 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql); // executeQuery() : SELECT 수행 후 ResultSet 반환
			
			// [3단계] : SQL 수행 결과로 반환 받은 ResultSet을 
			// 첫 번째 행부터 1행씩 접근하여 컬럼 값을 얻어와 출력
			
			while(rs.next()) {
				// rs.next() : 커서 1행씩 이동 -> 다음 행 있으면 true(내부 코드 실행), 없으면 false(실행x) 반환
			
				// 각 행에 존재하는 컬럼 값 얻어오기
				// -> rs.get자료형(컬럼명|컬럼순서)
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String jobCode = rs.getString("JOB_CODE");
				Date hireDate = rs.getDate("HIRE_DATE");
				// java.sql.Date!!
				
				System.out.printf("이름: %s / 급여: %d / 직급코드: %s / 입사일: %s \n", 
						empName, salary, jobCode, hireDate.toString());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// [4단계] : 사용한 JDBC 객체 자원 반환
			
			try { // 생성 역순으로 close 진행
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
