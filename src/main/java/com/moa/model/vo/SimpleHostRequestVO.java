package com.moa.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
public class SimpleHostRequestVO {
	private int articleNum;
	private int userId;
	private String nick;
	private String profileImg;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private String products;
	private int price;
	private String state;
	
	public SimpleHostRequestVO() {
		this(0,0,null,null, null, null, null, 0, null);
	}
	
	public SimpleHostRequestVO(int articleNum,int userId, String nick, String profileImg, Date startDate, Date endDate
			,String products,int price, String state) {
		this.articleNum = articleNum;
		this.userId =userId;
		this.nick = nick;
		this.profileImg = profileImg;
		this.startDate = startDate;
		this.endDate = endDate;
		this.products = products;
		this.price = price;
		this.state = state;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNum;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + price;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((profileImg == null) ? 0 : profileImg.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + userId;
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
		SimpleHostRequestVO other = (SimpleHostRequestVO) obj;
		if (articleNum != other.articleNum)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (price != other.price)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (profileImg == null) {
			if (other.profileImg != null)
				return false;
		} else if (!profileImg.equals(other.profileImg))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleRequestVO [articleNum=" + articleNum + ", userId=" + userId + ", nick=" + nick + ", profileImg="
				+ profileImg + ", startDate=" + startDate + ", endDate=" + endDate + ", products=" + products
				+ ", price=" + price + ", state=" + state + "]";
	}
	
	
}
