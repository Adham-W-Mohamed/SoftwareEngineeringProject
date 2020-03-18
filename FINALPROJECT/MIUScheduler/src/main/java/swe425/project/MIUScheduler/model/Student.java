package swe425.project.MIUScheduler.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@DiscriminatorValue("S")
public class Student extends User {

	@Column(unique = true)
	private Long studentId;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Section> sectionList = new ArrayList<>();

	public Student( String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
	}
	
	
	
	public Student() {
		super();
	}



	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long id) {
		this.studentId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}
	
	
}
