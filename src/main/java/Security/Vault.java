package Security;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;
import pageObjects.Base;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Vault extends Base {

    public String getDataValue(String dataName) throws IOException {
        String commandLine = "curl -H \"X-Vault-Token: s.YOyRy2eUKo83Jku2Mr5Mo4UH\" -X GET http://127.0.0.1:8200/v1/secret/data/demoWebShop";
        Reader reader = new InputStreamReader(Runtime.getRuntime().exec(commandLine).getInputStream());
        JsonElement element = new JsonParser().parse(reader);
        JsonObject jsonObject = element.getAsJsonObject();
        JsonElement dataVault = jsonObject.get("data").getAsJsonObject().get("data").getAsJsonObject().get(dataName);
        return dataVault.toString().replace("\"", "");

    }

    @Test
    public void dejMniePanResponse() throws IOException {
        getDataValue("login");
    }

}