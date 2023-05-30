package kr.go.gp.dto;

public class CategoryDTO {
	private String ct;
	private String cate;
	private String catename;
	private String categroup;
	private String bnum;
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getCategroup() {
		return categroup;
	}
	public void setCategroup(String categroup) {
		this.categroup = categroup;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	@Override
	public String toString() {
		return "CategoryDTO [ct=" + ct + ", cate=" + cate + ", catename="
				+ catename + ", categroup=" + categroup + ", bnum=" + bnum
				+ "]";
	}

}
