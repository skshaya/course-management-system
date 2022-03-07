/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dao;

import com.system.model.Student;

/**
 *
 * @author ASUS
 */
public class Hello {
    
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student(10, "S0004", "Test FirstName", "Test LastName", "Test Address", "0211239685", "1990-04-01", "desc");
        studentDao.save(student);
        System.out.println("Here..."+studentDao.students.size());
    }
    
}
