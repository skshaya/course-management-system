package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.dto.AuthDto;
import com.system.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentDao implements CoreCollectionRepository {

    private static List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAll() {
        students = Stream.of(
                new Student(1, "S0001", "Ramesh", "Ram", "Nallur", "0771234567", "1990-01-01", "Ramesh", "1234", "desc"),
                new Student(2, "S0002", "Kapputas", "Plane", "Colombo", "0778237267", "1993-06-23", "Kapputas", "1234d", "desc"),
                new Student(3, "S0003", "Linda", "Anderson", "Colombo", "0779630267", "1993-04-13", "Linda", "1234d", "desc"),
                new Student(4, "S0004", "Mike", "Tyson", "Tokyo", "0779283667", "1995-05-23", "Kapputas", "Tyson", "desc"),
                new Student(5, "S0005", "Cristiano", "London", "Nallur", "077367467", "1994-05-21", "Kapputas", "Cristiano", "desc"),
                new Student(6, "S0006", "Kumara", "Sangakara", "US", "0774174851", "1994-10-10", "Kapputas", "Sangakara", "desc"),
                new Student(7, "S0007", "Adlof", "Hitler", "France", "0776359741", "1993-09-02", "Kapputas", "Hitler", "desc"),
                new Student(8, "S0008", "Jonita", "Sam", "Jaffna", "0772541789", "1993-01-09", "Kapputas", "Jonita", "desc"),
                new Student(9, "S0009", "Pugazh", "Abi", "Kondavil", "0773620154", "1992-04-10", "Kapputas", "Pugazh", "desc"),
                new Student(10, "S0010", "Ajith", "AK", "India", "0779174563", "1993-12-19", "Ajith", "Ajith", "desc"))
                .collect(Collectors.toList());
        return students;
    }

    public static AuthDto authenticate(String username, String password) {
        AuthDto authDto = null;
        Optional<Student> student = students.stream()
                .filter(std -> std.getUsername().equals(username) && std.getPassword().equals(password))
                .findFirst();
        if (student.isPresent()) {
            authDto = new AuthDto(student.get(), true);
        } else {
            authDto = new AuthDto(new Student(), false);
        }
        return authDto;
    }
}
