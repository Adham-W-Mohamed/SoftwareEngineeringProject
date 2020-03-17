package swe425.project.MIUScheduler.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;

	@NotBlank
	private String courseTitle;



	@OneToOne
	private Course prerequisite;

	public Course getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}

	public Integer getCourseId() {
		return courseId;
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

	public Course(@NotBlank String courseTitle) {
		super();
		this.courseTitle = courseTitle;

	}

	public Course() {

	}
}
