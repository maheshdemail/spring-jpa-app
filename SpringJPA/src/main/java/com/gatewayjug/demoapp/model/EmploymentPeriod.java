package com.gatewayjug.demoapp.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents the period of time an employee has worked for the company. A null
 * endDate indicates that the employee is current.
 * 
 */
@Embeddable
public class EmploymentPeriod {

	@Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar startDate;
    
	@Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar endDate;

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
    public void setStartDate(int year, int month, int day) {
    	Calendar date = Calendar.getInstance();
        date.set(year, month + 1, day);
        setStartDate(date);
    }
    
    public void setStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setStartDate(calendar);
    }

    public Calendar getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        setEndDate(calender);
    }
    
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(int year, int month, int day) {
        Calendar date = Calendar.getInstance();
        date.set(year, month + 1, day);
        setEndDate(date);
    }
}
