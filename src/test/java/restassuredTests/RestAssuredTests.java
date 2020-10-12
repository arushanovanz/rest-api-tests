package restassuredTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredTests {
    @Test
    public void getEndpointTest() {

        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        given()
                .baseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .header("x-rapidapi-key", key)
                .auth()
                .oauth2("")
                .with()
                .when().get("/info")
                .then().log().all().statusCode(200);

    }

    @Test
    public void getEndpointHeaderTest() {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-key", key)
                .log(LogDetail.ALL)
                .build();

        given()

//                .spec(rs)
                .with()
                .when().get("/info")
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void getResponseSpecTest() {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-key", key)
//                .log(LogDetail.ALL) --->  передаем в глобальную переменную config
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectBody(notNullValue())
                .build();

        //вариант передачи конфигурации запроса 1 - через глобальную переменную
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));

        given()
//                .config(restAssuredConfig)  //вариант создания конфигурации запросов 2 - через метод config() в запросе
//                .spec(rs)
                .with()
                .when().get("/info")
                .then();
//              .log().all(); // установили уровень логирования при конфигурировании

    }
}
