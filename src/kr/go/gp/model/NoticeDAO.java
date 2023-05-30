package kr.go.gp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.gp.dto.NoticeDTO;
import kr.go.gp.dto.User1DTO;

public class NoticeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql="";
	
	public ArrayList<NoticeDTO> noticeListAll(){
		ArrayList<NoticeDTO> notiList = new ArrayList<NoticeDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NoticeDTO noti = new NoticeDTO();
				noti.setNnum(rs.getString("nnum"));
				noti.setNtitle(rs.getString("ntitle"));
				noti.setNcontent(rs.getString("ncontent"));
				noti.setNauthor(rs.getString("nauthor"));
				noti.setFile1(rs.getString("file1"));
				noti.setNdate(rs.getString("ndate"));
				notiList.add(noti);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(rs,  pstmt, con);
		return notiList;
	}
	
	public NoticeDTO getNotice(String nnum){
		NoticeDTO noti = new NoticeDTO();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ONE);
			pstmt.setString(1, nnum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				noti.setNnum(rs.getString("nnum"));
				noti.setNtitle(rs.getString("ntitle"));
				noti.setNcontent(rs.getString("ncontent"));
				noti.setNauthor(rs.getString("nauthor"));
				noti.setFile1(rs.getString("file1"));
				noti.setNdate(rs.getString("ndate"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return noti;
	}
	
	public String getNnumGenerator(){
		String nnum = "";
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NNUM_GENERATER);
			rs = pstmt.executeQuery();
			if(rs.next()){
				nnum = rs.getString("nnum");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		
		int tmp = Integer.parseInt(nnum) + 1;
		nnum = tmp + "";
		return nnum;
	}
	
	
	public int insertNotice(NoticeDTO noti){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_NOTICE);
			pstmt.setString(1, noti.getNnum());
			pstmt.setString(2, noti.getNtitle());
			pstmt.setString(3, noti.getNcontent());
			pstmt.setString(4, noti.getNauthor());
			pstmt.setString(5, noti.getFile1());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		
		return cnt;
	}
	
	public NoticeDTO updateNotice(String nnum){
		NoticeDTO noti = new NoticeDTO();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ONE);
			pstmt.setString(1, nnum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				noti.setNnum(rs.getString("nnum"));
				noti.setNtitle(rs.getString("ntitle"));
				noti.setNcontent(rs.getString("ncontent"));
				noti.setNauthor(rs.getString("nauthor"));
				noti.setFile1(rs.getString("file1"));
				noti.setNdate(rs.getString("ndate"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return noti;
	}

	public int updateNoticePro(NoticeDTO noti) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(noti.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_NOTICE2);
				pstmt.setString(1, noti.getNtitle());
				pstmt.setString(2, noti.getNcontent());
				pstmt.setString(3, noti.getNnum());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_NOTICE);
				pstmt.setString(1, noti.getNtitle());
				pstmt.setString(2, noti.getNcontent());
				pstmt.setString(3, noti.getFile1());
				pstmt.setString(4, noti.getNnum());
			}
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}

	public int deleteNotice(String nnum) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_NOTICE);
			pstmt.setString(1, nnum);

			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}
}

