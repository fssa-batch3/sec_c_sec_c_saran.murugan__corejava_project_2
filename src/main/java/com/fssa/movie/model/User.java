package com.fssa.movie.model;

public class User {
	private int Userid;
   	private String username;
    private String email;
    private String password;
    private String number;
    
   
    public User(String username, String email, String password, String number) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
	}
	
    
    public User(int userid, String username, String email, String password, String number) {
		super();
		Userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

    }