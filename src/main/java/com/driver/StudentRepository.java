package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class StudentRepository {

    HashMap<String,Student> studentMap;
    HashMap<String,Teacher> teacherMap;
    HashMap<String, List<String>> studentTeacherMap;

    public StudentRepository() {
        this.studentMap = new HashMap<String,Student>();
        this.teacherMap = new HashMap<String,Teacher>();
        this.studentTeacherMap = new HashMap<String,List<String>>();
    }

    public void addStudent(Student student){
        studentMap.put(student.getName(), student);
    }

    public void addTecher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void addPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            List<String> list = new ArrayList<>();
            if(studentTeacherMap.containsKey(teacher))
                list=studentTeacherMap.get(teacher);

            list.add(student);
            studentTeacherMap.put(teacher,list);
        }
    }

    public Student getStudent(String name){
        return studentMap.get(name);
    }

    public Teacher getTeacher(String name){
        return teacherMap.get(name);
    }

    public List<String> getStudentsByTeacher(String name){
        List<String> students = new ArrayList<>();

        if(studentTeacherMap.containsKey(name)){
            students= studentTeacherMap.get(name);
        }
        return students;
    }

    public List<String> getAllStudents(){

        return new ArrayList<>(studentMap.keySet());
    }

    public void delteTeachersAndStudents(String name){
       List<String> students = new ArrayList<>();

       if(studentTeacherMap.containsKey(name)){
           students = studentTeacherMap.get(name);

           for(String student : students){
               studentMap.remove(student);
           }
           studentTeacherMap.remove(name);
       }

       if(teacherMap.containsKey(name))
           teacherMap.remove(name);
     }

     public void deleteAllTeachersAndStudents(){

        for(List<String> studentsList : studentTeacherMap.values()){
            for(String student : studentsList)
                studentMap.remove(student);
        }
          studentTeacherMap.clear();
//        studentMap.clear();
          teacherMap.clear();
     }

}
