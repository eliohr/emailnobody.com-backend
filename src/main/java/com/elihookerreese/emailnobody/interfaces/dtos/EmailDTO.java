package com.elihookerreese.emailnobody.interfaces.dtos;

import com.elihookerreese.emailnobody.entities.Email;

public class EmailDTO {
	
	private int emailid;
	private String sent;
    private String name;
    private String subject;
    private String body;
    
    public EmailDTO() {}
    
    public EmailDTO (Email core) {
    	emailid = core.getEmailid();
    	sent = core.getSent().toString();
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
	
	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
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
