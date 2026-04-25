import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetTest {

    @Test
    public void getTest() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    public void getTestWithQueryParams(){
        given()
                .queryParam("userId",1)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200);

    }

    @Test
    public void getWithPathParam(){
        given()
                .pathParam("id",1)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/{id}")
                .then()
                .statusCode(200)
                .body("id",equalTo(1));
    }

}
