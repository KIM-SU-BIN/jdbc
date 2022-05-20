package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AuthorSelect {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
	
	
			    // 2. Connection 얻어오기
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "webdb", "webdb");
	
				
			    // 3. SQL문 준비 / 바인딩 / 실행 제일중요
				String query = "";
				query += "select author_id, ";
				query += "			author_name, ";
				query += " 			author_desc";
				query += " from author ";
						
				//바인딩
				pstmt = conn.prepareStatement(query);		//문자열 쿼리로 만들기
				
				//실행
				rs = pstmt.executeQuery();				//쿼리문실행 -->> 성공갯수 리턴
					
				
			    // 4.결과처리
				//전체 데이터가  출력됨
				while (rs.next()) {
				//int authorId = rs.getInt("author_id");
				//String authorName = rs.getString("author_name");
				//String authorDesc = rs.getString("author_desc");
					
				/*위의 형태 또는 아래의 형태로 사용하면 됨 
				위에는 컬럼명을 변경하지 않는 이상 이름상관없이 출력 가능하지만 
				아래의 형태도 출력할경우 번호는 고정이끼 때문에 불편함이 있을 수 있다. */
					
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				
				
				//sysout형태는 내가 원하는대로 바꾸면 됨
				System.out.println(authorId + "," + authorName + "," + authorDesc);
				}

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
			
		    // 5. 자원정리
		   try {
			   /* if (rs != null) {
		            rs.close();
		        } 
		        */               
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
	}
}
