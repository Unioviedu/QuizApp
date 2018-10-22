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
	private ILevelRankDao levelRankDao;

	@Override
	public UserInfoDto responseLevel(ResultLevelDto newResult) {
		CheckUserInfo info = new CheckUserInfo();
		
		User user = userDao.findByUsername(newResult.getUsername());

		user = info.checkNewResult(newResult, user);
		user = info.checkSection(newResult, user);
		user = info.checkChallangesSection(user, newResult.getCodSection());
		user = info.checkChallangesTrophy(user);
		user = info.checkLevelRank(user, getCurrentLevelRank(user));
		
		UserInfoDto response = info.getResponse();
		
		if (info.isUnlockSections())
			unlockedNextSections(user, newResult.getCodSection(), response);

		userDao.saveOrUpdate(user);

		return response;
	}
	
	private UserInfoDto unlockedNextSections(User user, String codSection, UserInfoDto response) {
		Section sectionCurrent = sectionDao.findByCod(codSection);
		List<Challange> challanges = changeDao.findAll();

		for (String codSectionUnlock : sectionCurrent.getNextSections()) {
			Section section = sectionDao.findByCod(codSectionUnlock);
			ResultSection rs = new ResultSection(section, challanges);
			rs.setUnlocked(true);
			user.addResultSection(rs);
			response.addSection(section.getTitle());
		}
		
		return response;
	}
	
	private LevelRank getCurrentLevelRank(User user) {
		return levelRankDao.findByExp(user.getExperience());
	}

}
