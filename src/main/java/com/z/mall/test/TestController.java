package com.z.mall.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	private Logger log = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/hello")
	public String hello() {
		log.info(
				"...............................................\nHello world....................................\n...............................................");
		return "Hello world.";
	}
}