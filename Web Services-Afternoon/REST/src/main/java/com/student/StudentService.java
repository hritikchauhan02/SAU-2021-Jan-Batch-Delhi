package com.student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentService {
    private static HashMap<Integer,Student> students=new HashMap<Integer, Student>();

    static
    {
        Student s1 = new Student(1, "XYZ", "10/10/10", "test1@test1.com", "CSE");
        Student s2 = new Student(2, "PQR", "11/11/11", "test2@test2.com", "CSE");
        students.put(1, s1);
        students.put(2, s2);
    }

    public List<Student> getAllStudents() {
        List<Student> studentsList= new ArrayList<>(students.values());
        return studentsList;
    }

    public Student getStudentByRollNo(int rollNo) {
        if(students.containsKey(rollNo) == false)
            return null;
        return students.get(rollNo);
    }

    public Object addStudent(Student student) {
        if(students.containsKey(student.getRollNo()))
            return "Student with given roll no already exists";
        students.put(student.getRollNo(), student);
        return students.get(student.getRollNo());
    }

    public Object updateStudent(int rollNo, Student student) {
        if(!students.containsKey(student.getRollNo()))
            return "Student with given roll no does not exist";
        return "Student updated Successfully";
    }

    public String deleteStudent(int rollNo) {
        if(students.containsKey(rollNo) == false)
            return "Student with given roll no does not exist";
        students.remove(rollNo);
        return "Student removed Successfully";
    }
}
