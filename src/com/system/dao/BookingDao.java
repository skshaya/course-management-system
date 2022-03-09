package com.system.dao;

import com.system.core.CoreRepository;
import com.system.model.Booking;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingDao implements CoreRepository {

    private static List<Booking> bookings = new ArrayList<>();

    @Override
    public List<?> getAll() {
        bookings = Stream.of(
                new Booking(1, 1, 1, 1, 1, 1000.00, "Booked", 1, "Desc"),
                new Booking(2, 1, 2, 1, 1, 1000.00, "Booked", 1, "Desc"),
                new Booking(3, 3, 1, 1, 1, 1000.00, "Booked", 1, "Desc"))
                .collect(Collectors.toList());
        return bookings;
    }

    @Override
    public Booking save(Object bookingObj) {
        Booking booking = new Booking();
        setToBooking((Booking) bookingObj, booking);
        bookings.add(booking);
        return booking;
    }

    @Override
    public Booking getOne(int id) {
         return BookingDao.bookings
                .stream()
                .filter(booking -> booking.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    @Override
    public Booking update(Object bookingObj) {
        Booking paramObject = (Booking) bookingObj;
        Booking booking = bookings.stream()
                .filter(bk -> bk.getId() == paramObject.getId())
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
        setToBooking(paramObject, booking);
        return booking;
    }

    @Override
    public void delete(int id) {
        bookings.removeIf(booking -> booking.getId() == id);
    }

    private void setToBooking(Booking bookingObj, Booking booking) {
        booking.setId(bookingObj.getId());
        booking.setStudentId(bookingObj.getStudentId());
        booking.setDivisionId(bookingObj.getDivisionId());
        booking.setGroupId(bookingObj.getGroupId());
        booking.setCourseId(bookingObj.getCourseId());
        booking.setAmount(bookingObj.getAmount());
        booking.setStatus(bookingObj.getStatus());
        booking.setPaymentMasterId(bookingObj.getPaymentMasterId());
        booking.setDescription(bookingObj.getDescription());
    }

    public static List<Booking> getAllBookingList() {
        return BookingDao.bookings;
    }
}
