package kr.go.gp.board;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.go.gp.dto.BoardDTO;
import kr.go.gp.model.BoardDAO;

@WebServlet("/UpdateBoardPro.do")
public class UpdateBoardProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/board/img";	//업로드할 디렉토리
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//업로드할 파일 크기 제한
		String encType = "UTF-8";		//멀티파트 데이터의 인코딩 설정
		ServletContext context = getServletContext();	//현재 서블릿(프로젝트)의 위치 저장
		String uploadFilePath = context.getRealPath(savePath);  //서버 상에 실제 업로드되는 디렉토리 지정
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		int n = 0;
		String bnum = "";
		String[] fileName = new String[5];
		String[] oriFileName = new String[5];
		BoardDAO dao = new BoardDAO();
		BoardDTO boa = new BoardDTO();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());	
			
			Enumeration<?> files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement();
				fileName[n] = multi.getFilesystemName(file);
				//중복된 파일을 업로드할 경우 파일명이 바뀐다.
				oriFileName[n] = multi.getOriginalFileName(file);
				n++;
			}
			
			String ori_pic1 = multi.getParameter("ori_pic1");
			String ori_pic2 = multi.getParameter("ori_pic2");
			String ori_pic3 = multi.getParameter("ori_pic3");
			String ori_pic4 = multi.getParameter("ori_pic4");
			String ori_pic5 = multi.getParameter("ori_pic5");
			
			if (fileName[0] == null) { // 파일이 업로드 되지 않았을때
				boa.setPic1(ori_pic1);
			} else {
				boa.setPic1("img/"+fileName[0]);
			}
			
			if (fileName[1] == null) { // 파일이 업로드 되지 않았을때
				boa.setPic2(ori_pic2);
			} else {
				boa.setPic2("img/"+fileName[1]);
			}

			if (fileName[2] == null) { // 파일이 업로드 되지 않았을때
				boa.setPic3(ori_pic3);
			} else {
				boa.setPic3("img/"+fileName[2]);
			}
			
			if (fileName[3] == null) { // 파일이 업로드 되지 않았을때
				boa.setPic4(ori_pic3);
			} else {
				boa.setPic4("img/"+fileName[3]);
			}
			
			if (fileName[4] == null) { // 파일이 업로드 되지 않았을때
				boa.setPic5(ori_pic3);
			} else {
				boa.setPic5("img/"+fileName[4]);
			}
			bnum = multi.getParameter("bnum");			
			boa.setBnum(multi.getParameter("bnum"));
			boa.setBtitle(multi.getParameter("btitle"));
			boa.setBcontent(multi.getParameter("bcontent"));
			boa.setBauthor(multi.getParameter("bauthor"));
			boa.setBdate(multi.getParameter("bdate"));
			boa.setPic1(multi.getParameter("pic1"));
			boa.setPic2(multi.getParameter("pic2"));
			boa.setPic3(multi.getParameter("pic3"));
			boa.setPic4(multi.getParameter("pic4"));
			boa.setPic5(multi.getParameter("pic5"));
			boa.setCate(multi.getParameter("cate"));
			
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		int cnt = dao.updateBoard(boa);	
		if(cnt==0){ //상품 등록 실패
			String msg = "상품 정보를 수정하지 못했습니다.";
			request.setAttribute("msg", msg);
			
			//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
			RequestDispatcher view = request.getRequestDispatcher("UpdateBoard.do?bnum="+bnum);
			view.forward(request, response);
		} else { //상품 수정 성공시 목록으로 가기
			response.sendRedirect("BoardList.do");
		}
	}
}
