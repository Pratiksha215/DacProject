package com.app.pojos;


import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@SuppressWarnings("serial")
@Embeddable

@Entity
@Table(name="issues")
public class Issues implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer issueId;
	private String issueSummary;
	private String issueDescription;
	//private Integer identifiedBypersonId;//foreignKey
	@Column(name = "identifiedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "identifiedDate")
	private LocalDate identifiedDate;
	//private Integer relatedProjects;
	//private Integer assignedTo;
	 @Enumerated(EnumType.STRING)
	private issueStatus status;
	 @Enumerated(EnumType.STRING)
	private issuePriority priority;
	 @Enumerated(EnumType.STRING)
	private issueSeverity severity;
	@Column(name = "targetResolutionDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "targetResolutionDate")
	private LocalDate targetResolutionDate;
	private String progress;
	@Column(name = "actualResolutionDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "actual-resolution-date")
	private LocalDate actualResolutionDate;
	private String resolutionSummary;
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
	//private Integer personId;
	//private Integer projectId;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="personId",nullable = false)
	private People identifiedBypersonId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="projectId",nullable = false)
	private Projects relatedProjects;
	
	
	@ManyToOne
	@JoinColumn(name="personId",nullable=false,insertable=false,updatable=false)
	private People assignedtopeople;


	public Integer getIssueId() {
		return issueId;
	}


	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}


	public String getIssueSummary() {
		return issueSummary;
	}


	public void setIssueSummary(String issueSummary) {
		this.issueSummary = issueSummary;
	}


	public String getIssueDescription() {
		return issueDescription;
	}


	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}


	public LocalDate getIdentifiedDate() {
		return identifiedDate;
	}


	public void setIdentifiedDate(LocalDate identifiedDate) {
		this.identifiedDate = identifiedDate;
	}


	

	public issueStatus getStatus() {
		return status;
	}


	public void setStatus(issueStatus status) {
		this.status = status;
	}


	public issuePriority getPriority() {
		return priority;
	}


	public void setPriority(issuePriority priority) {
		this.priority = priority;
	}


	public issueSeverity getSeverity() {
		return severity;
	}


	public void setSeverity(issueSeverity severity) {
		this.severity = severity;
	}


	public LocalDate getTargetResolutionDate() {
		return targetResolutionDate;
	}


	public void setTargetResolutionDate(LocalDate targetResolutionDate) {
		this.targetResolutionDate = targetResolutionDate;
	}


	public String getProgress() {
		return progress;
	}


	public void setProgress(String progress) {
		this.progress = progress;
	}


	public LocalDate getActualResolutionDate() {
		return actualResolutionDate;
	}


	public void setActualResolutionDate(LocalDate actualResolutionDate) {
		this.actualResolutionDate = actualResolutionDate;
	}


	public String getResolutionSummary() {
		return resolutionSummary;
	}


	public void setResolutionSummary(String resolutionSummary) {
		this.resolutionSummary = resolutionSummary;
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


	public People getIdentifiedBypersonId() {
		return identifiedBypersonId;
	}


	public void setIdentifiedBypersonId(People identifiedBypersonId) {
		this.identifiedBypersonId = identifiedBypersonId;
	}


	public Projects getRelatedProjects() {
		return relatedProjects;
	}


	public void setRelatedProjects(Projects relatedProjects) {
		this.relatedProjects = relatedProjects;
	}


//	public Projects getAssignedtopeople() {
//		return assignedtopeople;
//	}
//
//
//	public void setAssignedtopeople(Projects assignedtopeople) {
//		this.assignedtopeople = assignedtopeople;
//	}


	@Override
	public String toString() {
		return "Issues [issueId=" + issueId + ", issueSummary=" + issueSummary + ", issueDescription="
				+ issueDescription + ", identifiedDate=" + identifiedDate + ", status="
				+ status + ", priority=" + priority + ", severity=" + severity + ", targetResolutionDate="
				+ targetResolutionDate + ", progress=" + progress + ", actualResolutionDate=" + actualResolutionDate
				+ ", resolutionSummary=" + resolutionSummary + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy + ", identifiedBypersonId="
				+ identifiedBypersonId + ", relatedProjects=" + relatedProjects + ", assignedtopeople="
				+ assignedtopeople + "]";
	}
}
	
	
	
	
		