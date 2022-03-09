package com.system.dto;

import com.system.model.Student;

public class AuthDto {
    
    private Student student;
    private boolean isAuthenticated;

    public AuthDto() {
    }

    public AuthDto(Student student, boolean isAuthenticated) {
        this.student = student;
        this.isAuthenticated = isAuthenticated;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the isAuthenticated
     */
    public boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    /**
     * @param isAuthenticated the isAuthenticated to set
     */
    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}
