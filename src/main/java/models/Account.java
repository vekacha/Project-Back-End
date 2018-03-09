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
    "accountNumber",
    "accountType",
    "isBlocked",
    "balance",
    "blocchiTypeCCO"
})
@XmlRootElement(name = "Acct")
public class Account {
	
	private int customerId;
	private String accountNumber;
	private String accountType;
	private boolean isBlocked;
	private double balance;
	private BlocchiTypeCCO blocchiTypeCCO;
		
	public Account() {
	}
	
	public Account(int customerId, String accountType, String accountNumber, boolean isBlocked, double balance, BlocchiTypeCCO blocchiTypeCCO) {
		this.customerId = customerId;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.isBlocked = isBlocked;
		this.balance = balance;
		this.blocchiTypeCCO = blocchiTypeCCO;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	public BlocchiTypeCCO getBlocchiTypeCCO() {
		return blocchiTypeCCO;
	}
	public void setBlocchiTypeCCO(BlocchiTypeCCO blocchiTypeCCO) {
		this.blocchiTypeCCO = blocchiTypeCCO;
	}


	@Override
	public String toString() {
		return "Account [customerId=" + customerId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", isBlocked=" + isBlocked + ", balance=" + balance + ", blocchiTypeCCO=" + blocchiTypeCCO + "]";
	}

	

		
}
