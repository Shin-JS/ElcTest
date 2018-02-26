package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.impl.BoardDAOMybatis;
/*import com.springbook.biz.board.impl.BoardDAO;*/
/*import com.springbook.biz.board.impl.BoardDAOSpring;*/
/*import com.springbook.biz.board.impl.BoardDAOSpring2;*/
import com.springbook.biz.board.impl.BoardDAOSpringOracle;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	/*private BoardDAO dao;*/
	/*private BoardDAOSpring dao;*/
	/*private BoardDAOSpring2 dao;*/
	/*private BoardDAOSpringOracle dao;*/
	private BoardDAOMybatis dao;
	
	@Override
	public void insertBoard(BoardVO vo) {
		
		dao.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int seq) {
		//return dao.deleteBoard(seq);
		return 0;
	}

	@Override
	public BoardVO getBoard(int seq) {
		//return dao.getBoard(seq);
		return new BoardVO();
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}

}
