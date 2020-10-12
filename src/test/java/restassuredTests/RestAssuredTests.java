package restassuredTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.config.XmlConfig.xmlConfig;

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
               .then().log().all().statusCode(200);

    }
    @Test
    public void getEndpointHeaderTest(){
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";

       RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-key",key)
                .log(LogDetail.ALL)
                .build();

       given()

//                .spec(rs)
                .with()
                .when().get("/info")
                .then()
                .log().all().statusCode(200);

    }
}
