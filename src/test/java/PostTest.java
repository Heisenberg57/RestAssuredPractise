import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostTest {

    @Test
    public void createPost(){

        baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .header("Content-Type", "application/json")
                .body("{\"title\":\"test\",\"body\":\"learning\",\"userId\":1}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title",equalTo("test"));

    }

    @Test
    public void creatPostusingVariable(){

        baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\"title\":\"test\",\"body\":\"learning\",\"userId\":1}";

        given()
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

    }

    @Test
    public void createPostusingJson(){

        baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .header("Content-Type", "application/json")
                .body("""
                        {
                        "title":"test",
                        "body":"learning",
                        "userId":1  
                        }
                        """)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title",equalTo("test"));

    }

    @Test
    public void createPostusingJSONva(){
        baseURI = "https://jsonplaceholder.typicode.com";
        String requestBody = """
                        {
                        "title":"test",
                        "body":"learning",
                        "userId":1  
                        }
                        """;

        given()
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);



    }


}
