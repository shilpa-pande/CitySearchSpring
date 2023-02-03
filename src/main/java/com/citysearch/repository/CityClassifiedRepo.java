package com.citysearch.repository;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citysearch.entities.CityClassified;


public interface CityClassifiedRepo extends JpaRepository<CityClassified,Integer> {
	
	@Query("from CityClassified as c where c.cityuser.id=:cityuser_id")
	//currentpage
	//record per page->5
	public Page<CityClassified> findCityClassifiedByUser(@Param("cityuser_id") int cityuser_id, Pageable pageable);


	

}
