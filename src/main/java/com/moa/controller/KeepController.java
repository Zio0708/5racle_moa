package com.moa.controller;

import com.moa.model.service.LuggageWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/storeBoard")
@Controller
public class KeepController {
	@Autowired
	private LuggageWelcomeService luggageWelcomeService;

	@RequestMapping("/keep")
	public ModelAndView registerStoreBoard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("keep");

		String hostId = "3"; //String hostId = (String)request.getAttribute("hostId");
		mav.addObject("hostId", hostId);
		Map<String, Object> map = luggageWelcomeService.initBoard(hostId);
		mav.addObject("map", map);
		return mav;
	}
}
