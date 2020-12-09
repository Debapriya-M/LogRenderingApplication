package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.LoggerProcessor;

@Controller
@RequestMapping("/")
public class LoggingController {
	
	@Autowired
	LoggerProcessor loggerProcessor;

	@RequestMapping(value = "/logs", method = RequestMethod.GET, produces = "text/html")
	public String displayLogs(Model model) throws Exception {
		model.addAttribute("message", loggerProcessor.getLogStrings());
		return "displayLogs";
	}
}
