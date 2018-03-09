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

import models.Account;
import repos.interfaces.IAccountRepository;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@Repository
public class AccountRepositoryImpl implements IAccountRepository{

	
	String testXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"       \r\n" + 
			"            <Acct>" + 
			"               <customerId>102</customerId>\r\n" + 
			"               <accountNumber>205-12345678923-36</accountNumber>\r\n" + 
			"               <accountType>STF</accountType>\r\n" + 
			"               <isBlocked>false</isBlocked>\r\n" + 
			"               <balance>58523.52</balance>\r\n" + 
			"            </Acct>\r\n" + 
			"          \r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	
	@Override
	public List<Account> getAll() throws JAXBException, SOAPException, IOException{
		List<Account> accounts = new ArrayList<>();
		StringWriter sw = new StringWriter();
		SOAPMessage soapResponse = getSoapMessageFromString(testXml);
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(soapResponse.getSOAPPart()),
					new StreamResult(sw));
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}

		Unmarshaller unmarshaller = JAXBContext.newInstance(models.Account.class).createUnmarshaller();
		Account account = (models.Account)unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
		accounts.add(account);
		accounts.add(account);
		return accounts;
	}
	
	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}
}
