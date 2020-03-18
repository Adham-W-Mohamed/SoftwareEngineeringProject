package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.repo.CourseRepository;
import swe425.project.MIUScheduler.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course findOne(Integer id) {
		return courseRepository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		courseRepository.deleteById(id);
	}

}
