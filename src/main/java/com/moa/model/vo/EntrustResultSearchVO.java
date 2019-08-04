package com.moa.model.vo;

import lombok.Data;

import java.util.Objects;

@Data
public class EntrustResultSearchVO {
	private int articleNum;
	private int detailPrice;
	private double starPointAvg;
	private String storageType;
	private String pictureName;
	private int totReviewCnt;
	private String storagePeriodTypeId;
	private String nickName;
	private double latitude;
	private double longitude;
	private String distanceResult;
	
	public EntrustResultSearchVO() {
		this(0,0,0,null,null,0,
				null,null,0,0,null);
		// TODO Auto-generated constructor stub
	}
	public EntrustResultSearchVO(int articleNum, int detailPrice, double starPointAvg, String storageType, String pictureName,
			int totReviewCnt, String storagePeriodTypeId, String nickName, double latitude, double longitude,String distanceResult) {
		super();
		this.articleNum = articleNum;
		this.detailPrice = detailPrice;
		this.starPointAvg = starPointAvg;
		this.storageType = storageType;
		this.pictureName = pictureName;
		this.totReviewCnt = totReviewCnt;
		this.storagePeriodTypeId = storagePeriodTypeId;
		this.nickName = nickName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distanceResult= distanceResult;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntrustResultSearchVO that = (EntrustResultSearchVO) o;
		return articleNum == that.articleNum &&
				detailPrice == that.detailPrice &&
				Double.compare(that.starPointAvg, starPointAvg) == 0 &&
				totReviewCnt == that.totReviewCnt &&
				Double.compare(that.latitude, latitude) == 0 &&
				Double.compare(that.longitude, longitude) == 0 &&
				storageType.equals(that.storageType) &&
				pictureName.equals(that.pictureName) &&
				storagePeriodTypeId.equals(that.storagePeriodTypeId) &&
				nickName.equals(that.nickName) &&
				distanceResult.equals(that.distanceResult);
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleNum, detailPrice, starPointAvg, storageType, pictureName, totReviewCnt, storagePeriodTypeId, nickName, latitude, longitude, distanceResult);
	}

	@Override
	public String toString() {
		return "EntrustResultSearchVO [articleNum=" + articleNum + ", detailPrice=" + detailPrice + ", starPointAvg="
				+ starPointAvg + ", storageType=" + storageType + ", pictureName=" + pictureName + ", totReviewCnt="
				+ totReviewCnt + ", storagePeriodTypeId=" + storagePeriodTypeId + ", nickName=" + nickName
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", distanceResult=" + distanceResult + "]";
	}
	
	
	
	
}
