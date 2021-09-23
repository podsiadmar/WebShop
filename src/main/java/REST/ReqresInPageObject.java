package REST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ReqresInPageObject {

    @Test
    public void getListUser(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        log.info(String.valueOf(response.getStatusCode()));
        log.info(response.getBody().asString());
        log.info(response.getStatusLine());
        log.info(response.getSessionId());
        log.info(response.getContentType());
    }
}
