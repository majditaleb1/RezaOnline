package com.reservation.hotel.services.jpa;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import com.reservation.hotel.domain.Contact;
import com.reservation.hotel.services.UserAuthenticationProviderService;



public class UserAuthenticationProviderServiceImpl implements UserAuthenticationProviderService {

	private AuthenticationManager authenticationManager;
	/**
	 * process user authentication
	 * 
	 * 
	 */

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public boolean processUserAuthentication(Contact user) {
		try{ 
			Authentication request=new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
			Authentication result=authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			return true;
		}catch(AuthenticationException e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"I'am sorry"));
			return false;
			
		}
		
	}



}
