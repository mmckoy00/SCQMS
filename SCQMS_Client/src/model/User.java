package model;

import java.io.Serializable;
import java.util.Objects;


public abstract class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public enum Role {STUDENT, ADVISOR, SUPERVISOR}; 
	

	protected String id;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected Role userRole;

    
    public User() {}

    public User(String id, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.password =password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
  
}
