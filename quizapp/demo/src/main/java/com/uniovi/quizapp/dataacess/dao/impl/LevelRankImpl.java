package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ILevelRankDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.user.LevelRank;

@Service
public class LevelRankImpl extends IDaoGenericImpl<LevelRank, ObjectId> implements ILevelRankDao {
	
	@Override
	public LevelRank findByExp(int exp) {
		LevelRank l = datastore.createQuery(getEntityClass())
				.field("experience")
				.lessThanOrEq(exp)
				.order("-experience")
				.asList().get(0);
		
		return l;
	}
	
	@Override
	public Class<LevelRank> getEntityClass() {
		return LevelRank.class;
	}

	@Override
	public LevelRank findFirstLevelRank() {
		return datastore.createQuery(getEntityClass())
				.field("experience")
				.equal(0).get();
	}

}
