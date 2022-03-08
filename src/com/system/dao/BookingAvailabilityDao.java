package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.model.BookingAvailability;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingAvailabilityDao extends CoreCollectionRepository {

    private static List<BookingAvailability> bookingAvailabilityList = new ArrayList<>();

    public BookingAvailabilityDao() {
        this.getAll();
    }

    @Override
    public int getTotal() {
        return bookingAvailabilityList.size();
    }

    @Override
    public List<BookingAvailability> getAll() {
        bookingAvailabilityList = Stream.of(
                new BookingAvailability("2022-03-05", 1, 1, 1, 4),
                new BookingAvailability("2022-03-06", 1, 1, 1, 4),
                new BookingAvailability("2022-03-12", 1, 1, 1, 4),
                new BookingAvailability("2022-03-13", 1, 1, 1, 4))
                .collect(Collectors.toList());
        return bookingAvailabilityList;
    }
    
    public static List<BookingAvailability> getAllBookingAvailabilityList()
    {
        return BookingAvailabilityDao.bookingAvailabilityList;
    }
}
  