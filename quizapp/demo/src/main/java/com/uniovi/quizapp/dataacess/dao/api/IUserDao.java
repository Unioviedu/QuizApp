package com.uniovi.quizapp.dataacess.dao.api;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.user.User;

public interface IUserDao extends IDaoGeneric<User, ObjectId> {
	
	public User findByUsername(String username);

}
