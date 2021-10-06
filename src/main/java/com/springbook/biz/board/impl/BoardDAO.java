package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;

// DAO = Data Access Object
// 다음은 Mybatis를 이용하여 데이터베이스 연동을 처리하는 BoardDAO 클래스를 작성한다.
// BoardDAO 클래스는 생성자에서 SqlSessionFactoryBean을 이용하여
// SqlSession 객체를 얻어 내고 있다. 그리고, 이 SqlSession 객체의 메소드를 이요하여
// CRUD 기능의 메서드를 모두 구현하고 있다.
// 구현된  각 메서드들은 두 개의 정보가 인자로 전달되고 있는데, 첫 번째 인자는 실행될 SQL의 id 정보이다.
// 이때, SQL Mapper에 선언된 네임스페이스와 아아디를 조합하여 아이디를 지정해야 한다.
// 그리고, 두번째 인자는 parameterType 속성으로 지정된 파라미터 객체이며,
// 등록, 수정, 삭제는 각각 insert(), update(), delete() 메서드로 처리한다.
// 이때, 단건 조회는 selectOne() 메서드로 처리하며, 목록 조회는 selectList()메서드로 처리한다.
public class BoardDAO {
	
	private static SqlSession mybatis;
	
	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	// CRUD 기능의 메서드 구현
	// 글 등록	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}	
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}	
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}		
}
