package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDAO")
public class StudentDAOImpl  implements  StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public int insert(Student student) {
        JdbcTemplate jdbcTemplate=getJDBCTemplate();
        String query="insert into student(id,name,city) values(?,?,?)";
        int result=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    public int delete(int studentId){
        JdbcTemplate jdbcTemplate=getJDBCTemplate();
        String query="delete from student where id=?";
        int result=jdbcTemplate.update(query,studentId);
        return result;
    };

    public Student getStudent(int studentId){
        JdbcTemplate jdbcTemplate=getJDBCTemplate();
        String query="select * from student where id=?";
        StudentRowMapperImpl studentRowMapperImpl=new StudentRowMapperImpl();
        Student student = jdbcTemplate.queryForObject(query, studentRowMapperImpl, studentId);
        return student;
    };

    public List<Student> getAllStudents(){
        JdbcTemplate jdbcTemplate=getJDBCTemplate();
        String query="select * from student";
        StudentRowMapperImpl studentRowMapperImpl=new StudentRowMapperImpl();
        List<Student> students = jdbcTemplate.query(query, studentRowMapperImpl);
        return students;
    };
    public JdbcTemplate getJDBCTemplate()
    {
        return  jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

}


