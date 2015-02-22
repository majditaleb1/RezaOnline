package com.reservation.rdv.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="hobby")
public class Hobby implements Serializable{
	private String hobbyId;
	private Set<Contact> contacts=new HashSet<Contact>();
	
	
	public Hobby() {
		
	}
	public Hobby(String hobbyId, Set<Contact> contacts) {
		super();
		hobbyId = hobbyId;
		this.contacts = contacts;
	}
	public Hobby(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	@Id
	@Column(name="Hobby_ID")
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hoobyId) {
		hobbyId = hoobyId;
	}
	
	@ManyToMany
	@JoinTable(name="contact_hobby_detail",joinColumns=@JoinColumn(name="Hobby_ID"), inverseJoinColumns=@JoinColumn(name="Contact_ID"))
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	

}
