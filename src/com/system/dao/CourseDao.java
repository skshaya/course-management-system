package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.model.Course;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseDao implements CoreCollectionRepository {

    private static List<Course> courses = new ArrayList<>();

    @Override
    public List<?> getAll() {
        courses = Stream.of(
                new Course(1, "C0001", "Yoha", 1000.00, "Desc"),
                new Course(2, "C0002", "Zumba", 2000.00, "Desc"),
                new Course(3, "C0003", "Aquacise", 3000.00, "Desc"),
                new Course(4, "C0004", "Box Fit", 4000.00, "Desc"),
                new Course(5, "C0005", "Body Bliz", 5000.00, "Desc"))
                .collect(Collectors.toList());
        return courses;
    }

    public static Course findById(int id) {
        return CourseDao.courses
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    public static List<Course> findAll() {
        return CourseDao.courses;
    }

    public static Course getCourseByName(String name) {
        return CourseDao.courses
                .stream()
                .filter(course -> course.getName().equals(name))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }
}
