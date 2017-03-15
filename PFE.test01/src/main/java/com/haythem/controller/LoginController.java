package com.haythem.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haythem.model.UserModel;
import com.haythem.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) throws IOException {

		
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String doLogin(Model model) throws IOException {

		return "login";
	}
	
	 @RequestMapping(value = "/passWordRec", method = RequestMethod.GET)
		public String passWordRec(Model model) throws IOException {
		 //public String generatePassword() {
			 
		 model.addAttribute("UserModel", new UserModel());
			return "passWordRec";
		}
	 
	 
	 
	 @RequestMapping(value = "/PassRec", method = RequestMethod.POST)
		public String PassRec(@ModelAttribute("SpringWeb") UserModel userModel,Model model) throws IOException {
		return userService.getNewPassword(userModel.getUsername());
		}
	
}
