package kr.go.gp.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.QnaDTO;
import kr.go.gp.model.QnaDAO;

@WebServlet("/UpdateReply.do")
public class UpdateReplyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String qnum = request.getParameter("qnum");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO qna = new QnaDTO();
		
		qna = dao.getQna2(qnum);	//해당 질문 불러오기
		
		request.setAttribute("qn", qna);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/updateReply.jsp");
		view.forward(request, response);
	}
}
