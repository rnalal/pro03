package kr.go.gp.review;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.NoticeDTO;
import kr.go.gp.dto.ReviewDTO;
import kr.go.gp.model.NoticeDAO;
import kr.go.gp.model.ReviewDAO;

@WebServlet("/UpdateReview.do")
public class UpdateReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");
		ReviewDAO rdao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		
		rev = rdao.getReviewSelectOne(rnum);
		
		String file1 = rev.getFile1().substring(5);
		String filepath1 = rev.getFile1().substring(0,4);

		file1 = URLEncoder.encode(file1, "UTF-8");
		
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("rev", rev);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/updateReview.jsp");
		view.forward(request, response);
	}
}
