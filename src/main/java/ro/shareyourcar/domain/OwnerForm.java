package ro.shareyourcar.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OwnerForm {
	

	@NotNull
    @Size(min=2, max=30)
    private String firstName;
  
    @NotNull
    @Size(min=2, max=30)
    private String lastName;
    
    @NotNull
    @Size(min=2, max=30)
    private String emailAddress;
    
    @NotNull
    @Size(min=2, max=30)
	private String phoneNumber;
    
    @NotNull
    @Size(min=2, max=30)
	private String userName;
    
    @NotNull
    @Size(min=2, max=30)
	private String password;
    
    
	private double profit;


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


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getProfit() {
		return profit;
	}


	public void setProfit(double profit) {
		this.profit = profit;
	}


	@Override
	public String toString() {
		return "OwnerForm [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password + ", profit="
				+ profit + "]";
	}

	    
}
