package ro.shareyourcar.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Car extends AbstractModel {

	@NotEmpty
	@Size(min = 2, max = 20)
	private String licensePlate;
	
	@NotEmpty
	@Size(min = 1, max = 20)
	private String producer;
	
	@NotEmpty
	@Size(min = 1, max = 20)
	private String model;
	
	@NotEmpty
	@Size(min = 2, max = 20)
	private String type;
	
	@NotEmpty
	@Size(min = 4, max = 4)
	private String yearOfProduction;
	
	private Integer nrOfSeats;
	private Double fuelTankCap;
	private Double consumption;
	private String startPositionLat;
	private String startPositionLong;
	private String endPositionLat;
	private String endPositionLong;
	private Double price;
	private boolean booked;
	private String ownerUserName;

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

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
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

	public Integer getNrOfSeats() {
		return nrOfSeats;
	}

	public void setNrOfSeats(Integer nrOfSeats) {
		this.nrOfSeats = nrOfSeats;
	}

	public Double getFuelTankCap() {
		return fuelTankCap;
	}

	public void setFuelTankCap(Double fuelTankCap) {
		this.fuelTankCap = fuelTankCap;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public String getStartPositionLong() {
		return startPositionLong;
	}

	public void setStartPositionLong(String startPositionLong) {
		this.startPositionLong = startPositionLong;
	}

	public String getStartPositionLat() {
		return startPositionLat;
	}

	public void setStartPositionLat(String startPositionLat) {
		this.startPositionLat = startPositionLat;
	}

	public String getEndPositionLong() {
		return endPositionLong;
	}

	public void setEndPositionLong(String endPositionLong) {
		this.endPositionLong = endPositionLong;
	}

	public String getEndPositionLat() {
		return endPositionLat;
	}

	public void setEndPositionLat(String endPositionLat) {
		this.endPositionLat = endPositionLat;
	}

	public String getOwnerUserName() {
		return ownerUserName;
	}

	public void setOwnerUserName(String ownerUserName) {
		this.ownerUserName = ownerUserName;
	}

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", producer=" + producer + ", model=" + model + ", type=" + type
				+ ", yearOfProduction=" + yearOfProduction + ", nrOfSeats=" + nrOfSeats + ", fuelTankCap=" + fuelTankCap
				+ ", consumption=" + consumption + ", startPositionLat=" + startPositionLat + ", startPositionLong="
				+ startPositionLong + ", endPositionLat=" + endPositionLat + ", endPositionLong=" + endPositionLong
				+ ", price=" + price + ", booked=" + booked + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booked ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(consumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((endPositionLat == null) ? 0 : endPositionLat.hashCode());
		result = prime * result + ((endPositionLong == null) ? 0 : endPositionLong.hashCode());
		temp = Double.doubleToLongBits(fuelTankCap);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + nrOfSeats;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + ((startPositionLat == null) ? 0 : startPositionLat.hashCode());
		result = prime * result + ((startPositionLong == null) ? 0 : startPositionLong.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

}
