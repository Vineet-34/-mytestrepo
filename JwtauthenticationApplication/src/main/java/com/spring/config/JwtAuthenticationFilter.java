package com.spring.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.jwtHelper.JwtUtil;
import com.spring.service.CustomUserDetailService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	/*
	 * @Override protected boolean shouldNotFilter(HttpServletRequest request)
	 * throws ServletException { String path = request.getRequestURI(); return
	 * path.contains("/token"); }
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
 		String requestTokenHeader=request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;
		//null and format
		String path = request.getRequestURI();
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")){
			
			jwtToken=requestTokenHeader.substring(7);
			
			try {
			username= this.jwtUtil.extractUsername(jwtToken);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			UserDetails userDetails=this.customUserDetailService.loadUserByUsername(username); 
			
			//security
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				 
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}else {
				System.out.println("Tooken is not valid");
			}
			
			filterChain.doFilter(request, response);
			
		}
		
		
		
	}

}
