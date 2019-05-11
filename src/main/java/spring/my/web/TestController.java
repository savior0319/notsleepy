package spring.my.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public TestController() {

	}

	@RequestMapping(value = "/test.do")
	public void test(@RequestParam String inputStr) {
		String encryptPwd = passwordEncoder.encode(inputStr);
		String db = "$2a$10$nmx6rSOqpBcUq/jxLxjT6e0C6WGH7Epyr/MkfhA8u3Sh5NaznL9.y";
		boolean flag = passwordEncoder.matches(inputStr, db);
		if (flag)
			System.out.println("일치");
		else
			System.out.println("불일치");
	}

}
