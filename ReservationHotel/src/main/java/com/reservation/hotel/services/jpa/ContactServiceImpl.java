package com.reservation.hotel.services.jpa;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.reservation.hotel.domain.Contact;
import com.reservation.hotel.repository.ContactRepository;
import com.reservation.hotel.services.ContactService;


@Service("ContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService, UserDetailsService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.findOne(id);
	}

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
		
	}

	

	@Override
	@Transactional(readOnly=true)
	public Contact findByIdWithDetail(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.findByIdWithDetail(id);
	}

	@Override
	public boolean checkAvailable(AjaxBehaviorEvent event) {
		InputText inputText = (InputText) event.getSource();
        String value = (String) inputText.getValue();
		boolean available=contactRepository.checkAvailable(value);
		if(!available){
			 FacesMessage message = constructErrorMessage(null, String.format(getMessageBundle().getString("userExistsMsg"), value));
             getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		else{
			FacesMessage message = constructInfoMessage(null, String.format(getMessageBundle().getString("userAvailableMsg"), value));
            getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		return available;
	}

	@Override
	public Contact loadContactByContactName(String contactName) {
	
		return contactRepository.loadContactByContactName(contactName);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		return null;
	}
	protected ResourceBundle getMessageBundle() {
		 return ResourceBundle.getBundle("message-labels");
	}

	private FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL,message,detail);
	}


	protected FacesContext getFacesContext() {
		// TODO Auto-generated method stub
		return FacesContext.getCurrentInstance();
	}


	protected FacesMessage constructErrorMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR,message,detail);
		
	}
	protected FacesMessage constructInfoMessage(String message, String detail) {
        return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
}

	

	

}
