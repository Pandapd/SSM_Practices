package com.xuhao.service;

import com.xuhao.dao.IStudentDao;
import com.xuhao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao;

    @Autowired
    @Qualifier("IStudentDao")
    public void setDao(IStudentDao dao) {
        this.dao = dao;
    }
    @Override
    @Transactional
    public int addStudent(Student student) {
        return dao.insertStudent(student);
    }

    @Override
    public int removeStudentById(Integer id) {
        return dao.deleteStudentById(id);
    }

    @Override
    public int modifyStudent(Student student) {
        return dao.updateStudent(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        return dao.selectStudentById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return dao.selectAllStudents();
    }
}
