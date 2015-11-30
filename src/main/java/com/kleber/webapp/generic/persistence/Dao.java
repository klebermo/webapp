package com.kleber.webapp.generic.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Dao<E> {
	
	@Autowired
	private EntityManagerFactory factory;

	protected Class<E> clazz;
	
	public Dao(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public void insert(E object) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void update(E object) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(object);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void delete(E object) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(object) ? object : entityManager.merge(object));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<E> select() {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		List<E> lista = entityManager.createQuery("SELECT a FROM "+clazz.getSimpleName()+" a").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return lista;
	}
	
	public List<E> select(Object id) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		List<E> lista = entityManager.createQuery("SELECT a FROM "+clazz.getSimpleName()+" a WHERE a.id = :id").setParameter("id", id).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return lista;
	}
	
	public List<E> select(String key, String value) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		List<E> lista = entityManager.createQuery("SELECT a FROM "+clazz.getSimpleName()+" a WHERE a."+key+" = :value").setParameter("value", value).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return lista;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
