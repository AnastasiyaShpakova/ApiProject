package tests;

import models.SuccessLoginRequest;
import models.SuccessLoginResponse;
import models.UnsuccessLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.MainSpec.*;

@Tag("login_test")
public class LoginTest extends TestBase {

    @Test
    void successfulLoginTest() {
        SuccessLoginRequest requestBody = new SuccessLoginRequest();
        step("Filling request body object", () -> {
            requestBody.setEmail("eve.holt@reqres.in");
            requestBody.setPassword("cityslicka");
        });
        SuccessLoginResponse response = step("Send request", () -> given(requestRegressInSpecification)
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .spec(responseRegressInSpecificationStatusCode200)
                .extract().as(SuccessLoginResponse.class)
        );
        step("Check existToken", () -> assertThat(response.getToken()).isNotNull());
    }

    @Test
    void unsuccessfulLoginTest() {
        //String loginData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";
        SuccessLoginRequest loginData = new SuccessLoginRequest();
        loginData.setEmail("eve.holt@reqres.in");

        UnsuccessLogin response = step("Make request", () ->
                given(requestRegressInSpecification)
                        .body(loginData)
                        .when()
                        .post("/login")
                        .then()
                        .spec(missingPasswordResponseSpec)
                        .extract().as(UnsuccessLogin.class));

        step("Check response", () ->
                assertEquals("Missing password", response.getError()));
    }
}
