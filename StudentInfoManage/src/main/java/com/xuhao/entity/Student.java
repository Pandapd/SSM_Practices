package com.xuhao.entity;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;

/**
 * 实体类Student
 */
public class Student {
    private Integer id;
    private String name;
    private Integer age;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
