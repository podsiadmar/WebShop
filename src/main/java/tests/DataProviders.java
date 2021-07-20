package tests;

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
    public Object[] getDataFroNewAddress(){
        Random rnd = new Random();
        int bound = 300;
        String fname = faker.name().firstName();
        String lname = faker.name().lastName();
        String company = faker.company().name();
        String city = faker.beer().name();
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String zipCode = faker.address().zipCode();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String faxNumber = faker.number().digits(4);
        return new Object[][]{{fname, lname, fname+"."+lname+ rnd.nextInt(bound) +"@gmail.test", company, city, address1, address2, zipCode, phoneNumber, faxNumber}};
    }


}