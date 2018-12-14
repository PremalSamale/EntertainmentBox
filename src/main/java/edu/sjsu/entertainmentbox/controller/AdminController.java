package edu.sjsu.entertainmentbox.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.entertainmentbox.model.Genre;
import edu.sjsu.entertainmentbox.model.MPAARating;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.MovieAvailability;
import edu.sjsu.entertainmentbox.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value="/user/addMovie", method={RequestMethod.POST})
	public ModelAndView addMovie(HttpServletRequest request) {
		String title = request.getParameter("title");
		Genre genre = Genre.valueOf(request.getParameter("genre"));
		int year = Integer.parseInt(request.getParameter("year"));
		String actors = request.getParameter("actors");
		String director = request.getParameter("director");
		String studio = request.getParameter("studio");
		String synopsis = request.getParameter("synopsis");
		String image = request.getParameter("image");
		String movieLink = request.getParameter("movie");
		String country = request.getParameter("country");
		MPAARating mpaaRating = MPAARating.valueOf(request.getParameter("mpaaRating"));
		MovieAvailability availability = MovieAvailability.valueOf(request.getParameter("availability"));
		Movie movie = new Movie(title, genre, year, studio, synopsis, image, movieLink, actors, director, country, mpaaRating, availability, 10);
		adminService.addMovie(movie);
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("addMovieMsg", "Movie added successfully");
		return mv;
	}
}
