package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/CharacterIncodingFilter")
public class CharacterIncodingFilter implements Filter {

	FilterConfig config;
	
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter) throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));	// config.getInitParameter("encoding") = "UTF-8" ¿Í µ¿ÀÏ
		nextFilter.doFilter(request,  response);
	}
	
	public void destroy() {
	}

}
