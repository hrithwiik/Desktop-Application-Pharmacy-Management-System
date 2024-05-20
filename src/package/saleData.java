import java.sql.Date;

public class saleData {
    private Integer BatchNo;

    private String MedicineName;
    private String BrandName;
    private String MedicineType;
    private int Qty;
    private String GST;
    private Double Amount;
    private Date date;

    public saleData(
           Integer BatchNo,String MedicineName, String BrandName,
            String MedicineType,Integer Qty,
            String GST,Double Amount,Date date) {
  
        this.BatchNo = BatchNo;
        this.MedicineName = MedicineName;
        this.BrandName = BrandName;
        this.MedicineType = MedicineType;
        this.Qty = Qty;
        this.GST = GST;
        this.Amount=Amount;
        this.date = date;
    
    }
    public Date getDate() {
        return date;
    }

    public String getGST() {
        return GST;
    }

    public Integer getQty() {
        return Qty;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public String getMedicineType() {
        return MedicineType;
    }

    public Integer getBatchNo() {
        return BatchNo;
    }
    public Double getAmount() {
        return Amount;
    }


}

