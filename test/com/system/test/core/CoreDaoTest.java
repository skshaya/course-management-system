package com.system.test.core;

import com.system.dao.BookingAvailabilityDao;
import com.system.dao.BookingDao;
import com.system.dao.CourseDao;
import com.system.dao.DivisionDao;
import com.system.dao.GroupDao;
import com.system.dao.RatingDao;
import com.system.dao.StudentDao;
import com.system.dto.AuthDto;
import com.system.model.Booking;
import com.system.model.BookingAvailability;
import com.system.model.Rating;
import com.system.model.Student;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoreDaoTest {

    public static StudentDao studentDao = null;
    public static BookingAvailabilityDao bookingAvailabilityDao = null;
    public static DivisionDao divisionDao = null;
    public static GroupDao groupDao = null;
    public static CourseDao courseDao = null;
    public static BookingDao bookingDao = null;
    public static RatingDao ratingDao = null;

    public CoreDaoTest() {
    }

    @Before
    public void setUp() {
        studentDao = new StudentDao();
        bookingAvailabilityDao = new BookingAvailabilityDao();
        divisionDao = new DivisionDao();
        groupDao = new GroupDao();
        courseDao = new CourseDao();
        bookingDao = new BookingDao();
        ratingDao = new RatingDao();

        studentDao.getAll();
        bookingAvailabilityDao.getAll();
        divisionDao.getAll();
        groupDao.getAll();
        courseDao.getAll();
        bookingDao.getAll();
        ratingDao.getAll();

    }

    @Test
    public void testGetAll() {
        List<Student> studentList = studentDao.getAll();
        assertEquals(11, studentList.size());
        assertTrue(studentList.get(0) instanceof Student);
    }

    @Test
    public void testAuth() {
        AuthDto authDto = studentDao.authenticate("Ramesh", "1234");
        assertTrue(authDto.isIsAuthenticated());
    }

    @Test
    public void testInvalidAuth() {
        AuthDto authDto = StudentDao.authenticate("user", "1234");
        assertFalse(authDto.isIsAuthenticated());
    }

    @Test
    public void testGetAllBookingAvailabilityRecords() {
        List<BookingAvailability> bookingAvailabilitys = bookingAvailabilityDao.getAllBookingAvailabilityList();
        assertEquals(446, bookingAvailabilitys.size());
        assertTrue(bookingAvailabilitys.get(0) instanceof BookingAvailability);
    }

    @Test
    public void testGetAllBookingAvailabilityRecordByIdentifier() {
        BookingAvailability bookingAvailability = BookingAvailabilityDao.getOne("2022-04-02", 1, 1, 1);
        assertTrue(bookingAvailability instanceof BookingAvailability);
        assertEquals(bookingAvailability.getDate(), "2022-04-02");
        assertEquals(DivisionDao.findById(bookingAvailability.getDivisionId()).getName(), "Saturday");
        assertEquals(GroupDao.findById(bookingAvailability.getGroupId()).getName(), "Morning");
        assertEquals(CourseDao.findById(bookingAvailability.getCourseId()).getName(), "Yoha");
    }

    @Test
    public void testGetAllBooking() {
        List<Booking> booking = BookingDao.getAllBookingList();
        assertEquals(83, booking.size());
        assertTrue(booking.get(0) instanceof Booking);
    }

    @Test
    public void testBooking() {
        Booking booking = new Booking();
        booking.setId(BookingDao.getAllBookingList().size() + 1);
        booking.setStudentId(1);
        booking.setDivisionId(2);
        booking.setGroupId(3);
        booking.setCourseId(1);
        booking.setAmount(1000.00);
        booking.setDate("2022-02-06");
        booking.setMonth(2);
        booking.setStatus("Booked");
        booking.setDescription("Test");
        Booking result = bookingDao.save(booking);
        assertTrue(result instanceof Booking);
        assertEquals(84, BookingDao.getAllBookingList().size());
    }

    @Test
    public void testGetbookingById() {
        Booking booking = bookingDao.getOne(1);
        assertTrue(booking instanceof Booking);
        assertEquals("2022-01-01", booking.getDate());
        assertEquals(1000.00, booking.getAmount(), 0);
        assertEquals(DivisionDao.findById(booking.getDivisionId()).getName(), "Saturday");
        assertEquals(GroupDao.findById(booking.getGroupId()).getName(), "Morning");
        assertEquals(CourseDao.findById(booking.getCourseId()).getName(), "Yoha");
    }

    @Test
    public void testOverlapBooking() {
        Booking booking = bookingDao.getOne(1);
        booking.setCourseId(2);
        boolean result = BookingDao.checkOverlapBooking(booking);
        assertTrue(result);
    }

    @Test
    public void testGetAllRating() {
        List<Rating> ratingList = RatingDao.getAllRating();
        assertEquals(71, ratingList.size());
        assertTrue(ratingList.get(0) instanceof Rating);
    }
}
