package REST;

import jline.internal.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@Slf4j
public class CoinDeskApisPageObject {
    static String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
    int rspCode = given().when().get(url).getStatusCode();


    public void getWholeResponse(){
        log.info(String.valueOf(rspCode));
        given()
                .get(url)
                .then()
                .log()
                .all();

        Assert.assertEquals(rspCode, 200);

    }

    public void getResponseBody(){
        given()
                .get(url)
                .then()
                .log()
                .body();

    }

    public void getContentType(){

        Log.info(given()
                .get(url)
                .then()
                .extract()
                .contentType());
    }

    public void getResponseStatus(){
        int rspCode = given().get(url).then().extract().statusCode();

        System.out.println(rspCode);
    }

    public void getSpecificPartOfResponseBody(){
//        System.out.println((String) when().get(url).then().extract().jsonPath().get("bpi.USD.code"));
        List<String> codes = when().get(url).then().extract().jsonPath().get("bpi.*.code");
        System.out.println("Got it");
    }
}
