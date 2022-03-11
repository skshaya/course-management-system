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
                new Booking(1, 1, 1, 1, 1, 1000.00, "2022-03-12", "Booked", "Desc"),
                new Booking(2, 2, 2, 1, 1, 1000.00, "2022-03-13", "Booked", "Desc"),
                new Booking(3, 3, 2, 1, 2, 1000.00, "2022-03-13", "Booked", "Desc"))
                .collect(Collectors.toList());
        return bookings;
    }

    @Override
    public Booking save(Object bookingObj) {
        Booking booking = new Booking();
        setToBooking((Booking) bookingObj, booking);
        bookings.add(booking);
        BookingAvailabilityDao.updateBookingAvailabilityOnSaving(
                booking.getDate(),
                booking.getDivisionId(),
                booking.getGroupId(),
                booking.getCourseId());
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
        String oldDate = booking.getDate();
        int oldDivisionId = booking.getDivisionId();
        int oldGroupId = booking.getGroupId();
        int oldCourseId = booking.getCourseId();
        setToBooking(paramObject, booking);
        if (!oldDate.equals(booking.getDate())
                || oldDivisionId != booking.getDivisionId()
                || oldGroupId != booking.getGroupId()
                || oldCourseId != booking.getCourseId()) {

            BookingAvailabilityDao.updateBookingAvailabilityOnSaving(booking.getDate(),
                    booking.getDivisionId(),
                    booking.getGroupId(),
                    booking.getCourseId());

            BookingAvailabilityDao.updateBookingAvailabilityOnEditing(oldDate,
                    oldDivisionId,
                    oldGroupId,
                    oldCourseId);
        }
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
        booking.setDate(bookingObj.getDate());
        booking.setStatus(bookingObj.getStatus());
        booking.setDescription(bookingObj.getDescription());
    }

    public static List<Booking> getAllBookingList() {
        return BookingDao.bookings;
    }

    public static boolean checkOverlapBooking(Booking booking) {
        return bookings.stream()
                .filter(bk -> bk.getDate().equals(booking.getDate())
                && bk.getDivisionId() == booking.getDivisionId()
                && bk.getGroupId() == booking.getGroupId()
                && bk.getStudentId() == booking.getStudentId())
                .findFirst().isPresent();
    }

    public static boolean checkOverlapBookingWhenEditing(Booking booking) {
        return bookings.stream()
                .filter(bk -> bk.getDate().equals(booking.getDate())
                && bk.getDivisionId() == booking.getDivisionId()
                && bk.getGroupId() == booking.getGroupId()
                && bk.getStudentId() == booking.getStudentId()
                && bk.getId() != booking.getId())
                .findFirst().isPresent();
    }
}
