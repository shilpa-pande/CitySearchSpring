package com.citysearch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.citysearch.entities.CityUser;
import com.citysearch.repository.CityUserRepo;



public class CityUserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private CityUserRepo cityuserRepo;
	

	// fetching user from database
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		CityUser cityuser=cityuserRepo.getUserByUserName(username);
		
		if(cityuser==null) {
			
			throw new UsernameNotFoundException("user 404");
		}
		return new CustomCityUserDetails(cityuser);
	}

}
