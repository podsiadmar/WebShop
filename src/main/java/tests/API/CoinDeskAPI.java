package tests.API;

import REST.CoinDeskApisPageObject;
import org.testng.annotations.Test;

public class CoinDeskAPI {

    @Test
    public void getAllResponse(){
        new CoinDeskApisPageObject()
                .getWholeResponse();
    }

    @Test
    public void getResponseBodyCoin(){
        new CoinDeskApisPageObject()
                .getResponseBody();
    }

    @Test
    public void getContentType(){
        new CoinDeskApisPageObject()
                .getContentType();
    }

    @Test
    public void getStatusCode(){
        new CoinDeskApisPageObject()
                .getResponseStatus();
    }

    @Test
    public void erase(){
        new CoinDeskApisPageObject()
                .getSpecificPartOfResponseBody();
    }
}
