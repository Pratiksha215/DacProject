package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Issues;


public interface IIssuesDao extends JpaRepository<Issues, Integer>{
 //search by project name
	Optional<Issues> findByIssueId(Integer issueId );
}
