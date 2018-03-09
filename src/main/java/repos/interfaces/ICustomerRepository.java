package repos.interfaces;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import models.Customer;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

public interface ICustomerRepository {
	List<Customer> getAll() throws JAXBException, SOAPException, IOException;
}