package com.uniovi.quizapp.dataacess.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ICustomQuestionDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;

@Service
public class CustomQuestionDaoImpl extends IDaoGenericImpl<CustomQuestion, ObjectId> implements ICustomQuestionDao {

	@Override
	public List<CustomQuestion> findByUser(String username) {
		return findByField("username", username);
	}
	
	@Override
	public Class<CustomQuestion> getEntityClass() {
		return CustomQuestion.class;
	}

}