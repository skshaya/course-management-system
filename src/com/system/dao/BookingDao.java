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
                new Booking(1, 1, 1, 1, 1, 1000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(2, 2, 1, 1, 1, 1000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(3, 3, 1, 1, 1, 1000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(4, 4, 1, 1, 1, 1000.00, "2022-01-01", 1, "Booked", "Desc"),
                
                new Booking(5, 5, 1, 1, 2, 2000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(6, 6, 1, 1, 2, 2000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(7, 7, 1, 1, 2, 2000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(8, 8, 1, 1, 2, 2000.00, "2022-01-01", 1, "Booked", "Desc"),
                
                new Booking(9, 9, 1, 1, 3, 3000.00, "2022-01-01", 1, "Booked", "Desc"),
                new Booking(10,10, 1, 1, 3, 3000.00, "2022-01-01", 1, "Booked", "Desc"),
                
                
                new Booking(11,1, 2, 2, 4, 4000.00, "2022-01-02", 1, "Booked", "Desc"),
                new Booking(12,2, 2, 2, 4, 4000.00, "2022-01-02", 1, "Booked", "Desc"),
                
                new Booking(13,4, 2, 3, 3, 3000.00, "2022-01-02", 1, "Booked", "Desc"),
                new Booking(14,5, 2, 3, 3, 3000.00, "2022-01-02", 1, "Booked", "Desc"),
                
                
                new Booking(15,5, 1, 2, 1, 1000.00, "2022-01-08", 1, "Booked", "Desc"),
                new Booking(16,6, 1, 2, 2, 2000.00, "2022-01-08", 1, "Booked", "Desc"),
                
                new Booking(17,8, 1, 2, 3, 3000.00, "2022-01-08", 1, "Booked", "Desc"),
                new Booking(18,10, 1, 2, 3, 3000.00, "2022-01-08", 1, "Booked", "Desc"),
                
                
                new Booking(19,1, 1, 3, 5, 5000.00, "2022-01-08", 1, "Booked", "Desc"),
                new Booking(20,2, 1, 3, 5, 5000.00, "2022-01-08", 1, "Booked", "Desc"),
                new Booking(21,3, 1, 3, 5, 5000.00, "2022-01-08", 1, "Booked", "Desc"),
                new Booking(22,4, 1, 3, 5, 5000.00, "2022-01-08", 1, "Booked", "Desc"),
                
                new Booking(23,6, 2, 1, 1, 1000.00, "2022-01-09", 1, "Booked", "Desc"),
                new Booking(24,9, 2, 1, 2, 2000.00, "2022-01-09", 1, "Booked", "Desc"),
                new Booking(25,5, 2, 1, 3, 3000.00, "2022-01-09", 1, "Booked", "Desc"),
                new Booking(26,1, 2, 1, 4, 4000.00, "2022-01-09", 1, "Booked", "Desc"),
                
                new Booking(27,2, 2, 3, 5, 5000.00, "2022-01-09", 1, "Booked", "Desc"),
                
                new Booking(28,1, 1, 1, 5, 5000.00, "2022-01-15", 1, "Booked", "Desc"),
                new Booking(29,2, 1, 1, 5, 5000.00, "2022-01-15", 1, "Booked", "Desc"),
                new Booking(30,3, 1, 1, 5, 5000.00, "2022-01-15", 1, "Booked", "Desc"),
                new Booking(31,4, 1, 1, 5, 5000.00, "2022-01-15", 1, "Booked", "Desc"),
                
                new Booking(32,5, 1, 3, 1, 1000.00, "2022-01-15", 1, "Booked", "Desc"),
                new Booking(33,6, 1, 3, 1, 1000.00, "2022-01-15", 1, "Booked", "Desc"),
                new Booking(34,7, 1, 3, 1, 1000.00, "2022-01-15", 1, "Booked", "Desc"),
                new Booking(35,8, 1, 3, 1, 1000.00, "2022-01-15", 1, "Booked", "Desc"),
                
                new Booking(36,2, 2, 2, 4, 4000.00, "2022-01-16", 1, "Booked", "Desc"),
                new Booking(37,9, 2, 2, 4, 4000.00, "2022-01-16", 1, "Booked", "Desc"),
                new Booking(38,10, 2, 2, 4, 4000.00, "2022-01-16", 1, "Booked", "Desc"),
                new Booking(39,1, 2, 2, 4, 4000.00, "2022-01-16", 1, "Booked", "Desc"),
                
                new Booking(40,1, 1, 1, 5, 5000.00, "2022-01-22", 1, "Booked", "Desc"),
                new Booking(41,10, 1, 1, 5, 5000.00, "2022-01-22", 1, "Booked", "Desc"),
                new Booking(42,5, 1, 1, 5, 5000.00, "2022-01-22", 1, "Booked", "Desc"),
                new Booking(43,4, 1, 1, 5, 5000.00, "2022-01-22", 1, "Booked", "Desc"),
                
                new Booking(44,2, 1, 3, 3, 3000.00, "2022-01-22", 1, "Booked", "Desc"),
                new Booking(45,3, 1, 3, 3, 3000.00, "2022-01-22", 1, "Booked", "Desc"),
                new Booking(46,7, 1, 3, 3, 3000.00, "2022-01-22", 1, "Booked", "Desc"),
                new Booking(47,9, 1, 3, 3, 3000.00, "2022-01-22", 1, "Booked", "Desc"),
                
                new Booking(48,1, 2, 3, 2, 2000.00, "2022-01-23", 1, "Booked", "Desc"),
                new Booking(49,2, 2, 3, 2, 2000.00, "2022-01-23", 1, "Booked", "Desc"),
                new Booking(50,5, 2, 3, 2, 2000.00, "2022-01-23", 1, "Booked", "Desc"),
                new Booking(51,7, 2, 3, 2, 2000.00, "2022-01-23", 1, "Booked", "Desc"),
                
                new Booking(52,5, 1, 3, 5, 5000.00, "2022-01-29", 1, "Booked", "Desc"),
                new Booking(53,6, 1, 3, 5, 5000.00, "2022-01-29", 1, "Booked", "Desc"),
                new Booking(54,10, 1, 3, 5, 5000.00, "2022-01-29", 1, "Booked", "Desc"),
                new Booking(55,9, 1, 3, 5, 5000.00, "2022-01-29", 1, "Booked", "Desc"),
                
                new Booking(56,2, 2, 2, 3, 3000.00, "2022-01-30", 1, "Booked", "Desc"),
                new Booking(57,7, 2, 2, 3, 3000.00, "2022-01-30", 1, "Booked", "Desc"),
                new Booking(58,3, 2, 2, 3, 3000.00, "2022-01-30", 1, "Booked", "Desc"),
                new Booking(59,8, 2, 2, 3, 3000.00, "2022-01-30", 1, "Booked", "Desc"),
                
                new Booking(60,1, 1, 1, 4, 4000.00, "2022-02-05", 2, "Booked", "Desc"),
                new Booking(61,9, 1, 1, 4, 4000.00, "2022-02-05", 2, "Booked", "Desc"),
                new Booking(62,10, 1, 1, 4, 4000.00, "2022-02-05", 2, "Booked", "Desc"),
                new Booking(63,5, 1, 1, 4, 4000.00, "2022-02-05", 2, "Booked", "Desc"),
                
                new Booking(64,2, 1, 3, 5, 5000.00, "2022-02-05", 2, "Booked", "Desc"),
                new Booking(65,3, 1, 3, 5, 5000.00, "2022-02-05", 2, "Booked", "Desc"),
                new Booking(66,6, 1, 3, 5, 5000.00, "2022-02-05", 2, "Booked", "Desc"),
                new Booking(67,8, 1, 3, 5, 5000.00, "2022-02-05", 2, "Booked", "Desc"),
                
                new Booking(68,1, 2, 1, 3, 3000.00, "2022-02-06", 2, "Booked", "Desc"),
                new Booking(69,9, 2, 1, 3, 3000.00, "2022-02-06", 2, "Booked", "Desc"),
                new Booking(70,10, 2, 1, 3, 3000.00, "2022-02-06", 2, "Booked", "Desc"),
                new Booking(71,4, 2, 1, 3, 3000.00, "2022-02-06", 2, "Booked", "Desc"))
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
        return findById(id);
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
        booking.setMonth(bookingObj.getMonth());
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
                && bk.getStudentId() == booking.getStudentId()
                && !bk.getStatus().equals(Constant.STATUS_CANCELLED))
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

    private static Booking findById(int id) {
        return BookingDao.bookings
                .stream()
                .filter(booking -> booking.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    public static void updateBookingStatus(int bookingId, String status) {
        Booking booking = findById(bookingId);
        booking.setStatus(status);
    }
}
