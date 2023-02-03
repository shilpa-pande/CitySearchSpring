package com.citysearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citysearch.entities.AdminClassified;


public interface AdminClassifiedRepo extends JpaRepository<AdminClassified,Integer>{
	
	 @Query("SELECT a FROM AdminClassified a WHERE a.city LIKE %?1%" + " OR a.category LIKE %?1%")
	    public List<AdminClassified> search(String keyword);
}
