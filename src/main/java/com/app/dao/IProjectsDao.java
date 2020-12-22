package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Projects;

public interface IProjectsDao extends JpaRepository<Projects, Integer>{
 //search by project name
	Optional<Projects> findByProjectName(String projectName);
}
