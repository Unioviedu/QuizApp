package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.user.User;

@Service
public class UserDaoImpl extends IDaoGenericImpl<User, ObjectId> implements IUserDao {
	
	public User findByUsername(String username) {
		return datastore.createQuery(User.class)
			.field("username").equal(username)
			.get();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}
