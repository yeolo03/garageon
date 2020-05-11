package cf.garageon.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testController {
	@RequestMapping("/test")
	public String test() {
		
		System.out.println("@@@@@@");
		return"test";
	}
}
