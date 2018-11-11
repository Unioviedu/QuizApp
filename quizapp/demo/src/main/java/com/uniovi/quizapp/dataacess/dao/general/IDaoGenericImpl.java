package com.uniovi.quizapp.dataacess.dao.general;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;

import com.uniovi.quizapp.dataacess.model.general.IEntity;

public abstract class IDaoGenericImpl<ENTITY extends IEntity, ID> implements IDaoGeneric<ENTITY, ID>{
	
	@Autowired
	public Datastore datastore;
	
	public void saveOrUpdate(ENTITY entity) {
		datastore.save(entity);
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
	
	public List<ENTITY> findByField (String field, String fieldValue) {
		return datastore.createQuery(getEntityClass())
				.field(field).equal(fieldValue)
				.asList();
	}
	
	public List<ENTITY> findByField (String field, Integer fieldValue) {
		return datastore.createQuery(getEntityClass())
				.field(field).equal(fieldValue)
				.asList();
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
	
	public boolean update(Query<ENTITY> query, UpdateOperations<ENTITY> operations) {
		return datastore.update(query, operations).getUpdatedExisting();
	}
	
	public abstract Class<ENTITY> getEntityClass();

}
