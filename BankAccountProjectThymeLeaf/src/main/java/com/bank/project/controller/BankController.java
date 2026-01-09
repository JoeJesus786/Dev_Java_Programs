package com.bank.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.project.bean.Account;
import com.bank.project.bean.Customer;
import com.bank.project.service.AccountServiceImpl;
import com.bank.project.service.CustomerServiceImpl;

import jakarta.validation.Valid;

@Controller
public class BankController {

	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private CustomerServiceImpl customerService;

	public BankController() {
		super();
		this.accountService = new AccountServiceImpl();
		this.customerService = new CustomerServiceImpl();

	}

	@GetMapping("/createAccount")
	public String showForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("account", new Account());
		model.addAttribute("accountType", "Savings");

		return "account_form";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/createAccount")
	public String submitForm(@Valid @ModelAttribute("customer") Customer customer,
			@Valid @ModelAttribute("account") Account account, BindingResult bindingResult)

	{
		if (bindingResult.hasErrors()) {
			System.out.println("Total count of errors are = " + bindingResult.getErrorCount());
			return "account_form";
		}
		System.out.println(customer);
		customer.setAccount(account);
		account.setCustomer(customer);
		customerService.createNewCustomer(customer);

		return "account_success";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("account", new Account());
		return "Services";
	}

	@GetMapping("/checkBalance")
	public String showBalance(Model model) {
		model.addAttribute("account", new Account());
		return "Services";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/checkBalance")
	public String checkBalance(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult,
			Model model)

	{
		if (bindingResult.hasErrors()) {
			System.out.println("Total count of errors are = " + bindingResult.getErrorCount());
			return "Services";
		}
		System.out.println(account);
		Account accou = accountService.checkBalance(account.getAccountNumber());
		model.addAttribute("account", accou);
		return "check_balance_success";
	}

	@GetMapping("/deposit")
	public String showDeposit(Model model) {
		model.addAttribute("account", new Account());
		return "Services";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/deposit")
	public String submitDeposit(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult,
			Model model)

	{
		if (bindingResult.hasErrors()) {
			System.out.println("Total count of errors are = " + bindingResult.getErrorCount());
			return "Services";
		}
		System.out.println(account);
		Account accou = accountService.deposit(account.getAccountNumber(), account);
		model.addAttribute("account", accou);
		return "check_balance_success";
	}

	@GetMapping("/withdraw")
	public String showWithdraw(Model model) {
		model.addAttribute("account", new Account());
		return "Services";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/withdraw")
	public String submitWithdraw(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult,
			Model model)

	{
		if (bindingResult.hasErrors()) {
			System.out.println("Total count of errors are = " + bindingResult.getErrorCount());
			return "Services";
		}
		try {

			System.out.println(account);
			Account accou = accountService.withdraw(account.getAccountNumber(), account);
			model.addAttribute("account", accou);
			return "check_balance_success";
		}
		catch (IllegalArgumentException e) {
			// TODO: handle exception
			
			return "Insufficient_Balance";
			
		}
		
	}


}
