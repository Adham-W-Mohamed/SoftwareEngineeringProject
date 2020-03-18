package swe425.project.MIUScheduler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;

	@NotBlank
	private String courseTitle;

	@NotNull
	private Integer capacity;

	public Integer getCourseId() {
		return courseId;
	}
	
	

	@Override
	public String toString() {
		return courseTitle;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Course(@NotBlank String courseTitle, @NotNull Integer capacity) {
		super();
		this.courseTitle = courseTitle;
		this.capacity = capacity;
	}

	public Course() {

	}
}
