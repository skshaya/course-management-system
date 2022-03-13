package com.system.dao;

import com.system.dto.StudentBookingDto;
import com.system.model.Booking;
import com.system.utils.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentBookingHistoryDao {

    public static List<StudentBookingDto> getAll() {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(booking -> booking.getStudentId() == Constant.studentId)
                .collect(Collectors.toList());
        return getNormalizedData(bookingList);
    }

    public static List<StudentBookingDto> filterByDateAndStudentId(String date) {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(booking -> booking.getDate().equals(date)
                && booking.getStudentId() == Constant.studentId)
                .collect(Collectors.toList());
        return getNormalizedData(bookingList);
    }

    public static List<StudentBookingDto> filterByBookingId(int bookingId) {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(booking -> booking.getId() == bookingId
                && booking.getStudentId() == Constant.studentId)
                .collect(Collectors.toList());
        return getNormalizedData(bookingList);
    }

    private static List<StudentBookingDto> getNormalizedData(List<Booking> bookingList) {
        List<StudentBookingDto> studentBookingDtoList = new ArrayList<>();
        for (Booking booking : bookingList) {
            StudentBookingDto studentBookingDto = new StudentBookingDto();

            int divisionId = booking.getDivisionId();
            int groupId = booking.getGroupId();
            int courseId = booking.getCourseId();

            String divisionName = DivisionDao.findById(divisionId).getName();
            String groupName = GroupDao.findById(groupId).getName();
            String coursename = CourseDao.findById(courseId).getName();

            studentBookingDto.setId(booking.getId());
            studentBookingDto.setDivisionName(divisionName);
            studentBookingDto.setGroupName(groupName);
            studentBookingDto.setCourseName(coursename);
            studentBookingDto.setAmount(booking.getAmount());
            studentBookingDto.setDate(booking.getDate());
            studentBookingDto.setStatus(booking.getStatus());
            studentBookingDtoList.add(studentBookingDto);
        }
        return studentBookingDtoList;
    }
}
