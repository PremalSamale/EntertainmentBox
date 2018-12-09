package edu.sjsu.entertainmentbox.event;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.service.AuthenticUserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
	@Autowired
	private AuthenticUserService service;

	@Autowired
    private MessageSource messages;

	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnRegistrationCompleteEvent event) {
        AuthenticUser user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);
         
        String recipientAddress = user.getUsername();
        String subject = "Registration Confirmation";
        String confirmationUrl 
          = event.getAppUrl() + "/registrationConfirm?token=" + token;
        String message = messages.getMessage("message.regSucc", null, event.getLocale());
         
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " " + "http://localhost:8080" + confirmationUrl);
        // email.setText(message + " " + "http://entertainmentboapp.suhajmqpfk.us-east-1.elasticbeanstalk.com" + confirmationUrl);
        mailSender.send(email);
    }
}
