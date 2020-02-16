package com.scheduler.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("b08Messages")
public class B08Message {

	@Id
	private String transId;
	private String status;
	private String messageId;
	private String message;
	private Date createdDate;
	private boolean duplicate;
	
	public B08Message(String transId, String status, String messageId, String message, Date createdDate,
			boolean duplicate) {
		super();
		this.transId = transId;
		this.status = status;
		this.messageId = messageId;
		this.message = message;
		this.createdDate = createdDate;
		this.duplicate = duplicate;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isDuplicate() {
		return duplicate;
	}
	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}
	@Override
	public String toString() {
		return "B08Message [transId=" + transId + ", status=" + status + ", messageId=" + messageId + ", message="
				+ message + ", createdDate=" + createdDate + ", duplicate=" + duplicate + "]";
	}
	
	
	
}
