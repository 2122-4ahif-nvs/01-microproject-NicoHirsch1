package at.htl.recipes.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
class UserResourceTest {

    @Test
    void getAllUsers() {
        when().get("user/get/all").then().statusCode(200).body(startsWith("[{"));
    }
}