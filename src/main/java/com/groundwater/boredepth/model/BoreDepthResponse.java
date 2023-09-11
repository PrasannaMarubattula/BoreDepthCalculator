package com.groundwater.boredepth.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BoreDepthResponse {
	
	
	@JsonProperty("bore_Depth")
    String boreDepth;

	public String getBoreDepth() {
		return boreDepth;
	}

	public void setBoreDepth(String boreDepth) {
		this.boreDepth = boreDepth;
	}

}
