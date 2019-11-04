package com.ssm.service;

import com.ssm.entity.Student;

import java.util.List;

public interface StudentService {

    Student queryStudentByNo(int stuNo);
    void addStudent(Student student);

    List<Student> queryAllStudent();

    void updateStudentByStuNO(Student student);

    void deleteStudentByStuNo(Integer stuNo);
}
