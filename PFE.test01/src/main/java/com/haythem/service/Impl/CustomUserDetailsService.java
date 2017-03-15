package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.UserDao;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDAO;	

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		
		com.haythem.persistance.User domainUser = userDAO.findByUsernameLike(login);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(
				domainUser.getUsername(), 
				domainUser.getPassword(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked,
				getAuthorities(domainUser.getRoles().get(0).getId())
		);
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Long long1) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(long1));
		return authList;
	}
	
	public List<String> getRoles(Long long1) {

		List<String> roles = new ArrayList<String>();

		if (long1.intValue() == 1) {
			//roles.add("ROLE_MODERATOR");
			roles.add("ROLE_ADMIN");
		} else if (long1.intValue() == 2) {
			roles.add("ROLE_PATIENT");
		}else if (long1.intValue() == 3) {
			roles.add("ROLE_SUPERVISOR");
		}
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
