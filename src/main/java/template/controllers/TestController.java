package template.controllers;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;

@Controller
public class TestController {
	private static final Logger logger = LogManager.getLogger(TestController.class);

	@RequestMapping("/test")
	public String home() {
		//Java 8 test
		List<String> list = Lists.newArrayList("hi");
		list.forEach((s) -> System.out.println(s));
		
		logger.debug("Hello World!");
		return "test";
	}
}