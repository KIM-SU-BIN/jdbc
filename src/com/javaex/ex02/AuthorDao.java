package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/************************
 *Dao(Data Access Object)
 *DataBase(오라클: 우리가 사용하는 것은 오라클이지만, 그 회사에서 사용하는 것은 다를 수 있흠)관련된 일을 하는 클래스
 ************************/

public class AuthorDao {
	//필드
	
	//생성자
	
	//메소드 GS : 현재 필드가 없어서 생성X
	
	//매소드-일반
	
	//작가등록 매소드
	public int authorInsert(String authorName, String authorDesc) {
		int count = -1;		
		//정수인 경우 업데이트는 2건 이상으로 될 경우 헷갈릴 수 있고 0으로하면 인서트가 되지 않았을 경우 0으로 나오기때문에 헷갈릴 수 있으므로 
		//겹치지않는 -1로 시작하는 것이 좋음
		
		
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
			query += " insert into author ";
			query += "values(seq_author_id.nextval, ?, ?)";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setString(2, authorDesc);
			
			//실행
			count = pstmt.executeUpdate();	
				/*int count = pstmt.executeUpdate();	
			    원래 여기 있어야하는데 마지막 return을 위해 
			    {}괄호 밖으로 빼주어야해서 맨위 int count=0으로 뺌
				 */
			
		    // 4.결과처리
			System.out.println(count+"건이 생성되었습니다.");
			
			
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
	
	
	//작가 삭제 메소드
	public int authorDelete(int authorId) {
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
			query += " delete from author ";
			query += " where author_id = ? ";
			System.out.println(query);
			
			
			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, authorId);
			
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
		
	
	//작가 수정 메소드 
	public int authorUpdate(int authorId, String authorName, String authorDesc) {
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
			query += " Update author ";
			query += " set author_name = ?, ";
			query += " 	   author_desc = ? ";
			query += " where author_id = ? ";
			System.out.println(query);
			
			
			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setString(2, authorDesc);
			pstmt.setInt(3, authorId);
			
			
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
	
	
	//작가 list 가져오기 메소드
	public List<AuthorVo> authorSelect() {
		
		//list 출력해보기
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;						//리스트에서는 주석처리 하면 안됨!!

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " slect author_id, ";
			query += " 		 author_name, ";
			query += " 	   	 author_desc ";
			query += "from author ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행
			//ResultSet 가져오기
			rs = pstmt.executeQuery();	
			
			
		    // 4.결과처리
			//list로 만들기 ==>> 맨 위로 뻼 (return 때문에)
			//List<AuthorVo> authorList = new ArrayList<AuthorVo>();
			
			//반복문으로 Vo만들기 list에 추가하기
			while(rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				AuthorVo authorVo = new AuthorVo(authorId,authorName,authorDesc);
				
				authorList.add(authorVo);
			}
			
			//리스트를 출력해보기
			System.out.println(authorList.toString());
			

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
			
		    // 5. 자원정리
		    try {
				
				 if (rs != null) 
				  { rs.close(); }
				 
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
		return authorList;
	}
}
