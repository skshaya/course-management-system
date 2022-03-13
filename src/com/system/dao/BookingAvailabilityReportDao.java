package com.system.dao;

import com.system.core.CoreReportRepository;
import com.system.dto.BookingAvailabilityDto;
import com.system.model.BookingAvailability;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookingAvailabilityReportDao implements CoreReportRepository {

    @Override
    public List<BookingAvailabilityDto> filterByDate(String Date) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDate().equals(Date)
                && availability.getAvailability() != 0)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByGroup(int groupId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getGroupId() == groupId
                && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByDivision(int divisionId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByCourse(int courseId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getCourseId() == courseId
                && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByDivisionAndGroup(int divisionId, int groupId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getGroupId() == groupId
                && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByDivisionAndCourse(int divisionId, int courseId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getCourseId() == courseId
                && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByDivisionAndGroupAndCourse(int divisionId, int groupId, int courseId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDivisionId() == divisionId
                && availability.getGroupId() == groupId
                && availability.getCourseId() == courseId
                && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    @Override
    public List<BookingAvailabilityDto> filterByAll(String Date, int divisionId, int groupId, int courseId) {
        List<BookingAvailability> bookingAvailabilitys = BookingAvailabilityDao
                .getAllBookingAvailabilityList()
                .stream()
                .filter(availability -> availability.getDate().equals(Date)
                && availability.getGroupId() == groupId
                && availability.getDivisionId() == divisionId
                && availability.getCourseId() == courseId && availability.getAvailability() != 0
                && availability.getDateAsObject().compareTo(availability.getCurrentDateAsObject()) != -1)
                .collect(Collectors.toList());
        return getNormalizedData(bookingAvailabilitys);
    }

    private List<BookingAvailabilityDto> getNormalizedData(List<BookingAvailability> bookingAvailabilitys) {
        List<BookingAvailabilityDto> bookingAvailabilityDtoList = new ArrayList<>();
        for (BookingAvailability bookingAvailability : bookingAvailabilitys) {
            BookingAvailabilityDto bookingAvailabilityDto = new BookingAvailabilityDto();

            int divisionId = bookingAvailability.getDivisionId();
            int groupId = bookingAvailability.getGroupId();
            int courseId = bookingAvailability.getCourseId();

            String divisionName = DivisionDao.findById(divisionId).getName();
            String groupName = GroupDao.findById(groupId).getName();
            String coursename = CourseDao.findById(courseId).getName();

            bookingAvailabilityDto.setDate(bookingAvailability.getDate());
            bookingAvailabilityDto.setDivisionName(divisionName);
            bookingAvailabilityDto.setGroupName(groupName);
            bookingAvailabilityDto.setCourseName(coursename);
            bookingAvailabilityDto.setAvailability(bookingAvailability.getAvailability());
            bookingAvailabilityDto.setAmount(CourseDao.findById(courseId).getFees());
            System.out.println(CourseDao.findById(courseId).getFees());
            bookingAvailabilityDtoList.add(bookingAvailabilityDto);
        }
        return bookingAvailabilityDtoList;
    }
}
