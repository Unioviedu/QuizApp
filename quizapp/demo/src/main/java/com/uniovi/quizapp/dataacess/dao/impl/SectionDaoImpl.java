package com.uniovi.quizapp.dataacess.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.general.IDaoGenericImpl;
import com.uniovi.quizapp.dataacess.model.Section;

@Service
public class SectionDaoImpl extends IDaoGenericImpl<Section, ObjectId> implements ISectionDao {

	@Override
	public Class<Section> getEntityClass() {
		return Section.class;
	}

	@Override
	public Section findByCod(String codSection) {
		return findByField("codSection", codSection);
	}

}
