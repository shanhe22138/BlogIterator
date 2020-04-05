package com.blog.Mapper;

import java.io.*;

/**
 * @author shanhe
 * @className Test
 * @date 2020-03-30 01:26
 **/
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher1 = new Teacher(new Student()), teacher2 = (Teacher) teacher1.deepClone();

        System.out.println(teacher1==teacher2);
        System.out.println(teacher1.getStudent() == teacher2.getStudent());
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = -2670549298404052141L;
    private String name;


}

class Teacher implements Serializable {
    private String name;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public Teacher(Student student) {
        this.student = student;
    }
    
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(b);
        oo.writeObject(this);

        ByteArrayInputStream in = new ByteArrayInputStream(b.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(in);
        return inputStream.readObject();

    }
}