package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
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

import extraction.ExtractoOfSoapMessage;
import models.BlocchiTypeCCO;
import repos.BlocchiRepositoryImpl;
import service.BlocchiServiceImpl;

public class MyApp {
	/*static String testXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
			+ "   <soapenv:Header/>\r\n" + "   <soapenv:Body>\r\n"
			+ "      <jdf:JdfResponseFornkBlocchiCC xmlns:jdf=\"http://www.bnpp.com/jdf\">\r\n"
			+ "         <jdf:header>\r\n" + "            <jdf:trace-id>1</jdf:trace-id>\r\n"
			+ "            <jdf:timestamp>1520324132950</jdf:timestamp>\r\n"
			+ "            <jdf:command>jrf-nk.BlocchiCCFacade</jdf:command>\r\n" + "            <jdf:version/>\r\n"
			+ "            <jdf:operation-id/>\r\n" + "            <jdf:calling-user>a</jdf:calling-user>\r\n"
			+ "            <jdf:calling-application>test_app</jdf:calling-application>\r\n"
			+ "            <jdf:calling-channel/>\r\n" + "            <jdf:locale-code>it</jdf:locale-code>\r\n"
			+ "            <jdf:country-code>IT</jdf:country-code>\r\n" + "         </jdf:header>\r\n"
			+ "         <output-data xmlns=\"http://www.bnpp.com/jdf/service/nk/blocchicc/output\">\r\n"
			+ "            <app:BlocchiCCOType xmlns:app=\"http://www.bnpp.com/jdf/service/nk/blocchicc/output\">\r\n"
			+ "               <app:esistenzaConto>S</app:esistenzaConto>\r\n"
			+ "               <app:statoConto>20</app:statoConto>pare\r\n"
			+ "               <app:divisaConto>EUR</app:divisaConto>\r\n"
			+ "               <app:richiestaChiusura>N</app:richiestaChiusura>\r\n"
			+ "               <app:presenzaBlocchi>N</app:presenzaBlocchi>\r\n"
			+ "            </app:BlocchiCCOType>\r\n" + "         </output-data>\r\n"
			+ "      </jdf:JdfResponseFornkBlocchiCC>\r\n" + "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";*/
	static String testXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"       \r\n" + 
			"            <BlocchiCCOType>" + 
			"               <esistenzaConto>S</esistenzaConto>\r\n" + 
			"               <statoConto>20</statoConto>\r\n" + 
			"               <divisaConto>EUR</divisaConto>\r\n" + 
			"               <richiestaChiusura>N</richiestaChiusura>\r\n" + 
			"               <presenzaBlocchi>N</presenzaBlocchi>\r\n" + 
			"            </BlocchiCCOType>\r\n" + 
			"          \r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";

	public static void main(String[] args) throws JAXBException, SOAPException, IOException {

		/*JAXBContext jc = JAXBContext.newInstance(JaxB.BankAccount.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();*/
		
		ExtractoOfSoapMessage ouhg0ierg= new ExtractoOfSoapMessage();
		System.out.println(ouhg0ierg.extrctorMethod());

		StringWriter sw = new StringWriter();
		SOAPMessage soapResponse = getSoapMessageFromString(testXml);
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(soapResponse.getSOAPPart()),
					new StreamResult(sw));
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}

		// Now you have the XML as a String:
		System.out.println(sw.toString());
		System.out.println("****************************************************!!!");
		Unmarshaller unmarshaller = JAXBContext.newInstance(models.BlocchiTypeCCO.class).createUnmarshaller();
		BlocchiTypeCCO blocchiTypeCCO = (models.BlocchiTypeCCO)unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
		System.out.println("****************************************************");
		System.out.println(blocchiTypeCCO.getDivisaConto());
		System.out.println(blocchiTypeCCO.getEsistenzaConto());
		System.out.println(blocchiTypeCCO.getRichiestaChiusura());
		System.out.println(blocchiTypeCCO.getPresenzaBlocchi());
		System.out.println(blocchiTypeCCO.getStatoConto());
		System.out.println("****************************************************");
		System.out.println("TESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		
		//BlocchiRepositoryImpl x = new BlocchiRepositoryImpl();
		//BlocchiServiceImpl dva = new BlocchiServiceImpl();
		//System.out.println(x.getBlocchi().toString());
		//System.out.println(dva.toString());

	}

	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}
}
