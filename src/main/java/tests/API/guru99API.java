package tests.API;

import REST.guru99ApiPageObject;
import org.testng.annotations.Test;

public class guru99API {

    @Test
    public void getAllResponseBody(){
        new guru99ApiPageObject()
                .getResponse();
    }

    @Test
    public void getOnlyResponseBody(){
        new guru99ApiPageObject()
                .getResponseBody();
    }

    @Test
    public void getResponseStatus(){
        new guru99ApiPageObject()
                .getResponseStatus();

    }

    @Test
    public void getHeaders(){
        new guru99ApiPageObject()
                .getResponseHeaders();
    }

    @Test
    public void getResponseTime(){
        new guru99ApiPageObject()
                .getResponseTime();
    }

    @Test
    public void getContentType(){
        new guru99ApiPageObject()
                .getResponseContentType();
    }

    @Test
    public void eraseValue(){
        new guru99ApiPageObject()
                .getSpecificPartOfResponseBody();
    }


}
