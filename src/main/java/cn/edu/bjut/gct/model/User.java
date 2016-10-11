package cn.edu.bjut.gct.model;

public class User {

	private String userName;
	private String passWord;
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(String name, String pass, String mail){
		userName = name;
		passWord = pass;
		email = mail;
	}
}
