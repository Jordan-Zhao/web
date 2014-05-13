/**
 * Copyright (c) 2013.
 */
package com.findher.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.findher.web.db.Db;
import com.findher.web.vo.Location;

/**
 * @author Jordan 联系人位置服务
 */
@Controller
@RequestMapping("/")
public class ContactLocationController extends BaseController {

	@RequestMapping(value = "/updateContacterLoc.do", method = RequestMethod.GET)
	@ResponseBody
	public Object updateContacterLoc(HttpServletRequest request) {
		List<Location> list = new Db().updateContacterLoc(request.getParameter("myNumber"));
		JSONArray array = new JSONArray((List)list);
		System.out.println( array.toJSONString());
		return list;
	}

	@RequestMapping(value = "/addContacter.do", method = RequestMethod.GET)
	@ResponseBody
	public String addContacter(HttpServletRequest request) {
		new Db().addContacter(request.getParameter("myNumber"), request.getParameter("contacterNumber"));
		return "200";
	}

	@RequestMapping(value = "/updateMyLoc.do", method = RequestMethod.GET)
	@ResponseBody
	public String updateMyLoc(HttpServletRequest request) {
		new Db().updateMyLoc(request.getParameter("myNumber"),
				Double.parseDouble(request.getParameter("lat")),
				Double.parseDouble(request.getParameter("lon")));
		return "200";
	}

}
