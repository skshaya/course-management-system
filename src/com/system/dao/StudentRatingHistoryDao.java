package com.system.dao;

import com.system.dto.StudentRatingDto;
import com.system.model.Booking;
import com.system.utils.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRatingHistoryDao {

    public static List<StudentRatingDto> getAll() {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(booking -> booking.getStudentId() == Constant.studentId
                && !booking.getStatus().equals(Constant.STATUS_CANCELLED))
                .collect(Collectors.toList());
        return getNormalizedData(bookingList);
    }

    public static List<StudentRatingDto> filterByDate(String date) {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(booking -> booking.getDate().equals(date) && booking.getStudentId() == Constant.studentId)
                .collect(Collectors.toList());
        return getNormalizedData(bookingList);
    }

    public static List<StudentRatingDto> filterByBookingId(int bookingId) {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(booking -> booking.getId() == bookingId && booking.getStudentId() == Constant.studentId)
                .collect(Collectors.toList());
        return getNormalizedData(bookingList);
    }

    private static List<StudentRatingDto> getNormalizedData(List<Booking> bookingList) {
        List<StudentRatingDto> studentRatingDtoList = new ArrayList<>();
        for (Booking booking : bookingList) {
            StudentRatingDto studentRatingDto = new StudentRatingDto();

            int bookingId = booking.getId();
            int divisionId = booking.getDivisionId();
            int groupId = booking.getGroupId();
            int courseId = booking.getCourseId();

            String divisionName = DivisionDao.findById(divisionId).getName();
            String groupName = GroupDao.findById(groupId).getName();
            String coursename = CourseDao.findById(courseId).getName();
            String star = RatingDao.checkBookingRated(bookingId)
                    ? Integer.toString(RatingDao.getRatingByBookingId(bookingId).getStar()) : "Review Needed";
            String comment = RatingDao.checkBookingRated(bookingId) ? RatingDao.getRatingByBookingId(bookingId).getDescription() : "";
            studentRatingDto.setBookingId(bookingId);
            studentRatingDto.setDate(booking.getDate());
            studentRatingDto.setDivisionName(divisionName);
            studentRatingDto.setGroupName(groupName);
            studentRatingDto.setCourseName(coursename);
            studentRatingDto.setAmount(booking.getAmount());
            studentRatingDto.setRating(star);
            studentRatingDto.setComment(comment);
            studentRatingDtoList.add(studentRatingDto);
        }
        return studentRatingDtoList;
    }
}
