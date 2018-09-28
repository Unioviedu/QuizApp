package com.uniovi.quizapp.dataacess.dao.api;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.challange.Challange;

public interface IChallangeDao extends IDaoGeneric<Challange, ObjectId>{
	
	public Challange findAllChallangeSection();
	public Challange findAllTrohpies();

}
