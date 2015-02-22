package com.reservation.rdv.controllers;


import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.springframework.webflow.execution.RequestContext;

import com.reservation.rdv.domain.Contact;
import com.reservation.rdv.domain.Hobby;
import com.reservation.rdv.services.ContactService;
import com.reservation.rdv.services.HobbyService;
import com.reservation.rdv.web.view.ContactBean;
import com.reservation.rdv.web.view.ContactListBean;

@Component("contactController") 
public class ContactController { 
private static final Logger logger = LoggerFactory.getLogger(ContactController.class); 
@Autowired 
private ContactService contactService;
@Autowired
private HobbyService hobbyService;
public ContactListBean newContactListBean() { 
ContactListBean contactListBean = new ContactListBean(); 
contactListBean.setContacts(contactService.findAll()); 
return contactListBean; 
} 
public Contact showContact(RequestContext context){
	long id=context.getRequestScope().getLong("contactId");
	logger.info("selected contact id:{}", id);
	return contactService.findByIdWithDetail(id);
}

public ContactBean newContactBean(){
	logger.info("creating new contact");
	ContactBean contactBean=new ContactBean();
	Contact contact=new Contact();
	contactBean.setContact(contact);
	List<Hobby> hobbiesSource=new ArrayList<Hobby>();
	List<Hobby> hobbiesTarget=new ArrayList<Hobby>();
	for(Hobby hobby:hobbyService.findAll()){
		hobbiesSource.add(hobby);
	}
	DualListModel<Hobby> hobbies=new DualListModel<Hobby>(hobbiesSource, hobbiesTarget);
	contactBean.setHobbies(hobbies);
	return contactBean;
	
}
}