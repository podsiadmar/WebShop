package generators;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pageObjects.Base;

public class AddressGenerator {
    Faker faker = new Faker();
    private String firstName;
    private String lastName;
    private String eMail;
    private String company;
    private String country;
    private String province;
    private String city;
    private String address1;
    private String address2;
    private String zipPostalCode;
    private String phoneNumber;
    private String faxNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = faker.name().firstName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = faker.name().lastName();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail() {
        int min = 1;
        int max = 99999;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.eMail = getFirstName()+"."+getLastName()+random_int+"@gmail.test";
    }

    public String getCompany() {
        return company;
    }

    public void setCompany() {
        this.company = faker.company().name();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity() {
        this.city = faker.address().city();
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1() {
        this.address1 = faker.address().streetAddress();
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2() {
        this.address2 = faker.address().secondaryAddress();
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public void setZipPostalCode() {
        this.zipPostalCode = faker.address().zipCode();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        this.phoneNumber = faker.phoneNumber().phoneNumber();
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber() {
        this.faxNumber = faker.number().digits(4);
    }

    public static Object[][] newAddress() {
        AddressGenerator obj = new AddressGenerator();
        obj.setFirstName();
        obj.setLastName();
        obj.seteMail();
        obj.setCompany();
        obj.setCountry("Germany");
        obj.setProvince("Other (Non US)");
        obj.setCity();
        obj.setAddress1();
        obj.setAddress2();
        obj.setZipPostalCode();
        obj.setPhoneNumber();
        obj.setFaxNumber();
        return new Object[][]{{obj.getFirstName(), obj.getLastName(), obj.geteMail(), obj.getCompany(), obj.getCountry(),
                obj.getProvince(), obj.getCity(), obj.getAddress1(), obj.getAddress2(), obj.getZipPostalCode(),
                obj.getPhoneNumber(), obj.getFaxNumber()}};
    }

}



