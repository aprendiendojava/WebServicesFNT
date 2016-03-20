package dev.fnt.spboot.holidays.persist.ent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Holidays {
	@Id
	@GeneratedValue
	private Long id;

	@Column( updatable=false, nullable=false )
	private Date startDate;

	@Column( updatable=false, nullable=false )
	private Date endDate;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee employee;
}
