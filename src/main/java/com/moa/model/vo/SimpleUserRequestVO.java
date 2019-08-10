package com.moa.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SimpleUserRequestVO {
	private int requestId;
	private String profileName;
	private String hostNick;
	private Date startDate;
	private Date endDate;
	private List<String> productCategory;
	private List<String> productName;
	private List<Integer> productCnt;
	private int measuredPrice;
	private int bargainPrice;
	private String baseAddress;
	private String detailAddress;

	public SimpleUserRequestVO() {
		this.requestId = 0;
		this.profileName = null;
		this.hostNick = null;
		this.startDate = null;
		this.endDate = null;
		this.productCategory = new ArrayList<>();
		this.productName = new ArrayList<>();
		this.productCnt = new ArrayList<>();
		this.bargainPrice = 0;
		this.measuredPrice = 0;
		this.baseAddress = null;
		this.detailAddress = null;
	}
}
