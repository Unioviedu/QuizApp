package com.uniovi.quizapp.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.api.ILevelRankDao;
import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.user.LevelRank;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.api.IUserManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.service.dto.UserDto;

@Service
public class UserManagementImpl extends AbstractManagement implements IUserManagement {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private ISectionDao sectionDao;
	@Autowired
	private IChallangeDao challangeDao;
	@Autowired
	private ILevelRankDao levelRankDao;

	@Override
	public UserDto getUser(String username) {
		User user = userDao.findByUsername(username);
		UserDto userDto = mapper.convertValue(user, UserDto.class);

		return userDto;
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		Section firstSection = sectionDao.findFirstSection();
		List<Challange> challanges = challangeDao.findAllChallangeSection();
		List<Challange> trophies = challangeDao.findAllTrohpies();
		LevelRank firstLevelRank = levelRankDao.findFirstLevelRank();
		
		User user = new User(
				userDto.getUsername(), 
				userDto.getPassword(), 
				userDto.getMail(),
				firstSection,
				challanges,
				trophies,
				firstLevelRank
				);
		
		userDao.saveOrUpdate(user);
				
		return userDto;
	}

	
}
