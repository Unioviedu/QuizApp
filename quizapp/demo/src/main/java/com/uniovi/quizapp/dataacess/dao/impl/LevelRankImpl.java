package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.api.ILevelRankDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.LevelRank;

public class LevelRankImpl extends IDaoGenericImpl<LevelRank, ObjectId> implements ILevelRankDao {
	
	@Override
	public LevelRank findByExp(int exp) {
		return datastore.createQuery(getEntityClass()).field("experience").greaterThanOrEq(exp).order("experience").asList().get(0);
	}
	
	@Override
	public Class<LevelRank> getEntityClass() {
		return LevelRank.class;
	}

}
