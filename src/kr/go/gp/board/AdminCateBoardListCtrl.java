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

@WebServlet("/AdminCateBoardList.do")
public class AdminCateBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> boaList = new ArrayList<BoardDTO>();
		HashMap<String, String> cateMap = new HashMap<String, String>();
		if(cate==null){
			boaList = dao.getBoardList();
			cate = "0101";
			cateMap.put("catename", "전체");
		} else {
			boaList = dao.getAdminCateBoardList(cate);
			cateMap = dao.getCategory(cate);
		}
		
		request.setAttribute("boaList", boaList);
		request.setAttribute("cateMap", cateMap);
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/board/boaList.jsp");
		view.forward(request, response);
	}
}