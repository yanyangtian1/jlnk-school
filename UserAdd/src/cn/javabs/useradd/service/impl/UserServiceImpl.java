package cn.javabs.useradd.service.impl;

import cn.javabs.useradd.dao.UserDao;
import cn.javabs.useradd.dao.impl.UserDaoImpl;
import cn.javabs.useradd.entity.User;
import cn.javabs.useradd.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();

	@Override
	public int addUser(User u)  {
		
		return dao.addUser(u);
	}

}
