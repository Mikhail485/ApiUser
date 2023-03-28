package step;

import data.User;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static specification.Specification.*;

public class UserStep {

    @Step("Создаем новой User")
    public UserStep createUser(User user){
        installSpec(requestSpec(), responseSpec(200));

        given()
                .body(user)
                .when()
                .post("user")
                .then()
                .log().all();
        return this;
    }

    @Step("Изменяем User по userName")
    public UserStep updatedUser(String userName, User user){
        installSpec(requestSpec(), responseSpec(200));

        given()
                .body(user)
                .when()
                .put("user/" + userName)
                .then()
                .log().all();
        return this;
    }

    @Step("Получем User по userName и проверям")
    public UserStep getUserAndCheck(String userName, User user){
        installSpec(requestSpec(), responseSpec(200));

        User getUser = given()
                .when()
                .get("user/" + userName)
                .then()
                .log().all()
                .extract()
                .body().as(User.class);

        Assertions.assertEquals(getUser, user);
        return this;
    }

    @Step("Удаляем User по userName и проверяем, что User удален")
    public UserStep deleteUserAndCheck(String userName){
        installSpec(requestSpec(), responseSpec(200));

        given()
                .when()
                .delete("user/" + userName)
                .then()
                .log().all();

        installSpec(responseSpec(404));

        given()
                .when()
                .delete("user/" + userName)
                .then()
                .log().all();
        return this;
    }
}
