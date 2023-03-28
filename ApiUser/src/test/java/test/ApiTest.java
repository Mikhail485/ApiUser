package test;

import data.User;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import step.UserStep;

import java.util.Random;
import java.util.UUID;

@Owner("Komar_ML")
public class ApiTest {

    @Test
    @Description("Проверка создания, обновления, получения и удаления User")
    public void testApi(){

        User user = new User(new Random().nextInt(500000), "Alex_" + UUID.randomUUID(),
                "Soul", "SoulAlex@gmail.com", "123456", "89456374875", 745);
        User updatedUser = new User(new Random().nextInt(500000), "Serg_" + UUID.randomUUID(),
                "Dou", "goodK@mail.ru", "123456", "89456374875", 745);

        new UserStep().createUser(user)
                .updatedUser(user.getUsername(), updatedUser)
                .getUserAndCheck(updatedUser.getUsername(), updatedUser)
                .deleteUserAndCheck(updatedUser.getUsername());
    }
}
