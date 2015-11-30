package com.kleber.webapp.generic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kleber.webapp.generic.persistence.Dao;

public abstract class basicService<E> {
	
	@Autowired
	protected Dao<E> dao;

	protected Class<E> clazz;
	
	public basicService(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public void insert(E object) {
		dao.insert(object);
	}
	
	public void update(E object) {
		dao.update(object);
	}
	
	public void delete(E object) {
		dao.delete(object);
	}
	
	public List<E> select() {
		return dao.select();
	}
	
	public List<E> select(Object id) {
		return dao.select(id);
	}
	
	public List<E> select(String key, String value) {
		return dao.select(key, value);
	}
	
}
