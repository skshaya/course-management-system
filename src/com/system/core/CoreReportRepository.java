package com.system.core;

import java.util.List;

public interface CoreReportRepository {

    public List<?> filterByDate(String Date);

    public List<?> filterByGroup(int groupId);

    public List<?> filterByDivision(int divisionId);

    public List<?> filterByCourse(int courseId);

    public List<?> filterByDivisionAndGroup(int divisionId, int groupId);
    
    public List<?> filterByDivisionAndCourse(int divisionId, int courseId);
    
    public List<?> filterByAll(String Date, int groupId, int divisionId, int courseId);
    
}
