package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwtHelper.JwtUtil;
import com.spring.model.JwtRequest;
import com.spring.model.JwtResponse;
import com.spring.service.CustomUserDetailService;

@RestController
public class JwtController {
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/token", method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ) throws Exception{
		
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),jwtRequest.getPassword()));
			
		}catch (UsernameNotFoundException e) {
		e.printStackTrace();
		throw new Exception("Bad Credentaials");
		}
		
	UserDetails userDetails	=this.customUserDetailService.loadUserByUsername(jwtRequest.getUserName());
	String token=	this.jwtUtil.generateToken(userDetails);
	System.out.println("JWT :  " +token );
	
	//{"token:value"}
	return ResponseEntity.ok(new JwtResponse(token));
	
}
}
