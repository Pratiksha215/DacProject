package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")

@Entity
@Table(name = "people")
public class People implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personId")
	private Integer personId;
	@Column(length = 30)
	private String personName;
	@Column(length = 30)
	private String password;
	@Column(length = 30, unique = true)
	private String personEmail;
	@Enumerated(EnumType.STRING)
	private PersonRole role;
	private int assignedProjects;
	@Column(name = "createdOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "createdOn")
	private LocalDate createdOn;
	private String createdBy;
	@Column(name = "modifiedOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "modifiedOn")
	private LocalDate modifiedOn;
	private String modifiedBy;

//	@OneToMany(mappedBy = "identifiedBypersonId", cascade = CascadeType.ALL)
//	private List<Issues> issues = new ArrayList<>();

	@OneToMany(mappedBy = "assignedtopeople", cascade = CascadeType.ALL)
	private List<Issues> ownerOfIssue = new ArrayList<>();
	

	@OneToMany(mappedBy = "identifiedBypersonId", cascade = CascadeType.ALL)
	private List<Issues> issueId = new ArrayList<>();
	
	@OneToMany(mappedBy = "personId", cascade = CascadeType.ALL)
	private List<ProjectMapping> projectMappingId  = new ArrayList<>();

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public PersonRole getRole() {
		return role;
	}

	public void setRole(PersonRole role) {
		this.role = role;
	}

	public int getAssignedProjects() {
		return assignedProjects;
	}

	public void setAssignedProjects(int assignedProjects) {
		this.assignedProjects = assignedProjects;
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

	public List<Issues> getOwnerOfIssue() {
		return ownerOfIssue;
	}

	public void setOwnerOfIssue(List<Issues> ownerOfIssue) {
		this.ownerOfIssue = ownerOfIssue;
	}

	public List<Issues> getIssueId() {
		return issueId;
	}

	public void setIssueId(List<Issues> issueId) {
		this.issueId = issueId;
	}

	public List<ProjectMapping> getProjectMappingId() {
		return projectMappingId;
	}

	public void setProjectMappingId(List<ProjectMapping> projectMappingId) {
		this.projectMappingId = projectMappingId;
	}

	@Override
	public String toString() {
		return "People [personId=" + personId + ", personName=" + personName + ", password=" + password
				+ ", personEmail=" + personEmail + ", role=" + role + ", assignedProjects=" + assignedProjects
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn
				+ ", modifiedBy=" + modifiedBy + ", ownerOfIssue=" + ownerOfIssue + ", issueId=" + issueId
				+ ", projectMappingId=" + projectMappingId + "]";
	}

	

}
