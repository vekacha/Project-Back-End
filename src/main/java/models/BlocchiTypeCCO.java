package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"esistenzaConto", "statoConto", "divisaConto", "richiestaChiusura",
		"presenzaBlocchi" })
@XmlRootElement(name = "BlocchiCCOType")
public class BlocchiTypeCCO {//RESTRICTIONS ON BANK ACCOUNT
	private String esistenzaConto;//existence account
	private double statoConto; //State Account
	private String divisaConto;//Currency account
	private String richiestaChiusura;//Closure request
	private String presenzaBlocchi;//presence of Blocks
	
	

	public String getEsistenzaConto() {
		return esistenzaConto;
	}

	public void setEsistenzaConto(String esistenzaConto) {
		this.esistenzaConto = esistenzaConto;
	}

	public double getStatoConto() {
		return statoConto;
	}

	public void setStatoConto(double statoConto) {
		this.statoConto = statoConto;
	}

	public String getDivisaConto() {
		return divisaConto;
	}

	public void setDivisaConto(String divisaConto) {
		this.divisaConto = divisaConto;
	}

	public String getRichiestaChiusura() {
		return richiestaChiusura;
	}

	public void setRichiestaChiusura(String richiestaChiusura) {
		this.richiestaChiusura = richiestaChiusura;
	}

	public String getPresenzaBlocchi() {
		return presenzaBlocchi;
	}

	public void setPresenzaBlocchi(String presenzaBlocchi) {
		this.presenzaBlocchi = presenzaBlocchi;
	}

	@Override
	public String toString() {
		return "BlocchiTypeCCO [esistenzaConto=" + esistenzaConto + ", statoConto=" + statoConto + ", divisaConto="
				+ divisaConto + ", richiestaChiusura=" + richiestaChiusura + ", presenzaBlocchi=" + presenzaBlocchi
				+ "]";
	}
	
	

}
