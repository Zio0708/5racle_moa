package com.moa.controller;


import com.moa.model.service.AddressSearchService;
import com.moa.model.service.HostRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistHostController {
    @Autowired
    private HostRegistrationService hostRegistrationService;
    @Autowired
    private AddressSearchService addressSearchService;

    @RequestMapping(value="/registhost", method = RequestMethod.GET)
    public ModelAndView registHost(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        Map<String, Object> addressInfo = null;
        HttpSession session = request.getSession();

        //session에서 가져온다.
        int userId = 31;

        addressInfo =  addressSearchService.searchAddress(userId);
        if(addressInfo != null) {
            mav.setViewName("registHost");
            mav.addObject("addressId", addressInfo.get("addressId"));
            mav.addObject("address", addressInfo.get("address"));
        }
        else{
            //사용자 주소를 가져오지 못할 경우
        }

        return mav;
    }

    @RequestMapping(value="/registhost", method = RequestMethod.POST)
    @ResponseBody
    public String registHostProc(@RequestParam (value="storage_type") String storagetype,
                                 @RequestParam (value="other_text") String otherText,
                                 @RequestParam (value="origin_or_new") String originOrNew,
                                 @RequestParam (value="address_id") int addressId,
                                 @RequestParam (value="postcode") String postCode,
                                 @RequestParam (value="address") String baseAddress,
                                 @RequestParam (value="detailAddress") String detailAddress,
                                 @RequestParam (value="company_name") String businessName,
                                 @RequestParam (value="company_registration_name") String registrationNum,
                                 @RequestParam (value="company_representative_name") String representative){
        int userId = 31;
        double longitude = 21.45333;
        double latitude = 34.2513551;

        Map<String, Object> hostInfo = new HashMap<String, Object>();

        hostInfo.put("userId", userId);
        hostInfo.put("addressId", addressId);
        hostInfo.put("storageType", storagetype);
        hostInfo.put("originOrNew", originOrNew);
        hostInfo.put("businessName", businessName);
        hostInfo.put("registrationNum", registrationNum);
        hostInfo.put("representative", representative);
        hostInfo.put("otherText", otherText);
        hostInfo.put("postCode", postCode);
        hostInfo.put("baseAddress", baseAddress);
        hostInfo.put("detailAddress", detailAddress);
        hostInfo.put("longitude", longitude);
        hostInfo.put("latitude", latitude);

        boolean res = hostRegistrationService.registHost(hostInfo);

        if(res) {
            System.out.println("insert HostDB information successed");
            return "success";
        }
        else {
            System.out.println("insert HostDB information failed");
            return "fail";
        }

    }


}
