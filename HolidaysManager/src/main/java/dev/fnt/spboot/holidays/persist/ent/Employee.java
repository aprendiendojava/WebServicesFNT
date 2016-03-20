package dev.fnt.spboot.holidays.persist.ent;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column( insertable=false, updatable=false )
	private Long id;

	/* @Transient fields are cleared before the call to
	 @PreUpdate method. To workaround this behaviour
	 we need to use (insertable=false, updatable=false)
	 in that way, updated values are persisted and we
	 can access them in @PreUpdate method.
	 IMPORTANT - (name="id") : name must be whatever
	 existing field of the associated table. */
	@Column( name="id", insertable=false, updatable=false, nullable=false )
	private String firstName;

	@Column( name="id", insertable=false, updatable=false, nullable=false )
	private String lastName;

	@Column( updatable=true, nullable=true )
	private String office;

	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private Set<Holidays> holidays = new HashSet<>();

	public Long getId() {
		return id;
	}

/* ------------------------------------------------------ */

	@Embedded
	@JsonIgnore
	private EmployeeAdaptor adapter;

	@PostLoad
	private void postLoad(){
		firstName = adapter.getFirstName();
		lastName = adapter.getLastName();
	}

	@PrePersist
	private void prePersist() {
		if( id != null ) throw new RuntimeException();
		applyConversion();
	}

	@PreUpdate
	private void preUpdate() {
		applyConversion();
	}

	private void applyConversion() {
		adapter = new EmployeeAdaptor(firstName, lastName);
	}
}
