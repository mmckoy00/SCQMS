package model;

import java.io.Serializable;
import java.sql.Date;

public class EntryReference implements Serializable {

	private static final long serialVersionUID = 1L;
	private Entry entryNo;
	 private Supervisor supervisorId;
	 private Advisor advisorId;                       
	 private String response;
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

	public void setResponseDate() {
		long millis = System.currentTimeMillis();
		this.responseDate = new Date(millis);
	}
	 
	 
	 
}
