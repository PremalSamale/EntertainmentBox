package edu.sjsu.entertainmentbox.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
}
