package swe425.project.MIUScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.model.Location;
import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.service.BlockService;
import swe425.project.MIUScheduler.service.CourseService;
import swe425.project.MIUScheduler.service.FacultyService;
import swe425.project.MIUScheduler.service.LocationService;
import swe425.project.MIUScheduler.service.SectionService;
import swe425.project.MIUScheduler.service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class MiuSchedulerApplication implements CommandLineRunner {

	@Autowired
	SectionService sectionService;
	@Autowired
	CourseService courseService;
	@Autowired
	BlockService blockService;
	@Autowired
	FacultyService facultyService;
	@Autowired
	LocationService locationService;
	@Autowired
	StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(MiuSchedulerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Block jBlock = new Block("January 2020", LocalDate.of(2020,1,5),LocalDate.of(2020,1,29));
		Block fBlock = new Block("Fabruary 2020", LocalDate.of(2020,1,30),LocalDate.of(2020,2,25));
		Faculty faculty = new Faculty("oussama", "jablaoui", "OJablaoui@mum.edu");
		Course wCourse = new Course("Web Programming");
		Course eCourse = new Course("Enterprise Architecture");
		eCourse.setPrerequisite(wCourse);
		Location location = new Location("Verill Hall", "143");
		Section section1 = new Section(wCourse, jBlock, location, faculty, 50);
		Section section2 = new Section(eCourse, fBlock, location, faculty, 50);
		Student student = new Student("Mark", "ghatas", "mark@miu.edu");
		studentService.save(student);
		blockService.save(fBlock);
		blockService.save(jBlock);
		facultyService.save(faculty);
		locationService.save(location);
		courseService.save(wCourse);
		courseService.save(eCourse);
		facultyService.save(faculty);
		sectionService.save(section1);
		sectionService.save(section2);
		List<Section> list = new ArrayList();
		list.add(section1);
		list.add(section2);
		HashMap<String, List<Section>> result = studentService.register(student, list);
		
		
		
		
	}
}
