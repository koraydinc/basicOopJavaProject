package main.java.repository.abstr;

import java.util.ArrayList;

public interface IDao<T> {
	void add(T data);
	void delete(T data);
	void update(T data);
	ArrayList<T> getAll();
}
