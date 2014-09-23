package com.techidiocy.models.destination;

import java.util.Date;

import com.techidiocy.annotation.Relation;

@Relation(associatedSourceClass=com.techidiocy.models.source.Employment.class)
public class EmploymentDTO extends BaseDTO {
	
	private EmployerDTO employer;
	private Date startDate;
	private Date endDate;
	private long salary;
	private boolean current;
	
	public EmployerDTO getEmployer() {
		return employer;
	}
	public void setEmployer(EmployerDTO employer) {
		this.employer = employer;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
}
