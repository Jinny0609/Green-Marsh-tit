package com.tit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tit.model.MainLoginVO;
import com.tit.service.MainLoginService;


@Controller
public class LoginController {

	@Autowired
	private MainLoginService mainloginservice;
	
	@RequestMapping(value = "/MainMemberJoin", method = RequestMethod.POST)
	public String memberjoin (MainLoginVO mainloginVO) {
		mainloginservice.memberjoin(mainloginVO);
		return "redirect:/";
	}
}
