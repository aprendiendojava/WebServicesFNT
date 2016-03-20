package dev.fnt.spboot.holidays.persist.ent;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeAdaptor {
	@Column(updatable=true)
	private String f1;
	@Column(updatable=true)
	private String f2;
	@Column
	private String f3;
	@Column
	private String f4;

	@Column
	private String l1;
	@Column
	private String l2;
	@Column
	private String l3;
	@Column
	private String l4;

	public EmployeeAdaptor(){}
	public EmployeeAdaptor( String firstName, String lastName ) {
		try {
			f1 = ""+firstName.charAt(0);
			f2 = ""+firstName.charAt(1);
			f3 = ""+firstName.charAt(2);
			f4 = ""+firstName.charAt(3);
		} catch( IndexOutOfBoundsException e ){}
		try {
			l1 = ""+lastName.charAt(0);
			l2 = ""+lastName.charAt(1);
			l3 = ""+lastName.charAt(2);
			l4 = ""+lastName.charAt(3);
		} catch( IndexOutOfBoundsException e ){}
	}

	public String getFirstName() {
		return (f1!=null?f1:"")
				+(f2!=null?f2:"")
				+(f3!=null?f3:"")
				+(f4!=null?f4:"");
	}
	public String getLastName() {
		return (l1!=null?l1:"")
				+(l2!=null?l2:"")
				+(l3!=null?l3:"")
				+(l4!=null?l4:"");
	}
}
