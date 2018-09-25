package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.api.ILevelDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.Level;

public class LevelDaoImpl extends IDaoGenericImpl<Level, ObjectId> implements ILevelDao {

	@Override
	public Class<Level> getEntityClass() {
		return Level.class;
	}

}
