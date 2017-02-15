package com.silen.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable, PK extends Object> {
	List<T> findAll();

	T findById(Integer id);

	int insert(T entity);

	int update(T entity);

	int delete(Integer id);
}
