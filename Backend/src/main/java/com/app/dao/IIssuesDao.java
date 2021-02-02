package com.app.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Issues;
import com.app.pojos.issueSeverity;


@Repository
public interface IIssuesDao extends JpaRepository<Issues, Integer>{
 //search by project name
	Optional<Issues> findByIssueId(Integer issueId );
	
	
// @Query("select severity, count(*) from issues group by severity")
// Map<issueSeverity,Enum> getSeveritys();
	
	@Query("select severity, count(*) from Issues group by severity")
	 List<Object> getSeveritys();
	
//      @Query("select new com.app.dto.SeverityDTO(i.severity, count(*)) from Issues i group by i.severity")
//	 List<SeverityDTO>getSeverity();
	
//	@Query("select severity, count(*) from Issues group by severity")
//	 List<SeverityDTO> getSeverity();
     
      
      
     
 }
	
	

    
	
	
	

