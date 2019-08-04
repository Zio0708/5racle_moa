package com.moa.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailOptionVO {
	private String category;
	private int distance;
	private String filter;
	private String storageType;
	private String transactionType;
	private String storagePeriodType;
	private String securityFacility;
	private String petFlag;
	private double latitude;
	private double longitude;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + distance;
		result = prime * result + ((filter == null) ? 0 : filter.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((petFlag == null) ? 0 : petFlag.hashCode());
		result = prime * result + ((securityFacility == null) ? 0 : securityFacility.hashCode());
		result = prime * result + ((storagePeriodType == null) ? 0 : storagePeriodType.hashCode());
		result = prime * result + ((storageType == null) ? 0 : storageType.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
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
		DetailOptionVO other = (DetailOptionVO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (distance != other.distance)
			return false;
		if (filter == null) {
			if (other.filter != null)
				return false;
		} else if (!filter.equals(other.filter))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (petFlag == null) {
			if (other.petFlag != null)
				return false;
		} else if (!petFlag.equals(other.petFlag))
			return false;
		if (securityFacility == null) {
			if (other.securityFacility != null)
				return false;
		} else if (!securityFacility.equals(other.securityFacility))
			return false;
		if (storagePeriodType == null) {
			if (other.storagePeriodType != null)
				return false;
		} else if (!storagePeriodType.equals(other.storagePeriodType))
			return false;
		if (storageType == null) {
			if (other.storageType != null)
				return false;
		} else if (!storageType.equals(other.storageType))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetailOptionVO [category=" + category + ", distance=" + distance + ", filter=" + filter
				+ ", transactionType=" + transactionType + ", storageType=" + storageType + ", securityFacility="
				+ securityFacility + ", latitude=" + latitude + ", longitude=" + longitude + ", storagePeriodType="
				+ storagePeriodType + ", petFlag=" + petFlag + "]";
	}
	
	
		
}
