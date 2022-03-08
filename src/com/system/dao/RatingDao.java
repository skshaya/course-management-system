package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.core.CoreRepository;
import com.system.model.Rating;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RatingDao extends CoreCollectionRepository implements CoreRepository {

    private List<Rating> ratings = new ArrayList<>();

    public RatingDao() {
        this.getAll();
    }

    @Override
    public List<?> getAll() {
        ratings = Stream.of(
                new Rating(1, 1, 1, 4, "2022-01-01", "Desc"),
                new Rating(2, 1, 1, 5, "2022-02-01", "Desc"),
                new Rating(3, 1, 1, 5, "2022-03-01", "Desc"))
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
        rating.setDate(ratingObj.getDate());
        rating.setStar(ratingObj.getStar());
        rating.setDescription(ratingObj.getDescription());
    }

    @Override
    public int getTotal() {
       return this.ratings.size();
    }
}
