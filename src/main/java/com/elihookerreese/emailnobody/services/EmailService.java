package com.elihookerreese.emailnobody.services;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elihookerreese.emailnobody.entities.Email;
import com.elihookerreese.emailnobody.interfaces.dtos.EmailDTO;
import com.elihookerreese.emailnobody.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository er;
	
	public String save(EmailDTO email) {

	    if(email.getName().isBlank())
	    	return "No name";
	    if(email.getSubject().isBlank())
	    	return "No subject";
	    if(email.getBody().isBlank())
	    	return "No body";
	    
		Email newEmail = new Email(email);
		newEmail.setSent(LocalDateTime.now(Clock.systemUTC()));
		
		er.save(newEmail);
		
		email.setEmailid(newEmail.getEmailid());
		email.setSent(newEmail.getSent().toString());
		return Integer.toString(newEmail.getEmailid());
		
	}

	public EmailDTO findByEmailid(int emailid) {
		
		Optional<Email> maybeEmail = er.findById(emailid);
		
		if(!maybeEmail.isPresent())
			return null;
		
		EmailDTO email = new EmailDTO(maybeEmail.get());
		return email;
		
	}

	public Long count() {

		Long count = er.count();
		
		return count;
		
	}
	
}