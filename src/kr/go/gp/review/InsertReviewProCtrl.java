package kr.go.gp.review;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.NoticeDTO;
import kr.go.gp.dto.ReviewDTO;
import kr.go.gp.model.NoticeDAO;
import kr.go.gp.model.ReviewDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/InsertReviewPro.do")
public class InsertReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/image";	//업로드할 디렉토리
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//업로드할 파일 크기 제한
		String encType = "UTF-8";		//멀티파트 데이터의 인코딩 설정
		ServletContext context = getServletContext();	//현재 서블릿(프로젝트)의 위치 저장
		String uploadFilePath = context.getRealPath(savePath);  //서버 상에 실제 업로드되는 디렉토리 지정
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String rtitle = "";
		String rcontent = "";
		String rauthor = "";
		String fileName = "";
		
		ReviewDAO rdao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1"); 
			if (fileName == null) { 
				System.out.print("파일 업로드 실패~!");
			} else {
				rev.setFile1("data/"+fileName);
			}
			rauthor = multi.getParameter("rauthor");
			rtitle = multi.getParameter("rtitle");
			rcontent = multi.getParameter("rcontent");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		rev.setRtitle(rtitle);
		rev.setRcontent(rcontent);
		rev.setRauthor(rauthor);
		int cnt = rdao.insertReview(rev);		
		if(cnt==0){ 
			String msg = "리뷰 글이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/insertReview.jsp");
			view.forward(request, response);
		} else { 
			response.sendRedirect("ReviewList.do");
		}
	}
}

