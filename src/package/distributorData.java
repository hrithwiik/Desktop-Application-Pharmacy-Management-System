import java.sql.Date;

public class distributorData {

    private String GSTIN;
    private String Name;
    private String DrugNo;
    private String BankName;
    private String BankAccount;
    private String IFSCCode;
    private String Email;
    private String Mobile;
    private String Address;
    private String Description;
    private Date date;

    public distributorData(String GSTIN, String Name, String DrugNo, String BankName, String BankAccount,
            String IFSCCode, String Email, String mobile, String Address, String Description,Date date) {
        this.GSTIN = GSTIN;
        this.Name = Name;
        this.DrugNo = DrugNo;
        this.BankName = BankName;
        this.BankAccount = BankAccount;
        this.IFSCCode = IFSCCode;
        this.Email = Email;
        this.Mobile = mobile;
        this.Address = Address;
        this.Description = Description;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public String getGSTIN() {
        return GSTIN;

    }

    public String getName() {
        return Name;
    }

    public String getDrugNo() {
        return DrugNo;
    }

    public String getBankName() {
        return BankName;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public String getDescription() {
        return Description;
    }

}
