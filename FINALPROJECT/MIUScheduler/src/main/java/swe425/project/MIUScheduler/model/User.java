package swe425.project.MIUScheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long userId;

	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide first name")
	protected String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide last name")
	protected String lastName;

	@Column(name = "email", unique = true)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	protected String email;

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

}
