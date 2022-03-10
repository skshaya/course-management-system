package com.system.test.student;

import com.google.gson.Gson;
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
    public void testSave() {
        Student result = studentDao.save(new Student(10, "S0004", "Test FirstName", "Test LastName", "Test Address", "0211239685", "1990-04-01", "user","admin","desc"));
        assertTrue(result instanceof Student);
        assertEquals(10, result.getId());
        assertEquals("S0004", result.getCode());
        assertEquals("Test FirstName", result.getFirstName());
        assertEquals("Test Address", result.getAddress());
        assertEquals(4, studentDao.getTotal());
    }

    @Test
    public void testGetOne() {
        Student result = studentDao.getOne(1);
        assertTrue(result instanceof Student);
        assertEquals(1, result.getId());
        assertNotNull(result);
        assertEquals("S0001", result.getCode());
        assertEquals("Ramesh", result.getFirstName());
        assertEquals("Nallur", result.getAddress());
    }

    @Test
    public void testUpdate() {
        Student result = studentDao.update(new Student(1, "S0001", "Updated", "Ram", "Nallur", "0771234567", "1990-01-01", "admin","admin","desc"));
        assertTrue(result instanceof Student);
        assertEquals(1, result.getId());
        assertEquals("S0001", result.getCode());
        assertNotEquals("Ramesh", result.getFirstName());
        assertEquals("Updated", result.getFirstName());
    }

    @Test
    public void testDelete() {
        studentDao.delete(3);
        assertEquals(2, studentDao.getTotal());
    }
    
     @Test
    public void testAuth() {
        AuthDto authDto = studentDao.authenticate("Ramesh","1234");
        assertTrue(authDto.isIsAuthenticated());
    }
    
     @Test
    public void testInvalidAuth() {
         AuthDto authDto = studentDao.authenticate("user","1234");
        assertFalse(authDto.isIsAuthenticated());
    }
}
