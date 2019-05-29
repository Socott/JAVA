package com.company.pb;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * JDBC简单示例
 */
public class Demo04 {
    public static void main(String[] args) {
        try {
            List<Student> studentList = StudentManager.getInstance().querySomeStudents("Betty");
            for (Student student:studentList){
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 根据表字段建立实体类
 */
class Student{
    private int StudentId;
    private String    studentName;
    private int        studentAge;
    private String    studentPhone;

    public Student(int studentId, String studentName, int studentAge, String studentPhone) {
        StudentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentPhone='" + studentPhone + '\'' +
                '}';
    }
}

/**
 * DBConnection类专门用于向外提供数据库连接
 */
class DBConnection{
    private static Properties properties = new Properties();
    static {
        InputStream is = DBConnection.class.getResourceAsStream("./db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 这个connection只是为了用来从里面读一个PreparedStatement，不会往里面写数据，因此没有线程安全问题，可以作为一个全局变量 */
    public static Connection connection = getConnection();
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(properties.getProperty("driver"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String pwd = properties.getProperty("pwd");
            conn = DriverManager.getConnection(url,username,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

/**
 * StudentManager工具类，用来写各种方法，专门和数据库进行交互
 */
class StudentManager{
    private static StudentManager instance = new StudentManager();

    public static StudentManager getInstance() {
        return instance;
    }
    public List<Student> querySomeStudents(String studentName) throws Exception
    {
        List<Student> studentList = new ArrayList<Student>();
        Connection connection = DBConnection.connection;
        PreparedStatement ps = connection.prepareStatement("select * from student where studentName = ?");
        ps.setString(1, studentName);
        ResultSet rs = ps.executeQuery();

        Student student = null;
        while (rs.next())
        {
            student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            studentList.add(student);
        }

        ps.close();
        rs.close();
        return studentList;
    }
}