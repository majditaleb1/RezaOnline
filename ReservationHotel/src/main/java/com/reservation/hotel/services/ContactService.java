package com.reservation.hotel.services;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import com.reservation.hotel.domain.Contact;



public interface ContactService {
public List<Contact> findAll();
public Contact findById(Long id);
public Contact save(Contact contact);
public Contact findByIdWithDetail(Long id);
boolean checkAvailable(AjaxBehaviorEvent event);
Contact loadContactByContactName(String contactName);


}
