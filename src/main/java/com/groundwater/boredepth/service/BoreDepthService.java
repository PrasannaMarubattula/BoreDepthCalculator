package com.groundwater.boredepth.service;

import com.groundwater.boredepth.model.BoreDepthResponse;

public interface BoreDepthService {
	
	//Get BoreDepth
		public  BoreDepthResponse getBoreDepth(double time,double velocity);

}
