package kr.go.gp.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.BoardDTO;
import kr.go.gp.model.BoardDAO;

@WebServlet("/AdminBoardList.do")
public class AdminBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> boaList = dao.getBoardList();
		HashMap<String, String> cateMap = new HashMap<String, String>();
		
		cateMap.put("catename", "전체");
		request.setAttribute("boaList", boaList);
		request.setAttribute("cateMap", cateMap);
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/board/boaList.jsp");
		view.forward(request, response);
	}

}
