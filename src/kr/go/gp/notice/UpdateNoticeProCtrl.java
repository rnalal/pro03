package kr.go.gp.notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gp.dto.NoticeDTO;
import kr.go.gp.model.NoticeDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UpdateNoticePro.do")
public class UpdateNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/data";	
		int uploadFileSizeLimit = 10 * 1024 * 1024;	
		String encType = "UTF-8";		
		ServletContext context = getServletContext();	
		String uploadFilePath = context.getRealPath(savePath); 
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String ntitle = "";
		String ncontent = "";
		String nauthor = "";
		String fileName = "";
		String nnum = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1"); 
			if (fileName == null) { 
				System.out.print("파일 업로드 실패~!");
			} 
			nnum = multi.getParameter("nnum");
			nauthor = multi.getParameter("nauthor");
			ntitle = multi.getParameter("ntitle");
			ncontent = multi.getParameter("ncontent");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		NoticeDAO ndao = new NoticeDAO();
		NoticeDTO noti = new NoticeDTO();
		noti.setNnum(nnum);
		noti.setNtitle(ntitle);
		noti.setNcontent(ncontent);
		noti.setFile1(fileName);
		noti.setNauthor(nauthor);
		int cnt = ndao.updateNoticePro(noti);	
		if(cnt==0){ 
			String msg = "공지사항 글을 수정하지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("UpdateNotice.do?nnum="+noti.getNnum());
		} else { 
			response.sendRedirect("NoticeList.do");
		}
	}
}