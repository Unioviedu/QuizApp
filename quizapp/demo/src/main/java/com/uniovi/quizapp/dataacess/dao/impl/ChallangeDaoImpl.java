package com.uniovi.quizapp.dataacess.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.IChallangeDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.challange.ChallangeType;

@Service
public class ChallangeDaoImpl extends IDaoGenericImpl<Challange, ObjectId> implements IChallangeDao {

	@Override
	public List<Challange> findAllChallangeSection() {
		return datastore.createQuery(getEntityClass())
				.field("challangeType")
				.equal(ChallangeType.SECTION)
				.asList();
	}

	@Override
	public List<Challange> findAllTrohpies() {
		return datastore.createQuery(getEntityClass())
				.field("challangeType")
				.equal(ChallangeType.TROPHY)
				.asList();
	}
	
	@Override
	public Class<Challange> getEntityClass() {
		return Challange.class;
	}

}
