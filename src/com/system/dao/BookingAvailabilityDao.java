package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.model.BookingAvailability;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingAvailabilityDao implements CoreCollectionRepository {

    private static List<BookingAvailability> bookingAvailabilityList = new ArrayList<>();

    @Override
    public List<BookingAvailability> getAll() {
        // adding mock values
        bookingAvailabilityList = Stream.of(
                // Saturday morning ...............2022-01-01..............
                new BookingAvailability("2022-01-01", 1, 1, 1, 0),
                new BookingAvailability("2022-01-01", 1, 1, 2, 0),
                new BookingAvailability("2022-01-01", 1, 1, 3, 2),
                new BookingAvailability("2022-01-01", 1, 1, 4, 4),
                new BookingAvailability("2022-01-01", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-01-01", 1, 2, 1, 4),
                new BookingAvailability("2022-01-01", 1, 2, 2, 4),
                new BookingAvailability("2022-01-01", 1, 2, 3, 4),
                new BookingAvailability("2022-01-01", 1, 2, 4, 4),
                new BookingAvailability("2022-01-01", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-01-01", 1, 3, 1, 4),
                new BookingAvailability("2022-01-01", 1, 3, 2, 4),
                new BookingAvailability("2022-01-01", 1, 3, 3, 4),
                new BookingAvailability("2022-01-01", 1, 3, 4, 4),
                new BookingAvailability("2022-01-01", 1, 3, 5, 4),
                
                
                // Sunday morning ...............2022-01-02..............
                new BookingAvailability("2022-01-02", 2, 1, 1, 4),
                new BookingAvailability("2022-01-02", 2, 1, 2, 4),
                new BookingAvailability("2022-01-02", 2, 1, 3, 4),
                new BookingAvailability("2022-01-02", 2, 1, 4, 4),
                new BookingAvailability("2022-01-02", 2, 1, 5, 4),
                // Sunday afternoon 
                new BookingAvailability("2022-01-02", 2, 2, 1, 4),
                new BookingAvailability("2022-01-02", 2, 2, 2, 4),
                new BookingAvailability("2022-01-02", 2, 2, 3, 4),
                new BookingAvailability("2022-01-02", 2, 2, 4, 2),
                new BookingAvailability("2022-01-02", 2, 2, 5, 4),
                // Sunday evening 
                new BookingAvailability("2022-01-02", 2, 3, 1, 4),
                new BookingAvailability("2022-01-02", 2, 3, 2, 4),
                new BookingAvailability("2022-01-02", 2, 3, 3, 2),
                new BookingAvailability("2022-01-02", 2, 3, 4, 4),
                new BookingAvailability("2022-01-02", 2, 3, 5, 4),
                //........................................................... WEEK 1//

                // Saturday morning ...............2022-01-08..............
                new BookingAvailability("2022-01-08", 1, 1, 1, 4),
                new BookingAvailability("2022-01-08", 1, 1, 2, 4),
                new BookingAvailability("2022-01-08", 1, 1, 3, 4),
                new BookingAvailability("2022-01-08", 1, 1, 4, 4),
                new BookingAvailability("2022-01-08", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-01-08", 1, 2, 1, 3),
                new BookingAvailability("2022-01-08", 1, 2, 2, 3),
                new BookingAvailability("2022-01-08", 1, 2, 3, 2),
                new BookingAvailability("2022-01-08", 1, 2, 4, 4),
                new BookingAvailability("2022-01-08", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-01-08", 1, 3, 1, 4),
                new BookingAvailability("2022-01-08", 1, 3, 2, 4),
                new BookingAvailability("2022-01-08", 1, 3, 3, 4),
                new BookingAvailability("2022-01-08", 1, 3, 4, 4),
                new BookingAvailability("2022-01-08", 1, 3, 5, 0),
                
                
                // Sunday morning ...............2022-01-09..............
                new BookingAvailability("2022-01-09", 2, 1, 1, 3),
                new BookingAvailability("2022-01-09", 2, 1, 2, 3),
                new BookingAvailability("2022-01-09", 2, 1, 3, 3),
                new BookingAvailability("2022-01-09", 2, 1, 4, 3),
                new BookingAvailability("2022-01-09", 2, 1, 5, 3),
                // Sunday afternoon 
                new BookingAvailability("2022-01-09", 2, 2, 1, 4),
                new BookingAvailability("2022-01-09", 2, 2, 2, 4),
                new BookingAvailability("2022-01-09", 2, 2, 3, 4),
                new BookingAvailability("2022-01-09", 2, 2, 4, 4),
                new BookingAvailability("2022-01-09", 2, 2, 5, 4),
                // Sunday evening 
                new BookingAvailability("2022-01-09", 2, 3, 1, 4),
                new BookingAvailability("2022-01-09", 2, 3, 2, 4),
                new BookingAvailability("2022-01-09", 2, 3, 3, 4),
                new BookingAvailability("2022-01-09", 2, 3, 4, 4),
                new BookingAvailability("2022-01-09", 2, 3, 5, 3),
                //........................................................... WEEK 2//

                // Saturday morning ...............2022-01-15..............
                new BookingAvailability("2022-01-15", 1, 1, 1, 4),
                new BookingAvailability("2022-01-15", 1, 1, 2, 4),
                new BookingAvailability("2022-01-15", 1, 1, 3, 4),
                new BookingAvailability("2022-01-15", 1, 1, 4, 4),
                new BookingAvailability("2022-01-15", 1, 1, 5, 0),
                // Saturday afternoon 
                new BookingAvailability("2022-01-15", 1, 2, 1, 4),
                new BookingAvailability("2022-01-15", 1, 2, 2, 4),
                new BookingAvailability("2022-01-15", 1, 2, 3, 4),
                new BookingAvailability("2022-01-15", 1, 2, 4, 4),
                new BookingAvailability("2022-01-15", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-01-15", 1, 3, 1, 0),
                new BookingAvailability("2022-01-15", 1, 3, 2, 4),
                new BookingAvailability("2022-01-15", 1, 3, 3, 4),
                new BookingAvailability("2022-01-15", 1, 3, 4, 4),
                new BookingAvailability("2022-01-15", 1, 3, 5, 4),
                
                
                // Sunday morning ...............2022-01-16..............
                new BookingAvailability("2022-01-16", 2, 1, 1, 4),
                new BookingAvailability("2022-01-16", 2, 1, 2, 4),
                new BookingAvailability("2022-01-16", 2, 1, 3, 4),
                new BookingAvailability("2022-01-16", 2, 1, 4, 4),
                new BookingAvailability("2022-01-16", 2, 1, 5, 4),
                // Sunday afternoon 
                new BookingAvailability("2022-01-16", 2, 2, 1, 4),
                new BookingAvailability("2022-01-16", 2, 2, 2, 4),
                new BookingAvailability("2022-01-16", 2, 2, 3, 4),
                new BookingAvailability("2022-01-16", 2, 2, 4, 0),
                new BookingAvailability("2022-01-16", 2, 2, 5, 4),
                // Sunday evening 
                new BookingAvailability("2022-01-16", 2, 3, 1, 4),
                new BookingAvailability("2022-01-16", 2, 3, 2, 4),
                new BookingAvailability("2022-01-16", 2, 3, 3, 4),
                new BookingAvailability("2022-01-16", 2, 3, 4, 4),
                new BookingAvailability("2022-01-16", 2, 3, 5, 4),
                //........................................................... WEEK 3//

                // Saturday morning ...............2022-01-22..............
                new BookingAvailability("2022-01-22", 1, 1, 1, 4),
                new BookingAvailability("2022-01-22", 1, 1, 2, 4),
                new BookingAvailability("2022-01-22", 1, 1, 3, 4),
                new BookingAvailability("2022-01-22", 1, 1, 4, 4),
                new BookingAvailability("2022-01-22", 1, 1, 5, 0),
                // Saturday afternoon 
                new BookingAvailability("2022-01-22", 1, 2, 1, 4),
                new BookingAvailability("2022-01-22", 1, 2, 2, 4),
                new BookingAvailability("2022-01-22", 1, 2, 3, 4),
                new BookingAvailability("2022-01-22", 1, 2, 4, 4),
                new BookingAvailability("2022-01-22", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-01-22", 1, 3, 1, 4),
                new BookingAvailability("2022-01-22", 1, 3, 2, 4),
                new BookingAvailability("2022-01-22", 1, 3, 3, 0),
                new BookingAvailability("2022-01-22", 1, 3, 4, 4),
                new BookingAvailability("2022-01-22", 1, 3, 5, 4),
                
                
                // Sunday morning ...............2022-01-23..............
                new BookingAvailability("2022-01-23", 2, 1, 1, 4),
                new BookingAvailability("2022-01-23", 2, 1, 2, 4),
                new BookingAvailability("2022-01-23", 2, 1, 3, 4),
                new BookingAvailability("2022-01-23", 2, 1, 4, 4),
                new BookingAvailability("2022-01-23", 2, 1, 5, 4),
                // Sunday afternoon 
                new BookingAvailability("2022-01-23", 2, 2, 1, 4),
                new BookingAvailability("2022-01-23", 2, 2, 2, 4),
                new BookingAvailability("2022-01-23", 2, 2, 3, 4),
                new BookingAvailability("2022-01-23", 2, 2, 4, 4),
                new BookingAvailability("2022-01-23", 2, 2, 5, 4),
                // Sunday evening 
                new BookingAvailability("2022-01-23", 2, 3, 1, 4),
                new BookingAvailability("2022-01-23", 2, 3, 2, 0),
                new BookingAvailability("2022-01-23", 2, 3, 3, 4),
                new BookingAvailability("2022-01-23", 2, 3, 4, 4),
                new BookingAvailability("2022-01-23", 2, 3, 5, 4),
                //........................................................... WEEK 4//

                // Saturday morning ...............2022-01-29..............
                new BookingAvailability("2022-01-29", 1, 1, 1, 4),
                new BookingAvailability("2022-01-29", 1, 1, 2, 4),
                new BookingAvailability("2022-01-29", 1, 1, 3, 4),
                new BookingAvailability("2022-01-29", 1, 1, 4, 4),
                new BookingAvailability("2022-01-29", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-01-29", 1, 2, 1, 4),
                new BookingAvailability("2022-01-29", 1, 2, 2, 4),
                new BookingAvailability("2022-01-29", 1, 2, 3, 4),
                new BookingAvailability("2022-01-29", 1, 2, 4, 4),
                new BookingAvailability("2022-01-29", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-01-29", 1, 3, 1, 4),
                new BookingAvailability("2022-01-29", 1, 3, 2, 4),
                new BookingAvailability("2022-01-29", 1, 3, 3, 4),
                new BookingAvailability("2022-01-29", 1, 3, 4, 4),
                new BookingAvailability("2022-01-29", 1, 3, 5, 0),
                
                
                // Sunday morning ...............2022-01-30..............
                new BookingAvailability("2022-01-30", 2, 1, 1, 4),
                new BookingAvailability("2022-01-30", 2, 1, 2, 4),
                new BookingAvailability("2022-01-30", 2, 1, 3, 4),
                new BookingAvailability("2022-01-30", 2, 1, 4, 4),
                new BookingAvailability("2022-01-30", 2, 1, 5, 4),
                // Sunday afternoon 
                new BookingAvailability("2022-01-30", 2, 2, 1, 4),
                new BookingAvailability("2022-01-30", 2, 2, 2, 4),
                new BookingAvailability("2022-01-30", 2, 2, 3, 0),
                new BookingAvailability("2022-01-30", 2, 2, 4, 4),
                new BookingAvailability("2022-01-30", 2, 2, 5, 4),
                // Sunday evening 
                new BookingAvailability("2022-01-30", 2, 3, 1, 4),
                new BookingAvailability("2022-01-30", 2, 3, 2, 4),
                new BookingAvailability("2022-01-30", 2, 3, 3, 4),
                new BookingAvailability("2022-01-30", 2, 3, 4, 4),
                new BookingAvailability("2022-01-30", 2, 3, 5, 4),
                
                //........................................................... WEEK 5//
                
                // Saturday morning ...............2022-02-05..............
                new BookingAvailability("2022-02-05", 1, 1, 1, 4),
                new BookingAvailability("2022-02-05", 1, 1, 2, 4),
                new BookingAvailability("2022-02-05", 1, 1, 3, 4),
                new BookingAvailability("2022-02-05", 1, 1, 4, 0),
                new BookingAvailability("2022-02-05", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-02-05", 1, 2, 1, 4),
                new BookingAvailability("2022-02-05", 1, 2, 2, 4),
                new BookingAvailability("2022-02-05", 1, 2, 3, 4),
                new BookingAvailability("2022-02-05", 1, 2, 4, 4),
                new BookingAvailability("2022-02-05", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-02-05", 1, 3, 2, 4),
                new BookingAvailability("2022-02-05", 1, 3, 3, 4),
                new BookingAvailability("2022-02-05", 1, 3, 4, 4),
                new BookingAvailability("2022-02-05", 1, 3, 5, 0),
                //................... 2022-02-06 ...........................//
                // Sunday  morning 
                new BookingAvailability("2022-02-06", 2, 1, 1, 4),
                new BookingAvailability("2022-02-06", 2, 1, 2, 4),
                new BookingAvailability("2022-02-06", 2, 1, 3, 0),
                new BookingAvailability("2022-02-06", 2, 1, 4, 4),
                new BookingAvailability("2022-02-06", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-02-06", 2, 2, 1, 4),
                new BookingAvailability("2022-02-06", 2, 2, 2, 4),
                new BookingAvailability("2022-02-06", 2, 2, 3, 4),
                new BookingAvailability("2022-02-06", 2, 2, 4, 4),
                new BookingAvailability("2022-02-06", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-02-06", 2, 3, 1, 4),
                new BookingAvailability("2022-02-06", 2, 3, 2, 4),
                new BookingAvailability("2022-02-06", 2, 3, 3, 4),
                new BookingAvailability("2022-02-06", 2, 3, 4, 4),
                new BookingAvailability("2022-02-06", 2, 3, 5, 4),
                
                //.................................................................WEEK 6//
                // Saturday morning ...............2022-04-05..............
                new BookingAvailability("2022-04-02", 1, 1, 1, 4),
                new BookingAvailability("2022-04-02", 1, 1, 2, 4),
                new BookingAvailability("2022-04-02", 1, 1, 3, 4),
                new BookingAvailability("2022-04-02", 1, 1, 4, 4),
                new BookingAvailability("2022-04-02", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-04-02", 1, 2, 1, 4),
                new BookingAvailability("2022-04-02", 1, 2, 2, 4),
                new BookingAvailability("2022-04-02", 1, 2, 3, 4),
                new BookingAvailability("2022-04-02", 1, 2, 4, 4),
                new BookingAvailability("2022-04-02", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-04-02", 1, 3, 2, 4),
                new BookingAvailability("2022-04-02", 1, 3, 3, 4),
                new BookingAvailability("2022-04-02", 1, 3, 4, 4),
                new BookingAvailability("2022-04-02", 1, 3, 5, 4),
                //................... 2022-04-03...........................//
                // Sunday  morning 
                new BookingAvailability("2022-04-03", 2, 1, 1, 4),
                new BookingAvailability("2022-04-03", 2, 1, 2, 4),
                new BookingAvailability("2022-04-03", 2, 1, 3, 4),
                new BookingAvailability("2022-04-03", 2, 1, 4, 4),
                new BookingAvailability("2022-04-03", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-04-03", 2, 2, 1, 4),
                new BookingAvailability("2022-04-03", 2, 2, 2, 4),
                new BookingAvailability("2022-04-03", 2, 2, 3, 4),
                new BookingAvailability("2022-04-03", 2, 2, 4, 4),
                new BookingAvailability("2022-04-03", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-04-03", 2, 3, 1, 4),
                new BookingAvailability("2022-04-03", 2, 3, 2, 4),
                new BookingAvailability("2022-04-03", 2, 3, 3, 4),
                new BookingAvailability("2022-04-03", 2, 3, 4, 4),
                new BookingAvailability("2022-04-03", 2, 3, 5, 4),
                
        //.................................................................WEEK 7//
        
         // Saturday morning ...............2022-04-09..............
                new BookingAvailability("2022-04-09", 1, 1, 1, 4),
                new BookingAvailability("2022-04-09", 1, 1, 2, 4),
                new BookingAvailability("2022-04-09", 1, 1, 3, 4),
                new BookingAvailability("2022-04-09", 1, 1, 4, 4),
                new BookingAvailability("2022-04-09", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-04-09", 1, 2, 1, 4),
                new BookingAvailability("2022-04-09", 1, 2, 2, 4),
                new BookingAvailability("2022-04-09", 1, 2, 3, 4),
                new BookingAvailability("2022-04-09", 1, 2, 4, 4),
                new BookingAvailability("2022-04-09", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-04-09", 1, 3, 2, 4),
                new BookingAvailability("2022-04-09", 1, 3, 3, 4),
                new BookingAvailability("2022-04-09", 1, 3, 4, 4),
                new BookingAvailability("2022-04-09", 1, 3, 5, 4),
                //................... 2022-04-10...........................//
                // Sunday  morning 
                new BookingAvailability("2022-04-10", 2, 1, 1, 4),
                new BookingAvailability("2022-04-10", 2, 1, 2, 4),
                new BookingAvailability("2022-04-10", 2, 1, 3, 4),
                new BookingAvailability("2022-04-10", 2, 1, 4, 4),
                new BookingAvailability("2022-04-10", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-04-10", 2, 2, 1, 4),
                new BookingAvailability("2022-04-10", 2, 2, 2, 4),
                new BookingAvailability("2022-04-10", 2, 2, 3, 4),
                new BookingAvailability("2022-04-10", 2, 2, 4, 4),
                new BookingAvailability("2022-04-10", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-04-10", 2, 3, 1, 4),
                new BookingAvailability("2022-04-10", 2, 3, 2, 4),
                new BookingAvailability("2022-04-10", 2, 3, 3, 4),
                new BookingAvailability("2022-04-10", 2, 3, 4, 4),
                new BookingAvailability("2022-04-10", 2, 3, 5, 4),
        
            //.................................................................WEEK 8//
                 // Saturday morning ...............2022-04-16..............
                new BookingAvailability("2022-04-16", 1, 1, 1, 4),
                new BookingAvailability("2022-04-16", 1, 1, 2, 4),
                new BookingAvailability("2022-04-16", 1, 1, 3, 4),
                new BookingAvailability("2022-04-16", 1, 1, 4, 4),
                new BookingAvailability("2022-04-16", 1, 1, 5, 4),
                // Saturday afternoon 
                new BookingAvailability("2022-04-16", 1, 2, 1, 4),
                new BookingAvailability("2022-04-16", 1, 2, 2, 4),
                new BookingAvailability("2022-04-16", 1, 2, 3, 4),
                new BookingAvailability("2022-04-16", 1, 2, 4, 4),
                new BookingAvailability("2022-04-16", 1, 2, 5, 4),
                // Saturday evening 
                new BookingAvailability("2022-04-16", 1, 3, 2, 4),
                new BookingAvailability("2022-04-16", 1, 3, 3, 4),
                new BookingAvailability("2022-04-16", 1, 3, 4, 4),
                new BookingAvailability("2022-04-16", 1, 3, 5, 4),
                //................... 2022-04-17...........................//
                // Sunday  morning 
                new BookingAvailability("2022-04-17", 2, 1, 1, 4),
                new BookingAvailability("2022-04-17", 2, 1, 2, 4),
                new BookingAvailability("2022-04-17", 2, 1, 3, 4),
                new BookingAvailability("2022-04-17", 2, 1, 4, 4),
                new BookingAvailability("2022-04-17", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-04-17", 2, 2, 1, 4),
                new BookingAvailability("2022-04-17", 2, 2, 2, 4),
                new BookingAvailability("2022-04-17", 2, 2, 3, 4),
                new BookingAvailability("2022-04-17", 2, 2, 4, 4),
                new BookingAvailability("2022-04-17", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-04-17", 2, 3, 1, 0),
                new BookingAvailability("2022-04-17", 2, 3, 2, 4),
                new BookingAvailability("2022-04-17", 2, 3, 3, 4),
                new BookingAvailability("2022-04-17", 2, 3, 4, 4),
                new BookingAvailability("2022-04-17", 2, 3, 5, 4),
                
                //.................................................................WEEK 9//
                //................... 2022-04-30...........................//
                // Saturday  morning 
                new BookingAvailability("2022-04-30", 1, 1, 1, 4),
                new BookingAvailability("2022-04-30", 1, 1, 2, 4),
                new BookingAvailability("2022-04-30", 1, 1, 3, 4),
                new BookingAvailability("2022-04-30", 1, 1, 4, 4),
                new BookingAvailability("2022-04-30", 1, 1, 5, 4),
                // Saturday  afternoon 
                new BookingAvailability("2022-04-30", 1, 2, 1, 4),
                new BookingAvailability("2022-04-30", 1, 2, 2, 4),
                new BookingAvailability("2022-04-30", 1, 2, 3, 4),
                new BookingAvailability("2022-04-30", 1, 2, 4, 4),
                new BookingAvailability("2022-04-30", 1, 2, 5, 4),
                // Saturday  evening 
                new BookingAvailability("2022-04-30", 1, 3, 1, 0),
                new BookingAvailability("2022-04-30", 1, 3, 2, 4),
                new BookingAvailability("2022-04-30", 1, 3, 3, 4),
                new BookingAvailability("2022-04-30", 1, 3, 4, 4),
                new BookingAvailability("2022-04-30", 1, 3, 5, 4),
                //................... 2022-05-01...........................//
                // Sunday  morning 
                new BookingAvailability("2022-05-01", 2, 1, 1, 4),
                new BookingAvailability("2022-05-01", 2, 1, 2, 4),
                new BookingAvailability("2022-05-01", 2, 1, 3, 4),
                new BookingAvailability("2022-05-01", 2, 1, 4, 4),
                new BookingAvailability("2022-05-01", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-05-01", 2, 2, 1, 4),
                new BookingAvailability("2022-05-01", 2, 2, 2, 4),
                new BookingAvailability("2022-05-01", 2, 2, 3, 4),
                new BookingAvailability("2022-05-01", 2, 2, 4, 4),
                new BookingAvailability("2022-05-01", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-05-01", 2, 3, 1, 0),
                new BookingAvailability("2022-05-01", 2, 3, 2, 4),
                new BookingAvailability("2022-05-01", 2, 3, 3, 4),
                new BookingAvailability("2022-05-01", 2, 3, 4, 4),
                new BookingAvailability("2022-05-01", 2, 3, 5, 4),
                
                //.................................................................WEEK 10//
//................... 2022-05-07...........................//
                // Saturday  morning 
                new BookingAvailability("2022-05-07", 1, 1, 1, 4),
                new BookingAvailability("2022-05-07", 1, 1, 2, 4),
                new BookingAvailability("2022-05-07", 1, 1, 3, 4),
                new BookingAvailability("2022-05-07", 1, 1, 4, 4),
                new BookingAvailability("2022-05-07", 1, 1, 5, 4),
                // Saturday  afternoon 
                new BookingAvailability("2022-05-07", 1, 2, 1, 4),
                new BookingAvailability("2022-05-07", 1, 2, 2, 4),
                new BookingAvailability("2022-05-07", 1, 2, 3, 4),
                new BookingAvailability("2022-05-07", 1, 2, 4, 4),
                new BookingAvailability("2022-05-07", 1, 2, 5, 4),
                // Saturday  evening 
                new BookingAvailability("2022-05-07", 1, 3, 1, 0),
                new BookingAvailability("2022-05-07", 1, 3, 2, 4),
                new BookingAvailability("2022-05-07", 1, 3, 3, 4),
                new BookingAvailability("2022-05-07", 1, 3, 4, 4),
                new BookingAvailability("2022-05-07", 1, 3, 5, 4),
                //................... 2022-05-08...........................//
                // Sunday  morning 
                new BookingAvailability("2022-05-08", 2, 1, 1, 4),
                new BookingAvailability("2022-05-08", 2, 1, 2, 4),
                new BookingAvailability("2022-05-08", 2, 1, 3, 4),
                new BookingAvailability("2022-05-08", 2, 1, 4, 4),
                new BookingAvailability("2022-05-08", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-05-08", 2, 2, 1, 4),
                new BookingAvailability("2022-05-08", 2, 2, 2, 4),
                new BookingAvailability("2022-05-08", 2, 2, 3, 4),
                new BookingAvailability("2022-05-08", 2, 2, 4, 4),
                new BookingAvailability("2022-05-08", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-05-08", 2, 3, 1, 0),
                new BookingAvailability("2022-05-08", 2, 3, 2, 4),
                new BookingAvailability("2022-05-08", 2, 3, 3, 4),
                new BookingAvailability("2022-05-08", 2, 3, 4, 4),
                new BookingAvailability("2022-05-08", 2, 3, 5, 4),
                
                //.................................................................WEEK 11//
//................... 2022-05-14...........................//
                // Saturday  morning 
                new BookingAvailability("2022-05-14", 1, 1, 1, 4),
                new BookingAvailability("2022-05-14", 1, 1, 2, 4),
                new BookingAvailability("2022-05-14", 1, 1, 3, 4),
                new BookingAvailability("2022-05-14", 1, 1, 4, 4),
                new BookingAvailability("2022-05-14", 1, 1, 5, 4),
                // Saturday  afternoon 
                new BookingAvailability("2022-05-14", 1, 2, 1, 4),
                new BookingAvailability("2022-05-14", 1, 2, 2, 4),
                new BookingAvailability("2022-05-14", 1, 2, 3, 4),
                new BookingAvailability("2022-05-14", 1, 2, 4, 4),
                new BookingAvailability("2022-05-14", 1, 2, 5, 4),
                // Saturday  evening 
                new BookingAvailability("2022-05-14", 1, 3, 1, 0),
                new BookingAvailability("2022-05-14", 1, 3, 2, 4),
                new BookingAvailability("2022-05-14", 1, 3, 3, 4),
                new BookingAvailability("2022-05-14", 1, 3, 4, 4),
                new BookingAvailability("2022-05-14", 1, 3, 5, 4),
                //................... 2022-05-15...........................//
                // Sunday  morning 
                new BookingAvailability("2022-05-15", 2, 1, 1, 4),
                new BookingAvailability("2022-05-15", 2, 1, 2, 4),
                new BookingAvailability("2022-05-15", 2, 1, 3, 4),
                new BookingAvailability("2022-05-15", 2, 1, 4, 4),
                new BookingAvailability("2022-05-15", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-05-15", 2, 2, 1, 4),
                new BookingAvailability("2022-05-15", 2, 2, 2, 4),
                new BookingAvailability("2022-05-15", 2, 2, 3, 4),
                new BookingAvailability("2022-05-15", 2, 2, 4, 4),
                new BookingAvailability("2022-05-15", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-05-15", 2, 3, 1, 0),
                new BookingAvailability("2022-05-15", 2, 3, 2, 4),
                new BookingAvailability("2022-05-15", 2, 3, 3, 4),
                new BookingAvailability("2022-05-15", 2, 3, 4, 4),
                new BookingAvailability("2022-05-15", 2, 3, 5, 4),
                
                //.................................................................WEEK 12//
//................... 2022-05-21...........................//
                // Saturday  morning 
                new BookingAvailability("2022-05-21", 1, 1, 1, 4),
                new BookingAvailability("2022-05-21", 1, 1, 2, 4),
                new BookingAvailability("2022-05-21", 1, 1, 3, 4),
                new BookingAvailability("2022-05-21", 1, 1, 4, 4),
                new BookingAvailability("2022-05-21", 1, 1, 5, 4),
                // Saturday  afternoon 
                new BookingAvailability("2022-05-21", 1, 2, 1, 4),
                new BookingAvailability("2022-05-21", 1, 2, 2, 4),
                new BookingAvailability("2022-05-21", 1, 2, 3, 4),
                new BookingAvailability("2022-05-21", 1, 2, 4, 4),
                new BookingAvailability("2022-05-21", 1, 2, 5, 4),
                // Saturday  evening 
                new BookingAvailability("2022-05-21", 1, 3, 1, 0),
                new BookingAvailability("2022-05-21", 1, 3, 2, 4),
                new BookingAvailability("2022-05-21", 1, 3, 3, 4),
                new BookingAvailability("2022-05-21", 1, 3, 4, 4),
                new BookingAvailability("2022-05-21", 1, 3, 5, 4),
                //................... 2022-05-22...........................//
                // Sunday  morning 
                new BookingAvailability("2022-05-22", 2, 1, 1, 4),
                new BookingAvailability("2022-05-22", 2, 1, 2, 4),
                new BookingAvailability("2022-05-22", 2, 1, 3, 4),
                new BookingAvailability("2022-05-22", 2, 1, 4, 4),
                new BookingAvailability("2022-05-22", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-05-22", 2, 2, 1, 4),
                new BookingAvailability("2022-05-22", 2, 2, 2, 4),
                new BookingAvailability("2022-05-22", 2, 2, 3, 4),
                new BookingAvailability("2022-05-22", 2, 2, 4, 4),
                new BookingAvailability("2022-05-22", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-05-22", 2, 3, 1, 0),
                new BookingAvailability("2022-05-22", 2, 3, 2, 4),
                new BookingAvailability("2022-05-22", 2, 3, 3, 4),
                new BookingAvailability("2022-05-22", 2, 3, 4, 4),
                new BookingAvailability("2022-05-22", 2, 3, 5, 4),
                
                //.................................................................WEEK 13//
//................... 2022-05-28...........................//
                // Saturday  morning 
                new BookingAvailability("2022-05-28", 1, 1, 1, 4),
                new BookingAvailability("2022-05-28", 1, 1, 2, 4),
                new BookingAvailability("2022-05-28", 1, 1, 3, 4),
                new BookingAvailability("2022-05-28", 1, 1, 4, 4),
                new BookingAvailability("2022-05-28", 1, 1, 5, 4),
                // Saturday  afternoon 
                new BookingAvailability("2022-05-28", 1, 2, 1, 4),
                new BookingAvailability("2022-05-28", 1, 2, 2, 4),
                new BookingAvailability("2022-05-28", 1, 2, 3, 4),
                new BookingAvailability("2022-05-28", 1, 2, 4, 4),
                new BookingAvailability("2022-05-28", 1, 2, 5, 4),
                // Saturday  evening 
                new BookingAvailability("2022-05-28", 1, 3, 1, 0),
                new BookingAvailability("2022-05-28", 1, 3, 2, 4),
                new BookingAvailability("2022-05-28", 1, 3, 3, 4),
                new BookingAvailability("2022-05-28", 1, 3, 4, 4),
                new BookingAvailability("2022-05-28", 1, 3, 5, 4),
                //................... 2022-05-29...........................//
                // Sunday  morning 
                new BookingAvailability("2022-05-29", 2, 1, 1, 4),
                new BookingAvailability("2022-05-29", 2, 1, 2, 4),
                new BookingAvailability("2022-05-29", 2, 1, 3, 4),
                new BookingAvailability("2022-05-29", 2, 1, 4, 4),
                new BookingAvailability("2022-05-29", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-05-29", 2, 2, 1, 4),
                new BookingAvailability("2022-05-29", 2, 2, 2, 4),
                new BookingAvailability("2022-05-29", 2, 2, 3, 4),
                new BookingAvailability("2022-05-29", 2, 2, 4, 4),
                new BookingAvailability("2022-05-29", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-05-29", 2, 3, 1, 0),
                new BookingAvailability("2022-05-29", 2, 3, 2, 4),
                new BookingAvailability("2022-05-29", 2, 3, 3, 4),
                new BookingAvailability("2022-05-29", 2, 3, 4, 4),
                new BookingAvailability("2022-05-29", 2, 3, 5, 4),
                
                //.................................................................WEEK 14//
//................... 2022-06-04...........................//
                // Saturday  morning 
                new BookingAvailability("2022-06-04", 1, 1, 1, 4),
                new BookingAvailability("2022-06-04", 1, 1, 2, 4),
                new BookingAvailability("2022-06-04", 1, 1, 3, 4),
                new BookingAvailability("2022-06-04", 1, 1, 4, 4),
                new BookingAvailability("2022-06-04", 1, 1, 5, 4),
                // Saturday  afternoon 
                new BookingAvailability("2022-06-04", 1, 2, 1, 4),
                new BookingAvailability("2022-06-04", 1, 2, 2, 4),
                new BookingAvailability("2022-06-04", 1, 2, 3, 4),
                new BookingAvailability("2022-06-04", 1, 2, 4, 4),
                new BookingAvailability("2022-06-04", 1, 2, 5, 4),
                // Saturday  evening 
                new BookingAvailability("2022-06-04", 1, 3, 1, 0),
                new BookingAvailability("2022-06-04", 1, 3, 2, 4),
                new BookingAvailability("2022-06-04", 1, 3, 3, 4),
                new BookingAvailability("2022-06-04", 1, 3, 4, 4),
                new BookingAvailability("2022-06-04", 1, 3, 5, 4),
                //................... 2022-06-05...........................//
                // Sunday  morning 
                new BookingAvailability("2022-06-05", 2, 1, 1, 4),
                new BookingAvailability("2022-06-05", 2, 1, 2, 4),
                new BookingAvailability("2022-06-05", 2, 1, 3, 4),
                new BookingAvailability("2022-06-05", 2, 1, 4, 4),
                new BookingAvailability("2022-06-05", 2, 1, 5, 4),
                // Sunday  afternoon 
                new BookingAvailability("2022-06-05", 2, 2, 1, 4),
                new BookingAvailability("2022-06-05", 2, 2, 2, 4),
                new BookingAvailability("2022-06-05", 2, 2, 3, 4),
                new BookingAvailability("2022-06-05", 2, 2, 4, 4),
                new BookingAvailability("2022-06-05", 2, 2, 5, 4),
                // Sunday  evening 
                new BookingAvailability("2022-06-05", 2, 3, 1, 0),
                new BookingAvailability("2022-06-05", 2, 3, 2, 4),
                new BookingAvailability("2022-06-05", 2, 3, 3, 4),
                new BookingAvailability("2022-06-05", 2, 3, 4, 4),
                new BookingAvailability("2022-06-05", 2, 3, 5, 4))
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

    public static boolean checkBookingAvailability(String date, int divisionId, int groupId, int courseId) {
        return BookingAvailabilityDao.bookingAvailabilityList
                .stream()
                .filter(availability -> availability.getDate().equals(date)
                && availability.getDivisionId() == divisionId
                && availability.getGroupId() == groupId
                && availability.getCourseId() == courseId
                && availability.getAvailability() == 0)
                .findFirst().isPresent();

    }
}
