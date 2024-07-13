package main.java.controller;

import main.java.model.Category;
import main.java.service.impl.CategoryService;

public class CategoryController {
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void add(Category course) {
		categoryService.add(course);
	};
}
