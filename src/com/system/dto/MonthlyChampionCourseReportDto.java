package com.system.dto;

import java.util.DoubleSummaryStatistics;

public class MonthlyChampionCourseReportDto {

    private String courseName;
    private DoubleSummaryStatistics statistics;

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
    public DoubleSummaryStatistics getStatistics() {
        return statistics;
    }

    /**
     * @param statistics the statistics to set
     */
    public void setStatistics(DoubleSummaryStatistics statistics) {
        this.statistics = statistics;
    }
}
