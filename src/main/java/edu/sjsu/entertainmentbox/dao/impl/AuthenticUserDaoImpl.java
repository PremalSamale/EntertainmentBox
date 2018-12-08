package edu.sjsu.entertainmentbox.dao.impl;

import edu.sjsu.entertainmentbox.dao.AuthenticUserDao;
import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.User;
import edu.sjsu.entertainmentbox.model.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticUserDaoImpl implements AuthenticUserDao {
	/*@Autowired
	private SessionFactory sessionFactory;*/

	@Override
	public AuthenticUser getUser(String username) {
		List<AuthenticUser> users = new ArrayList<AuthenticUser>();
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(AuthenticUser.class)
				.addAnnotatedClass(UserRole.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		users = session
			.createQuery("from AuthenticUser where username=?")
			.setParameter(0, username)
			.list();

		AuthenticUser result = null;
		if (users.size() > 0) {
			result = users.get(0);
		}
		tx.commit();
		return result;
	}

	@Override
	public void saveUser(AuthenticUser user) {
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(AuthenticUser.class)
				.addAnnotatedClass(UserRole.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	@Override
	public void saveUserAndRole(UserRole userRole, AuthenticUser user) {
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(AuthenticUser.class)
				.addAnnotatedClass(UserRole.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		session.save(userRole);
		tx.commit();
		session.close();
	}

}
