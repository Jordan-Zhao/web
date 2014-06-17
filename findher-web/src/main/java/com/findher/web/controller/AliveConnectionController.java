/**
 * Copyright (c) 2013.
 */
package com.findher.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class AliveConnectionController extends BaseController {

	@RequestMapping(value = "/keepAlive.do", method = RequestMethod.GET)
	public Object updateContacterLoc(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Enumeration enum1 = request.getHeaderNames();
		System.out.println("===========>");
		while (enum1.hasMoreElements()) {
			Object object = (Object) enum1.nextElement();
			System.out.println(object+":"+request.getHeader(object.toString()));
		}
		System.out.println("<===========");
//		while(true){
			OutputStream out = response.getOutputStream();
			out.write(String.valueOf(System.currentTimeMillis()).getBytes());
			Thread.sleep(1000);
			out.flush();
//		}
			out.close();
			return null;
	}


}
