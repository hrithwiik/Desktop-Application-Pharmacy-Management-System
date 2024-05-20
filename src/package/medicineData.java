import java.sql.Date;

public class medicineData {
    private String Distributor;
    private Integer BatchNo;
    private Date ExpiryDate;
    private String MedicineName;
    private String BrandName;
    private String MedicineType;
    private Double MRP;
    private Double RetailPrice;
    private Double SupplierPrice;
    private int Qty;
    private Double Discount;
    private String GST;
    private Date date;
    

    public medicineData(
            String Distributor, Integer BatchNo, Date ExpiryDate, String MedicineName, String BrandName,
            String MedicineType, Double MRP, Double RetailPrice, Double SupplierPrice, Integer Qty, Double Discount,
            String GST,Date date) {
        this.Distributor = Distributor;
        this.BatchNo = BatchNo;
        this.ExpiryDate = ExpiryDate;
        this.MedicineName = MedicineName;
        this.BrandName = BrandName;
        this.MedicineType = MedicineType;
        this.MRP = MRP;
        this.RetailPrice = RetailPrice;
        this.SupplierPrice = SupplierPrice;
        this.Qty = Qty;
        this.Discount = Discount;
        this.GST = GST;
        this.date=date;

    }
    public Date getDate() {
        return date;
    }


 
    public String getGST() {
        return GST;
    }

    public Double getRetailPrice() {
        return RetailPrice;
    }

    public Double getSupplierPrice() {
        return SupplierPrice;
    }

    public Double getDiscount() {
        return Discount;
    }

    public Integer getQty() {
        return Qty;
    }

    public Double getMRP() {
        return MRP;
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

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public String getDistributor() {
        return Distributor;
    }

    public Integer getBatchNo() {
        return BatchNo;
    }


}
