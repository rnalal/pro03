package kr.go.gp.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.NoticeDTO;
import kr.go.gp.model.NoticeDAO;

@WebServlet("/NoticeList.do")
public class GetNoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO ndao = new NoticeDAO();
		ArrayList<NoticeDTO> notiList = new ArrayList<NoticeDTO>();
		notiList = ndao.noticeListAll();
		request.setAttribute("notiList", notiList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/notiList.jsp");
		view.forward(request, response);
	}

}