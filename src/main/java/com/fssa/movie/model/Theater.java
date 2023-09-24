package com.fssa.movie.model;

public class Theater {
	
	
	private int theaterId;
	private String name;
    private String location;
    private String address;
    private int numSeats;

    // Constructor
    public Theater(String name, String location, String address, int numSeats) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.numSeats = numSeats;
    }

    public Theater(int theaterId, String name, String location, String address, int numSeats) {
		super();
		this.theaterId = theaterId;
		this.name = name;
		this.location = location;
		this.address = address;
		this.numSeats = numSeats;
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
