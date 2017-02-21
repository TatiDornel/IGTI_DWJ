package br.igti.webjava.dao;

import java.io.Serializable;
import java.util.List;

public interface IWebJavaDAO<T, PK extends Serializable> {

	void save(T entity);
	
	void update(T entity);
	
	void delete(PK id);
	
	T findById(PK id);
	
	List<T> findByName(String name);
	
	List<T> findAll();

}
