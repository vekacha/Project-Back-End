package service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Account;
import repos.interfaces.IAccountRepository;
import service.interfaces.IAccountService;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	IAccountRepository accountRepository;
	
	@Override
	public List<Account> getAll() throws JAXBException, SOAPException, IOException {
		return accountRepository.getAll();
	}

}