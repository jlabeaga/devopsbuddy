package com.devopsbuddy.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.devopsbuddy.web.domain.frontend.FeedbackPojo;

public interface EmailService {
	
	public void senFeedbackEmail(FeedbackPojo feedbackPojo);
	
	public void sendGenericEmailMessage(SimpleMailMessage message);

}
