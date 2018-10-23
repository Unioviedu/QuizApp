package com.uniovi.quizapp.logic.general;

import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;
import com.uniovi.quizapp.dataacess.model.user.LevelRank;
import com.uniovi.quizapp.dataacess.model.user.ResultChallange;
import com.uniovi.quizapp.dataacess.model.user.ResultLevel;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.service.dto.UserInfoDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

@Service
@Configurable
public class CheckUserInfo {
	
	private UserInfoDto response;
	
	private boolean unlockSections;
	
	public CheckUserInfo() {
		response = new UserInfoDto();
	}
	
	public User checkNewResult(ResultLevelDto newResult, User user) {
		ResultSection resultSection = user.getResultSection(newResult.getCodSection());
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

		return user;
	}
	
	public User checkResponseCustomQuestion(User user, CustomQuestion question, boolean isCorrect) {
		int exp;
		
		if (isCorrect) {
			exp = 20;
		} else {
			exp = -20;
		}
		
		user.sumExp(exp);
		response.setNewExp(exp);
		
		return user;
	}
	
	public User checkSection(ResultLevelDto newResult, User user) {
		ResultSection resultSection = user.getResultSection(newResult.getCodSection());
		
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
			unlockSections = true;

		resultSection.setComplete(isComplete);
		resultSection.setCompleteAll(isCompleteAll);
		
		return user;
	}

	public User checkChallangesSection(User user, String codSection) {
		ResultSection resultSection = user.getResultSection(codSection);
		
		for (ResultChallange challange : resultSection.getResultChallanges()) {
			if (!challange.isComplete()) {
				boolean isComplete = new ChallangeFunction().checkChallange(challange.getChallange().getCodChallange(), resultSection);
				challange.setComplete(isComplete);
				
				if (isComplete)
					response.addChallange(challange);
			}
		}
		
		return user;
	}
	
	public User checkChallangesTrophy (User user) {
		for (ResultChallange trophy: user.getResultTrophies()) {
			if (!trophy.isComplete()) {
				boolean isComplete = new TrophyFunction().checkTrophies(trophy.getChallange().getCodChallange(), user);
				trophy.setComplete(isComplete);
				
				if (isComplete)
					response.addTrophy(trophy);
			}
		}
		
		return user;
	}
	
	public User checkLevelRank(User user, LevelRank newRank) {
		if (!user.getLevelRank().equals(newRank)) {
			response.setNewRank(newRank);
			user.setLevelRank(newRank);
		}
		
		return user;
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
	
	public UserInfoDto getResponse() {
		return response;
	}
	
	public boolean isUnlockSections() {
		return unlockSections;
	}

}
