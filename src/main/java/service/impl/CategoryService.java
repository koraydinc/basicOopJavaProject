package main.java.service.impl;

import java.util.ArrayList;

import main.java.core.logging.abstr.ILogger;
import main.java.core.utilities.results.Result;
import main.java.model.Category;
import main.java.service.abstr.ICategoryService;
import main.java.service.abstr.IService;

public class CategoryService implements ICategoryService {
	private IService<Category> _service;
	private ArrayList<ILogger> _logServices;

	public CategoryService(ArrayList<ILogger> logServices) {
		this._service = new Service<Category>();
		this._logServices = logServices;
	}

	@Override
	public void add(Category data) {
		Result checkData = checkData(data);
		
		if (checkData.isSuccess()) {
			_service.add(data);
			
		} else {
			System.out.println(checkData.getMessage());
		}
		
		for (ILogger logger : _logServices) {
			logger.log(data.getName());
		}
	}

	@Override
	public void delete(Category data) {
		_service.delete(data);
	}

	@Override
	public void update(Category data) {
		_service.update(data);
	}

	@Override
	public ArrayList<Category> getAll() {
		return _service.getAll();
	}

	private Result checkData(Category data) {
		ArrayList<Category> categories = _service.getAll();

		for (Category category : categories) {
			if (category.getName().equals(data.getName())) {
				return new Result(false, "İlgili kategori kayıtlarda bulunmaktadır!");

			}
		}
		
		return new Result(true);
	}

}
