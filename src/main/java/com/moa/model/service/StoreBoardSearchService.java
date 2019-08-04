package com.moa.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.moa.model.dao.StoreBoardDAO;
import com.moa.model.dao.StoreBoardDAOImpl;
import com.moa.model.vo.DetailOptionVO;
import com.moa.model.vo.EntrustResultSearchVO;
import com.moa.model.vo.EntrustSearchVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class StoreBoardSearchService {
	@Autowired
	private StoreBoardDAO storeBoardDAO;

	public  List<Object> search(DetailOptionVO detail){
		
		List<Object> resultAry = new ArrayList<>();
		EntrustResultSearchVO result;
		List<EntrustSearchVO> entrustAry;
		entrustAry=storeBoardDAO.searchEntrust(detail);

		for(EntrustSearchVO en : entrustAry) 
		{
		String storagePeriod ="";
		double latResult = en.getLatitude();
		double logResult = en.getLongitude();
			System.out.println("서비스 가동 : "+en.getNickName());
		String distanceResult = (Double.toString(distance(detail.getLatitude(),detail.getLongitude(),
				latResult,logResult,"kilometer"))).substring(0,3);
		
		if(en.getStoragePeriodTypeId().equals("1"))
		{
			storagePeriod="무관";
		}
		else if(en.getStoragePeriodTypeId().equals("2"))
		{
			storagePeriod="장기(1달~1년)";
		}
		else if(en.getStoragePeriodTypeId().equals("3"))
		{
			storagePeriod="단기(1일~1달)";
		}
		result =new EntrustResultSearchVO(en.getArticleNum(),en.getDetailPrice(),en.getStarPointAvg(),en.getStorageType(),en.getPictureName(),
				en.getTotReviewCnt(),storagePeriod,en.getNickName(),en.getLatitude(),en.getLongitude(),distanceResult);
		resultAry.add(result);
		}
		return resultAry;
	}
	  private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
	         
	        double theta = lon1 - lon2;
	        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	         
	        dist = Math.acos(dist);
	        dist = rad2deg(dist);
	        dist = dist * 60 * 1.1515;
	         
	        if (unit.equals("kilometer")) {
	            dist = dist * 1.609344;
	        } else if(unit.equals("meter")){
	            dist = dist * 1609.344;
	        }
	 
	        return (dist);
	    }
	    private double deg2rad(double deg) {
	        return (deg * Math.PI / 180.0);
	    }
	    private double rad2deg(double rad) {
	        return (rad * 180 / Math.PI);
	    }
}
