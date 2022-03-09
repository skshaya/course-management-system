package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.core.CoreRepository;
import com.system.model.Course;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseDao extends CoreCollectionRepository implements CoreRepository {

    private static List<Course> courses = new ArrayList<>();

    @Override
    public List<?> getAll() {
        courses = Stream.of(
                new Course(1, "C0001", "Yoha", 1000.00, "Desc"),
                new Course(2, "C0002", "Zumba", 2000.00, "Desc"),
                new Course(3, "C0003", "Aquacise", 3000.00, "Desc"),
                new Course(4, "C0004", "Box Fit", 3500.00, "Desc"),
                new Course(5, "C0005", "Body Bliz", 4000.00, "Desc"))
                .collect(Collectors.toList());
        return courses;
    }

    @Override
    public Course save(Object courseObj) {
        Course course = new Course();
        setToCourse((Course) courseObj, course);
        courses.add(course);
        return course;
    }

    @Override
    public Course getOne(int id) {
        return findById(id);
    }

    @Override
    public Course update(Object coursePbje) {
        Course paramObject = (Course) coursePbje;
        Course course = courses.stream()
                .filter(cour -> cour.getId() == paramObject.getId())
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
        setToCourse(paramObject, course);
        return course;
    }

    @Override
    public void delete(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

    private void setToCourse(Course courseObj, Course course) {
        course.setId(courseObj.getId());
        course.setCode(courseObj.getCode());
        course.setName(courseObj.getName());
        course.setFees(courseObj.getFees());
        course.setDescription(courseObj.getDescription());
    }

    @Override
    public int getTotal() {
        return CourseDao.courses.size();
    }

    public static Course findById(int id) {
        return CourseDao.courses
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    public static List<Course> loadToComboBox() {
        return CourseDao.courses;
    }
}
