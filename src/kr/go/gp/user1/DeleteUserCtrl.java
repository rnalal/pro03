package kr.go.gp.user1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.gp.model.User1DAO;

@WebServlet("/DeleteUser.do")
public class DeleteUserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User1DAO dao = new User1DAO();
		int cnt = dao.deleteUser(id);
		HttpSession ses = request.getSession();
		if(cnt>=1){
			ses.invalidate();
			response.sendRedirect(request.getContextPath());
		} else {
			ses.invalidate();
			response.sendRedirect("UserLogin.do");
		}
	}

}