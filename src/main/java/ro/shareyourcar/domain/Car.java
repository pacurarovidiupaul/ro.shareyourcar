package ro.shareyourcar.domain;

public class Car extends AbstractModel {

	private String producer;
	private String model;
	private String type;
	private String yearOfProduction;
	private int seats;
	private double fuelTankCapacity;
	private double consumptionPerKm;
	private String startPosition;
	private String endPosition;
	private String pricePerKm;

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(String yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public double getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(double fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public double getConsumptionPerKm() {
		return consumptionPerKm;
	}

	public void setConsumptionPerKm(double consumptionPerKm) {
		this.consumptionPerKm = consumptionPerKm;
	}

	public String getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}

	public String getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(String endPosition) {
		this.endPosition = endPosition;
	}

	public String getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(String pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

	@Override
	public String toString() {
		return "Car [producer=" + producer + ", model=" + model + ", type=" + type + ", yearOfProduction="
				+ yearOfProduction + ", seats=" + seats + ", fuelTankCapacity=" + fuelTankCapacity
				+ ", consumptionPerKm=" + consumptionPerKm + ", startPosition=" + startPosition + ", endPosition="
				+ endPosition + ", pricePerKm=" + pricePerKm + "]";
	}

}