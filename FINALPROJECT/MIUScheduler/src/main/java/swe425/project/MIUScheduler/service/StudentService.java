package swe425.project.MIUScheduler.service;

import java.util.List;

import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.model.Student;


public interface StudentService {
	 List<Student> findAll();
	 Student save(Student student);
	 Student findOne(Long id);
	 void delete(Long id);
	 void register(Student student, List<Course> courseList);
}
