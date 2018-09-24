package com.uniovi.quizapp.logic.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.model.Challange;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.user.ResultChallange;
import com.uniovi.quizapp.dataacess.model.user.ResultLevel;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.api.ILevelManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.logic.general.ChallangeFunction;
import com.uniovi.quizapp.service.dto.level.ResponseLevelDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

@Service
public class LevelManagementImpl extends AbstractManagement implements ILevelManagement {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private ISectionDao sectionDao;
	@Autowired
	private IChallangeDao changeDao;

	private ResponseLevelDto response;

	@Override
	public ResponseLevelDto responseLevel(ResultLevelDto newResult) {
		response = new ResponseLevelDto();
		User user = userDao.findByField("username", newResult.getUsername());

		ResultSection resultSection = user.getResultSection(newResult.getCodSection());

		checkNewResult(newResult, resultSection);
		checkSection(newResult, resultSection, user);
		checkChallangesSection(resultSection);

		userDao.saveOrUpdate(user);

		return response;
	}

	private void checkChallangesSection(ResultSection resultSection) {
		for (ResultChallange challange : resultSection.getResultChallanges()) {
			boolean isComplete = new ChallangeFunction().checkChallange(challange.getCodChallange(), resultSection);
			challange.setComplete(isComplete);
		}
	}

	private void checkSection(ResultLevelDto newResult, ResultSection resultSection, User user) {
		boolean isCompleteBefore = resultSection.isComplete();
		
		boolean isComplete = true;
		boolean isCompleteAll = true;

		for (Map.Entry<String, ResultLevel> level : resultSection.getResultLevels().entrySet()) {
			if (!level.getValue().isComplete()) {
				isCompleteAll = false;
				if (level.getValue().isMain())
					isComplete = false;
			}
		}
		
		if (isComplete && !isCompleteBefore)
			unlockedNextSections(newResult, user);

		resultSection.setComplete(isCompleteAll);
	}

	private void unlockedNextSections(ResultLevelDto newResult, User user) {
		Section sectionCurrent = sectionDao.findByField("codSection", newResult.getCodSection());

		for (String codSectionUnlock : sectionCurrent.getNextSections()) {
			Section section = sectionDao.findByField("codSection", codSectionUnlock);
			List<Challange> challanges = changeDao.findAll();
			ResultSection rs = new ResultSection(section, challanges);
			rs.setUnlocked(true);
			user.addResultSection(rs);
			response.addSection(rs);
		}
	}

	private ResultSection checkNewResult(ResultLevelDto newResult, ResultSection resultSection) {
		ResultLevel oldResult = resultSection.getResultLevels().get(newResult.getCodLevel());

		oldResult.sumNumAttemps();

		if (isBetterResult(newResult, oldResult)) {
			oldResult.setNumCorrectQuestion(newResult.getNumCorrectQuestion());
			oldResult.setNumIncorrectQuestion(newResult.getNumIncorrectQuestion());

			if (isComplete(newResult) && !oldResult.isComplete()) {
				oldResult.setComplete(true);
				for (String codLevelUnlock : newResult.getNextLevels()) {
					ResultLevel level = resultSection.getResultLevels().get(codLevelUnlock);
					level.setUnlocked(true);
					response.addLevel(level);
				}
			}
		}

		return resultSection;
	}

	private boolean isComplete(ResultLevelDto newResult) {
		return newResult.getNumCorrectQuestion() > newResult.getNumIncorrectQuestion();
	}

	private boolean isBetterResult(ResultLevelDto newResult, ResultLevel oldResult) {
		return newResult.getNumCorrectQuestion() > oldResult.getNumCorrectQuestion();
	}

}
