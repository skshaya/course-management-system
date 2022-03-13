package com.system.dao;

import com.system.dto.MonthlyCourseReportDto;
import com.system.model.Rating;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ReportDao {

    private static Map<String, Integer> monthMap = new TreeMap<>();

    public ReportDao() {
        fillMonthMap();
    }

    public void fillMonthMap() {
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
    }

    public static List<MonthlyCourseReportDto> getAll(int month) {
        List<Rating> ratingList = RatingDao.getAllRating()
                .stream()
                .filter(rating -> rating.getMonth() == month)
                .collect(Collectors.toList());
        return getNormalizedData(ratingList);
    }

    private static List<MonthlyCourseReportDto> getNormalizedData(List<Rating> ratingList) {

        List<MonthlyCourseReportDto> monthlyCourseReportDtos = new ArrayList<>();
        Set<Integer> courseIds = ratingList.stream().map(Rating::getCourseId).collect(Collectors.toSet());
        for (Integer id : courseIds) {
            MonthlyCourseReportDto monthlyCourseReportDto = new MonthlyCourseReportDto();
            String courseName = CourseDao.findById(id).getName();
            IntSummaryStatistics summary = RatingDao.getAllRating()
                    .stream()
                    .filter(rating -> rating.getCourseId() == id)
                    .mapToInt(d -> d.getStar())
                    .summaryStatistics();
            monthlyCourseReportDto.setCourseName(courseName);
            monthlyCourseReportDto.setAverageRating((float) summary.getAverage());
            monthlyCourseReportDtos.add(monthlyCourseReportDto);
        }
        return monthlyCourseReportDtos;
    }

    public static Map<String, Integer> getMonthMap() {
        return monthMap;
    }
}
