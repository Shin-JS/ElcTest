package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardList") /*name이 xml의 rootelement가 됨*/
@XmlAccessorType(XmlAccessType.FIELD) 
public class BoardListVO {
	@XmlElement(name="board")/*boardlist안에 board라는 이름으로 값들이 저장됨?*/
	private List<BoardVO> boardList;

	//getter/setter
	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
	
}
