package com.system.dao;

import com.system.core.CoreReportRepository;
import java.util.List;
import java.util.stream.Collectors;

public class BookingAvailabilityReportDao implements CoreReportRepository {

    @Override
    public List<?> filterByDate(String Date) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDate().equals(Date)
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<?> filterByGroup(int groupId) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getGroupId() == groupId
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<?> filterByDivision(int divisionId) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<?> filterByCourse(int courseId) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getCourseId() == courseId
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<?> filterByDivisionAndGroup(int divisionId, int groupId) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getGroupId() == groupId
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<?> filterByDivisionAndCourse(int divisionId, int courseId) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getCourseId() == courseId
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<?> filterByAll(String Date, int groupId, int divisionId, int courseId) {
        return BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDate().equals(divisionId)
                && availability.getGroupId() == groupId
                && availability.getDivisionId() == divisionId
                && availability.getCourseId() == courseId && availability.getAvailability() != 0)
                .collect(Collectors.toList());
    }
}
