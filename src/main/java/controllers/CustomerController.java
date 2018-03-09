package controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Customer;
import service.interfaces.ICustomerService;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@RestController
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@RequestMapping(path = "/customers", method = RequestMethod.GET, produces="application/json")
	public List<Customer> getCustomers() throws JAXBException, SOAPException, IOException{
		return customerService.getAll();
	}
}
