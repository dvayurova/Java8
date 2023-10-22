package school21.spring.service.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;
import school21.spring.service.services.UsersServiceImpl;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "school21.spring.service")
public class TestApplicationConfig {

    @Primary
    @Bean
    @Qualifier("driverManagerBean")
    public DriverManagerDataSource driverManagerDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:h2:mem:testdb");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("");
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        return driverManagerDataSource;
    }
    @Primary
    @Bean
    @Qualifier("usersRepositoryTestBean")
    public UsersRepositoryJdbcTemplateImpl usersRepositoryJdbcTemplate (@Qualifier("driverManagerBean") DataSource dataSource) {
        return new UsersRepositoryJdbcTemplateImpl(dataSource);
    }

    @Primary
    @Bean
    @Qualifier("usersServiceTestBean")
    public UsersServiceImpl usersService (@Qualifier("UsersRepositoryJdbcTemplateImpl") UsersRepository usersRepository) {
       return new UsersServiceImpl(usersRepository);
    }

}
