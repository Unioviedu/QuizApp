package com.uniovi.quizapp.dataacess.dao.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;
import com.uniovi.quizapp.dataacess.model.question.StateQuestion;

public interface ICustomQuestionDao extends IDaoGeneric<CustomQuestion, ObjectId> {
	
	public List<CustomQuestion> findByUser(String username);
	
	public List<CustomQuestion> findQuestionForVote(String username);

	public List<CustomQuestion> findQuestionForPlay(String username);
	
	public void voteQuestion(ObjectId id, boolean vote);
	
	public void changeState(ObjectId id, StateQuestion state);

}
