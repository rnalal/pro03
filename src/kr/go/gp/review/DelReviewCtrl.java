package kr.go.gp.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.model.NoticeDAO;
import kr.go.gp.model.ReviewDAO;

@WebServlet("/DelReview.do")
public class DelReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");
		ReviewDAO rdao = new ReviewDAO();
		
		int cnt = rdao.deleteReview(rnum);
		if(cnt==0){ //실패하면, 공지사항 글 상세보기로 다시 이동
			String msg = "리뷰를 삭제하지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("GetReview.do?rnum="+rnum);
		} else { //삭제 처리가 성공하면, 공지사항 목록으로 이동
			response.sendRedirect("ReviewList.do");
		}
	}
}
