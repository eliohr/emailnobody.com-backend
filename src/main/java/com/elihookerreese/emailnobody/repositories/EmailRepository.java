package com.elihookerreese.emailnobody.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elihookerreese.emailnobody.entities.Email;
import com.elihookerreese.emailnobody.interfaces.dtos.EmailDTO;

public interface EmailRepository extends JpaRepository<Email,Integer>{

	void save(EmailDTO email);
	
	long count();
	
}