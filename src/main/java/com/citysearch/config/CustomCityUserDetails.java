package com.citysearch.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.citysearch.entities.CityUser;

public class CustomCityUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 7259985727812852235L;
	private CityUser cityuser;
	
	public CustomCityUserDetails(CityUser cityuser) {
		super();
		this.cityuser = cityuser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(cityuser.getRole());
		
		return List.of(simpleGrantedAuthority) ;
	}

	@Override
	public String getPassword() {
		
		return cityuser.getPassword();
	}

	@Override
	public String getUsername() {
		
		return cityuser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	

}
