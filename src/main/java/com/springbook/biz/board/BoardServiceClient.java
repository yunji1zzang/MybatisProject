package com.springbook.biz.board;

import java.util.List;

import com.springbook.biz.board.impl.BoardDAO;

// 다음은 BoardDAO 클래스의 메서드를 테스트하는 클라이언트 프로그램을 작성한다.
public class BoardServiceClient {

	public static void main(String[] args) {

		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis 제목");
		vo.setWriter("장나라");
		vo.setContent("myBatis 내용입니다...");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}
}
