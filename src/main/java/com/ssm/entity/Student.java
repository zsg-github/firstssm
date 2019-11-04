package com.ssm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Student {
    private int stuNo;
    @NotEmpty
    private String stuName;
    private int stuAge ;

    //数据格式化
        //数据校验
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stuRegTime;

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Date getStuRegTime() {
        return stuRegTime;
    }

    public void setStuRegTime(Date stuRegTime) {
        this.stuRegTime = stuRegTime;
    }

    @Override
        public String toString() {
            return "Student{" +
                    "stuNo=" + stuNo +
                    ", stuName='" + stuName + '\'' +
                    ", stuAge=" + stuAge +
                    ", stuRegTime=" + stuRegTime +
                    '}';
    }
}
