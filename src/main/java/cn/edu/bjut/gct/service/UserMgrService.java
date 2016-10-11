package cn.edu.bjut.gct.service;

import cn.edu.bjut.gct.model.User;

public interface UserMgrService {
	
	public boolean IsUserExist(String name);
	
	public void AddUser(User user);
	
	public boolean Login(String name, String pass);
	
}
