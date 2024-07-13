package main.java.repository.impl;

import java.util.ArrayList;

import main.java.repository.abstr.IDao;

public class HibernateDao<T> implements IDao<T> {
	private ArrayList<T> dataList;

	public HibernateDao() {
		this.dataList = new ArrayList<T>();
	}

	@Override
	public void add(T data) {
		dataList.add(data);
		System.out.println("Hibernate ile nesne eklendi.");
	}

	@Override
	public void delete(T data) {
		if (dataList.remove(data)) {
			System.out.println("Hibernate ile nesne silindi.");
		} else {
			System.out.println("Hibernate ile silinmek istenen nesne bulunamadı!");
		}
	}

	@Override
	public void update(T data) {
		int index = dataList.indexOf(data);
		if (index != -1) {
			dataList.set(index, data);
			System.out.println("Hibernate ile nesne güncellendi.");
		} else {
			System.out.println("Hibernate ile güncellenmek istenen nesne bulunamadı!");
		}
	}
	
	public ArrayList<T> getAll() {
		return dataList;
	}
}
