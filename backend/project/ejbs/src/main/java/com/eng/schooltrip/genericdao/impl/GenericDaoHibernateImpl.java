package com.eng.schooltrip.genericdao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import com.eng.schooltrip.genericdao.GenericDao;

public abstract class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@PersistenceUnit(name="TRIP_DB")
	EntityManager entityManager;
	
	private Class<T> type;
	
	public void create(T o) {
		entityManager.persist(o);
	}

	public T read(PK id) {
		return (T) entityManager.find(getClazz(), id);
	}

	public void update(T o) {
		entityManager.merge(o);
	}

	public void delete(T o) {
		entityManager.remove(o);
	}
	
	public List<T> find(){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getClazz() {
		if (type == null) {
			Type type = getClass().getGenericSuperclass();

			if (type instanceof ParameterizedType) {
				type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
			} else {
				type = ((Class<?>) type).getGenericSuperclass();
			}

			this.type = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
		}

		return this.type;
	}
}
