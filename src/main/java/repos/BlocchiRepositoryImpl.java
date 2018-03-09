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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import extraction.ExtractoOfSoapMessage;
import models.BlocchiTypeCCI;
import models.BlocchiTypeCCO;
import repos.interfaces.IBlocchiRepository;

@Repository
public class BlocchiRepositoryImpl implements IBlocchiRepository{	
	
	@Autowired
	ExtractoOfSoapMessage ouhg0ierg;  
	 
	@Override
	public BlocchiTypeCCO getBlocchi() throws JAXBException, SOAPException, IOException{
		
		StringWriter sw = new StringWriter();		 
		SOAPMessage soapResponse = getSoapMessageFromString(ouhg0ierg.extrctorMethod());
		 
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(soapResponse.getSOAPPart()),
					new StreamResult(sw));
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}

		Unmarshaller unmarshaller = JAXBContext.newInstance(models.BlocchiTypeCCO.class).createUnmarshaller();
		BlocchiTypeCCO blocchiTypeCCO = (models.BlocchiTypeCCO)unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
		return blocchiTypeCCO;
	}
	
	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}
	
	public List<BlocchiTypeCCO> getBlocchiList() throws JAXBException, SOAPException, IOException{
		ArrayList<BlocchiTypeCCO> temp = new ArrayList<>();
		temp.add(getBlocchi());
		//temp.add(getBlocchi());
		return temp;
	}

	@Override
	public void insertBlocchiCC(BlocchiTypeCCI blocchiTypeCCI) {
		//ovde prebaciti blocchiTypeCCI u string
		System.out.println(blocchiTypeCCI.getSportello()+", "+ blocchiTypeCCI.getConto());
		System.out.println(blocchiTypeCCI.getServiceInput().getAhChannelType());
		System.out.println(blocchiTypeCCI.getServiceInput().getAhCodCentro());
		System.out.println(blocchiTypeCCI.getServiceInput().getAhDomainId());
		System.out.println(blocchiTypeCCI.getServiceInput().getAhHeaderType());
		System.out.println(blocchiTypeCCI.getServiceInput().getAhNodeId());
		System.out.println(blocchiTypeCCI.getServiceInput().getAhUserId());
		
	
		                  		
		
		
	}
	
	 

}
