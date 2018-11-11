package com.uniovi.quizapp.dataacess.dao.api;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.history.Section;

public interface ISectionDao extends IDaoGeneric<Section, ObjectId> {
	
	public Section findByCod(Integer cod);
	public Section findFirstSection();

}
