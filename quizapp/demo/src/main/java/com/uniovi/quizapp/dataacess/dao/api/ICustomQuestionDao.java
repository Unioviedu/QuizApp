package com.uniovi.quizapp.dataacess.dao.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;

public interface ICustomQuestionDao extends IDaoGeneric<CustomQuestion, ObjectId> {
	
	public List<CustomQuestion> findByUser(String username);

}
