package com.springbook.biz.board.impl;

import java.util.ArrayList;
import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

/*	JdbcTemplate 객체를 얻는 두가지 방법중 두번째
 *	2. bean으로 등록된 jdbcTemplate를 얻는 방법(POJO 객체)
 * */
@Repository()
public class BoardDAOMybatis /*extends SqlSessionDaoSupport*/{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	/*@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}*/
	
	/*private SqlSession mybatis;
	
	public BoardDAOMybatis() {
		mybatis = SqlSessionFactoryBean.getInstance();
	}*/
	
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
		/*if(vo.getSearchCondition().equals("TITLE")) {
			if(vo.getSearchKeyword()==null) {그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..
				vo.setSearchKeyword("");
			}
			list = mybatis.selectList("BoardDAO.getBoardList_T", vo);
		}else if(vo.getSearchCondition().equals("CONTENT")){
			if(vo.getSearchKeyword()==null) {그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..
				vo.setSearchKeyword("");
			}
			list = mybatis.selectList("BoardDAO.getBoardList_C", vo);
		}else{
			if(vo.getSearchKeyword()==null) { 그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..
				vo.setSearchKeyword("");
			}
			list = mybatis.selectList("BoardDAO.getBoardList_A", vo);
		}*/
		//Dynamic SQL 적용 후
		if(vo.getSearchKeyword()==null) {/*그냥 null값하니 mybatis에서 쿼리문 실행하면서 null값은 안된다고 에러남..*/
			vo.setSearchKeyword("");
		}
		list = mybatis.selectList("BoardDAO.getBoardList", vo);
		return list;
	}
	
	//글 상세정보
	public BoardVO getBoard(int seq) {
		System.out.println("===>Spring JDBC로 getBoard()기능 처리");
		mybatis.update("BoardDAO.updateCount",seq);
		return mybatis.selectOne("BoardDAO.selectOne", seq);
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);
			
	}
	
	//삭제 메소드
	public int deleteBoard(int seq) {
		System.out.println("===>Spring JDBC로 deleteBoard()기능 처리");
		return mybatis.delete("BoardDAO.deleteBoard",seq);
		
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
