package kr.go.gp.model;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.crypto.util.AES256;
import kr.go.gp.dto.User1DTO;

public class User1DAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String key = "%03x";
	String qpw;
	
	public ArrayList<User1DTO> getUserList() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		ArrayList<User1DTO> userList = new ArrayList<User1DTO>();
		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User1DTO user = new User1DTO();
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();
				String vpw = qpw.substring(0, 3);
				String hpw = "";
				for(int i=0;i<k-3;i++){
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setHpw(qpw);
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setUdate(rs.getString("udate"));
				userList.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return userList;
	}
	
	public int loginCheck(String id, String pw) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		int cnt = 0;
		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				System.out.println(qpw);
				if(pw.equals(qpw)){
					cnt = 1;
				} else {
					cnt = 0;
				}
			} else {
				cnt = 9;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cnt;		
	}
	
	public int loginPass(String id, String pw) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		int cnt = 0;	
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				System.out.println(qpw);
				if(pw.equals(qpw)){
					cnt = 1;
				} else {
					cnt = 0;
				}						
			} else {
				cnt = 9;
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	public int idCheck(String id){
		int cnt = 0;		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = 1;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	
	public int insertUser(User1DTO user){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_USER);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getTel());
			pstmt.setString(5, user.getAddr());
			pstmt.setString(6, user.getEmail());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	public User1DTO myInfo(String id) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		User1DTO user = new User1DTO();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	
				String vpw = qpw.substring(0, 3);	
				String hpw = "";
				for(int i=0;i<k-3;i++){	
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setHpw(qpw);
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setUdate(rs.getString("udate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return user;
	}
	
	public User1DTO myInfo2(String id) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		User1DTO user = new User1DTO();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	
				String vpw = qpw.substring(0, 3);	
				String hpw = "";
				for(int i=0;i<k-3;i++){	
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setHpw(qpw);
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setUdate(rs.getString("udate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return user;
	}
	
	
	public User1DTO userDetail(String id) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		User1DTO user = new User1DTO();
		String wid="";
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, wid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getString("wid"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	
				String vpw = qpw.substring(0, 3);	
				String hpw = "";
				for(int i=0;i<k-3;i++){	
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setHpw(qpw);
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setUdate(rs.getString("udate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return user;
	}

	
	public int updateUser(User1DTO user){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_USER);
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getAddr());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getId());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	public int updateUser2(User1DTO user){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_USER2);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getTel());
			pstmt.setString(3, user.getAddr());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getId());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	
	public int deleteUser(String id){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_USER);
			pstmt.setString(1, id);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	public ArrayList<User1DTO> userList() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		ArrayList<User1DTO> uList = new ArrayList<User1DTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User1DTO user = new User1DTO();
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	
				String vpw = qpw.substring(0, 3);	
				String hpw = "";
				for(int i=0;i<k-3;i++){	
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setHpw(qpw);
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setUdate(rs.getString("udate"));
				uList.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return uList;
	}
	
	public User1DTO getTel(String id) {
		User1DTO user = new User1DTO();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setUdate(rs.getString("udate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return user;
	}
	
	public int resetPassword(String id, String passwd) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_PW_RESET);
			pstmt.setString(1, passwd);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
}






