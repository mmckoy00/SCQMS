package model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;


@Entity
@Table(name="advisors_tbl")
@PrimaryKeyJoinColumn
public class Advisor extends User {
	
	@OneToMany
	Collection <Complaint> complaintsAssigned;

	private static final long serialVersionUID = 1L;
	
	public Advisor() {};
	public Advisor(String id, String password, String firstName, String lastName, Role role) {
		super(id, password, firstName, lastName, role);
	}
	
    
  	public void create() {
  		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
  		Transaction transaction = session.beginTransaction();
	    session.persist(this);
	    transaction.commit();
	    session.close();
  	}
    
    
  	public void update() {
    	Transaction transaction = null;
  		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
  			transaction = session.beginTransaction();
	  			User user = session.get(User.class, this.id);
	  		if(user != null) {
	  	  		user.setPassword(this.password);
	  	  		session.update(user);
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

    
  	public List<Advisor> getAll() {
    	Transaction transaction = null;
  		try {
  		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
  		transaction = session.beginTransaction();
  		List<Advisor> users = session.createQuery("FROM User", Advisor.class).getResultList();
  		transaction.commit();
  		session.close();
  		return users;
  		}catch(HibernateException he) {
  			if(transaction != null) {
  				transaction.rollback();
  			}
  			he.printStackTrace();
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
  		return null;
  	}

  	
  	public void delete() {
  		Transaction transaction = null;
  		try {
  		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
  		transaction = session.beginTransaction();
  		User user = session.get(User.class, this.id);
  		if(user!= null) {
  			session.delete(user);
  			transaction.commit();
  			session.close();
  	  		JOptionPane.showMessageDialog(null, "Account Successfully Deleted!", "Account Status", JOptionPane.OK_OPTION);
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
  		

}
