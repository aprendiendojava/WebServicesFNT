package dev.fnt.pcarrier.ejhib.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericEntity {
	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
}
