package com.xuhao.dao;

import com.xuhao.entity.Student;

import java.util.List;

public interface IStudentDao {
    int insertStudent(Student student);

    int deleteStudentById(Integer id);

    int updateStudent(Student student);

    Student selectStudentById(Integer id);

    List<Student> selectAllStudents();
}
