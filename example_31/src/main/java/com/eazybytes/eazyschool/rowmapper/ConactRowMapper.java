package com.eazybytes.eazyschool.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.eazybytes.eazyschool.model.Contact;

public class ConactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new  Contact();
		contact.setContactId(rs.getInt("CONTACT_ID"));
		contact.setName(rs.getString("NAME"));
		contact.setEmail(rs.getString("EMAIL"));
		contact.setMobileNum(rs.getString("MOBILE_NUM"));
		contact.setMessage(rs.getString("MESSAGE"));
		contact.setStatus(rs.getString("STATUS"));
		contact.setSubject(rs.getString("SUBJECT"));
		contact.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		contact.setCreatedBy(rs.getString("CREATED_BY"));
		if(rs.getTimestamp("UPDATED_AT") != null) {
			contact.setUpdatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
			contact.setUpdatedBy(rs.getString("UPDATED_BY"));
		}
		return contact;
	}



}
