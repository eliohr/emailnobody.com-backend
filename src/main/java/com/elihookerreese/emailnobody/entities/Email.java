package com.elihookerreese.emailnobody.entities;

import java.time.LocalDateTime;

import com.elihookerreese.emailnobody.interfaces.dtos.EmailDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emails")
public class Email {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emailid;
	private LocalDateTime sent;
	private String name;
    private String subject;
    private String body;
    
    public Email() {}
    
    public Email(EmailDTO core) {
    	name = core.getName();
    	subject = core.getSubject();
    	body = core.getBody();
	}

	public int getEmailid() {
		return emailid;
	}

	public void setEmailid(int emailid) {
		this.emailid = emailid;
	}
	
	public LocalDateTime getSent() {
		return sent;
	}

	public void setSent(LocalDateTime sent) {
		this.sent = sent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
