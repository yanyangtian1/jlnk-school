package cn.javabs.useradd.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import cn.javabs.useradd.dao.UserDao;
import cn.javabs.useradd.entity.User;
import cn.javabs.useradd.exception.AddUserException;
import cn.javabs.useradd.util.DbcpUtil;

public class UserDaoImpl implements UserDao {
	QueryRunner qr = new QueryRunner(DbcpUtil.getDataSource());

	@Override
	public int addUser(User u) {
		
		try {
			return qr.update("insert into user(username,password,sex) values (?,?,?)",
					u.getUsername(),u.getPassword(),u.getSex());
		} catch (Exception e) {
			throw new AddUserException(e);
		}
	}

}
