package Data;

import PageObjectModel.Models.PersonModel;
import PageObjectModel.Models.Title;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Mocks {

    private final static Faker dataFaker = new Faker();
    private static List<PersonModel> personsList;
    private static PersonModel personModel;

    public final static List<String> clothes = new ArrayList<String>() {{
        add("Faded Short Sleeve T-shirts");
        add("Printed Chiffon Dress");
    }};

    public static PersonModel validCredentials() {
        personModel = new PersonModel();
        personModel.setEmail(dataFaker.internet().emailAddress());
        personModel.setPassword(dataFaker.internet().password());

        return personModel;
    }

    public static PersonModel invalidPersonalData() {
        personModel = new PersonModel();
        personModel.setEmail(dataFaker.internet().emailAddress());
        personModel.setPassword(dataFaker.internet().password());

        return personModel;
    }

    public static PersonModel personalData() {
        personModel = new PersonModel();

        personModel.setTitle(Title.Mr);
        personModel.setFirstName(dataFaker.name().firstName());
        personModel.setLastName(dataFaker.name().lastName());
        personModel.setDay("25");
        personModel.setMonth("July");
        personModel.setYear("1992");
        personModel.setFirstNameAddress(dataFaker.name().firstName());
        personModel.setLastNameAddress(dataFaker.name().lastName());
        personModel.setCompany(dataFaker.company().name());
        personModel.setAddress(dataFaker.address().fullAddress());
        personModel.setAddressLine2(dataFaker.address().secondaryAddress());
        personModel.setCity(dataFaker.address().city());
        personModel.setState(dataFaker.address().state());
        personModel.setZipCode("11111");
        personModel.setCountry(dataFaker.address().country());
        personModel.setAdditionalInformation(dataFaker.lorem().sentence());
        personModel.setHomePhone("8331234567");
        personModel.setMobilePhone(dataFaker.phoneNumber().cellPhone());
        personModel.setAddressAlias(dataFaker.hacker().adjective());

        return personModel;
    }
}
