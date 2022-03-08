package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.core.CoreRepository;
import com.system.model.Student;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentDao extends CoreCollectionRepository implements CoreRepository {

    private List<Student> students = new ArrayList<>();

    public StudentDao() {
        this.getAll();
    }

    @Override
    public List<Student> getAll() {
        students = Stream.of(
                new Student(1, "S0001", "Ramesh", "Ram", "Nallur", "0771234567", "1990-01-01", "Ramesh", "1234", "desc"),
                new Student(2, "S0002", "Kapputas", "Plane", "Nallur", "0779234567", "1993-05-23", "Kapputas", "1234d", "desc"),
                new Student(3, "S0003", "Ajith", "AK", "Nallur", "0779233567", "1993-12-19", "Ajith", "1234d", "desc"))
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
        student.setUsername(studentObj.getUsername());
        student.setPassword(studentObj.getPassword());
        student.setDescription(studentObj.getDescription());
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    @Override
    public int getTotal() {
        return this.students.size();
    }
    
    public boolean authenticate(String username, String password)
    {
        return students.stream()
                .filter(student -> student.getUsername().equals(username) && student.getPassword().equals(password))
                .findFirst().isPresent();
    }
}
