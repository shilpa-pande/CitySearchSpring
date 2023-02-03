package com.citysearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citysearch.entities.CityUser;



public interface CityUserRepo extends JpaRepository<CityUser,Integer> {

	@Query(value = "select u from CityUser u where u.email = :email")
	public CityUser getUserByUserName(@Param("email") String email);
	
	

}
