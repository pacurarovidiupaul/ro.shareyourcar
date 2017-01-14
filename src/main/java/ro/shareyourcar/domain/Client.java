package ro.shareyourcar.domain;

public class Client extends AbstractModel {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String userName;
	private String password;
	private int age;
	private double wallet;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
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

}
