package com.example.demo.topic;
public class Topic {
	private String id;
	private String name;
	private String descp;
	public Topic()
	{
		
	}
	public Topic(String id, String name, String descp) {
		super();
		this.id = id;
		this.name = name;
		this.descp = descp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
