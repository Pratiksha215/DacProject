package com.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.dao.IPeopleDao;
import com.app.pojos.People;

@Controller
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IPeopleDao peopledao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		People people=peopledao.getByUsername(username);
		
		if (people!=null) {
			return new User(people.getPersonEmail(), people.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
