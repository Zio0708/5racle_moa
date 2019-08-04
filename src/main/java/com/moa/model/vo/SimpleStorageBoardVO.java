package com.moa.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SimpleStorageBoardVO {
	private int articleNum;
	private String title;
	private int storeProductCnt;
	private int expireProductCnt;
	private int favoriteCnt;
	private int reviewCnt;
	private double starPoint;
	private String pictureName;

	public SimpleStorageBoardVO() {
		this(0, null, 0, 0, 0, 0, 0, null);
	}

	public SimpleStorageBoardVO(int articleNum, String title, int storeProductCnt, int expireProductCnt,
			int favoriteCnt, int reviewCnt, double starPoint2, String pictureName) {
		this.articleNum = articleNum;
		this.title = title;
		this.storeProductCnt = storeProductCnt;
		this.expireProductCnt = expireProductCnt;
		this.favoriteCnt = favoriteCnt;
		this.reviewCnt = reviewCnt;
		this.starPoint = starPoint2;
		this.pictureName = pictureName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNum;
		result = prime * result + expireProductCnt;
		result = prime * result + favoriteCnt;
		result = prime * result + ((pictureName == null) ? 0 : pictureName.hashCode());
		result = prime * result + reviewCnt;
		long temp;
		temp = Double.doubleToLongBits(starPoint);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + storeProductCnt;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleStorageBoardVO other = (SimpleStorageBoardVO) obj;
		if (articleNum != other.articleNum)
			return false;
		if (expireProductCnt != other.expireProductCnt)
			return false;
		if (favoriteCnt != other.favoriteCnt)
			return false;
		if (pictureName == null) {
			if (other.pictureName != null)
				return false;
		} else if (!pictureName.equals(other.pictureName))
			return false;
		if (reviewCnt != other.reviewCnt)
			return false;
		if (Double.doubleToLongBits(starPoint) != Double.doubleToLongBits(other.starPoint))
			return false;
		if (storeProductCnt != other.storeProductCnt)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleStorageBoardVO [articleNum=" + articleNum + ", title=" + title + ", storeProductCnt="
				+ storeProductCnt + ", expiredProductCnt=" + expireProductCnt + ", favoriteCnt=" + favoriteCnt
				+ ", reviewCnt=" + reviewCnt + ", starPoint=" + starPoint + ", pictureName=" + pictureName + "]";
	}

	
	
	
	

}
