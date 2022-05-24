package com.javaex.ex02;

import java.util.List;

public class BookApp {
	
	public static void main (String[] args) {
		
		BookDao bookDao = new BookDao();
		
		/*
		authorDao.authorInsert("김문열", "경북 영양"); 
		authorDao.authorInsert("박경리", "경상남도 통영"); 
		authorDao.authorInsert("유시민", "17대 국회의원");
		authorDao.authorInsert("기안84", "기안동에서 산 84년생"); 
		authorDao.authorInsert("강풀", "온라인 만화가 1세대"); 
		authorDao.authorInsert("김영하", "알쓸신잡");
		*/
		
		/*//< 데이터 생성 >
		 bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22",1);
		 bookDao.bookInsert("삼국지", "민음사", "2002-03-01",1); 
		 bookDao.bookInsert("토지", "마로니에북스", "2012-08-15",2); 
		 bookDao.bookInsert("유시민의 글쓰기 특강", "생각의길", "2015-04-01",3); 
		 bookDao.bookInsert("패션왕", "중앙북스", "2012-02-22",4);
		 bookDao.bookInsert("순정만화", "재미주의", "2011-08-03",5);
		 bookDao.bookInsert("오직두사람", "문학동네", "2017-05-04",6);
		 bookDao.bookInsert("26년", "재미주의", "2012-02-04",5);
		 */
		
		
		//< 데이터 삭제 > 
		 /*int dCount = bookDao.bookDelete(8); 
		 System.out.println("삭제건수:" + dCount);
		*/
		
		
		 //< 데이터 수정 >
		 //int uCount = bookDao.bookUpdate(4, "자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
		 //System.out.println("수정건수:" + uCount);
		 //bookDao.bookUpdate(4, "자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
		 
		
		// < 데이터 조회 >
		 bookDao.bookSelect();
			List<BookVo> bookList = bookDao.bookSelect();

			for (int i = 0; i < bookList.size(); i++) {
				
				BookVo bookVo = bookList.get(i);
				System.out.println(bookVo.getBookId() + "," + bookVo.getTitle() + "," + bookVo.getPubs() + ","
						+ bookVo.getPub_date() + "," + bookVo.getAuthorName());
		
		
		}

	}	
}


