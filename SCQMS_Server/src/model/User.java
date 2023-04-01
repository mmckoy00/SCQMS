package model;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="users_tbl")
public abstract class User implements Serializable {
	

	private static final long serialVersionUID = 1L;


	public enum Role {STUDENT, ADVISOR, SUPERVISOR}; 
	
	
	@Id
	protected String id;
	
	@Column(nullable=false)
    protected String password;
    
    @Column(name="first_name", nullable=false)
    protected String firstName;
    
    @Column(name="last_name", nullable=false)
    protected String lastName;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    protected Role userRole;

    
    public User() {}

    public User(String id, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.password = password;
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
    
    

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userRole=" + userRole + "]";
	}

	public static User getById(String id) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	
	public static void deleteById(String id) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
	            transaction = session.beginTransaction();
	            User user = session.get(User.class, id);
	            if (user != null) {
	                session.delete(user);
	                transaction.commit();
	                JOptionPane.showMessageDialog(null, "Successfully Deleted!");
	            }
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		
	}

}
