
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDAOImpl;
import com.spring.jdbc.entities.Student;





public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(JDBCConfig.class);
       StudentDAOImpl studentDAO=(StudentDAOImpl)applicationContext.getBean("studentDAO");
        // Student student=new Student( );
        // StudentDAOImpl studentDAO = new StudentDAOImpl();
        // Student student1=studentDAO.getStudent(1);
        // System.out.println(student1);
        List<Student> students=studentDAO.getAllStudents();
        for(Student s:students){
            System.out.println(s);
        }
        // int result = studentDAO.insert(student);
        // int resultDeleted=studentDAO.delete(3);
        // System.out.println(result);
        // System.out.println(resultDeleted);
    }


}
