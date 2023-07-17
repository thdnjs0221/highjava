
package kr.or.ddit.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

//JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된 class작성하기
//(dbinfo.properties파일의 내용을 읽어와 설정하기 )==> ResourseBundle객체 이용하기 
public class DBUtil3 {
	
	private static ResourceBundle bundle; //ResourceBundle객체 변수 선언
	
	//static초기화 블럭
	static {
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn= null;
		try {
			conn = DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("db연결 실패!");
			e.printStackTrace();
		}
		return conn;
	}

	
}