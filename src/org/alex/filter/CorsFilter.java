package org.alex.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");
//		øÁ”ÚHeader
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		if(request.getMethod().equals("OPTIONS")) {
			response.setStatus(200);
			response.getWriter().write("OPTIONS returns OK");
		}
		filterChain.doFilter(request, response);
	}
	
}
