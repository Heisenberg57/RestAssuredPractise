import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetTestWithQueryParams {

    @Test
    public void getTestWithQueryParams(){
        given()
                .queryParam("userId",1)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200);

    }
}
