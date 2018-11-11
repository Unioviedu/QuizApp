package com.uniovi.quizapp.logic.general;

import java.util.HashMap;
import java.util.function.Function;

import com.uniovi.quizapp.dataacess.model.user.User;

public class TrophyFunction {
	
	private HashMap<Integer, Function<User, Boolean>> functions = new HashMap<>();
	
	public static int FIRST_SECTION_COMPLETE = 50;
	private Function<User, Boolean> firstSectionComplete;
	
	public TrophyFunction() {
		createFunctions();
	}
	
	public boolean checkTrophies(int codTrophy, User user) {
		return functions.get(codTrophy).apply(user);
	}
	
	private void createFunctions() {
		firstSectionComplete = user -> {
			return user.getResultSections().entrySet().size() > 1;
		};
		
		functions.put(FIRST_SECTION_COMPLETE, firstSectionComplete);
	}

}
