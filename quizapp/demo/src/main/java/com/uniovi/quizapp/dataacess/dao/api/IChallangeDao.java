package com.uniovi.quizapp.dataacess.dao.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.dao.general.IDaoGeneric;
import com.uniovi.quizapp.dataacess.model.challange.Challange;

public interface IChallangeDao extends IDaoGeneric<Challange, ObjectId>{
	
	public List<Challange> findAllChallangeSection();
	public List<Challange> findAllTrohpies();

}
