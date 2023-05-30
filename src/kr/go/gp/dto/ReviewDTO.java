package kr.go.gp.dto;

public class ReviewDTO {
	private String rnum;
	private String rtitle;
	private String rcontent;
	private String rauthor;
	private String File1;
	private String rdate;
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRauthor() {
		return rauthor;
	}
	public void setRauthor(String rauthor) {
		this.rauthor = rauthor;
	}
	public String getFile1() {
		return File1;
	}
	public void setFile1(String file1) {
		File1 = file1;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "ReviewDTO [rnum=" + rnum + ", rtitle=" + rtitle + ", rcontent="
				+ rcontent + ", rauthor=" + rauthor + ", File1=" + File1
				+ ", rdate=" + rdate + "]";
	}
	


}

