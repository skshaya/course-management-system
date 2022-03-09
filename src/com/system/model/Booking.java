package com.system.model;

public class Booking {
   
    private int id;
    private int studentId;
    private int divisionId;
    private int groupId;
    private int courseId;
    private double amount;
    private String status;
    private int paymentMasterId;
    private String description;

    public Booking() {
    }

    public Booking(int id, int studentId, int divisionId, int groupId, int courseId, double amount, String status, int paymentMasterId, String description) {
        this.id = id;
        this.studentId = studentId;
        this.divisionId = divisionId;
        this.groupId = groupId;
        this.courseId = courseId;
        this.amount = amount;
        this.status = status;
        this.paymentMasterId = paymentMasterId;
        this.description = description;
    } 

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the paymentMasterId
     */
    public int getPaymentMasterId() {
        return paymentMasterId;
    }

    /**
     * @param paymentMasterId the paymentMasterId to set
     */
    public void setPaymentMasterId(int paymentMasterId) {
        this.paymentMasterId = paymentMasterId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
