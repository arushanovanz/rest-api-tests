package restassuredTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;
import static org.hamcrest.Matchers.lessThan;

public class JsonSchemaValiadtionTests {
    @Test
    public void responseTime(){

        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
         long time =    given().pathParam("name","Ysera").get(EndPoint.CARD).timeIn(TimeUnit.MILLISECONDS);



// способ 1 - в конфигурации
        responseSpecification = expect().time(lessThan(2000L));
        given().pathParam("name","Ysera").get(EndPoint.CARD);
       // способ 2 в запросе
       // given().pathParam("name","Ysera").get(EndPoint.CARD).then().time(lessThan(1000L));
        System.out.println(time);

    }
    @Test
    public void gPathFind(){
        String key = "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14";
        config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .setAccept(ContentType.JSON)
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91862a20f9msh633e027463600f2p1ca3edjsn9e88f1e2dd14")
                .build();
       Object card =  given().pathParam("name","Ysera").get(EndPoint.CARD)
                .then().log().all()
                       .extract().path(" $.find { it.cardId=='EX1_572'}"); //groovy не работает
        System.out.println(card);
    }
}
