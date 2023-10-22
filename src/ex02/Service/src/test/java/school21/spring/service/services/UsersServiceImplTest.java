package school21.spring.service.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import school21.spring.service.config.TestApplicationConfig;
import school21.spring.service.repositories.UsersRepository;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
public class UsersServiceImplTest {
    @Autowired
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    @Test
    @Sql("/table.sql")
    void signUpTest() {
        ((UsersServiceImpl)usersService).setUsersRepository(usersRepository);

        String password = usersService.signUp("test@mail.ru");
        Mockito.verify(usersRepository, Mockito.times(1)).save(Mockito.any());

        Assertions.assertNotNull(password);
    }
}