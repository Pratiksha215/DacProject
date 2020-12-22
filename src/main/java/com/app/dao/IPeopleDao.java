package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.People;


public interface IPeopleDao extends JpaRepository<People, Integer>{
 //search by project name
	Optional<People> findByPersonName(String personName);
}
