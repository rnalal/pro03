package kr.go.gp.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.go.gp.model.BoardDAO;

@WebServlet("/BoardCodeGenerator.do")
public class BoardCodeGeneratorCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		String msg = "새로운 상품코드를 발생하였습니다.";
		
		BoardDAO dao = new BoardDAO();
		String bnum = dao.getBoardCodeGenerator(cate);
		
		request.setAttribute("bnum", cate+bnum);
		request.setAttribute("msg", msg);
		
		response.setContentType("text/html; charset=UTF-8");
		JSONObject json = new JSONObject();
		json.put("bnum", cate+bnum);
		json.put("msg", msg);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
}
