package cn.edu.bjut.gct.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cache {

	public static List<User> USERS = Collections.synchronizedList(new ArrayList<User>());
	
}
