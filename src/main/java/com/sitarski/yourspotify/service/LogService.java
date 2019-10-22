package com.sitarski.yourspotify.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LogService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<String> getLogs(){

		logger.info("Logs are to be get from your_spotify_application.log");

		List<String> logs = new ArrayList<>();

		File file = new File("./your_spotify_application.log");
		Scanner sc = null;

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			logger.warn(e.getMessage());
		}
		sc.useDelimiter(",|\r\n");
		while(sc.hasNext()){
			String logRow = sc.next();
			logs.add(logRow);
			System.out.println(logRow);
		}
		sc.close();

		return logs;
	}
}
