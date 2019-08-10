package com.moa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/storeboard")
@Controller
public class KeepConxtroller {
	@RequestMapping("/keep")
	public String registerStoreBoard() {
		return "keep";
	}
	public void asd(){

	}
}
