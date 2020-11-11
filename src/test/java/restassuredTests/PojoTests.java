package restassuredTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import restassuredTests.pojo.Cards;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;

public class PojoTests {
    @Test
    public void getCardPOJO() {
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
      Cards card = given().contentType(ContentType.JSON).log().all().pathParam("name","EX1_572")
                            .get(EndPoint.CARD).jsonPath().getObject("cards[0]",Cards.class);
        System.out.println(card);
    }
}
