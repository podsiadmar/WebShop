package REST;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class CoinDeskApisPageObject {
    static String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public void getWholeResponse(){
        given().get(url).then().log().all();
    }

    public void getResponseBody(){
        given().get(url).then().log().body();
    }

    public void getContentType(){
        System.out.println(given().get(url).then().extract().contentType());
    }

    public void getResponseStatus(){
        int rspCode = given().get(url).then().extract().statusCode();

        System.out.println(rspCode);
    }

    public void getSpecificPartOfResponseBody(){
        System.out.println((LinkedHashMap) when().get(url).then().extract().jsonPath().get("bpi.*.code"));
    }
}
