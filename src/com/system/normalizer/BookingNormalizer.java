package com.system.normalizer;

import com.system.dao.BookingDao;
import com.system.dao.CourseDao;
import com.system.dao.DivisionDao;
import com.system.dao.GroupDao;
import com.system.dto.BookingDto;
import com.system.model.Booking;
import com.system.utils.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingNormalizer {

    public static List<BookingDto> normalize() {
        List<Booking> bookingList = BookingDao.getAllBookingList()
                .stream()
                .filter(bl -> bl.getStudentId() == Constant.studentId).collect(Collectors.toList());
        List<BookingDto> bookingDtoList = new ArrayList<>();

        for (Booking booking : bookingList) {
            BookingDto bookingDto = new BookingDto();
            int divisionId = booking.getDivisionId();
            int groupId = booking.getGroupId();
            int courseId = booking.getCourseId();

            String divisionName = DivisionDao.findById(divisionId).getName();
            String groupName = GroupDao.findById(groupId).getName();
            String coursename = CourseDao.findById(courseId).getName();

            bookingDto.setBookingId(booking.getId());
            bookingDto.setGroupName(groupName);
            bookingDto.setDivisionName(divisionName);
            bookingDto.setCourseName(coursename);
            bookingDto.setAmount(booking.getAmount());
            bookingDto.setStatus(booking.getStatus());
            bookingDtoList.add(bookingDto);
        }
        return bookingDtoList;
    }
}
