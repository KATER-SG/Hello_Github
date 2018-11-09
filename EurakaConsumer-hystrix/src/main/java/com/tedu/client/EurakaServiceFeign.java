package com.tedu.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("provider-user")
public interface EurakaServiceFeign {
	
	@RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
	public String hello(@PathVariable("name") String name);
}
