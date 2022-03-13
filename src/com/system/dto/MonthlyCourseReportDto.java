package com.system.dto;

public class MonthlyCourseReportDto {

    private String courseName;
    private float averageRating;

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the averageRating
     */
    public float getAverageRating() {
        return averageRating;
    }

    /**
     * @param averageRating the averageRating to set
     */
    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }
}
