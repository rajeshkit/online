package com.cts.ota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.ota.model.AccountDetails;
import com.cts.ota.service.AccountService;

@Controller
public class WithdrawController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MessageSource messageSource;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping(value = "/{locale:en|fr|hi}/checkWithdraw", method = RequestMethod.POST)
	public String checkWithdraw(@ModelAttribute("accountDetails") AccountDetails accountDetails,
			@RequestParam String username, @RequestParam Double amount, Model model, BindingResult result) {
		System.out.println("Username :" + username + " Amount: " + amount + " & Account Details : " + accountDetails);
		AccountDetails accountDetail = accountService.getAccountByUsername(username);
		double newBalance = 0;
		String accountType = accountDetail.getAccountType();
		Double accountBalance = accountDetail.getBalance();

		String msg;
		if (accountType.equalsIgnoreCase("savings")) {
			if (amount <= accountBalance && amount <= 40000) {
				newBalance = accountBalance - amount;
				msg = messageSource.getMessage("msg.success", new Object[] { "Test Obj" },
						LocaleContextHolder.getLocale());
				msg = msg + " " + newBalance;
				model.addAttribute("msg", msg);
			} else if (amount > 40000) {
				msg = messageSource.getMessage("error.limitExceeded", new Object[] { "Test Obj" },
						LocaleContextHolder.getLocale());
				msg = msg + " 40,000/-";
				model.addAttribute("msg", msg);
			} else if (amount > accountBalance) {
				msg = messageSource.getMessage("error.lowBalance", new Object[] { "Test Obj" },
						LocaleContextHolder.getLocale());
				model.addAttribute("msg", msg);
			}
		} else if (accountType.equalsIgnoreCase("current")) {
			if (amount <= accountBalance && amount <= 200000) {
				newBalance = accountBalance - amount;
				msg = messageSource.getMessage("msg.success", new Object[] { "Test Obj" },
						LocaleContextHolder.getLocale());
				msg = msg + " " + newBalance;
				model.addAttribute("msg", msg);
			} else if (amount > 200000) {
				msg = messageSource.getMessage("error.limitExceeded", new Object[] { "Test Obj" },
						LocaleContextHolder.getLocale());
				msg = msg + " 2,00,000/-";
				model.addAttribute("msg", msg);
			} else if (amount > accountBalance) {
				msg = messageSource.getMessage("error.lowBalance", new Object[] { "Test Obj" },
						LocaleContextHolder.getLocale());
				model.addAttribute("msg", msg);
			}
		}
		return "withdraw";
	}

}
