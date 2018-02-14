package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("annotationContext.xml");
		
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("오늘은 설 전날.................");
		boardService.insertBoard(vo);
		
		//글 목록 검색기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO b: boardList) {
			System.out.println("====>"+b.toString());
		}
		
		//Spring컨테이너 종료
		container.close();
		//뭔가 바꿨다는 티는 내줘야지
	}
}
