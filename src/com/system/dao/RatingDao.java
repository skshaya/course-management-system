package com.system.dao;

import com.system.core.CoreRepository;
import com.system.model.Rating;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RatingDao implements CoreRepository {

    private static List<Rating> ratings = new ArrayList<>();

    @Override
    public List<?> getAll() {
        ratings = Stream.of(
                new Rating(1, 1, 1, 1, 5, 1, "2022-01-01", "Desc"),
                new Rating(2, 2, 2, 1, 4, 1, "2022-01-01", "Desc"),
                new Rating(3, 3, 3, 1, 4, 1, "2022-01-01", "Desc"),
                new Rating(4, 4, 4, 1, 4, 1, "2022-01-01", "Desc"),
                
                new Rating(5, 5, 5, 2, 5, 1, "2022-01-01", "Desc"),
                new Rating(6, 6, 6, 2, 4, 1, "2022-01-01", "Desc"),
                new Rating(7, 7, 7, 2, 3, 1, "2022-01-01", "Desc"),
                new Rating(8, 8, 8, 2, 2, 1, "2022-01-01", "Desc"),
                
                new Rating(9, 9, 9, 2, 3, 1, "2022-01-01", "Desc"),
                new Rating(10, 10, 10, 3, 4, 1, "2022-01-01", "Desc"),
                
                new Rating(11, 1, 11, 1, 3, 1, "2022-01-02", "Desc"),
                new Rating(12, 2, 12, 1, 3, 1, "2022-01-02", "Desc"),
                
                new Rating(13, 4, 13, 3, 4, 1, "2022-01-02", "Desc"),
                new Rating(14, 5, 14, 3, 5, 1, "2022-01-02", "Desc"),
                
                new Rating(15, 5, 15, 1, 5, 1, "2022-01-08", "Desc"),
                new Rating(16, 6, 16, 2, 5, 1, "2022-01-08", "Desc"),
                
                new Rating(17, 8, 17, 3, 1, 1, "2022-01-08", "Desc"),
                new Rating(18, 10, 18, 3, 2, 1, "2022-01-08", "Desc"),
                
                new Rating(19, 1, 19, 5, 4, 1, "2022-01-08", "Desc"),
                new Rating(20, 2, 20, 5, 4, 1, "2022-01-08", "Desc"),           
                new Rating(21, 3,21, 5, 5, 1, "2022-01-08", "Desc"),
                new Rating(22, 4, 22, 5, 4, 1, "2022-01-08", "Desc"),
                
                new Rating(23, 6, 23, 1, 3, 1, "2022-01-09", "Desc"),
                new Rating(24, 9, 24, 2, 3, 1, "2022-01-09", "Desc"),
                new Rating(25, 5, 25, 3, 4, 1, "2022-01-09", "Desc"),
                new Rating(26, 1, 26, 4, 1, 1, "2022-01-09", "Desc"),
                
                new Rating(27, 2, 27, 5, 5, 1, "2022-01-09", "Desc"),
                
                new Rating(28, 1, 28, 5, 4, 1, "2022-01-15", "Desc"),
                new Rating(29, 2, 29, 5, 4, 1, "2022-01-15", "Desc"),
                new Rating(30, 3, 30, 5, 4, 1, "2022-01-15", "Desc"),
                new Rating(31, 4, 31, 5, 3, 1, "2022-01-15", "Desc"),
                
                new Rating(32, 5, 32, 1, 4, 1, "2022-01-15", "Desc"),            
                new Rating(33, 6, 33, 1, 4, 1, "2022-01-15", "Desc"),
                new Rating(34, 7, 34, 1, 4, 1, "2022-01-15", "Desc"),
                new Rating(35, 8, 35, 1, 5, 1, "2022-01-15", "Desc"),
                
                new Rating(36, 2, 36, 4, 4, 1, "2022-01-16", "Desc"),
                new Rating(37, 9, 37, 4, 2, 1, "2022-01-16", "Desc"),
                new Rating(38, 10, 38, 4, 2, 1, "2022-01-16", "Desc"),
                new Rating(39, 1, 39, 4, 4, 1, "2022-01-16", "Desc"),
                
                new Rating(40, 1, 40, 5, 4, 1, "2022-01-22", "Desc"),               
                new Rating(41, 10, 41, 5, 5, 1, "2022-01-22", "Desc"),
                new Rating(42, 5, 42, 5, 4, 1, "2022-01-22", "Desc"),
                new Rating(43, 4, 43, 5, 4, 1, "2022-01-22", "Desc"),
                
                new Rating(44, 2, 44, 3, 5, 1, "2022-01-22", "Desc"),
                new Rating(45, 3, 45, 3, 4, 1, "2022-01-22", "Desc"),
                new Rating(46, 7, 46, 3, 4, 1, "2022-01-22", "Desc"),
                new Rating(47, 9, 47, 3, 4, 1, "2022-01-22", "Desc"),
                
                new Rating(48, 1, 48, 2, 4, 1, "2022-01-23", "Desc"),
                new Rating(49, 2, 49, 2, 5, 1, "2022-01-23", "Desc"),
                new Rating(50, 5, 50, 2, 4, 1, "2022-01-23", "Desc"),             
                new Rating(51, 7, 51, 2, 5, 1, "2022-01-23", "Desc"),
                
                new Rating(52, 5, 52, 5, 5, 1, "2022-01-29", "Desc"),
                new Rating(53, 6, 53, 5, 4, 1, "2022-01-29", "Desc"),
                new Rating(54, 10, 54, 5, 4, 1, "2022-01-29", "Desc"),
                new Rating(55, 9, 55, 5, 5, 1, "2022-01-29", "Desc"),
                
                new Rating(56, 2, 56, 3, 1, 1, "2022-01-30", "Desc"),
                new Rating(57, 7, 57, 3, 2, 1, "2022-01-30", "Desc"),
                new Rating(58, 3, 58, 3, 3, 1, "2022-01-30", "Desc"),
                new Rating(59, 8, 59, 3, 3, 1, "2022-01-30", "Desc"),
                
                new Rating(60, 1, 60, 4, 4, 2, "2022-02-05", "Desc"),           
                new Rating(61, 9, 61, 4, 5, 2, "2022-02-05", "Desc"),
                new Rating(62, 10, 62, 4, 4, 2, "2022-02-05", "Desc"),
                new Rating(63, 5, 63, 4, 4, 2, "2022-02-05", "Desc"),
                
                new Rating(64, 2, 64, 5, 4, 2, "2022-02-05", "Desc"),
                new Rating(65, 3, 65, 5, 4, 2, "2022-02-05", "Desc"),
                new Rating(66, 6, 66, 5, 4, 2, "2022-02-05", "Desc"),
                new Rating(67, 8, 67, 5, 4, 2, "2022-02-05", "Desc"),
                
                new Rating(68, 1, 68, 3, 5, 2, "2022-02-06", "Desc"),
                new Rating(69, 9, 69, 3, 5, 2, "2022-02-06", "Desc"),
                new Rating(70, 10, 70, 3, 5, 2, "2022-02-06", "Desc"),
                new Rating(71, 4, 71, 3, 4, 2, "2022-02-06", "Desc"))
                .collect(Collectors.toList());
        return ratings;
    }

    @Override
    public Rating save(Object ratingObj) {
        Rating rating = new Rating();
        setToRating((Rating) ratingObj, rating);
        ratings.add(rating);
        return rating;
    }

    @Override
    public Rating getOne(int id) {
        return ratings.stream()
                .filter(rate -> rate.getId() == id && rate.getStudentId() == Constant.studentId)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    @Override
    public Rating update(Object ratingObj) {
        Rating paramObject = (Rating) ratingObj;
        Rating rating = ratings.stream()
                .filter(rate -> rate.getId() == paramObject.getId() && rate.getStudentId() == Constant.studentId)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
        setToRating(paramObject, rating);
        return rating;
    }

    @Override
    public void delete(int id) {
        ratings.removeIf(course -> course.getId() == id);
    }

    private void setToRating(Rating ratingObj, Rating rating) {
        rating.setId(ratingObj.getId());
        rating.setStudentId(ratingObj.getStudentId());
        rating.setBookingId(ratingObj.getBookingId());
        rating.setCourseId(ratingObj.getCourseId());
        rating.setMonth(ratingObj.getMonth());
        rating.setDate(ratingObj.getDate());
        rating.setStar(ratingObj.getStar());
        rating.setDescription(ratingObj.getDescription());
    }

    public static List<Rating> getAllRating() {
        return ratings;
    }

    public static boolean checkBookingRated(int bookingId) {
        return ratings.stream()
                .filter(rate -> rate.getBookingId() == bookingId && rate.getStudentId() == Constant.studentId)
                .findFirst().isPresent();
    }

    public static Rating getRatingByBookingId(int bookingId) {
        return ratings.stream()
                .filter(rate -> rate.getBookingId() == bookingId && rate.getStudentId() == Constant.studentId)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }
}
