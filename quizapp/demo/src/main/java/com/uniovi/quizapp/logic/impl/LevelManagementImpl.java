package com.uniovi.quizapp.logic.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.api.ILevelRankDao;
import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.model.LevelRank;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.user.ResultChallange;
import com.uniovi.quizapp.dataacess.model.user.ResultLevel;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.api.ILevelManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.logic.general.ChallangeFunction;
import com.uniovi.quizapp.logic.general.TrophyFunction;
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
	@Autowired
	private ILevelRankDao levelRankDao;

	private ResponseLevelDto response;

	@Override
	public ResponseLevelDto responseLevel(ResultLevelDto newResult) {
		response = new ResponseLevelDto();
		User user = userDao.findByUsername(newResult.getUsername());

		ResultSection resultSection = user.getResultSection(newResult.getCodSection());

		checkNewResult(newResult, resultSection, user);
		checkSection(newResult, resultSection, user);
		checkChallangesSection(resultSection);
		checkChallangesTrophy(user);
		checkLevelRank(user);

		userDao.saveOrUpdate(user);

		return response;
	}
	
	private ResultSection checkNewResult(ResultLevelDto newResult, ResultSection resultSection, User user) {
		ResultLevel oldResult = resultSection.getResultLevels().get(newResult.getCodLevel());

		oldResult.sumNumAttemps();

		if (isBetterResult(newResult, oldResult)) {
			oldResult.setNumCorrectQuestion(newResult.getNumCorrectQuestion());
			oldResult.setNumIncorrectQuestion(newResult.getNumIncorrectQuestion());

			if (isComplete(newResult) && !oldResult.isComplete()) {
				oldResult.setComplete(true);
				for (String codLevelUnlock : newResult.getNextLevels()) {
					ResultLevel rl = resultSection.getResultLevels().get(codLevelUnlock);
					rl.setUnlocked(true);
					response.addLevel(rl.getName());
				}
			}
		}
		
		int exp = getExpUser(oldResult.getExperience(),
				newResult.getNumCorrectQuestion(), 
				newResult.getNumIncorrectQuestion(), 
				oldResult.getNumAttemps());
		
		user.sumExp(exp);
		response.addExp(exp);

		return resultSection;
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

		resultSection.setComplete(isComplete);
		resultSection.setCompleteAll(isCompleteAll);
	}

	private void checkChallangesSection(ResultSection resultSection) {
		for (ResultChallange challange : resultSection.getResultChallanges()) {
			if (!challange.isComplete()) {
				boolean isComplete = new ChallangeFunction().checkChallange(challange.getChallange().getCodChallange(), resultSection);
				challange.setComplete(isComplete);
				
				if (isComplete)
					response.addChallange(challange);
			}
		}
	}
	
	private void checkChallangesTrophy (User user) {
		for (ResultChallange trophy: user.getResultTrophies()) {
			if (!trophy.isComplete()) {
				boolean isComplete = new TrophyFunction().checkTrophies(trophy.getChallange().getCodChallange(), user);
				trophy.setComplete(isComplete);
				
				if (isComplete)
					response.addTrophy(trophy);
			}
		}
	}
	
	private void checkLevelRank(User user) {
		LevelRank levelRank = levelRankDao.findByExp(user.getExperience());
		
		user.setLevelRank(levelRank);
	}
	
	private void unlockedNextSections(ResultLevelDto newResult, User user) {
		Section sectionCurrent = sectionDao.findByCod(newResult.getCodSection());

		for (String codSectionUnlock : sectionCurrent.getNextSections()) {
			Section section = sectionDao.findByField("codSection", codSectionUnlock);
			List<Challange> challanges = changeDao.findAll();
			ResultSection rs = new ResultSection(section, challanges);
			rs.setUnlocked(true);
			user.addResultSection(rs);
			response.addSection(section.getTitle());
		}
	}
	
	private int getExpUser(int expBase, int correct, int incorrect, int numAttemps) {
		int e = expBase * (correct - incorrect);
		return (int) (e / Math.pow(numAttemps, 2));
	}

	private boolean isComplete(ResultLevelDto newResult) {
		return newResult.getNumCorrectQuestion() > newResult.getNumIncorrectQuestion();
	}

	private boolean isBetterResult(ResultLevelDto newResult, ResultLevel oldResult) {
		return newResult.getNumCorrectQuestion() > oldResult.getNumCorrectQuestion();
	}

}
