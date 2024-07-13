package main.java.service.impl;

import java.util.ArrayList;

import main.java.repository.abstr.IDao;
import main.java.repository.impl.HibernateDao;
//import main.java.repository.impl.JdbcDao;
import main.java.service.abstr.IService;

public class Service<T> implements IService<T> {
	private IDao<T> dao;

	public Service() {
		this.dao = new HibernateDao<T>();
	}

	public void add(T data) {
		dao.add(data);
	}

	public void delete(T data) {
		dao.delete(data);
	}

	public void update(T data) {
		dao.update(data);
	}
   
	public ArrayList<T> getAll(){
		return dao.getAll();
	};
	
}
