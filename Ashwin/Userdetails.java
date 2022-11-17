package com.Ashwin;

public class Userdetails {
	
	private String name;
	private String password;
    private String username;
    
    
    
	public Userdetails(String name,String password,String username) {
		this.name = name;
		this. password =  password;
		this.username = username;
	}
	
	public Userdetails() {
		
	}


	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() 
	{
		return "Userdetails [name=" + name + ", password=" + password + ", username=" + username + "]";
	}
	

	public String updateQuery() {
		return "'"+name+"','"+username+"','"+password+"'";
		//		return '+name+","+username+","+password;
	}
	
	
}
