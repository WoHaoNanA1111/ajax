package com.aaa.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {
	@Autowired
	public SessionFactory factory;
	public Class<?> clazz=null;
	public BaseDao(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<?>) type.getActualTypeArguments()[0];
	}
	public void insert(T entity){
		Session session=factory.openSession();
		Transaction tn=session.beginTransaction();
		session.save(entity);
		tn.commit();
		session.close();
	}
	public void delete(T entity){
		Session session=factory.openSession();
		Transaction tn=session.beginTransaction();
		session.delete(entity);
		tn.commit();
		session.close();
	}
	public void update(T entity){
		Session session=factory.openSession();
		Transaction tn=session.beginTransaction();
		session.update(entity);
		tn.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	public T findOne(T entity){
		Session session=factory.openSession();
		Transaction tn=session.beginTransaction();
		Object obj=null;
		Method[] ms=clazz.getDeclaredMethods();
		for(Method m:ms){
			Id id=m.getAnnotation(Id.class);
			if(id!=null){
				try {
					obj=m.invoke(entity);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		entity=(T) session.get(entity.getClass(), Integer.valueOf(obj.toString()));
		tn.commit();
		session.close();
		return entity;
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Session session=factory.openSession();
		Transaction tn=session.beginTransaction();
		String entityName=null;
		Entity e=clazz.getAnnotation(Entity.class);
		if(e==null){
			return null;
		}else if(!"".equals(e.name())){
			entityName=e.name();
		}else{
			entityName=clazz.getSimpleName();
		}
		List<T> list=session.createQuery("from "+entityName).list();
		tn.commit();
		session.close();
		return list;
	}
}
