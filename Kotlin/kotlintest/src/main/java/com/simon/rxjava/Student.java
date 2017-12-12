package com.simon.rxjava;

import java.util.List;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/10 13:46
 */

public class Student {

    private String name;
    private List<String> course;

    public Student() {
    }

    public Student(String name, List<String> course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }
}
