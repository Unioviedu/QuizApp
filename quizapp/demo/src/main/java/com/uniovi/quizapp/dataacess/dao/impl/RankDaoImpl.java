package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IRankDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.user.Rank;

@Service
public class RankDaoImpl extends IDaoGenericImpl<Rank, ObjectId> implements IRankDao {
	
	@Override
	public Rank findByExp(int exp) {
		Rank l = datastore.createQuery(getEntityClass())
				.field("experience")
				.lessThanOrEq(exp)
				.order("-experience")
				.asList().get(0);
		
		return l;
	}
	
	@Override
	public Class<Rank> getEntityClass() {
		return Rank.class;
	}

	@Override
	public Rank findFirstLevelRank() {
		return datastore.createQuery(getEntityClass())
				.field("experience")
				.equal(0).get();
	}

}
