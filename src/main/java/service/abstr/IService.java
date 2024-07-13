package main.java.service.abstr;

import java.util.ArrayList;

public interface IService<T> {
	void add(T data);
	void delete(T data);
	void update(T data);
	ArrayList<T> getAll();
}
