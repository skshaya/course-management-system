package com.system.dao;

import com.system.core.CoreRepository;
import com.system.model.Student;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentDao implements CoreRepository {

    public static List<Student> students = new ArrayList<>();
    
    public StudentDao(){
        this.getAll();
    }
    
    @Override
    public List<Student> getAll() {
        students =  Stream.of(
                new Student(1, "S0001", "Ramesh", "Ram", "Nallur", "0771234567", "1990-01-01", "desc"),
                new Student(2, "S0002", "Kapputas", "Plane", "Nallur", "0779234567", "1993-05-23", "desc"),
                new Student(3, "S0003", "Ajith", "AK", "Nallur", "0779233567", "1993-12-19", "desc"))
                .collect(Collectors.toList());
        return students;
    }
    
    public Student getOne(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Record Not Found"));
    }
    
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
    
     
    public void update(Student studentObj) {
        Student student = students.stream()
                .filter(std -> std.getId() == studentObj.getId())
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Record Not Found"));
        
    }
    
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        studentDao.delete(1);
        System.out.println(studentDao.students);
        System.out.println(studentDao.students.get(0).getCode());
        System.out.println(studentDao.students.get(1).getCode());


    }
 
}
