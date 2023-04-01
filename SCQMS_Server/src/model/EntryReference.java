package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;

@Entity
@Table(name="entries_ref")
public class EntryReference implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)   //id
	 private int id;
	
	@OneToOne
	 private Entry entryNo;
	
	 @ManyToOne
	 private Supervisor supervisorId;
	
	 @ManyToOne
	 private Advisor advisorId;                       
	 
	 private String response;
	 
	 @Column(name="response_date")
	 private Date responseDate;
	 

	public EntryReference() {
	
	}
	
	public EntryReference(Entry entryNo) {
		this.entryNo = entryNo;
	}


	public Entry getEntryNo() {
		return entryNo;
	}

	public void setEntryNo(Entry entryNo) {
		this.entryNo = entryNo;
	}

	public Supervisor getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Supervisor supervisorId) {
		this.supervisorId = supervisorId;
	}

	public Advisor getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Advisor advisorId) {
		this.advisorId = advisorId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	 
	
	public static void createEntryRef(EntryReference entryNo) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
		transaction = session.beginTransaction();
		session.persist(entryNo);
	    transaction.commit();
	    session.close();
		} catch (Exception e) {
	        e.printStackTrace();
	      }
	}
	 
	 
}
