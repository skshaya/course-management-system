package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.model.BookingAvailability;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingAvailabilityDao extends CoreCollectionRepository {

    private static List<BookingAvailability> bookingAvailabilityList = new ArrayList<>();

    @Override
    public int getTotal() {
        return bookingAvailabilityList.size();
    }

    @Override
    public List<BookingAvailability> getAll() {
        bookingAvailabilityList = Stream.of(
                // Saturday morning ...............2022-03-12..............
                new BookingAvailability("2022-03-12", 1, 1, 1, 3),
                new BookingAvailability("2022-03-12", 1, 1, 2, 4),
                new BookingAvailability("2022-03-12", 1, 1, 3, 4),
                new BookingAvailability("2022-03-12", 1, 1, 4, 4),
                new BookingAvailability("2022-03-12", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-03-12", 1, 2, 1, 4),
                new BookingAvailability("2022-03-12", 1, 2, 2, 4),
                new BookingAvailability("2022-03-12", 1, 2, 3, 4),
                new BookingAvailability("2022-03-12", 1, 2, 4, 4),
                new BookingAvailability("2022-03-12", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-03-12", 1, 3, 1, 4),
                new BookingAvailability("2022-03-12", 1, 3, 2, 4),
                new BookingAvailability("2022-03-12", 1, 3, 3, 4),
                new BookingAvailability("2022-03-12", 1, 3, 4, 4),
                new BookingAvailability("2022-03-12", 1, 3, 5, 4),
                //................... 2022-03-13 ...........................//
                // Sunday  morning 
                new BookingAvailability("2022-03-13", 2, 1, 1, 3),
                new BookingAvailability("2022-03-13", 2, 1, 2, 3),
                new BookingAvailability("2022-03-13", 2, 1, 3, 4),
                new BookingAvailability("2022-03-13", 2, 1, 4, 4),
                new BookingAvailability("2022-03-13", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-03-13", 2, 2, 1, 4),
                new BookingAvailability("2022-03-13", 2, 2, 2, 4),
                new BookingAvailability("2022-03-13", 2, 2, 3, 4),
                new BookingAvailability("2022-03-13", 2, 2, 4, 4),
                new BookingAvailability("2022-03-13", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-03-13", 2, 3, 1, 4),
                new BookingAvailability("2022-03-13", 2, 3, 2, 4),
                new BookingAvailability("2022-03-13", 2, 3, 3, 4),
                new BookingAvailability("2022-03-13", 2, 3, 4, 4),
                new BookingAvailability("2022-03-13", 2, 3, 5, 4))
                .collect(Collectors.toList());
        return bookingAvailabilityList;
    }

    public static BookingAvailability getOne(String date, int divisionId, int groupId, int courseId) {
        return BookingAvailabilityDao.bookingAvailabilityList
                .stream()
                .filter(availability -> availability.getDate().equals(date)
                && availability.getDivisionId() == divisionId
                && availability.getGroupId() == groupId
                && availability.getCourseId() == courseId)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    public static List<BookingAvailability> getAllBookingAvailabilityList() {
        return BookingAvailabilityDao.bookingAvailabilityList;
    }

    public static void updateBookingAvailabilityOnSaving(String date, int divisionId, int groupId, int courseId) {
        BookingAvailability availability = getOne(date, divisionId, groupId, courseId);
        availability.setAvailability(availability.getAvailability() - 1);
    }

    public static void updateBookingAvailabilityOnEditing(String date, int divisionId, int groupId, int courseId) {
        BookingAvailability availability = getOne(date, divisionId, groupId, courseId);
        availability.setAvailability(availability.getAvailability() + 1);
    }
}
