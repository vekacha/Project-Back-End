package service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Customer;
import repos.interfaces.ICustomerRepository;
import service.interfaces.ICustomerService;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAll() throws JAXBException, SOAPException, IOException {
		return customerRepository.getAll();
	}
}