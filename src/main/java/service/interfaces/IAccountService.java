package service.interfaces;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import models.Account;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

public interface IAccountService {
	List<Account> getAll() throws JAXBException, SOAPException, IOException;
}
