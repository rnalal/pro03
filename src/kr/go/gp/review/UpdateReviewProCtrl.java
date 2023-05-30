package kr.go.gp.review;

import java.io.IOException;

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

@WebServlet("/UpdateReviewPro.do")
public class UpdateReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/image";	
		int uploadFileSizeLimit = 10 * 1024 * 1024;	
		String encType = "UTF-8";		
		ServletContext context = getServletContext();	
		String uploadFilePath = context.getRealPath(savePath); 
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String rtitle = "";
		String rcontent = "";
		String rauthor = "";
		String fileName = "";
		String rnum = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1"); 
			if (fileName == null) { 
				System.out.print("파일 업로드 실패~!");
			} 
			rnum = multi.getParameter("rnum");
			rauthor = multi.getParameter("rauthor");
			rtitle = multi.getParameter("rtitle");
			rcontent = multi.getParameter("rcontent");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		ReviewDAO rdao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		rev.setRnum(rnum);
		rev.setRtitle(rtitle);
		rev.setRcontent(rcontent);
		rev.setFile1(fileName);
		rev.setRauthor(rauthor);
		int cnt = rdao.updateReview(rev);	
		if(cnt==0){ 
			String msg = "리뷰 글을 수정하지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("UpdateReview.do?rnum="+rev.getRnum());
		} else { 
			response.sendRedirect("ReviewList.do");
		}
	}
}