package generators;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class DataProviders{
    Faker faker = new Faker();

    @DataProvider(name = "Login")
    public Object[][] getDataForLogin(){
        return new Object[][]{{"JN.8i4201@gmail.test", "Tosca1234!"}, {"JN.2Nb315@gmail.test", "Tosca1234!"}};
    }

    @DataProvider(name = "Registration")
    public Object[] getDataForRegistration() {
        Random rnd = new Random();
        int bound = 300;
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        return new Object[][]{{fName, lName, fName+"."+lName+ rnd.nextInt(bound) +"@gmail.test"}};
    }

    @DataProvider(name = "NewAddress")
    public Object[] getDataFromNewAddress(){
        new AddressGenerator();
        return AddressGenerator.newAddress();
    }


}