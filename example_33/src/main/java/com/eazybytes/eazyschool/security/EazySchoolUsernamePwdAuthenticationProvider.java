package com.eazybytes.eazyschool.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.model.Roles;
import com.eazybytes.eazyschool.repository.PersonRepository;

@Component
public class EazySchoolUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		Person dbPerson = personRepository.findByEmail(email);

		if (dbPerson != null && dbPerson.getPersonId() > 0 && passwordEncoder.matches(password, dbPerson.getPwd())) {
			return new UsernamePasswordAuthenticationToken(email, null,
					getGrantedAuthorities(dbPerson.getRoles()));
		}

		return null;
	}

	private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
