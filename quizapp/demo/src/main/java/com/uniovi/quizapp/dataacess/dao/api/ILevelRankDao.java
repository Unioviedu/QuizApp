package com.uniovi.quizapp.dataacess.dao.api;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.user.LevelRank;

public interface ILevelRankDao extends IDaoGeneric<LevelRank, ObjectId> {
	
	public LevelRank findByExp(int exp);
	public LevelRank findFirstLevelRank();

}
