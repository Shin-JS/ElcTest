package com.springbook.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

/*	JdbcTemplate 객체를 얻는 두가지 방법중 두번째
 *	2. bean으로 등록된 jdbcTemplate를 얻는 방법(POJO 객체)
 * */
@Repository
public class BoardDAOJPA /*extends SqlSessionDaoSupport*/{
	@PersistenceContext /*persistence.xml파일을 대체*/
	private EntityManager em;
	
	//CRUD 기능 메소드 구현
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JPA로 insertBoard()기능 처리");
		/*if(vo.getFiles()==null) {
			vo.setFiles("");
		}*/
		System.out.println("seq"+vo.getSeq());
		em.persist(vo);
		System.out.println("seq22"+vo.getSeq());
	}
	//글 리스트

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JPA로 getBoardList()기능 처리");
		List<BoardVO> list = new ArrayList<BoardVO>();
		String jqpl = "select b from BoardVO b order by b.seq desc";
		list = em.createQuery(jqpl).getResultList();
		return list;
	}
	
	//글 상세정보
	public BoardVO getBoard(int seq) {
		System.out.println("===>Spring JPA로 getBoard()기능 처리");
		/*mybatis.update("BoardDAO.updateCount",seq);*/
		BoardVO vo = em.find(BoardVO.class, seq);
		int cnt = vo.getCnt()+1;
		vo.setCnt(cnt);
		updateBoard(vo);
		return vo;
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		em.merge(vo);
			
	}
	
	//삭제 메소드
	public int deleteBoard(int seq) {
		System.out.println("===>Spring JPA로 deleteBoard()기능 처리");
		em.remove(em.find(BoardVO.class,seq));
		return 1;
		
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
