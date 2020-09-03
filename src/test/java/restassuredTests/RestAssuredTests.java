package restassuredTests;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredTests {


    @Test
    public void getEndpointTest(){

       String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        given()
                    .baseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                    .header("x-rapidapi-key",key)
                    .auth()
                    .oauth2("")
               .with()
               .when().get("/info")
               .then().statusCode(200);

    }
}
