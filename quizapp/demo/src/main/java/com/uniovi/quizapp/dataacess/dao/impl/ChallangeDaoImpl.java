package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.challange.ChallangeType;

@Service
public class ChallangeDaoImpl extends IDaoGenericImpl<Challange, ObjectId> implements IChallangeDao {

	@Override
	public Challange findAllChallangeSection() {
		return datastore.createQuery(getEntityClass())
				.field("type")
				.equal(ChallangeType.SECTION)
				.get();
	}

	@Override
	public Challange findAllTrohpies() {
		return datastore.createQuery(getEntityClass())
				.field("type")
				.equal(ChallangeType.TROPHY)
				.get();
	}
	
	@Override
	public Class<Challange> getEntityClass() {
		return Challange.class;
	}

}
