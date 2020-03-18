package swe425.project.MIUScheduler.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.service.SectionService;
import swe425.project.MIUScheduler.service.StudentService;


@Controller
public class StudentController {

	private StudentService studentService;
	private SectionService sectionService;

	@Autowired
	public StudentController(StudentService studentService,SectionService sectionService) {
		this.studentService = studentService;
		this.sectionService = sectionService;
	}

	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ModelAndView students(){		
		List<Student> students = studentService.findAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", students);
		modelAndView.setViewName("student/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/student", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("student", new Student());
		return "student/edit";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("student") Student student, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "student/edit";
		}
		student = studentService.save(student);
		return "redirect:/students";
	}	
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("student", studentService.findOne(id));
		return "student/edit";
	}
	
	@RequestMapping(value="/student/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		studentService.delete(id);
		return "redirect:/students";
	}

	@GetMapping(value="/register")
	public ModelAndView getScheduleForRegistration(){
		List<Section> sections = sectionService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sections", sections);
		modelAndView.addObject("selected", new ArrayList<Section>());
		modelAndView.setViewName("student/register");
		return modelAndView;
	}
	@PostMapping(value = "/register")
	public String postScheduleForRegistration(@Valid @ModelAttribute("student") Student student,
					   BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "student/edit";
		}
		student = studentService.save(student);
		return "redirect:/students";
	}
}
