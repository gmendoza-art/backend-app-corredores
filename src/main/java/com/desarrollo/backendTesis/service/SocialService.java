package com.desarrollo.backendTesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desarrollo.backendTesis.entity.Social;
import com.desarrollo.backendTesis.repository.SocialRepository;

@Service
public class SocialService {

	
	@Autowired
	private SocialRepository Srepo;
	
	public Social savepubli (Social social) {
		return Srepo.save(social);		
	}
}
