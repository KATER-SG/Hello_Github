package com.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tedu.client.EurakaServiceFeign;

@RestController
public class FeignController {
	
	@Autowired
	private EurakaServiceFeign eurakaServiceFeign;
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloFallback")
	@ResponseBody
	public String hello(@PathVariable String name){
		return eurakaServiceFeign.hello(name);
	}
	
	
	public String helloFallback(String name){
		return "hhhhhhhh";
	}
}
