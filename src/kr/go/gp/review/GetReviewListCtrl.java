package kr.go.gp.review;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/ReviewList.do")
public class GetReviewListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rdao = new ReviewDAO();
		ArrayList<ReviewDTO> revList = new ArrayList<ReviewDTO>();
		revList = rdao.getAllReview();
		request.setAttribute("revList", revList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/revList.jsp");
		view.forward(request, response);
	}

}