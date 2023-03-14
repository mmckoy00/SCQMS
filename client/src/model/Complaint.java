
package model;

import java.io.Serializable; import java.sql.Date;
 
import javax.persistence.*;
 
@Entity
@Table(name="complaints_tbl")
public class Complaint implements Serializable{

	 
public enum Status {
	UNRESOLVED,
	PENDING,
	RESOLVED
	};

	
public enum ComplaintCategory {
	MISSING_GRADES 
	};
 
 
 @Id
 @Column(name="case_no")
 @GeneratedValue(strategy=GenerationType.IDENTITY) 
 private int id;
 
 @Enumerated(EnumType.STRING)
 @Column(nullable=false)
 private ComplaintCategory category;
 
 @Column(name="student_id", nullable=false)
 @ManyToOne
 private Student studentId;
 
 @Column(name="case_details", nullable=false)
 private String caseDetails;
 
 @Enumerated(EnumType.STRING)
 @Column( nullable=false) 
 private Status complaintStatus;
  
 @Column(name="request_date") 
 @Temporal(TemporalType.DATE)
 private Date requestDate;
 
 @Column(name="staff_id")
 @ManyToOne
 private Advisor staffId;
 
 private String response;
 
 @Column(name="response_date")
 private Date responseDate;
 
 
 

public Complaint() {}

public Complaint(ComplaintCategory category, Student studentId, String caseDetails, Status complaintStatus, Date requestDate) {
	super();
	this.category = category;
	this.studentId = studentId;
	this.caseDetails = caseDetails;
	this.complaintStatus = complaintStatus;
	this.requestDate = requestDate;

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public ComplaintCategory getCategory() {
	return category;
}

public void setCategory(ComplaintCategory category) {
	this.category = category;
}

public Student getStudentId() {
	return studentId;
}

public void setStudentId(Student studentId) {
	this.studentId = studentId;
}

public String getCaseDetails() {
	return caseDetails;
}

public void setCaseDetails(String caseDetails) {
	this.caseDetails = caseDetails;
}

public Status getComplaintStatus() {
	return complaintStatus;
}

public void setComplaintStatus(Status complaintStatus) {
	this.complaintStatus = complaintStatus;
}

public Date getRequestDate() {
	return requestDate;
}

public void setRequestDate(Date requestDate) {
	this.requestDate = requestDate;
}

public Advisor getStaffId() {
	return staffId;
}

public void setStaffId(Advisor staffId) {
	this.staffId = staffId;
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
 
 
 
 

 }
