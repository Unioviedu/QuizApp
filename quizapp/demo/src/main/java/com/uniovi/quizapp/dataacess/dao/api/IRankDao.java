package com.uniovi.quizapp.dataacess.dao.api;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.user.Rank;

public interface IRankDao extends IDaoGeneric<Rank, ObjectId> {
	
	public Rank findByExp(int exp);
	public Rank findFirstLevelRank();

}
