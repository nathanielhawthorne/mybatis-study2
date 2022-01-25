package com.xiong.dao;

import com.xiong.pojo.Student;
import com.xiong.pojo.Teacher;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生信息，及对应的老师信息
    public List<Student> getStudent();
    public List<Student> getStudent2();

    public List<Teacher> getTeacher();
}
