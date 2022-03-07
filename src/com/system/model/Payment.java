package com.system.model;

public class Payment {

    private int id;
    private int paymentMasterId;
    private double unitTotal;
    private int groubId;
    private int divisionId;
    private int courseId;

    public Payment() {
    }

    public Payment(int id, int paymentMasterId, double unitTotal, int groubId, int divisionId, int courseId) {
        this.id = id;
        this.paymentMasterId = paymentMasterId;
        this.unitTotal = unitTotal;
        this.groubId = groubId;
        this.divisionId = divisionId;
        this.courseId = courseId;
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
     * @return the unitTotal
     */
    public double getUnitTotal() {
        return unitTotal;
    }

    /**
     * @param unitTotal the unitTotal to set
     */
    public void setUnitTotal(double unitTotal) {
        this.unitTotal = unitTotal;
    }

    /**
     * @return the groubId
     */
    public int getGroubId() {
        return groubId;
    }

    /**
     * @param groubId the groubId to set
     */
    public void setGroubId(int groubId) {
        this.groubId = groubId;
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
}
