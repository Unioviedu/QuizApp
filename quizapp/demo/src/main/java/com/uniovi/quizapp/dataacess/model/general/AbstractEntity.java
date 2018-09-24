package com.uniovi.quizapp.dataacess.model.general;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
public abstract class AbstractEntity<T> implements IEntity{
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private T id;
	
	public T getId() {
		return id;
	}

}
