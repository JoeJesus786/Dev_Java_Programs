package com.hackerrank.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilteredProducts {
	
	@JsonProperty("barCode")
	private String barCode;
	

	public FilteredProducts() {
        // Default constructor for deserialization
    }

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	
	
	public FilteredProducts(String barCode) {
		this.barCode=barCode;
	}


}