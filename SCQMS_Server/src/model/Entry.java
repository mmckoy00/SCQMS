package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.persistence.*;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import server.DatabaseConfiguration;
 
@Entity
@Table(name="entries_tbl")
public class Entry implements Serializable{

	private static final long serialVersionUID = 1L;

public enum Status {
	UNRESOLVED,                    // new entry and advisor not assign
	PENDING,					   // advisor was assigned
	RESOLVED					  //  advisor added resolve message
	};

	
public enum EntryType{
	QUERY,
	COMPLAINT
};
 
 @Id
 @Column(name="entry_no")
 @GeneratedValue(strategy=GenerationType.IDENTITY)   //id
 private int id;
 
 @Enumerated(EnumType.STRING)                      // entry type
 @Column(nullable=false)
 private EntryType type;
 
 @Column(nullable=false)                           //category
 private String category;
        											// student
 @ManyToOne
 private Student studentId; 
 
 @Column(nullable=false)                            // description
 private String details;
 
 @Column(name="request_date", nullable=false)        // request date
 private Date requestDate;
 
 @Enumerated(EnumType.STRING)
 @Column( nullable=false)                           // entry status
 private Status status = Status.UNRESOLVED;
 
 
 
 
public Entry() {}

public Entry(EntryType entryType, String category, Student studentId, String caseDetails) {
	 long millis = System.currentTimeMillis();
	
	this.type = entryType;
	this.category = category;
	this.studentId = studentId;
	this.details = caseDetails;
	this.requestDate = new Date(millis);
	

}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public EntryType getType() {
	return type;
}

public void setType(EntryType type) {
	this.type = type;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public Student getStudentId() {
	return studentId;
}

public void setStudentId(Student studentId) {
	this.studentId = studentId;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}

public Status getStatus() {
	return status;
}

public void setStatusPending(int entryNo) {
	String sql= "UPDATE entries_tbl SET Status = PENDING WHERE = "+entryNo;
	Connection con = DatabaseConfiguration.getDBConnection();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	} catch (SQLException e) {
		//TODO:handle
		e.printStackTrace();
	}
	
	this.status = Status.PENDING;
	
}

public void setStatusResolved(int entryNo) {
	String sql= "UPDATE entries_tbl SET Status = RESOLVE WHERE = "+entryNo;
	Connection con = DatabaseConfiguration.getDBConnection();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	} catch (SQLException e) {
		// TODO: handle
		e.printStackTrace();
	}
	
	this.status = Status.RESOLVED;
}

public Date getRequestDate() {
	return requestDate;
}

//sets current date
public void setRequestDate() {
	long millis = System.currentTimeMillis();
	this.requestDate = new Date(millis);
}



public static void logNewEntry(Entry entry) {
	
	Transaction transaction = null;
	try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
	transaction = session.beginTransaction();
	session.persist(entry);
    transaction.commit();
    session.close();
	} catch (Exception e) {
        e.printStackTrace();
      }
}


public void updateEntryDetails() {
	Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			transaction = session.beginTransaction();
			Entry entry = session.get(Entry.class, id);
  		if(!(entry.equals(null)) && !(entry.getStatus().equals(Status.RESOLVED))) {
  	  		session.update(entry);
  	  		transaction.commit();
  	  		session.close();
  	  		JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATE!", "Account Status", JOptionPane.OK_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "USER NOT FOUND!", "Account Status", JOptionPane.WARNING_MESSAGE);
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
