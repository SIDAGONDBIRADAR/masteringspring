package com.eazybytes.eazyschool.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Contact;

import jakarta.transaction.Transactional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	List<Contact> findByStatus(String status);
	
//	@Query("select c from Contact c where status= :status")
	@Query(value = "select * from contact_msg c where c.status=:status",nativeQuery = true)
	Page<Contact> findByStatus(String status,Pageable pageable);
	
	@Modifying
	@Transactional
	@Query("update Contact c set c.status=?1 where c.contactId=?2")
	int updateStatus(String status,int id);

}
