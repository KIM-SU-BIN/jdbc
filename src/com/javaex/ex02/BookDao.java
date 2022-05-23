package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {
	
	private int bookId;

	//필드
	
	//생성자
	
	//메소드 GS 
	
	//매소드-일반
	
	//북 등록 매소드
	public int bookInsert(String title, String pubs, String pudDate, int authorId) {
		int count = -1;		
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " insert into book ";
			query += " values(seq_book_id.nextval,?, ?, ?, ?) "; 
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pudDate);
			pstmt.setInt(4, authorId);
			
			//실행
			count = pstmt.executeUpdate();	
			
			
		    //4.결과처리
			System.out.println(count + " 건이 생성되었습니다.");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
				/*
				 * if (rs != null) { rs.close(); }
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
		
		return count;
	}
	
	//북 삭제 매소드
	public int bookDelete(int bookId) {
		int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

												
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";
			System.out.println(query);
						
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			
			//실행
			count = pstmt.executeUpdate();	
			

		    // 4.결과처리
			System.out.println(count + "건 삭제되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
				/*
				 * if (rs != null) { rs.close(); }
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
	
		return count;
	}
		
	//북 수정 매소드	
	public int bookUpdate(String title, String pubs, String pubDate, int authorId) {
			int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
									
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    //SQL문 준비
			String query = "";
			query += " Update book ";
			query += " set title = ?, ";
			query += " 	   pubs = ?, ";
			query += " 	   pub_date = ?, ";
			query += " 	   author_id = ? ";
			query += " where book_id = ? ";
			System.out.println(query);
			
			
			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);
			pstmt.setInt(5, bookId);
			
			//실행
			count = pstmt.executeUpdate();	
			
		    // 4.결과처리
			System.out.println(count + "건 수정되었습니다.");
		    

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
			
		    // 5. 자원정리
		    try {
				/*
				 * if (rs != null) { rs.close(); }
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
		return count;
	}
		
	//책 작가 조인하기
	
		
		
}
