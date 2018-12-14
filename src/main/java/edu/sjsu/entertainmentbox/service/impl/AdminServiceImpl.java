package edu.sjsu.entertainmentbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.entertainmentbox.dao.AdminDao;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public void addMovie(Movie movie) {
		adminDao.addMovie(movie);
	}

}
