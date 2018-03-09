package extraction;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

@Service
public class ExtractoOfSoapMessage {
	
	public String extrctorMethod() {
		String returnValue = "";
		try {
			
			File fXmlFile = new File("C:\\inputXml.txt");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			String strS = "";
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("output-data");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				NodeList nList2 = doc.getElementsByTagName("app:BlocchiCCOType");

				for (int i = 0; i < nList2.getLength(); i++) {
							
					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						
						strS = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""
								+ " xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
								+ " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
								+ "   <soapenv:Header/>\r\n" + "   <soapenv:Body>      \r\n"
								+ "            <BlocchiCCOType>\r\n" + "               <esistenzaConto>"
								+ eElement.getElementsByTagName("app:esistenzaConto").item(0).getTextContent()
								+ "</esistenzaConto>\r\n" + "               <statoConto>"
								+ eElement.getElementsByTagName("app:statoConto").item(0).getTextContent()
								+ "</statoConto>\r\n" + "               <divisaConto>"
								+ eElement.getElementsByTagName("app:divisaConto").item(0).getTextContent()
								+ "</divisaConto>\r\n" + "               <richiestaChiusura>"
								+ eElement.getElementsByTagName("app:richiestaChiusura").item(0).getTextContent()
								+ "</richiestaChiusura>\r\n" + "               <presenzaBlocchi>"
								+ eElement.getElementsByTagName("app:presenzaBlocchi").item(0).getTextContent()
								+ "</presenzaBlocchi>\r\n" + "            </BlocchiCCOType>        \r\n"
								+ "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";

						
						 
						returnValue += strS;
					}
					
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	 
		 
		return returnValue;
	}
}