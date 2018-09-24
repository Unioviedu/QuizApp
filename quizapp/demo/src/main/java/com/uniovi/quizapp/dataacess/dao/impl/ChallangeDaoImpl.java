package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.Challange;

@Service
public class ChallangeDaoImpl extends IDaoGenericImpl<Challange, ObjectId> implements IChallangeDao {

	@Override
	public Class<Challange> getEntityClass() {
		return Challange.class;
	}

}
