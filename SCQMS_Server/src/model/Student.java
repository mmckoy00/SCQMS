package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import domain.Student;
//import domain.User.Role;
import hibernate.HibernateUtil;


@Entity
@Table(name="students_tbl")
@PrimaryKeyJoinColumn
public class Student extends User{
	
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(unique=true)
	private String contact;
	
	@OneToMany
	private List<Entry> entriesLogged;
	

    public Student() {}
    
    public Student(String id, String password, String firstName, String lastName, Role role, String email, String contact) {
    	super(id,password,firstName,lastName,role);
        this.email = email;
        this.contact = contact;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContact() {
    	return contact;
    }
    
    public void setContact(String contact) {
    	this.contact = contact;
    }
    
    
	@Override
	public String toString() {
		return "Student [email=" + email + ", contact=" + contact + ", entriesLogged=" + entriesLogged + "]";
	}

	public static void createStudent(Student student) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
            Root<Student> root = criteriaQuery.from(Student.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), student.getEmail()));
            List<Student> users = session.createQuery(criteriaQuery).getResultList();
            if (!users.isEmpty()) {
                throw new HibernateException("User with email " + student.getEmail() + " already exists");
            }
            
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("contact"), student.getContact()));
            List<Student> students = session.createQuery(criteriaQuery).getResultList();
            
            
            if (!students.isEmpty()) {
                throw new HibernateException("User with contact " + student.getContact() + " already exists");
            }
            session.persist(student);
            transaction.commit();
            
            JOptionPane.showMessageDialog(null, "Successfully Created!");

        } catch (Exception e) {
           if (transaction != null) {
              transaction.rollback();
            }
            JOptionPane.showMessageDialog(null, "Account Creation Unsuccessful: "+e.getMessage());
        }
	}
	

	public static void update(String id) {
		Transaction transaction = null;
  		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
  			transaction = session.beginTransaction();
  			Student student = session.get(Student.class, id);
	  		if(student != null) {
	  	  		session.update(student);
	  	  		transaction.commit();
	  	  		session.close();
	  	  		JOptionPane.showMessageDialog(null, "Account Successfully Updated!", "Account Status", JOptionPane.OK_OPTION);
  			}else {
  				JOptionPane.showMessageDialog(null, "User Not Found!", "Account Status", JOptionPane.WARNING_MESSAGE);
  			}
  		}catch(HibernateException he) {
  			if(transaction != null) {
  				transaction.rollback();
  			}
  			he.printStackTrace();
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
		
	}
	
	public static List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	List<User> users = session.createQuery("FROM users_tbl", User.class).getResultList();
        	return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	public static void main(String[] args) {
		Student student = new Student("10002", "cat", "Carl", "Peterson",Role.STUDENT, "pc@gmail.com", "422-3432");
		Student.createStudent(student);
	}


  
}
