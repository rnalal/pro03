package kr.go.gp.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.BoardDTO;
import kr.go.gp.model.BoardDAO;

@WebServlet("/UpdateBoard.do")
public class UpdateBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품코드를 받아서 dao로 전달하여 한 개의 특정 상품에 대한 정보를 로딩
		String bnum = request.getParameter("bnum");
		BoardDAO dao = new BoardDAO();
		BoardDTO boa = dao.getBoard(bnum); 
		
		//카테고리 코드를 저장하여 dao에서 처리한 후 해당 카테고리명을 로딩
		String cate = boa.getCate();	 
		HashMap<String, String> cateMap = dao.getCategory(cate);
		
		request.setAttribute("boa", boa);	//한 개의 상품 정보
		request.setAttribute("cateMap", cateMap);	//카테고리 정보
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/board/updateBoard.jsp");
		view.forward(request, response);
	}
}
