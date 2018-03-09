package controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Account;
import service.interfaces.IAccountService;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@RestController
public class AccountController {
	
	@Autowired
	IAccountService accountService;
	
	@RequestMapping(path = "/accounts", method = RequestMethod.GET, produces="application/json")
	public List<Account> getAccountsForCustomer() throws JAXBException, SOAPException, IOException{
		return accountService.getAll();
	}
}