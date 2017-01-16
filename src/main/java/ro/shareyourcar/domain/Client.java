package ro.shareyourcar.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Client extends AbstractModel {

	@NotEmpty
	@Size(min = 2, max = 60)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 60)
	private String lastName;

	@NotEmpty
	@Size(min = 2, max = 60)
	private String emailAddress;

	@NotEmpty
	@Size(min = 2, max = 15)
	private String phoneNumber;

	@NotEmpty
	@Size(min = 3, max = 15)
	private String userName;

	@NotEmpty
	@Size(min = 6, max = 15)
	private String password;

	private Integer age;
	private Double wallet;
	private String currentLocation;
	private String currentLocationLong;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getCurrentLocationLong() {
		return currentLocationLong;
	}

	public void setCurrentLocationLong(String currentLocationLong) {
		this.currentLocationLong = currentLocationLong;
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", wallet=" + wallet + ", currentLocation=" + currentLocation + ", currentLocationLong="
				+ currentLocationLong + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + age;
		temp = Double.doubleToLongBits(wallet);
		result = prime * result + (int) (temp ^ (temp >>> 32));

		return result;
	}

}
