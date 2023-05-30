package kr.go.gp.user1;

import java.io.IOException;
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

import kr.go.gp.model.User1DAO;

@WebServlet("/UserLoginPro.do")
public class UserLoginProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		User1DAO dao = new User1DAO();
		int cnt = 0;
		
			try {
				cnt = dao.loginPass(id, pw);
			} catch (InvalidKeyException | NoSuchPaddingException
					| NoSuchAlgorithmException | InvalidKeySpecException
					| InvalidAlgorithmParameterException | BadPaddingException
					| IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		HttpSession ses = request.getSession();
		String msg = "";
		if(cnt==1){
			msg = "로그인 성공";
			ses.setAttribute("sid", id);
			response.sendRedirect(request.getContextPath());
		} else if(cnt==9){
			msg = "존재하지 않는 아이디입니다. 회원 가입 후 진행하시기 바랍니다.";
			request.setAttribute("msg", msg);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
			view.forward(request, response);
		} else {
			msg = "아이디 또는 비밀번호가 틀립니다.";
			request.setAttribute("msg", msg);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
			view.forward(request, response);
		}
	}

}

