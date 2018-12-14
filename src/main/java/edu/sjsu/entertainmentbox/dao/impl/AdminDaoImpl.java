package edu.sjsu.entertainmentbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import edu.sjsu.entertainmentbox.dao.AdminDao;
import edu.sjsu.entertainmentbox.model.Movie;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Override
	public void addMovie(Movie movie) {
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(Movie.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(movie);
		tx.commit();
		session.close();
	}
	
}
