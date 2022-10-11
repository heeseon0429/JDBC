package a_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEmp {

	public static void main(String[] args) {

		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공");
			
			//2. 연결객체 얻어오기
			String ur1 = "jdbc:oracle:thin:@192.168.0.68:1521:xe";
			String user = "scott";
			String pass = "tiger";
			
			Connection con = DriverManager.getConnection(ur1, user,pass);
			System.out.println("디비 연결 성공2");
			
			//----입력값
			String bonmyeong = "윤희선";
			int welgup = 10000;
			String jikup = "IT";
			//3. SQL 문장
			
			String sql = "INSERT INTO emp(empno, ename, sal, job) "
					+ " VALUES(5555, ?, ?, ? )";
			
			
			//4. SQL 전송객체
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, bonmyeong);
			stmt.setInt(2, welgup);
			stmt.setString(3, jikup);
			
			//5. SQL 전송
			/*		
			 * 		- ResultSet executeQuery()  : SELECT
			 * 		- int executeUpdate() : INSERT/DELETE/UPDATE
			 */
			int result = stmt.executeUpdate();
			System.out.println(result + "행을 실행");
			
			//6. 닫기
			stmt.close();
			con.close();
			
			} catch (Exception e) {
			System.out.println("DB 실패 :" + e);
			
			}
	
	}
	
	

}
