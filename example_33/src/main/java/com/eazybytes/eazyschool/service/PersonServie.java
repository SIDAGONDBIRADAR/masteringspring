package com.eazybytes.eazyschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.model.Roles;
import com.eazybytes.eazyschool.repository.PersonRepository;
import com.eazybytes.eazyschool.repository.RolesRepository;

@Service
public class PersonServie {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public boolean createUser(Person person) {

		boolean isSaved = false;
		Roles studentRole = rolesRepository.findByRoleName(EazySchoolConstants.STUDENT_ROLE);
		person.setRoles(studentRole);
		person.setPwd(passwordEncoder.encode(person.getPwd()));
		Person savedPerson = personRepository.save(person);
		if (savedPerson != null && savedPerson.getPersonId() > 0) {
			isSaved = true;
		}

		return isSaved;
	}

}
