package kr.go.gp.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.QnaDTO;
import kr.go.gp.model.QnaDAO;

@WebServlet("/GetQna.do")
public class GetQnaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String qnum = request.getParameter("qnum");
		
		QnaDAO dao = new QnaDAO();
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		QnaDTO qna = new QnaDTO();
		
		qna = dao.getQna2(qnum);	//해당 질문 불러오기
		qnaList = dao.getReplyList(qnum);	//해당 질문에 대한 답변 목록 불러오기
		
		request.setAttribute("qna", qna);
		request.setAttribute("qnaList", qnaList);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/getQna.jsp");
		view.forward(request, response);
	}
}

