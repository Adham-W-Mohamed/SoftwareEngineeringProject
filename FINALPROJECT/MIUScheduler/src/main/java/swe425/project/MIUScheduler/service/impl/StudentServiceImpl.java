package swe425.project.MIUScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.repo.StudentRepository;
import swe425.project.MIUScheduler.service.StudentService;



@Service("studentService")
public class StudentServiceImpl implements StudentService {


	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl( StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findOne(Long id) {
		return studentRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}



}
