package com.groundwater.boredepth.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groundwater.boredepth.model.BoreDepthResponse;
import com.groundwater.boredepth.service.BoreDepthService;

@RestController
@EnableCaching
@RequestMapping("/")
public class Controller {
	
	Logger logger = Logger.getLogger(Controller.class.getName());

	@Autowired
	BoreDepthService serviceImpl;
	
	@GetMapping("/BoreDepth")
	public BoreDepthResponse boreDepthTest(
			 @RequestParam(name = "Time", required = true) double time,
			@RequestParam(name = "velocity", required = true) double velocity) {
		BoreDepthResponse bDR = serviceImpl.getBoreDepth(time, velocity);
		
		return bDR;
	}
	
	

}
