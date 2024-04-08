package tests;

import models.UserData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.MainSpec.*;

@Tag("user_test")
public class UserTests extends TestBase{

    @Test
    void checkUserIdTest() {
        UserData response = step("Check user id", () -> given(requestRegressInSpecification)
                .when()
                .get("/users/{id}", 2)
                .then()
                .spec(responseRegressInSpecificationStatusCode200)
                .extract().as(UserData.class)
        );
        step("Check user id", () -> assertThat(response.getData().getId()).isEqualTo(2));
    }

    @Test
    void userIdNotInListIdTest() {
        step("Check status code 404", () -> given(requestRegressInSpecification)
                .when()
                .get("/unknown/{id}", 23)
                .then()
                .spec(responseRegressInSpecificationStatusCode404)
        );
    }

    @Test
    void successfulDeleteTest() {
        step("Delete user with id 2", () -> given(requestRegressInSpecification)
                .when()
                .delete("/users/{id}", 2)
                .then()
                .spec(responseRegressInSpecificationStatusCode204)
        );
      }
    }

