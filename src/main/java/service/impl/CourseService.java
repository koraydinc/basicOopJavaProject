package main.java.service.impl;

import java.util.ArrayList;

import main.java.core.logging.abstr.ILogger;
import main.java.core.utilities.results.Result;
import main.java.model.Course;
import main.java.service.abstr.ICourseService;
import main.java.service.abstr.IService;

public class CourseService implements ICourseService {
	private IService<Course> _service;
	private ArrayList<ILogger> _logServices;

	public CourseService(ArrayList<ILogger> logServices) {
		this._service = new Service<Course>();
		this._logServices = logServices;
	}

	@Override
	public void add(Course data) {
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
	public void delete(Course data) {
		_service.delete(data);
	}

	@Override
	public void update(Course data) {
		_service.update(data);
	}

	@Override
	public ArrayList<Course> getAll() {
		return _service.getAll();
	}

	private Result checkData(Course data) {
		ArrayList<Course> courses = _service.getAll();

		if (data.getPrice() <= 0) {
			return new Result(false, "Kursun fiyatı 0'dan küçük olamaz!");
		}

		for (Course course : courses) {
			if (course.getName().equals(data.getName())) {
				return new Result(false, "İlgili kurs kayıtlarda bulunmaktadır!");
			}

		}

		return new Result(true);
	}
}
