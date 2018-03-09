package repos.interfaces;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import models.BlocchiTypeCCI;
import models.BlocchiTypeCCO;

public interface IBlocchiRepository {
	BlocchiTypeCCO getBlocchi() throws JAXBException, SOAPException, IOException;

	List<BlocchiTypeCCO> getBlocchiList() throws JAXBException, SOAPException, IOException;

	void insertBlocchiCC(BlocchiTypeCCI blocchiTypeCCI);

}
