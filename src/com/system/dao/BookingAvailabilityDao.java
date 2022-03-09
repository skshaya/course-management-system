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
                new BookingAvailability("2022-03-05", 1, 1, 1, 4),
                new BookingAvailability("2022-03-06", 1, 1, 1, 4),
                new BookingAvailability("2022-03-12", 2, 1, 1, 4),
                new BookingAvailability("2022-03-13", 1, 1, 1, 4))
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
}
