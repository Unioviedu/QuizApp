package com.uniovi.quizapp.dataacess.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ICustomQuestionDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;
import com.uniovi.quizapp.dataacess.model.question.StateQuestion;

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

	@Override
	public List<CustomQuestion> findQuestionForVote(String username) {
		return datastore
				.createQuery(CustomQuestion.class)
				.field("username").notEqual(username)
				.field("state").equal(StateQuestion.CREATED)
				.asList();
	}

	@Override
	public List<CustomQuestion> findQuestionForPlay(String username) {
		return datastore
				.createQuery(CustomQuestion.class)
				.field("username").notEqual(username)
				.field("state").equal(StateQuestion.ACCEPT)
				.asList();
	}

	@Override
	public CustomQuestion voteQuestion(ObjectId id, boolean vote) {
		String field = vote ? "positivesVote" : "negativesVote";
		
		Query<CustomQuestion> query = datastore
				.createQuery(getEntityClass())
				.field("id").equal(id);
		
		UpdateOperations<CustomQuestion> operations = datastore
				.createUpdateOperations(getEntityClass())
				.inc(field);
		
		datastore.update(query, operations);
		return query.get();
	}

	@Override
	public void changeState(ObjectId id, StateQuestion state) {
		Query<CustomQuestion> query = datastore
				.createQuery(getEntityClass())
				.field("id").equal(id);
		
		UpdateOperations<CustomQuestion> operations = datastore
				.createUpdateOperations(getEntityClass())
				.set("state", state);
		
		datastore.update(query, operations);
		
	}

	@Override
	public CustomQuestion responseQuestion(ObjectId id, boolean response) {
		String field = response ? "positivesResponse" : "negativesResponse";
		
		Query<CustomQuestion> query = datastore
				.createQuery(getEntityClass())
				.field("id").equal(id);
		
		UpdateOperations<CustomQuestion> operations = datastore
				.createUpdateOperations(getEntityClass())
				.inc(field);
		datastore.update(query, operations);
		
		return query.get();
	}
	
	

}
