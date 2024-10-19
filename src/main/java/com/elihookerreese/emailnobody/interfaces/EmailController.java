package com.elihookerreese.emailnobody.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elihookerreese.emailnobody.interfaces.dtos.EmailDTO;
import com.elihookerreese.emailnobody.services.EmailService;


@RestController
@RequestMapping("/emails")
@CrossOrigin(origins = "*")
public class EmailController {

	private EmailService es;
    
    public EmailController(EmailService es) {
    	this.es = es;
    }
	
	@PostMapping
    public ResponseEntity<EmailDTO> save(@RequestBody EmailDTO email) {
    	String result = es.save(email);
    	if (result.contains("No name") || result.contains("No subject") || result.contains("No body"))
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(email);
    	return ResponseEntity.ok().body(email);
    }
    
	@GetMapping("/{emailid}")
    public ResponseEntity<EmailDTO> findByEmailid(@PathVariable int emailid) {
    	EmailDTO result = es.findByEmailid(emailid);
    	if (result == null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    	}
    	return ResponseEntity.ok().body(result);
    }
	
	@GetMapping("/count")
    public ResponseEntity<Long> count() {
    	Long result = es.count();
    	return ResponseEntity.ok().body(result);
    }
	
}