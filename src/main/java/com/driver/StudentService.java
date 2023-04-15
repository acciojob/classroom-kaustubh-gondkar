package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTecher(teacher);
    }

    public void addPair(String student,String teacher){
        studentRepository.addPair(student,teacher);
    }

    public Student getStudent(String name){
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name){
        return studentRepository.getTeacher(name);
    }

    public List<String > getStudentsbyTeacher(String name){
       return studentRepository.getStudentsByTeacher(name);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeachersAndStudends(String name){
        studentRepository.delteTeachersAndStudents(name);
    }

    public void deleteAllTeachersAndStudents(){
        studentRepository.deleteAllTeachersAndStudents();
    }
}
