package REST;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class guru99ApiPageObject {
    static String url = "http://demo.guru99.com/V4/sinkministatement.php";

    //get whole response body
    public void getResponse(){
        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log()
                .all();

    }
    //get response body
    public void getResponseBody(){

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get(url).then().log()
                .body();
    }
    //get response status
    public void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

    //get headers
    public void getResponseHeaders(){
        System.out.println(given().get(url).then().extract().headers());
    }

    //get response time
    public void getResponseTime(){
        System.out.println("The time taken to fetch the response "+given().get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    //get content type
    public void getResponseContentType(){
        System.out.println("The content type of response "+
                given().get(url).then().extract()
                        .contentType());
    }
    //erase JSON elements from body

    public void getSpecificPartOfResponseBody(){

        ArrayList<String> amounts = when().get("http://demo.guru99.com/V4/sinkministatement.php").then().extract().path("result.statements.AMOUNT");
        int sumOfAll=0;
        for(String a:amounts){

            System.out.println("The amount value fetched is "+a);
            sumOfAll=sumOfAll+Integer.parseInt(a);
        }
        System.out.println("The total amount is "+sumOfAll);

    }


}
