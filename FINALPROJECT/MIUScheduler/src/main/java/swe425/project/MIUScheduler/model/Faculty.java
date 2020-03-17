package swe425.project.MIUScheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Faculty extends User {

	@Column(unique = true)
	private Long facultyId;

	public Long getId() {
		return facultyId;
	}

	public void setId(Long id) {
		this.facultyId = id;
	}

	

}
