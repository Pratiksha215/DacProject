package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@SuppressWarnings("serial")

@Entity
@Table(name="projects")
public class Projects implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	@Column(length = 30,unique = true)
	private String projectName;
	@Column(name = "startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "startDate")
	private LocalDate startDate;
	@Column(name = "targetEndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "targetEndDate")
	private LocalDate targetEndDate;
	@Column(name = "actualEndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "actualEndDate")
	private LocalDate actualEndDate;
	@Column(name = "createdOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "createdOn")
	private LocalDate createdOn;
	@Column(length = 30)
	private String createdBy;
	@Column(name = "modifiedOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "modifiedOn")
	private LocalDate modifiedOn;
	@Column(length = 30)
	private String modifiedBy;
	
	
	@OneToMany(mappedBy = "relatedProjects",cascade = CascadeType.ALL)
        private List<Issues> issues=new ArrayList<>();
	
	@OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL)
	private List<ProjectMapping> projectMappingId  = new ArrayList<>();

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getTargetEndDate() {
		return targetEndDate;
	}

	public void setTargetEndDate(LocalDate targetEndDate) {
		this.targetEndDate = targetEndDate;
	}

	public LocalDate getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(LocalDate actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<Issues> getIssues() {
		return issues;
	}

	public void setIssues(List<Issues> issues) {
		this.issues = issues;
	}

	public List<ProjectMapping> getProjectMappingId() {
		return projectMappingId;
	}

	public void setProjectMappingId(List<ProjectMapping> projectMappingId) {
		this.projectMappingId = projectMappingId;
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", targetEndDate=" + targetEndDate + ", actualEndDate=" + actualEndDate + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy + ", issues="
				+ issues + ", projectMappingId=" + projectMappingId + "]";
	}
	
}