package edu.sjsu.entertainmentbox.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VerificationToken {
	private static final int EXPIRATION = 60 * 24;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    private String token;
   
    @OneToOne(targetEntity = AuthenticUser.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private AuthenticUser user;
     
    private Date expiryDate;
    
    public VerificationToken(String token, AuthenticUser user) {
		this.token = token;
		this.user = user;
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
     
    // standard constructors, getters and setters
}
