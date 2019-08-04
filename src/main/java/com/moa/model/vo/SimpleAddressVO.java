package com.moa.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleAddressVO {
	private int addressId;
	private String baseAddress;
	private String detailAddress;
}	
