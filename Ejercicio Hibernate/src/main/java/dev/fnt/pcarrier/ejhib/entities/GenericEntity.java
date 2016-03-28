package dev.fnt.pcarrier.ejhib.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFilter;

@MappedSuperclass
@JsonFilter("CustomFilter")
public class GenericEntity {
	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
}
