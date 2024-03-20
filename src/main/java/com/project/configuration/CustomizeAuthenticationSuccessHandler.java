package com.project.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		boolean admin = false;
		boolean faculty = false;
		boolean user = false;
		
		System.out.println("AT onAuthenticationSuccess(...) function!");

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if ("ROLE_ADMIN".equals(auth.getAuthority())) {
				admin = true;
			}else if ("ROLE_STUDENT".equals(auth.getAuthority())) {
				user = true;
			}else if ("ROLE_FACULTY".equals(auth.getAuthority())) {
				faculty = true;
			}else {
				
			}
		}

		if (admin) {
			System.out.println("user is admin");
			response.sendRedirect("/admin/index");
		} else if(faculty) {
			System.out.println("user is faculty");
			response.sendRedirect("/faculty/index");
		}
		else if(user) {
			System.out.println("user is student");
			response.sendRedirect("/user/index");
		}else {
			System.out.println("user is anonymous");
			response.sendRedirect("/403");
		}
	}
}
