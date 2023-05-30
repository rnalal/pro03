package kr.go.gp.review;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.gp.dto.NoticeDTO;
import kr.go.gp.dto.ReviewDTO;
import kr.go.gp.dto.User1DTO;
import kr.go.gp.model.NoticeDAO;
import kr.go.gp.model.ReviewDAO;
import kr.go.gp.model.User1DAO;

@WebServlet("/Review.do")
public class GetReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");
		ReviewDAO rdao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		rev = rdao.getReviewSelectOne(rnum);
		String file1 = ""; 
		String filepath1 = "";		
		
		if(rev.getFile1()!=null){
			file1 = rev.getFile1().substring(5);
			filepath1 = rev.getFile1().substring(0,4);
			file1 = URLEncoder.encode(file1, "UTF-8");
		}		
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("rev", rev);
		
		HttpSession ses = request.getSession();
		String id = (String) ses.getAttribute("sid");
		
		User1DAO udao = new User1DAO();
		User1DTO user = new User1DTO();
			try {
				user = udao.myInfo(id);
			} catch (InvalidKeyException | NoSuchPaddingException
					| NoSuchAlgorithmException | InvalidKeySpecException
					| InvalidAlgorithmParameterException | BadPaddingException
					| IllegalBlockSizeException e) {
				e.printStackTrace();
			}
			request.setAttribute("user", user);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/getReview.jsp");
		view.forward(request, response);
	}
}