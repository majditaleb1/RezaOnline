package com.reservation.hotel.services;

import com.reservation.hotel.domain.Contact;



public interface UserAuthenticationProviderService {
	boolean processUserAuthentication(Contact contact);
}
