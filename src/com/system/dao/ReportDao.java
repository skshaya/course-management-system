package com.system.dao;

import com.system.dto.MonthlyChampionCourseReportDto;
import com.system.dto.MonthlyCourseReportDto;
import com.system.model.Booking;
import com.system.model.Rating;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
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

    public static List<MonthlyCourseReportDto> generateMonthlyCourseReport(int month) {
        List<Rating> ratingList = RatingDao.getAllRating()
                .stream()
                .filter(rating -> rating.getMonth() == month)
                .collect(Collectors.toList());
        return getNormalizedDataForMonthlyCourseReport(ratingList);
    }

    public static List<MonthlyChampionCourseReportDto> generateMonthlyChampionCourseReport(int month) {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(rating -> rating.getMonth() == month)
                .collect(Collectors.toList());
        return getNormalizedDataForChampionReport(bookingList);
    }

    private static List<MonthlyChampionCourseReportDto> getNormalizedDataForChampionReport(List<Booking> bookingList) {
        List<MonthlyChampionCourseReportDto> monthlyChampionCourseReportDtoList = new ArrayList<>();
        Set<Integer> courseIds = bookingList.stream().map(Booking::getCourseId).collect(Collectors.toSet());
        courseIds.stream().map((Integer id) -> {
            MonthlyChampionCourseReportDto monthlyChampionCourseReportDto = new MonthlyChampionCourseReportDto();
            String courseName = CourseDao.findById(id).getName();
            DoubleSummaryStatistics summaryStatistics = BookingDao.getAllBookingList()
                    .stream()
                    .filter(booking -> booking.getCourseId() == id)
                    .mapToDouble(d -> d.getAmount())
                    .summaryStatistics();
            monthlyChampionCourseReportDto.setCourseName(courseName);
            monthlyChampionCourseReportDto.setStatistics(summaryStatistics);
            return monthlyChampionCourseReportDto;
        }).forEachOrdered((monthlyChampionCourseReportDto) -> {
            monthlyChampionCourseReportDtoList.add(monthlyChampionCourseReportDto);
        });
        Collections.sort(monthlyChampionCourseReportDtoList, (MonthlyChampionCourseReportDto o1, MonthlyChampionCourseReportDto o2) -> (int) (o2.getStatistics().getSum() - o1.getStatistics().getSum()));
        return monthlyChampionCourseReportDtoList;
    }

    public static Map<String, Integer> getMonthMap() {
        return monthMap;
    }

    private static List<MonthlyCourseReportDto> getNormalizedDataForMonthlyCourseReport(List<Rating> ratingList) {

        List<MonthlyCourseReportDto> monthlyCourseReportDtoList = new ArrayList<>();
        Set<Integer> courseIds = ratingList.stream().map(Rating::getCourseId).collect(Collectors.toSet());
        courseIds.stream().map((id) -> {
            MonthlyCourseReportDto monthlyCourseReportDto = new MonthlyCourseReportDto();
            String courseName = CourseDao.findById(id).getName();
            IntSummaryStatistics summaryStatistics = RatingDao.getAllRating()
                    .stream()
                    .filter(rating -> rating.getCourseId() == id)
                    .mapToInt(i -> i.getStar())
                    .summaryStatistics();
            monthlyCourseReportDto.setCourseName(courseName);
            monthlyCourseReportDto.setStatistics(summaryStatistics);
            return monthlyCourseReportDto;
        }).forEachOrdered((monthlyCourseReportDto) -> {
            monthlyCourseReportDtoList.add(monthlyCourseReportDto);
        });
        Collections.sort(monthlyCourseReportDtoList, (MonthlyCourseReportDto o1, MonthlyCourseReportDto o2) -> Double.compare(o2.getStatistics().getAverage(), o1.getStatistics().getAverage()));
        return monthlyCourseReportDtoList;
    }
}
