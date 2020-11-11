package restassuredTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import java.sql.SQLOutput;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.responseSpecification;
import static io.restassured.config.LogConfig.logConfig;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class CrudTests {

    @Test
    public void getAllCards() {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-key", key)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody(notNullValue())
                .build();
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        get(EndPoint.ALLCARDS).then().body("cards.size()", is(2631));

    }

    @Test
    public void getPathParamSingleCard() {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();

        given()
                .pathParam("name", "Ysera")
                .log().all()
                .when()
                .get(EndPoint.CARD)
                .then()
                .log()
                .all()
                .body("cardId", hasItems("EX1_572", "TB_BaconShop_HERO_53"));


    }

    @Test
    public void getQueryPathTest() {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();

        given()
                //   .queryParam("i","TB_BaconShop_HERO_53")
                .pathParam("name", "Ysera")
                .when()
                .get(EndPoint.CARD)
                .then()
                .log()
                .all()
                .body("rarity", hasItems("Legendary"));


    }

    @Test
    //пример queryParam  ../?id=
    public void getQueryParamTest() {
//     given()
//             .queryParam("id","1")
//             .when()
//             .get("EndPoint")
//             .then()
//             .log().all()
//             .body("id",equalTo(1));
//    }
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
        given()
                .queryParam("locale", "ruRU")
                .when()
                .get(EndPoint.CARDSBYQUALITY, "Common",1,5)
                .then()
                .log().all()
                .body(notNullValue());

    }

    @Test
     public void getPostLikersTest (){
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://instagram-data1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "instagram-data1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
         given()
//                 .pathParam("post","CHWnWZEHbFE")
                 .when()
                 .get(EndPoint.POSTLIKERS,"CHWnWZEHbFE")
                 .then()
                 .log()
                 .all()
                 .body("count",equalTo(2382));
    }


    @Test
    //примерн post-запроса
    public void postTest () {

        String body = "";// json - объекта
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(EndPoint.CARD)
                .then()
                .log()
                .all()
                .statusCode(201);
    }

    @Test
    //пример put-зарпоса
    public void putTest () {
        String body = "";//json объекта
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(EndPoint.CARD)
                .then()
                .log()
                .all()
                .statusCode(201);
    }
    @Test
    //пример put-зарпоса
    public void getBodyAsString () {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
        String body = given()
                        .pathParam("name","Ysera")
                        .get(EndPoint.CARD).asString();
        System.out.println(body);
    }
    @Test
    public void getBody () {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
        String body = given()
                .pathParam("name","Ysera")
                .get(EndPoint.CARD)
                .then()
                .body("cards.size()",is(2))
                .contentType(ContentType.JSON)
                .extract().asString();
        System.out.println(body);
    }
    @Test
    public void getBodyJsonPath(){
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
      String tittle = given().get(EndPoint.CARDSET,"Classic")
                .getBody()
                .jsonPath()
                .get("cards[0].dbfid"); //не работает, возвращает объект null
        System.out.println(tittle);
    }

    @Test
    public void getCoolies () {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        //RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());// если просрочен сертификат у сайта
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
        Map<String, String> cookies = given()
                .get(EndPoint.CARDSET,"Blackrock Mountain")
                .then()
                .statusCode(200)
                .extract().cookies();
        String sessionId = given()
                .auth()
                .basic("arushanovanz","31337asdf")
                .get(EndPoint.CARD,"Ysera")
                .then()
                .statusCode(200)
                .extract()
                .sessionId();

        System.out.println(sessionId);
        System.out.println(cookies);
    }


}
