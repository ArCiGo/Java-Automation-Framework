package Models;

import Utilities.Log;
import com.opencsv.bean.CsvBindByName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MockarooFakeModel extends CsvBean {

    @CsvBindByName(column = "id")
    private int ID;

    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "gender")
    private String gender;

    @CsvBindByName(column = "ip_address")
    private String IPAddress;

    @CsvBindByName(column = "date")
    private String date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public Date getDate() {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(this.date);
            return date;
        } catch (ParseException ex) {
            Log.error(ex.toString());
            return null;
        }
    }

    public void setDate(String date) {
        this.date = date;
    }
}
