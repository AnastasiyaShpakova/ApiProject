package tests;

import models.SuccessLoginRequest;
import models.SuccessLoginResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.MainSpec.requestRegressInSpecification;
import static specs.MainSpec.responseRegressInSpecificationStatusCode200;

@Tag("login_test")
public class LoginTest extends TestBase{

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
}
