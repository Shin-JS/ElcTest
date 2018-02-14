package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		/*AbstractApplicationContext container = new GenericXmlApplicationContext("annotationContext.xml");*/
		AbstractApplicationContext container = new GenericXmlApplicationContext("aopContext.xml");
		
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
		
		//글 수정 테스트
		for(int i=0; i<boardList.size();i++) {
			if(boardList.get(i).getSeq()==8) {
				vo = boardList.get(i); //8번글 저장
			}
		}
		/*vo = boardList.get(8); //list의 8번째 객체 저장*/
		vo.setTitle("수정제목");
		vo.setContent("아버지를 아버지라 못부르고..");
		//수정된 vo객체 출력
		System.out.println(vo.toString());
		
		boardService.updateBoard(vo);
		
		//결과리스트 보기
		//글 목록 검색기능 테스트
		boardList = boardService.getBoardList(vo);
		System.out.println("-----수정결과-----");
		for(BoardVO b: boardList) {
			System.out.println("====>"+b.toString());
		}
		
		//상세보기
		for(int i=0; i<boardList.size();i++) {
			if(boardList.get(i).getSeq()==8) {
				vo = boardList.get(i); //8번글 저장
			}
		}
		BoardVO vo2 = boardService.getBoard(vo.getSeq());
		System.out.println("상세정보");
		System.out.println(vo2);
		
		//삭제
		int seq = -1;
		for(int i=0;i<boardList.size();i++) {
			if(boardList.get(i).getSeq()==12) {
				seq = boardList.get(i).getSeq();
			}
		}
		int result = boardService.deleteBoard(seq);
		if(result>0) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		boardList = boardService.getBoardList(vo);
		System.out.println("-----삭제결과-----");
		for(BoardVO b: boardList) {
			System.out.println("====>"+b.toString());
		}
		
		//Spring컨테이너 종료
		container.close();
		//뭔가 바꿨다는 티는 내줘야지
	}
}
