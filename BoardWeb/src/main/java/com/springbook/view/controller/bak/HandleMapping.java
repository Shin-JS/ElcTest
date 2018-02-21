package com.springbook.view.controller.bak;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.InsertBoardProcController;
import com.springbook.view.board.LogoutController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;

public class HandleMapping {
	private Map<String, Controller> mappings;
	
	public HandleMapping() {
		mappings = new HashMap<>();
		/*mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/insertBoardProc.do", new InsertBoardProcController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());*/
	}
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
