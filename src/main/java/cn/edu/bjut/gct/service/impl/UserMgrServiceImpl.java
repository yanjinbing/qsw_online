package cn.edu.bjut.gct.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.bjut.gct.service.UserMgrService;
import cn.edu.bjut.gct.model.Cache;
import cn.edu.bjut.gct.model.User;

@Service
public class UserMgrServiceImpl implements UserMgrService {

	@Override
	public boolean IsUserExist(String name){
		boolean exists = false;
		for(User u : Cache.USERS){
			if(u.getUserName().equals(name)){
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	@Override
	public void AddUser(User user){
		Cache.USERS.add(user);
	}

	@Override
	public boolean Login(String name, String pass){
		boolean flag = false;
		for(User u : Cache.USERS){
			if(u.getUserName().equals(name) && u.getPassWord().equals(pass)){
				flag = true;
				break;
			}
		}
		return flag;
	}
}
