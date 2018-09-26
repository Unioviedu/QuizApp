package com.uniovi.quizapp.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.api.IUserManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.service.dto.UserDto;

@Service
public class UserManagementImpl extends AbstractManagement implements IUserManagement {

	@Autowired
	private IUserDao userDao;

	@Override
	public UserDto getUser(String username) {
		User user = userDao.findByUsername(username);
		UserDto userDto = mapper.convertValue(user, UserDto.class);

		return userDto;
	}

	
}
