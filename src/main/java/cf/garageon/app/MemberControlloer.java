package cf.garageon.app;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cf.garageon.app.Service.UserService;
import cf.garageon.app.VO.UserVo;

@Controller
public class MemberControlloer {
	private static final Logger logger = LoggerFactory.getLogger(MemberControlloer.class);
	
	@Inject
	UserService userService;
	
	//로그인
	@RequestMapping(value = "/login/login", method = RequestMethod.POST)
	public String login(UserVo vo,HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		UserVo login=userService.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
		
	
	@RequestMapping(value = "/login/register_view", method = RequestMethod.GET)
	public String register_view() {
		return "/login/register_view";
	
	}
	
	@RequestMapping(value = "/login/register", method = RequestMethod.POST)
	public String register(UserVo vo, Model model) throws Exception {
		
		userService.register(vo);
		
		return "redirect:/index";
	
	}
}
