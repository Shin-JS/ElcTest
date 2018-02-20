package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
/*	JdbcTemplate 객체를 얻는 두가지 방법중 두번째
 *	2. bean으로 등록된 jdbcTemplate를 얻는 방법(POJO 객체)
 * */
@Repository()
public class BoardDAOSpringOracle{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//JDBC관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//sql문
/*	private final String BOARD_INSERT="insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_LIST="select * from board order by seq desc";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_DELETE="delete from board where seq=?";*/
	private final String BOARD_INSERT="insert into board3(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board3),?,?,?)";
	private final String BOARD_LIST="select * from board3 order by seq desc";
	private final String BOARD_UPDATE="update board3 set title=?, content=? where seq=?";
	private final String BOARD_GET="select * from board3 where seq=?";
	private final String BOARD_DELETE="delete from board3 where seq=?";
	/* annotationAopContext.xml에 설정된 dataSource 얻기*/
/*	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);		
	}*/
	
	//CRUD 기능 메소드 구현
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard()기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	//글 리스트
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoardList()기능 처리");
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		return list;
	}
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 updateBoard()기능 처리");
		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
	}
	//글 상세정보
	public BoardVO getBoard(int seq) {
		System.out.println("===>Spring JDBC로 getBoard()기능 처리");
		BoardVO board = new BoardVO();
		Object[] args = {seq};
		board = jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		return board;
		/*교제에는 BoardVO객체 안만들고 바로 return.. p.221참고*/
	}
	//삭제 메소드
	public int deleteBoard(int seq) {
		int result = 0;
		System.out.println("===>Spring JDBC로 deleteBoard()기능 처리");
		result = jdbcTemplate.update(BOARD_DELETE,seq);
		return result;
	}
	
}
