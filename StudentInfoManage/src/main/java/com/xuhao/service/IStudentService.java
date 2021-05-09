package com.xuhao.service;

import com.xuhao.entity.Student;

import java.util.List;

public interface IStudentService {
    int addStudent(Student student);

    int removeStudentById(Integer id);

    int modifyStudent(Student student);

    Student findStudentById(Integer id);

    List<Student> findAllStudents();
}
