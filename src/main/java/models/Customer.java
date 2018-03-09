package models;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * 
 * @author Srdjan Cvetkovic, Goran Marinkovic
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerId",
    "roleId",
    "firstName",
    "lastName",
    "legalStatus",
    "signatureType"
})
@XmlRootElement(name = "Cust")
public class Customer {

	private int customerId;
	private int roleId;
	private String firstName;
	private String lastName;
	private String legalStatus;
	private String signatureType;
	
	public Customer() {
	}

	public Customer(int customerId, int roleId, String firstName, String lastName, String legalStatus,
			String signatureType) {
		this.customerId = customerId;
		this.roleId = roleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.legalStatus = legalStatus;
		this.signatureType = signatureType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getSignatureType() {
		return signatureType;
	}

	public void setSignatureType(String signatureType) {
		this.signatureType = signatureType;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", roleId=" + roleId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", legalStatus=" + legalStatus + ", signatureType=" + signatureType + "]";
	}	
}
