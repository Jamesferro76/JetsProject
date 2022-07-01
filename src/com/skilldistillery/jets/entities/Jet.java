package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private int speedMPH;
	private double speedMach;
	private long range;
	private double price;
	
	public Jet(String model, int speedMPH, long range, double price) {
		super();
		this.model = model;
		this.speedMPH = speedMPH;
		this.range = range;
		this.price = price;
		this.speedMach=speedMPH/767.3;
	}

	public Jet() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeedMPH() {
		return speedMPH;
	}

	public void setSpeedMPH(int speedMPH) {
		this.speedMPH = speedMPH;
	}

	public long getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speedMPH=" + speedMPH + ", speedMach=" + speedMach + ", range=" + range
				+ ", price=" + price + "]";
	}
	
	
	

}
