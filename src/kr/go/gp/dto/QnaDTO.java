package kr.go.gp.dto;

public class QnaDTO {
	private String qnum;
	private String qtitle;
	private String qcontent;
	private String qauthor;
	private String qdate;
	private int lev;
	private String parno;
	public String getQnum() {
		return qnum;
	}
	public void setQnum(String qnum) {
		this.qnum = qnum;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQauthor() {
		return qauthor;
	}
	public void setQauthor(String qauthor) {
		this.qauthor = qauthor;
	}
	public String getQdate() {
		return qdate;
	}
	public void setQdate(String qdate) {
		this.qdate = qdate;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public String getParno() {
		return parno;
	}
	public void setParno(String parno) {
		this.parno = parno;
	}
	@Override
	public String toString() {
		return "QnaDTO [qnum=" + qnum + ", qtitle=" + qtitle + ", qcontent="
				+ qcontent + ", qauthor=" + qauthor + ", qdate=" + qdate
				+ ", lev=" + lev + ", parno=" + parno + "]";
	}

	
}

