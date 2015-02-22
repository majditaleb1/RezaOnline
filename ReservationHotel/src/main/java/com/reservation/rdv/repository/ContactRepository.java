package com.reservation.rdv.repository;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.reservation.rdv.domain.Contact;



public interface ContactRepository extends CrudRepository<Contact,Long>{

	@Query("select c from Contact c left join fetch c.hobbies h where c.id = :id")
	public Contact findByIdWithDetail(@Param("id") Long id);
	
	@Query("select c from Contact c where c.contactName=:contactName")
	public Contact loadContactByContactName(@Param("contactName") String contactName);
	
	@Query("select count(*) from Contact c where c.contactName:=contactName")
	public boolean checkAvailable(@Param("contactName") String contactName);
}
