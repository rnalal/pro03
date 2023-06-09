package kr.go.gp.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.BoardDTO;
import kr.go.gp.model.BoardDAO;

@WebServlet("/AdminInventoryList.do")
public class AdminInventoryListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> boaList = new ArrayList<BoardDTO>();
		boaList = dao.getBoardList();

		request.setAttribute("boaList", boaList);
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/inventoryList.jsp");
		view.forward(request, response);
	}
}
