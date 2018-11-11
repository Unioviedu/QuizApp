package com.uniovi.quizapp.logic.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.api.IRankDao;
import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.history.Section;
import com.uniovi.quizapp.dataacess.model.user.Rank;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.api.ILevelManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.logic.general.CheckUserInfo;
import com.uniovi.quizapp.service.dto.UserInfoDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

@Service
public class LevelManagementImpl extends AbstractManagement implements ILevelManagement {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private ISectionDao sectionDao;
	@Autowired
	private IChallangeDao changeDao;
	@Autowired
	private IRankDao levelRankDao;
	
	@Override
	public UserInfoDto responseLevel(ResultLevelDto newResult) {
		CheckUserInfo info = new CheckUserInfo();
		
		User user = userDao.findByUsername(newResult.getUsername());
		
		user = info.checkNewResult(newResult, user);
		user = info.checkSection(newResult, user);
		user = info.checkChallangesSection(user, newResult.getIdSection());
		user = info.checkChallangesTrophy(user);
		user = info.checkLevelRank(user, getCurrentLevelRank(user));
		
		UserInfoDto response = info.getResponse();
		
		if (info.isUnlockSections())
			unlockedNextSections(user, newResult.getIdSection(), response);

		userDao.saveOrUpdate(user);

		return response;
	}
	
	private UserInfoDto unlockedNextSections(User user, ObjectId idSection, UserInfoDto response) {
		Section sectionCurrent = sectionDao.find(idSection);
		List<Challange> challanges = changeDao.findAll();

		for (String id : sectionCurrent.getNextSections()) {
			Section section = sectionDao.find(new ObjectId(id));
			ResultSection rs = new ResultSection(section, challanges);
			rs.setUnlocked(true);
			user.addResultSection(rs);
			response.addSection(section.getTitle());
		}
		
		return response;
	}
	
	private Rank getCurrentLevelRank(User user) {
		return levelRankDao.findByExp(user.getExperience());
	}

}
