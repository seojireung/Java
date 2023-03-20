package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class LoadXMLFile {
	
	public static void main(String[] args) {
		
		// XML 파일 읽어오기
		try {
			// Properties 객체 생성
			Properties prop =new Properties();
			
			// FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream("driver.xml");
			
			// FileInputStream에 연결된 xml 파일을 읽어와
			// Properties 객체에 저장
			prop.loadFromXML(fis);
			
			System.out.println(prop.toString());
			
			// Property : 성질, 속성
			// String Properties.getProperty("key") : key에 해당하는 value를 얻어옴
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(user);
			System.out.println(pw);
			
			// DB 연결 테스트 (Connection 얻어오기)
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println(conn);
			
			conn.close();
			
			/* 왜 XML 같은 외부 파일을 이용해서 DB 정보를 읽어올까?
			 * 
			 * 1. 코드 중복 제거
			 * 
			 * 2. 별도 관리 용이
			 *    - 별도 파일을 이용하기 때문에 공통된 코드로 관리 가능
			 *    -> (자바에서 일일이 수정 안해도 됨)
			 *    
			 * 3. 코드 수정으로 인한 재컴파일 과정 없애기 위해
			 *    -코드가 한 글자라도 수정되면 Java 전체가 컴파일 재진행
			 *    -> 코드 수정 x로 만들어서 재컴파일 시간 단축
			 *    (참고. new코드 -> 컴파일러 -> 2진법 -> 실행(?))
			 *    
			 * 4. SQL 작성/관리 용이
			 *    - XML 파일에 작성된 문자열은 형태 그대로를 읽어오게 됨 (띄어쓰기)
			 * 
			 * 
			 * 
			 * 
			 * */
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
