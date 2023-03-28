package model;

import java.util.List;


public class Advisor extends User {
	
	private static final long serialVersionUID = 1L;
	private List <EntryReference> entriesAssigned;
	
	public Advisor() {}
	
	public Advisor(String id, String password, String firstName, String lastName, Role role) {
		super(id, password, firstName, lastName, role);
	}

}
