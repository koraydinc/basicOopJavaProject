package main.java.repository.impl;

import java.util.ArrayList;

import main.java.repository.abstr.IDao;

public class JdbcDao<T> implements IDao<T> {
	private ArrayList<T> dataList;
	
	public JdbcDao() {
		this.dataList = new ArrayList<T>();
	}

	@Override
	public void add(T data) {
		dataList.add(data);
		System.out.println("JDBC ile nesne eklendi.");
	}

	@Override
	public void delete(T data) {
		if (dataList.remove(data)) {
			System.out.println("JDBC ile nesne silindi.");
		} else {
			System.out.println("JDBC ile silinmek istenen nesne bulunamadı!");
		}
	}

	@Override
	public void update(T data) {
		int index = dataList.indexOf(data);
		if (index != -1) {
			dataList.set(index, data);
			System.out.println("JDBC ile nesne güncellendi.");
		} else {
			System.out.println("JDBC ile güncellenmek istenen nesne bulunamadı!");
		}
	}
	
	public ArrayList<T> getAll() {
		return dataList;
	}
}
