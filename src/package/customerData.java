import java.sql.Date;

public class customerData {
    private String MobileNo;
    private String FirstName;
    private String LastName;
    private String Address;
    private String City;
    private String Pincode;
    private String GSTN;
    private Date date;

    public customerData(String MobileNo, String FirstName, String LastName, String Address, String City, String Pincode,
            String GSTN,Date date) {
        this.MobileNo = MobileNo;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.City = City;
        this.Pincode = Pincode;
        this.GSTN = GSTN;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getPincode() {
        return Pincode;
    }

    public String getGSTN() {
        return GSTN;
    }
}
