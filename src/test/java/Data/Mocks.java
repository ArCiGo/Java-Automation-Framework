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

    public static List<PersonModel> personalData() {
        personsList = new ArrayList<PersonModel>();
        personModel = new PersonModel();

        personModel.setTitle(Title.Mr);
        personModel.setFirstName(dataFaker.name().firstName());
        personModel.setLastName(dataFaker.name().lastName());
        personModel.setEmail(dataFaker.internet().emailAddress());
        personModel.setPassword(dataFaker.internet().password());
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
        personModel.setHomePhone(dataFaker.phoneNumber().phoneNumber());
        personModel.setMobilePhone(dataFaker.phoneNumber().cellPhone());
        personModel.setAddressAlias(dataFaker.hacker().adjective());

        personsList.add(personModel);

        return personsList;
    }

    public static PersonModel invalidPersonalData() {
        return personModel = new PersonModel() {{
            setEmail(dataFaker.internet().emailAddress());
            setPassword(dataFaker.internet().password());
        }};
    }
}
