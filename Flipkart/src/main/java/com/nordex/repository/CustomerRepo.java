package com.nordex.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nordex.model.Customer;


	

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	/*
	 * @Query("select e from Customer e where e.name=:name") List<Customer>
	 * getCustByName(@Param("name") String name);
	 */

}

