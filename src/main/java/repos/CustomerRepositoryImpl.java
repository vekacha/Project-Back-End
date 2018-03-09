package repos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Repository;

import models.Customer;
import repos.interfaces.ICustomerRepository;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository{
	
	String testXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"       \r\n" + 
			"            <Cust>" + 
			"               <customerId>102</customerId>\r\n" + 
			"               <roleId>36</roleId>\r\n" + 
			"               <firstName>Stevan</firstName>\r\n" + 
			"               <lastName>Stevic</lastName>\r\n" + 
			"               <legalStatus>PTC</legalStatus>\r\n" + 
			"               <signatureType>S</signatureType>\r\n" + 
			"            </Cust>\r\n" + 
			"          \r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	
	@Override
	public List<Customer> getAll() throws JAXBException, SOAPException, IOException{
		List<Customer> customers = new ArrayList<>();
		StringWriter sw = new StringWriter();
		SOAPMessage soapResponse = getSoapMessageFromString(testXml);
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(soapResponse.getSOAPPart()),
					new StreamResult(sw));
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}

		Unmarshaller unmarshaller = JAXBContext.newInstance(models.Customer.class).createUnmarshaller();
		Customer customer = (models.Customer)unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
		customers.add(customer);
		customers.add(customer);
		return customers;
	}
	
	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}

}
