package com.ssm.service.impl;

import com.ssm.dao.StudentMapper;
import com.ssm.entity.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

   // public void setStudentMapper(StudentMapper studentMapper){
    //    this.studentMapper=studentMapper;
    //}

    @Override
    public Student queryStudentByNo(int stuNo) {
        return studentMapper.queryStudentByStuno(stuNo) ;
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);

    }

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }

    @Override
    public void deleteStudentByStuNo(Integer stuNo) {
        studentMapper.deleteStudentByStuno(stuNo);
    }

    @Override
    public void updateStudentByStuNO(Student student) {
        studentMapper.updateStudentByStuno(student);
    }
}
