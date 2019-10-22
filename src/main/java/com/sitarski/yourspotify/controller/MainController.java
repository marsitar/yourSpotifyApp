package com.sitarski.yourspotify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView getMain(){
		Map<String,Object> params = new HashMap<>();
		params.put("content", "main");

		return new ModelAndView("home", params);
	}
}
