package com.system.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingAvailability {

    private String date;
    private int divisionId;
    private int groupId;
    private int courseId;
    private int availability;

    public BookingAvailability() {
    }

    public BookingAvailability(String date, int divisionId, int groupId, int courseId, int availability) {
        this.date = date;
        this.divisionId = divisionId;
        this.groupId = groupId;
        this.courseId = courseId;
        this.availability = availability;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the divisionId
     */
    public int getDivisionId() {
        return divisionId;
    }

    /**
     * @param divisionId the divisionId to set
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Date getDateAsObject() {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdformat.parse(this.date);
        } catch (ParseException ex) {
            Logger.getLogger(BookingAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    public Date getCurrentDateAsObject() {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdformat.format(new Date());
        Date date = null;
        try {
            date = sdformat.parse(currentDate);
        } catch (ParseException ex) {
            Logger.getLogger(BookingAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
