import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDAOImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JDBCConfig {
    @Bean("ds")
    public DriverManagerDataSource getDataSource()
    {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbc_template");
        ds.setUsername("munshi");
        ds.setPassword("");
        return ds;
    }
    
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate()
    {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean("studentDAO")
    public StudentDAOImpl getStudentDAOImpl()
    {
        StudentDAOImpl studentDAOImpl=new StudentDAOImpl();
        studentDAOImpl.setJdbcTemplate(getJdbcTemplate());
        return studentDAOImpl;
    }
}
