package school21.spring.service.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.services.UsersService;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UsersService usersService = context.getBean("UsersServiceImpl", UsersService.class);
        usersService.signUp("mail.ru");
        UsersRepository repository = context.getBean("UsersRepositoryJdbcTemplateImpl", UsersRepository.class);
        System.out.println(repository.findByEmail("mail.ru"));
    }
}


