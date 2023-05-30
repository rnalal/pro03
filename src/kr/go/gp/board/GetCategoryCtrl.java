package kr.go.gp.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.CategoryDTO;
import kr.go.gp.model.BoardDAO;

@WebServlet("/GetCategory.do")
public class GetCategoryCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String categroup = request.getParameter("categroup");
		
		BoardDAO dao = new BoardDAO();
		ArrayList<CategoryDTO> cateList = dao.getCategoryName(categroup);
		request.setAttribute("cateList", cateList);
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/cateList.jsp");
		view.forward(request, response);
	}
}

