package com.reservation.rdv.services;

import com.reservation.rdv.domain.Contact;



public interface UserAuthenticationProviderService {
	boolean processUserAuthentication(Contact contact);
}
