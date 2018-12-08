package edu.sjsu.entertainmentbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import edu.sjsu.entertainmentbox.dao.VerificationTokenRepository;
import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.VerificationToken;

@Repository
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

	@Override
	public VerificationToken findByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerificationToken findByUser(AuthenticUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(VerificationToken myToken) {
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(VerificationToken.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(myToken);
		tx.commit();
		session.close();
	}
}
