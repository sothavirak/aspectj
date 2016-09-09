package edu.sample.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogService {

	public void log(String message) {
		log.info("[log: message]={}", message);	
	}
}
