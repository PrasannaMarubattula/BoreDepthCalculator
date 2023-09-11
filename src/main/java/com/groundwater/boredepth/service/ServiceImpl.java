package com.groundwater.boredepth.service;

import java.lang.annotation.Annotation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.lang.Math;

import com.groundwater.boredepth.model.BoreDepthResponse;

@Service
public class ServiceImpl implements BoreDepthService {


@Override
public BoreDepthResponse getBoreDepth(double time, double velocity) {
	
	BoreDepthResponse brDpth=new BoreDepthResponse();
	double velocitypower= Math.pow(velocity, 2)+4*4.905*(time*velocity);
	double sqrt=Math.sqrt(velocitypower);
	System.out.println("veloctitypower---"+velocitypower);
	System.out.println("sqrt4ac---"+sqrt);
	
	double t1= ((-velocity+sqrt)/(2*4.905)) ;
	System.out.println("t1---"+t1);
	double t2= ((-velocity-sqrt)/(2*4.905)) ;
	System.out.println("t2---"+t2);
	
	if(t1>t2)
	{
		double height= (velocity*(time-t1));
		System.out.println("BoreDepth---"+height);
		String h=String.valueOf(height);
		brDpth.setBoreDepth(h);
	}
	else
	{
		double height= (velocity*(time-t2));
		System.out.println("BoreDepth---"+height);
		String h=String.valueOf(height);
		brDpth.setBoreDepth(h);
	}
	
	
	
	return brDpth;
	
}

}
