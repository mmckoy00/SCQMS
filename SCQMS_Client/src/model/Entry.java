package model;

import java.io.Serializable; 
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;
 
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
 
 private int id;
 private EntryType type;
 private String category;
 private Student studentId; 
 private String details;
 private Date requestDate;
 private Status status = Status.UNRESOLVED;

 
 
 

public Entry() {}

public Entry(EntryType type, String category, Student studentId, String caseDetails) {
	long millis = System.currentTimeMillis();
	this.type = type;
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

public void setStatus(Status status) {
	this.status = status;
}

public Date getRequestDate() {
	return requestDate;
}

public void setRequestDate(Date requestDate) {
	this.requestDate = requestDate;
}


 }
