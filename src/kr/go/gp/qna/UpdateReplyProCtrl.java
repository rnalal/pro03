package kr.go.gp.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.QnaDTO;
import kr.go.gp.model.QnaDAO;

@WebServlet("/UpdateReplyPro.do")
public class UpdateReplyProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		QnaDTO qna = new QnaDTO();
		QnaDAO dao = new QnaDAO();
		
		String qnum = request.getParameter("qnum");
		qna.setQnum(qnum);
		qna.setQtitle(request.getParameter("qtitle"));
		qna.setQcontent(request.getParameter("qcontent"));
		qna.setQauthor(request.getParameter("qauthor"));
		
		int cnt = dao.updateReply(qna);
		
		if(cnt==0){ //답변수정 실패
			String msg = "답변이 수정되지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("UpdateReply.do?qnum="+qnum);
		} else { //답변수정 성공
			response.sendRedirect("QnaList.do");
		}
	}
}
