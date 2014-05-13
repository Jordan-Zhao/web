package com.findher.web.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.security.util.SecurityUtil;

/**
 * 支持jsonp请求
 * 
 * @author jindong.zjd
 * 
 */
public class JsonpCallbackFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);

		chain.doFilter(request, wrapper);

		OutputStream out = httpResponse.getOutputStream();
		@SuppressWarnings("unchecked")
		Map<String, String[]> parms = httpRequest.getParameterMap();
		if (parms.containsKey("callback") && parms.get("callback") != null 
				&& parms.get("callback").length > 0) { // 包装callback回调函数
			String callback = SecurityUtil.escapeHtml(parms.get("callback")[0]);
			out.write(new String(callback + "(").getBytes());
			out.write(wrapper.getData());
			out.write(new String(");").getBytes());
			wrapper.setContentType("text/javascript;charset=UTF-8");
			out.close();
		} else {
			out.write(wrapper.getData());
			wrapper.setContentType("text/javascript;charset=UTF-8");
			out.close();
		}
	}

	@Override
	public void destroy() {
	}

}