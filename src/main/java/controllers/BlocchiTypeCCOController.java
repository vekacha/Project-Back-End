package controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.BlocchiTypeCCO;
import service.BlocchiServiceImpl;
import service.interfaces.IBlocchiService;

@RestController
public class BlocchiTypeCCOController {
	
	@Autowired
	IBlocchiService blocchiService= new BlocchiServiceImpl();
	
	
	/*@RequestMapping(path = "/getblocchi",method = RequestMethod.GET, produces = "application/json")
	public BlocchiTypeCCO getBlocchi() throws JAXBException, SOAPException, IOException {
	 
		return blocchiService.getBlocchi();
	}*/
	
	@CrossOrigin
	@RequestMapping(path = "/getblocchi",method = RequestMethod.GET, produces = "application/json")
	public List<BlocchiTypeCCO> getBlocchiList() throws JAXBException, SOAPException, IOException {
	 
		return blocchiService.getBlocchiList();
	}
}
