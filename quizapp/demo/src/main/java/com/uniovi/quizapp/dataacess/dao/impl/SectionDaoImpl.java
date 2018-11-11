package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.history.Section;

@Service
public class SectionDaoImpl extends IDaoGenericImpl<Section, ObjectId> implements ISectionDao {

	@Override
	public Class<Section> getEntityClass() {
		return Section.class;
	}

	@Override
	public Section findByCod(Integer codSection) {
		return findByField("orden", codSection).get(0);
	}

	@Override
	public Section findFirstSection() {
		return datastore
				.createQuery(getEntityClass())
				.field("orden")
				.equal(1).get();
	}

}
