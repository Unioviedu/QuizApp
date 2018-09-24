package com.uniovi.quizapp.dataacess.dao.general;

import java.util.List;

import com.uniovi.quizapp.dataacess.model.general.IEntity;

public interface IDaoGeneric<ENTITY extends IEntity, ID> {
	
	public void saveOrUpdate(ENTITY entity);
	
	public ENTITY find(ID id);
	
	public List<ENTITY> findAll();
	
	public ENTITY findByField(String field, String fieldValue);
	
	public void delete(ENTITY entity);
	
	public void deleteById(ID id);
}
