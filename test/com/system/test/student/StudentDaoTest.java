package com.system.test.student;

import com.system.dao.StudentDao;
import com.system.dto.AuthDto;
import com.system.model.Student;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentDaoTest {

    public static StudentDao studentDao = null;

    public StudentDaoTest() {
    }

    @Before
    public void setUp() {
        studentDao = new StudentDao();
        studentDao.getAll();
    }

    @Test
    public void testGetAll() {
        List<Student> studentList = studentDao.getAll();
        assertEquals(3, studentList.size());
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
}
