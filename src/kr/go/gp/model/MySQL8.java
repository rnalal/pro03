package kr.go.gp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL8 {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/gp?serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pass = "1234";
	
	/*user1*/
	final static String USER_SELECT_ALL = "select * from user1";
	final static String USER_LOGIN = "select * from user1 where id=?";
	final static String INSERT_USER = "insert into user1(id, pw, name, tel, addr, email) values (?,?,?,?,?,?)";
	final static String UPDATE_USER	= "update user1 set pw=?, name=?, tel=?, addr=?, email=? where id=?";
	final static String UPDATE_USER2 = "update user1 set name=?, tel=?, addr=?, email=? where id=?";
	final static String DELETE_USER = "delete from user1 where id=?";
	final static String UPDATE_PW_RESET = "update user1 set pw=? where id=?";
	
	/*review*/
	final static String REV_GENERATOR = "select rnum from (select * from review order by rnum desc) where rownum = 1";
	final static String ALL_REVIEW = "select * from review";
	final static String REVIEW_SELECT_ONE = "select * from review where rnum=?";
	final static String ADD_REVIEW = "insert into review values (default,?,?,?,?,default)";
	final static String UPDATE_REVIEW = "update review set rcontent=?, rtitle=? where rnum=?";
	final static String UPDATE_REVIEW2 = "update review set rcontent=?, rtitle=?, file1=? where rnum=?";
	final static String DELETE_REVIEW = "delete from review where rnum=?";
	
	/*qna*/
	/*final static String QNUM_GENERATOR = "select qnum from (select * from qna order by qnum desc)a where rownum = 1";*/
	final static String QNUM_GENERATOR = "select @rownum:=@rownum+1, A.* from qna a, (select @rownum:=0)r";
	final static String ADD_QNA = "insert into qna values (?,?,?,?,default,1,?)";
	final static String ADD_REPLY = "insert into qna values (?,?,?,?,default,2,?)";
	final static String QNA_LIST = "select * from qna order by parno desc, qnum desc";
	final static String QNA_SELECT = "select * from qna where parno=? order by qnum desc";
	final static String QNA_SELECT_ONE = "select * from qna where qnum=?";
	final static String REPLY_LIST = "select * from qna where parno=? and lev=2 order by qnum desc";
	final static String REPLY_SELECT = "select * from qna where parno=? and lev=2 order by qnum desc";
	final static String REPLY_SELECT_ONE = "select * from qna where lev=2 and qnum=? order by qnum desc";
	final static String UPDATE_QNA = "update qna set qtitle=?, qcontent=? where qnum=?";
	final static String DELETE_QNA = "delete from qna where qnum=?";
	final static String DELETE_REPLY = "delete from qna where qnum=?";
	
	
	/*notice*/
	final static String NNUM_GENERATER="select nnum from (select * from notice order by nnum desc) where rownum = 1";
	final static String NOTICE_SELECT_ALL = "select * from notice";
	final static String NOTICE_SELECT_ONE = "select * from notice where nnum=?";
	final static String INSERT_NOTICE = "insert into notice values (?,?,?,?,?,default)";
	final static String UPDATE_NOTICE = "update notice set ntitle=?, ncontent=?, file1=? where nnum=?";
	final static String UPDATE_NOTICE2 = "update notice set ntitle=?, ncontent=? where nnum=?";
	final static String DELETE_NOTICE = "delete from notice where nnum=?";
	
	/*board*/
	final static String BOARD_CATENAME_SELECT = "select * from category where cate=?";
	final static String BOARD_SELECT_ALL = "select * from board order by cate desc";
	final static String BOARD_SELECT = "select * from board where bnum=?";
	final static String BOARD_CATE_SELECT = "select * from board where cate=?";
	final static String BOARD_CATE_SELECT2 = "select * from board where cate like ?||'%'";
	final static String BOARD_CATE_SELECT3 = "select * from board where cate like concat(?, '%')";
	final static String FIRST_CATEGORY_SELECT = "select distinct substr(cate,1,2) as ct, categroup from category group by substr(cate,1,2), categroup order by ct";
	final static String SECOND_CATEGORY_SELECT = "select cate, catename from category where cate like ?||'%' order by cate";
	final static String BNUM_GENERATOR = "select bnum from (select * from board where cate=? order by bnum desc) where rownum = 1";
	final static String INSERT_BOARD = "insert into board values(?,?,?,?,default,?,?,?,?,?,?)";
	final static String UPDATE_BOARD2 = "update board set btitle=?, bcontent=?, bauthor=?, bdate=sysdate, pic1=?, pic2=?, pic3=?, pic4=?, pic5=?, cate=? where bnum=?";
	final static String DELETE_BOARD = "delete from board where bnum=?";
	final static String CATEGORY_ALL = "select * from category order by cate asc";
	final static String CATEGORY_SELECT = "select * from category where categroup=? order by cate asc";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	public static void close(PreparedStatement pstmt, Connection con){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
