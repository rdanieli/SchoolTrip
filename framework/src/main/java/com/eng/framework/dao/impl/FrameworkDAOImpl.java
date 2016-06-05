package com.eng.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.eng.framework.authz.model.BaseDAO;
import com.eng.framework.dao.FrameworkDAO;

public abstract class FrameworkDAOImpl<T extends BaseDAO, PK extends Serializable> implements FrameworkDAO<T, PK> {

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

	public List<T> find(T searchEntity) {
		Query query = queryBuilder(searchEntity);
		return query.getResultList();
	}

	/**
	 * @param searchEntity
	 * @return
	 */
	private Query queryBuilder(T searchEntity) {
		StringBuilder sb = new StringBuilder("SELECT e FROM ");
		sb.append(searchEntity.getClass().getSimpleName());
		sb.append(" e ");
		sb.append(" WHERE 1 = 1 ");

		List<Object> values = new ArrayList<Object>();

		for (int i = 0, j = 1; i < searchEntity.getClass().getDeclaredFields().length; i++) {
			Field field = searchEntity.getClass().getDeclaredFields()[i];
			field.setAccessible(true);
			try {
				Object value = field.get(searchEntity);

				if (value != null) {
					sb.append(" AND e.");
					sb.append(field.getName());
					// TODO: Modificar para aceitar qualquer condição
					sb.append(" = ?");
					sb.append(String.valueOf(j++));
					values.add(value);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		Query query = entityManager.createQuery(sb.toString());

		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + 1, values.get(i));
		}
		return query;
	}

	public T findUnique(T searchEntity) {
		Query query = queryBuilder(searchEntity);

		T r = null;
		try {
			//TODO:Melhorar este escopo, usar singleResult somente para contabilizações
			
			r = (T) query.getSingleResult();
		} catch (NoResultException e) {
			// silent
		}

		return r;
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

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
