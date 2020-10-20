package com.cts.ota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ota.model.AccountDetails;
import com.cts.ota.service.AccountService;

@Controller
public class LoginController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/{locale:en|fr|hi}/login", method = RequestMethod.GET)
	public ModelAndView showHomePage(ModelMap model) {
		AccountDetails accountDetails = new AccountDetails();
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject(accountDetails);
		return modelAndView;
	}

	@RequestMapping(value = "/{locale:en|fr|hi}/login", method = RequestMethod.POST)
	public String showWithdrawPage(ModelMap model, @RequestParam String username, @RequestParam String password) {

		boolean isValidUser = accountService.validateUser(username, password);

		if (!isValidUser) {
			String msg = messageSource.getMessage("error.invalidPassword", new Object[] { "Test Obj" },
					LocaleContextHolder.getLocale());
			model.put("errorMessage", msg);
			return "login";
		}
		AccountDetails accountDetails = accountService.getAccountByUsername(username);
		model.addAttribute("accountDetails", accountDetails);
		return "withdraw";
	}
}
