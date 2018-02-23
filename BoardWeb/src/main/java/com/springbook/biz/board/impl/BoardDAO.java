package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
@Repository
public class BoardDAO {
	//JDBC관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//sql문
	private final String BOARD_INSERT="insert into board3(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board3),?,?,?)";
	private final String BOARD_LIST="select * from board3 order by seq desc";
	private final String BOARD_UPDATE="update board3 set writer=?, title=?, content=? where seq=?";
	private final String BOARD_GET="select * from board3 where seq=?";
	private final String BOARD_DELETE="delete from board3 where seq=?";
	private final String BOARD_CNTUPDATE = "update board3 set cnt=nvl(cnt,0)+1 where seq=?";
	//Title
	private final String BOARD_LIST_SEARCH_T = "select * from board3 where title like '%'||?||'%' order by seq desc";
	//Content
	private final String BOARD_LIST_SEARCH_C = "select * from board3 where content like '%'||?||'%' order by seq desc";
	//all
	private final String BOARD_LIST_SEARCH_A = "select * from board3 where title like '%'||?||'%' or content like '%'||?||'%' order by seq desc";
	
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			int i = 0;
			pstmt.setString(++i, vo.getTitle());
			pstmt.setString(++i, vo.getWriter());
			pstmt.setString(++i, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	//검색조건처리
	public List<BoardVO> getBoardList(String condition,String keyword) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			if(condition.equals("TITLE")) {
				pstmt = conn.prepareStatement(BOARD_LIST_SEARCH_T);
				pstmt.setString(1, keyword);
			}else if(condition.equals("CONTENT")){
				pstmt = conn.prepareStatement(BOARD_LIST_SEARCH_C);
				pstmt.setString(1, keyword);
			}else{
				pstmt = conn.prepareStatement(BOARD_LIST_SEARCH_A);
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			int i = 0;
			pstmt.setString(++i, vo.getWriter()); //작성자 수정용으로 추가
			pstmt.setString(++i, vo.getTitle());
			pstmt.setString(++i, vo.getContent());
			pstmt.setInt(++i, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public BoardVO getBoard(int seq) {
		BoardVO board = new BoardVO();
		try {
			updateCount(seq);
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;
	}

	public int deleteBoard(int seq) {
		int result = 0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			int i = 0;
			pstmt.setInt(++i, seq);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	
	//조회수 증가 메소드
	public void updateCount(int seq) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_CNTUPDATE);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(pstmt, conn);
		}

	}
	
}
