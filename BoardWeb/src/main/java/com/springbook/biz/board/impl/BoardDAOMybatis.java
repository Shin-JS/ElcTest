package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;
/*	JdbcTemplate 객체를 얻는 두가지 방법중 두번째
 *	2. bean으로 등록된 jdbcTemplate를 얻는 방법(POJO 객체)
 * */
@Repository()
public class BoardDAOMybatis{
	
	private SqlSession mybatis;
	
	public BoardDAOMybatis() {
		mybatis = SqlSessionFactoryBean.getInstance();
	}
	
	/* annotationAopContext.xml에 설정된 dataSource 얻기*/
/*	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);		
	}*/
	
	//CRUD 기능 메소드 구현
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard()기능 처리");
		if(vo.getFiles()==null) {
			vo.setFiles("");
		}
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	//글 리스트

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoardList()기능 처리");
		List<BoardVO> list = new ArrayList<BoardVO>();
		if(vo.getSearchCondition().equals("TITLE")) {
			System.out.println("p1");
			if(vo.getSearchKeyword()==null) {/*그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..*/
				System.out.println("p4");
				vo.setSearchKeyword("");
			}
			list = mybatis.selectList("BoardDAO.getBoardList_T", vo);
		}else if(vo.getSearchCondition().equals("CONTENT")){
			System.out.println("p2");
			if(vo.getSearchKeyword()==null) {/*그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..*/
				System.out.println("p5");
				vo.setSearchKeyword("");
			}
			list = mybatis.selectList("BoardDAO.getBoardList_C", vo);
		}else{
			System.out.println("p3");
			if(vo.getSearchKeyword()==null) { /*그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..*/
				System.out.println("p6");
				vo.setSearchKeyword("");
			}
			list = mybatis.selectList("BoardDAO.getBoardList_A", vo);
		}
		return list;
	}
	//글 수정
/*	public void updateBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 updateBoard()기능 처리");
			jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getFiles(),vo.getSeq());
		
	}
	//글 상세정보
	public BoardVO getBoard(int seq) {
		System.out.println("===>Spring JDBC로 getBoard()기능 처리");
		BoardVO board = new BoardVO();
		Object[] args = {seq};
		board = jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		return board;
		교제에는 BoardVO객체 안만들고 바로 return.. p.221참고
	}
	//삭제 메소드
	public int deleteBoard(int seq) {
		int result = 0;
		System.out.println("===>Spring JDBC로 deleteBoard()기능 처리");
		result = jdbcTemplate.update(BOARD_DELETE,seq);
		return result;
	}*/
	
}
