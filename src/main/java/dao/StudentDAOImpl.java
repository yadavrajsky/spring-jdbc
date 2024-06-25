package dao;

import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import entities.Student;

public class StudentDAOImpl  implements  StudentDAO {

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
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        return  jdbcTemplate;
    }

}
