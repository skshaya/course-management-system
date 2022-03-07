package com.system.dao;

import com.system.core.CoreRepository;
import com.system.model.Student;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentDao implements CoreRepository {

    private List<Student> students = new ArrayList<>();

    public StudentDao() {
        this.getAll();
    }

    @Override
    public List<Student> getAll() {
        students = Stream.of(
                new Student(1, "S0001", "Ramesh", "Ram", "Nallur", "0771234567", "1990-01-01", "desc"),
                new Student(2, "S0002", "Kapputas", "Plane", "Nallur", "0779234567", "1993-05-23", "desc"),
                new Student(3, "S0003", "Ajith", "AK", "Nallur", "0779233567", "1993-12-19", "desc"))
                .collect(Collectors.toList());
        return students;
    }

    @Override
    public Student save(Object studentObj) {
        Student student = new Student();
        setToStudent((Student) studentObj, student);
        students.add(student);
        return student;
    }

    @Override
    public Student getOne(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    @Override
    public Student update(Object studentObj) {
        Student paramObject = (Student) studentObj;
        Student student = students.stream()
                .filter(std -> std.getId() == paramObject.getId())
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
        setToStudent(paramObject, student);
        return student;
    }

    private void setToStudent(Student studentObj, Student student) {
        student.setId(studentObj.getId());
        student.setCode(studentObj.getCode());
        student.setFirstName(studentObj.getFirstName());
        student.setLastName(studentObj.getLastName());
        student.setAddress(studentObj.getAddress());
        student.setMobile(studentObj.getMobile());
        student.setDob(studentObj.getDob());
        student.setDescription(studentObj.getDescription());
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
    
    public int getStudentListCount()
    {
        return this.students.size();
    }
}
