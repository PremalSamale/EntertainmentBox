package edu.sjsu.entertainmentbox.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import edu.sjsu.entertainmentbox.model.AuthenticUser;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private String appUrl;
    private Locale locale;
    private AuthenticUser user;
 
    public OnRegistrationCompleteEvent(
    		AuthenticUser user, Locale locale, String appUrl) {
        super(user);
         
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public AuthenticUser getUser() {
		return user;
	}

	public void setUser(AuthenticUser user) {
		this.user = user;
	}

}
