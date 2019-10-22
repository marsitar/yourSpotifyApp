package com.sitarski.yourspotify.controller;

import com.sitarski.yourspotify.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LogsController {

	private final LogService logService;

	@Autowired
	public LogsController(LogService logService) {
		this.logService = logService;
	}

	@GetMapping("/logs")
	public ModelAndView getLogs() {

		Map<String,Object> params = new HashMap<>();

		List<String> logs = logService.getLogs();

		params.put("content", "logs");
		params.put("logs",logs);

		return new ModelAndView("home", params);
	}
}
