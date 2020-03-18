package swe425.project.MIUScheduler.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@DiscriminatorValue("F")
public class Faculty extends User {

	
	private Long facultyId;

	public Long getId() {
		return facultyId;
	}

	public void setId(Long id) {
		this.facultyId = id;
	}

	
	public Faculty( String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
	}

	public Faculty() {
		super();
	}

	

	
	
}
