package kr.go.gp.dto;

public class User1DTO {
	private String id;
	private String pw;
	private String hpw;
	private String name;
	private String tel;
	private String addr;
	private String email;
	private String udate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	
	public String getHpw() {
		return hpw;
	}
	public void setHpw(String hpw) {
		this.hpw = hpw;
	}
	@Override
	public String toString() {
		return "User1DTO [id=" + id + ", pw=" + pw + ", hpw=" + hpw + ", name="
				+ name + ", tel=" + tel + ", addr=" + addr + ", email=" + email
				+ ", udate=" + udate + "]";
	}

	
}
