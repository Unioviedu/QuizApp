package com.uniovi.quizapp.dataacess.dao.general;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.uniovi.quizapp.dataacess.model.general.IEntity;

public abstract class IDaoGenericImpl<ENTITY extends IEntity, ID> {
	
	@Autowired
	public Datastore datastore;
	
	public void saveOrUpdate(ENTITY entity) {
		datastore.merge(entity);
	}
	
	public ENTITY find(ID id) {
		return datastore.createQuery(getEntityClass())
				.field("id").equal(id)
				.get();
	}
	
	public List<ENTITY> findAll() {
		return datastore.find(getEntityClass())
				.asList();
	}
	
	public ENTITY findByField (String field, String fieldValue) {
		return datastore.createQuery(getEntityClass())
				.field(field).equal(fieldValue)
				.get();
	}
	
	public void delete (ENTITY entity) {
		datastore.delete(entity);
	}
	
	public void deleteById (ID id) {
		final Query<ENTITY> entityById = datastore
				.createQuery(getEntityClass())
				.field("id").equal(id);
		
		datastore.delete(entityById);
	}
	
	public abstract Class<ENTITY> getEntityClass();

}
