package com.moa.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ReadStoreRequestVO {
	private String profileName;
	private int userId;
	private int hostId;
	private String hostNick;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private List<String> productCategory;
	private List<String> productName;
	private List<Integer> productCnt;
	private int bargainPrice;
	private int measuredPrice;
	private List<String> pictureList;
	private String content;
	private String transactionType;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp applicationDate;
	private int requestId;
	private String baseAddress;
	private String detailAddress;

	public ReadStoreRequestVO() {
		this.profileName = null;
		this.userId = 0;
		this.hostId = 0;
		this.hostNick = null;
		this.startDate = null;
		this.endDate = null;
		this.productCategory = new ArrayList<>();
		this.productName =  new ArrayList<>();
		this.productCnt =  new ArrayList<>();
		this.bargainPrice = 0;
		this.measuredPrice = 0;
		this.pictureList =  new ArrayList<>();;
		this.content = null;
		this.transactionType = null;
		this.applicationDate = null;
		this.requestId = 0;
		this.baseAddress = null;
		this.detailAddress = null;
	}
}
