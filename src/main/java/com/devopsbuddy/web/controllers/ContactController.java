package com.devopsbuddy.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.web.domain.frontend.FeedbackPojo;

@Controller
public class ContactController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

	public static final String FEEDBACK_MODEL_KEY = "feedback";
	
	public static final String CONTACT_US_VIEW_NAME = "contact/contact";
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactGet( ModelMap model ) {
		FeedbackPojo feedbackPojo = new FeedbackPojo();
		model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
		return ContactController.CONTACT_US_VIEW_NAME;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contactPost( @ModelAttribute(ContactController.FEEDBACK_MODEL_KEY) FeedbackPojo feedback) {
		LOG.debug("FeedbackPojo contente {}", feedback);
		emailService.senFeedbackEmail(feedback);
		return ContactController.CONTACT_US_VIEW_NAME;
	}

}
