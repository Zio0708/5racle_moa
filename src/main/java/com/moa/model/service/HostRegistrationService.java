package com.moa.model.service;

import com.moa.model.dao.HostStorageDAO;
import com.moa.model.vo.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@NoArgsConstructor
public class HostRegistrationService {
    @Autowired
    private HostStorageDAO hostStorageDAO;

    public boolean registHost(Map<String, Object> hostInfo){
        String storageType = (String)hostInfo.get("storageType");
        String originOrNew = (String)hostInfo.get("originOrNew");

        if(storageType.equals("home")) {
            if(originOrNew.equals("origin")) {
                OriginHomeStorageVO ohsVO = new OriginHomeStorageVO();

                ohsVO.setUserId((Integer)hostInfo.get("userId"));
                ohsVO.setAddressId((Integer)hostInfo.get("addressId"));

                return hostStorageDAO.insertOriginHome(ohsVO);
            }
            else if(originOrNew.equals("new")) {
                NewHomeStorageVO nhsVO = new NewHomeStorageVO();

                nhsVO.setLongitude((Double)hostInfo.get("longitude"));
                nhsVO.setLatitude((Double)hostInfo.get("latitude"));
                nhsVO.setPostCode((String)hostInfo.get("postCode"));
                nhsVO.setBaseAddress((String)hostInfo.get("baseAddress"));
                nhsVO.setDetailAddress((String)hostInfo.get("detailAddress"));
                nhsVO.setUserId((Integer)hostInfo.get("userId"));

                return hostStorageDAO.insertNewHome(nhsVO);
            }
            else {
                System.out.println("home & exception");
            }
        }
        else if(storageType.equals("store") || storageType.equals("company")) {
            if(originOrNew.equals("origin")) {
                OriginCompanyStorageVO ocsVO = new OriginCompanyStorageVO();

                ocsVO.setUserId((Integer)hostInfo.get("userId"));
                ocsVO.setAddressId((Integer)hostInfo.get("addressId"));
                ocsVO.setBusinessName((String)hostInfo.get("businessName"));
                ocsVO.setRepresentative((String)hostInfo.get("representative"));
                ocsVO.setRegistrationNum((String)hostInfo.get("registrationNum"));

                return hostStorageDAO.insertOriginCompany(ocsVO);
            }
            else if(originOrNew.equals("new")) {
                NewCompanyStorageVO ncsVO = new NewCompanyStorageVO();

                ncsVO.setLongitude((Double)hostInfo.get("longitude"));
                ncsVO.setLatitude((Double)hostInfo.get("latitude"));
                ncsVO.setPostCode((String)hostInfo.get("postCode"));
                ncsVO.setBaseAddress((String)hostInfo.get("baseAddress"));
                ncsVO.setDetailAddress((String)hostInfo.get("detailAddress"));
                ncsVO.setUserId((Integer)hostInfo.get("userId"));
                ncsVO.setBusinessName((String)hostInfo.get("businessName"));
                ncsVO.setRepresentative((String)hostInfo.get("representative"));
                ncsVO.setRegistrationNum((String)hostInfo.get("registrationNum"));

                return hostStorageDAO.insertNewCompany(ncsVO);
            }
            else {
                System.out.println("company & exception");
            }
        }
        else if(storageType.equals("other")) {
            if(originOrNew.equals("origin")) {
                OriginOtherStorageVO oosVO = new OriginOtherStorageVO();

                oosVO.setUserId((Integer)hostInfo.get("userId"));
                oosVO.setAddressId((Integer)hostInfo.get("addressId"));
                oosVO.setOtherText((String)hostInfo.get("otherText"));

                return hostStorageDAO.insertOriginOther(oosVO);
            }
            else if(originOrNew.equals("new")) {
                NewOtherStorageVO nosVO = new NewOtherStorageVO();

                nosVO.setLongitude((Double)hostInfo.get("longitude"));
                nosVO.setLatitude((Double)hostInfo.get("latitude"));
                nosVO.setPostCode((String)hostInfo.get("postCode"));
                nosVO.setBaseAddress((String)hostInfo.get("baseAddress"));
                nosVO.setDetailAddress((String)hostInfo.get("detailAddress"));
                nosVO.setUserId((Integer)hostInfo.get("userId"));
                nosVO.setOtherText((String)hostInfo.get("otherText"));
                System.out.println("2");
                return hostStorageDAO.insertNewOther(nosVO);
            }
            else {
                System.out.println("other & exception");
            }
        }
        else {
            System.out.println("exception");
        }
        return false;
    }
}

