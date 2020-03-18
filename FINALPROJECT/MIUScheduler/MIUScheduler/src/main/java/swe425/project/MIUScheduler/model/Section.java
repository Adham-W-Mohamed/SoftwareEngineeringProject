package swe425.project.MIUScheduler.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sectionId;

	@OneToOne
	private Course course;

	@OneToOne
	private Block block;

	@OneToOne
	private Location location;

	@OneToOne
	private Faculty faculty;

	@ManyToMany(mappedBy = "sections")
	private List<Student> students;

	public Section(Course course, Block block, Location location, Faculty faculty) {
		super();
		this.course = course;
		this.block = block;
		this.location = location;
		this.faculty = faculty;
	
	}

	public Section() {
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
