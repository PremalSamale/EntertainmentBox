package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.VerificationToken;

public interface VerificationTokenRepository {
	VerificationToken findByToken(String token);
    VerificationToken findByUser(AuthenticUser user);
	void save(VerificationToken myToken);
}
