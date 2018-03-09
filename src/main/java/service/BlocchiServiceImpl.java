package service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.BlocchiTypeCCI;
import models.BlocchiTypeCCO;
import repos.interfaces.IBlocchiRepository;
import service.interfaces.IBlocchiService;

@Service
public class BlocchiServiceImpl implements IBlocchiService{

	@Autowired
	 IBlocchiRepository blocchiRepo;

	@Override
	public BlocchiTypeCCO getBlocchi() throws JAXBException, SOAPException, IOException {
		// TODO Auto-generated method stub
		return blocchiRepo.getBlocchi();
	}

	@Override
	public List<BlocchiTypeCCO> getBlocchiList() throws JAXBException, SOAPException, IOException {
		
		return  blocchiRepo.getBlocchiList();
	}

	@Override
	public void insertBlocchiCC(BlocchiTypeCCI blocchiTypeCCI) {
		// TODO Auto-generated method stub
		blocchiRepo.insertBlocchiCC(blocchiTypeCCI);
	}

 
}
