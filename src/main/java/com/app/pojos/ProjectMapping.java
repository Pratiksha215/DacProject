package com.app.pojos;


import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@SuppressWarnings("serial")
@Embeddable
@Entity
@Table(name="projectMapping")
public class ProjectMapping implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectMappingid;
	
	//private Integer personId;
	//private Integer projectId;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="personId",referencedColumnName="personId",nullable = false)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private People personId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="projectId",referencedColumnName="projectId",nullable = false)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Projects projectId;
	
	
	@Column(name = "startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "startDate")
	private LocalDate startDate;
	
	@Column(name = "endDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "endDate")
	private LocalDate endDate;

	public Integer getProjectMappingid() {
		return projectMappingid;
	}

	public void setProjectMappingid(Integer projectMappingid) {
		this.projectMappingid = projectMappingid;
	}

	public People getPersonId() {
		return personId;
	}

	public void setPersonId(People personId) {
		this.personId = personId;
	}

	public Projects getProjectId() {
		return projectId;
	}

	public void setProjectId(Projects projectId) {
		this.projectId = projectId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ProjectMapping [projectMappingid=" + projectMappingid + ", personId=" + personId + ", projectId="
				+ projectId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}

	