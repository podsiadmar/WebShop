package REST;

import jline.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

@Slf4j
public class CoinDeskApisPageObject {
    static String url = "   ";
    int rspCode = given().when().get(url).getStatusCode();

@Test
    public void getWholeResponse(){

        given()
                .get(url)
                .then()
                .and()
                .log()
                .all();



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
@Test
    public void getResponseStatus(){
        int rspCode = given().get(url).then().extract().statusCode();

        System.out.println(rspCode);
    }
@Test
    public void getSpecificPartOfResponseBody(){
//        System.out.println((String) when().get(url).then().extract().jsonPath().get("bpi.USD.code"));
        log.info(when().get(url).then().extract().jsonPath().get("object.bpi"));
        System.out.println("Got it");
    }
}
