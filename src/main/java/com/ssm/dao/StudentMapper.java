package com.ssm.dao;

import com.ssm.entity.Student;

import java.util.List;

public interface StudentMapper {

     void addStudent(Student student	);

    Student queryStudentByStuno(int stuno);

    List<Student> queryAllStudent();

     void deleteStudentByStuno(int stuno);

     void updateStudentByStuno(Student student);

}
