package kr.go.gp.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.model.QnaDAO;

@WebServlet("/DelQna.do")
public class DelQnaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		QnaDAO dao = new QnaDAO();	
		String qnum = request.getParameter("qnum");

		int cnt = dao.delQna(qnum);
		
		if(cnt==0){ //질문삭제 실패
			String msg = "답변이 삭제되지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("GetQna.do?qnum="+qnum);
		} else { //질문삭제 성공
			response.sendRedirect("QnaList.do");
		}
	}
}