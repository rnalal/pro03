package kr.go.gp.dto;

public class BoardDTO {
	private String bnum;
	private String btitle;
	private String bcontent;
	private String bauthor;
	private String bdate;
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String cate;
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}
	public String getPic4() {
		return pic4;
	}
	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
	public String getPic5() {
		return pic5;
	}
	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}
	
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	@Override
	public String toString() {
		return "BoardDTO [bnum=" + bnum + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bauthor=" + bauthor + ", bdate=" + bdate
				+ ", pic1=" + pic1 + ", pic2=" + pic2 + ", pic3=" + pic3
				+ ", pic4=" + pic4 + ", pic5=" + pic5 + ", cate=" + cate + "]";
	}
}