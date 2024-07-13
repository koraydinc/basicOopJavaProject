package main.java;

import java.util.ArrayList;

import main.java.controller.CourseController;
import main.java.model.Course;
import main.java.service.impl.CourseService;
import main.java.core.logging.abstr.ILogger;
import main.java.core.logging.impl.DatabaseLogger;
import main.java.core.logging.impl.FileLogger;
import main.java.core.logging.impl.MailLogger;

public class Main {

	public static void main(String[] args) {

		ArrayList<ILogger> logServices = new ArrayList<ILogger>();
		logServices.add(new MailLogger());
		logServices.add(new DatabaseLogger());
		logServices.add(new FileLogger());
		
		CourseService courseService = new CourseService(logServices);
		CourseController cc = new CourseController(courseService);
		
		Course c1 = new Course();
		c1.setName("Test");
		c1.setPrice(1);
		cc.add(c1);
		
		System.out.println("-------------");
		
		Course c2 = new Course();
		c2.setName("Test2");
		c2.setPrice(2);
		cc.add(c2);
		
		System.out.println("-------------");
		
		Course c3 = new Course();
		c3.setName("Test3");
		c3.setPrice(0);
		cc.add(c3);
		
		System.out.println("-------------");
		
		cc.delete(c1);
		cc.delete(c1);
		
		System.out.println("-------------");
		
		cc.add(c1);
	}
}
