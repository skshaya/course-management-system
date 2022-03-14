package com.system.dto;

import java.util.IntSummaryStatistics;

public class MonthlyCourseReportDto {
    
    private String courseName;
    private IntSummaryStatistics  statistics;

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
     * @return the statistics
     */
    public IntSummaryStatistics getStatistics() {
        return statistics;
    }

    /**
     * @param statistics the statistics to set
     */
    public void setStatistics(IntSummaryStatistics statistics) {
        this.statistics = statistics;
    }
}
