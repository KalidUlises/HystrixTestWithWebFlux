package com.learning.micro.micro;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Request {
	@NotNull(message="{javax.validation.custom.notnull.message}")
	@Size(min=3, max=10,message = "{javax.validation.custom.size.message}")
	private String kalid;
	@NotNull(message="{javax.validation.custom.notnull.message}")
	private int count;
	
	public Request() {
		
	}
	
	
	public Request(String kalid, int count) {
		
		this.kalid = kalid;
		this.count = count;
	}


	public String getKalid() {
		return kalid;
	}


	public void setKalid(String kalid) {
		this.kalid = kalid;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return String.format("Request [kalid=%s, count=%s]", kalid, count);
	}
	
	

	
	
	
	

}
