package com.kleber.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kleber.webapp.model.usuario.Usuario;

@Controller
public class MainController {
	
	@Autowired
	private MainService serv;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	@ResponseBody
	public void signup_post(@ModelAttribute("object") Usuario object, BindingResult result) {
		serv.signup(object);
	}	
	
}
