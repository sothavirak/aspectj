package edu.sample;

import edu.sample.service.LogService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
    	LogService logService = new LogService();
    	logService.log("test");
    }
}
