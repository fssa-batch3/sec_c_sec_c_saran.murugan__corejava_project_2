
package com.fssa.movie.model;

public class Theater {
	
	
	private int theaterId;
	private String name;
    private String location;
    private String address;
    private int numSeats;
    private int seatCost;

    // Constructor
    public Theater(String name, String location, String address, int numSeats,int seatCost) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.numSeats = numSeats;
        this.seatCost = seatCost;
    }

    public Theater(int theaterId, String name, String location, String address, int numSeats ,int seatCost) {
		super();
		this.theaterId = theaterId;
		this.name = name;
		this.location = location;
		this.address = address;
		this.numSeats = numSeats;
		this.seatCost = seatCost;
	}

	public int getSeatCost() {
		return seatCost;
	}

	public void setSeatCost(int seatCost) {
		this.seatCost = seatCost;
	}

	public Theater() {
		// TODO Auto-generated constructor stub
	}
	// Getters and setters
    public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
}
