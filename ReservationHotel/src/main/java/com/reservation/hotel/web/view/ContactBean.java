package com.reservation.hotel.web.view;

import java.io.Serializable;

import org.primefaces.model.DualListModel;

import com.reservation.hotel.domain.Contact;
import com.reservation.hotel.domain.Hobby;

public class ContactBean implements Serializable {
private Contact contact;
private DualListModel<Hobby> hobbies;
public Contact getContact() {
	return contact;
}
public void setContact(Contact contact) {
	this.contact = contact;
}
public DualListModel<Hobby> getHobbies() {
	return hobbies;
}
public void setHobbies(DualListModel<Hobby> hobbies) {
	this.hobbies = hobbies;
}

}
