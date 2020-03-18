package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Course;


public interface CourseService {
	 List<Course> findAll();
	 Course save(Course course);
	 Course findOne(Integer id);
	 void delete(Integer id);
}
