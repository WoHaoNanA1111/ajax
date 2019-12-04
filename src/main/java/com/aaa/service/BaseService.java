package com.aaa.service;

import java.util.List;

import com.aaa.dao.BaseDao;

public abstract class BaseService<T> {
	public abstract BaseDao<T> getDao();
	public void insert(T entity){
		getDao().insert(entity);
	}
	public void delete(T entity){
		getDao().delete(entity);
	}
	public void update(T entity){
		getDao().update(entity);
	}
	public T findOne(T entity){
		return getDao().findOne(entity);
	}
	public List<T> findAll(){
		return getDao().findAll();
	}
}
