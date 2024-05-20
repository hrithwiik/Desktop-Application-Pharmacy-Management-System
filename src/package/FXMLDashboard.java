import java.awt.Desktop;
import java.net.URI;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDashboard implements Initializable {

    @FXML
    private AnchorPane CustomerForm;

    @FXML
    private AnchorPane DistributorForm;

    @FXML
    private AnchorPane DunzoForm;

    @FXML
    private AnchorPane EclinicForm;

    @FXML
    private AnchorPane HomeForm;

    @FXML
    private AnchorPane InventoryForm;

    @FXML
    private AnchorPane PurchaseForm;

    @FXML
    private AnchorPane ReportsForm;

    @FXML
    private AnchorPane SaleForm;

    @FXML
    private AnchorPane SaleFormDetails;

    @FXML
    private Button close;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private DatePicker customerStartPicker;

    @FXML
    private DatePicker customerLastPicker;

    @FXML
    private Button customerReportBtn;

    @FXML
    private TextField customerReportTotal;

    @FXML
    private TextField customerAddress;

    @FXML
    private TextField customerCity;

    @FXML
    private Button customerClearBtn;

    @FXML
    private Button customerDeleteBtn;

    @FXML
    private TextField customerFirstName;

    @FXML
    private TextField customerGSTN;

    @FXML
    private ImageView customerImage;

    @FXML
    private Button customerImportPrescriptionBtn;

    @FXML
    private TextField customerLastName;

    @FXML
    private TextField customerMobileNo;

    @FXML
    private TextField customerPincode;

    @FXML
    private Button customerSaleBtn;

    @FXML
    private TextField customerSearch;

    @FXML
    private TableView<customerData> customerTable;

    @FXML
    private TableColumn<customerData, String> customerTableAddress;

    @FXML
    private TableColumn<customerData, String> customerTableCity;

    @FXML
    private TableColumn<customerData, String> customerTableFirstName;

    @FXML
    private TableColumn<customerData, String> customerTableGSTN;

    @FXML
    private TableColumn<customerData, String> customerTableLastName;

    @FXML
    private TableColumn<customerData, String> customerTableMobileNo;

    @FXML
    private TableColumn<customerData, String> customerTablePincode;

    @FXML
    private TableColumn<customerData, String> customerTableDate;

    @FXML
    private TableView<customerData> customerTable1;

    @FXML
    private TableColumn<customerData, String> customerTableAddress1;

    @FXML
    private TableColumn<customerData, String> customerTableCity1;

    @FXML
    private TableColumn<customerData, String> customerTableFirstName1;

    @FXML
    private TableColumn<customerData, String> customerTableGSTN1;

    @FXML
    private TableColumn<customerData, String> customerTableLastName1;

    @FXML
    private TableColumn<customerData, String> customerTableMobileNo1;

    @FXML
    private TableColumn<customerData, String> customerTablePincode1;

    @FXML
    private TableColumn<customerData, String> customerTableDate1;

    @FXML
    private Button customerUpdateBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private DatePicker distributorStartPicker;

    @FXML
    private DatePicker distributorLastPicker;

    @FXML
    private Button distributorReportBtn;

    @FXML
    private TextField distributorReportTotal;

    @FXML
    private Button distributorAddBtn;

    @FXML
    private TextField distributorAddress;

    @FXML
    private TextField distributorBankAccount;

    @FXML
    private TextField distributorBankName;

    @FXML
    private Button distributorClearBtn;

    @FXML
    private Button distributorDeleteBtn;

    @FXML
    private TextField distributorDescription;

    @FXML
    private TextField distributorDrugLicenseNo;

    @FXML
    private TextField distributorEmail;

    @FXML
    private TextField distributorGSTIN;

    @FXML
    private TextField distributorIFSCCode;

    @FXML
    private ImageView distributorImage;

    @FXML
    private Button distributorImportBtn;

    @FXML
    private TextField distributorMobile;

    @FXML
    private TextField distributorName;

    @FXML
    private TextField distributorSearch;

    @FXML
    private TableView<distributorData> distributorTable;

    @FXML
    private TableColumn<distributorData, String> distributorTableAddress;

    @FXML
    private TableColumn<distributorData, String> distributorTableBankAccount;

    @FXML
    private TableColumn<distributorData, String> distributorTableBankName;

    @FXML
    private TableColumn<distributorData, String> distributorTableDescription;

    @FXML
    private TableColumn<distributorData, String> distributorTableDrugLicenseNo;

    @FXML
    private TableColumn<distributorData, String> distributorTableEmail;

    @FXML
    private TableColumn<distributorData, String> distributorTableGGSTIN;

    @FXML
    private TableColumn<distributorData, String> distributorTableIFSCCode;

    @FXML
    private TableColumn<distributorData, String> distributorTableMobile;

    @FXML
    private TableColumn<distributorData, String> distributorTableName;

    @FXML
    private TableColumn<distributorData, String> distributorTableDate;

    // Distributor Report

    @FXML
    private TableView<distributorData> distributorTable1;

    @FXML
    private TableColumn<distributorData, String> distributorTableAddress1;

    @FXML
    private TableColumn<distributorData, String> distributorTableBankAccount1;

    @FXML
    private TableColumn<distributorData, String> distributorTableBankName1;

    @FXML
    private TableColumn<distributorData, String> distributorTableDescription1;

    @FXML
    private TableColumn<distributorData, String> distributorTableDrugLicenseNo1;

    @FXML
    private TableColumn<distributorData, String> distributorTableEmail1;

    @FXML
    private TableColumn<distributorData, String> distributorTableGGSTIN1;

    @FXML
    private TableColumn<distributorData, String> distributorTableIFSCCode1;

    @FXML
    private TableColumn<distributorData, String> distributorTableMobile1;

    @FXML
    private TableColumn<distributorData, String> distributorTableName1;

    @FXML
    private TableColumn<distributorData, String> distributorTableDate1;

    @FXML
    private Button distributorUpdateBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button eClinicBookBtn;

    @FXML
    private Button eClinicPremiumPackageBtn;

    @FXML
    private Button eClinicReferBtn;

    @FXML
    private Button eClinicStandardPackageBtn;

    @FXML
    private Button eClinicSubscribeBtn;

    @FXML
    private Button eClinicWhatsappBtn;

    @FXML
    private AnchorPane eclinicBookForm;

    @FXML
    private ComboBox<?> eclinicBookSelectSpecialist;

    @FXML
    private Button eclinicDr1;

    @FXML
    private Button eclinicDr2;

    @FXML
    private Button eclinicDr3;

    @FXML
    private Button eclinicDr4;

    @FXML
    private Button eclinicDr5;

    @FXML
    private Button eclinicDr6;

    @FXML
    private Button eclinicDr7;

    @FXML
    private Button eclinicDr8;

    @FXML
    private Button eclinicReferBookNowBtn;

    @FXML
    private AnchorPane eclinicReferForm;

    @FXML
    private ImageView eclinicReferImage;

    @FXML
    private TextField eclinicReferPatientAge;

    @FXML
    private ComboBox<?> eclinicReferPatientGender;

    @FXML
    private TextField eclinicReferPatientMobileNo;

    @FXML
    private ComboBox<?> eclinicReferPatientProblemSince;

    @FXML
    private TextField eclinicReferPatientReferredFor;

    @FXML
    private TextField eclinicReferPatientname;

    @FXML
    private RadioButton eclinicReferRadioConsultation;

    @FXML
    private RadioButton eclinicReferRadioNo;

    @FXML
    private RadioButton eclinicReferRadioSurgery;

    @FXML
    private RadioButton eclinicReferRadioTests;

    @FXML
    private RadioButton eclinicReferRadioYes;

    @FXML
    private Button eclinicReferUploadBtn;

    @FXML
    private AnchorPane eclinicSubcribeForm;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Label headerText;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button homeAddDistributorBtn;

    @FXML
    private Button homeAddPurchaseBtn;

    @FXML
    private Button homeAddSaleBtn;

    @FXML
    private Button homeClinicBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button inventoryAddBtn;

    @FXML
    private TextField inventoryBatchNo;

    @FXML
    private TextField inventoryBrandName;

    @FXML
    private Button inventoryClearBtn;

    @FXML
    private Button inventoryDeleteBtn;

    @FXML
    private TextField inventoryDiscount;

    @FXML
    private ComboBox<?> inventoryDistributor;

    @FXML
    private DatePicker inventoryExpiryDate;

    @FXML
    private ComboBox<?> inventoryGST;

    @FXML
    private ImageView inventoryImage;

    @FXML
    private Button inventoryImportBtn;

    @FXML
    private TextField inventoryMRP;

    @FXML
    private TextField inventoryMedicineName;

    @FXML
    private ComboBox<?> inventoryMedicineType;

    @FXML
    private TextField inventoryQty;

    @FXML
    private TextField inventoryRetailPrice;

    @FXML
    private TextField inventorySearch;

    @FXML
    private TextField inventorySupplierPrice;

    @FXML
    private TableView<medicineData> inventoryTable;

    @FXML
    private TableColumn<medicineData, String> inventoryTableBatchNo;

    @FXML
    private TableColumn<medicineData, String> inventoryTableBrandName;

    @FXML
    private TableColumn<medicineData, String> inventoryTableDiscount;

    @FXML
    private TableColumn<medicineData, String> inventoryTableDistributor;

    @FXML
    private TableColumn<medicineData, String> inventoryTableExpiryDate;

    @FXML
    private TableColumn<medicineData, String> inventoryTableDate;

    @FXML
    private TableColumn<medicineData, String> inventoryTableGST;

    @FXML
    private TableColumn<medicineData, String> inventoryTableMRP;

    @FXML
    private TableColumn<medicineData, String> inventoryTableMedicineName;

    @FXML
    private TableColumn<medicineData, String> inventoryTableMedicineType;

    @FXML
    private TableColumn<medicineData, String> inventoryTableQty;

    @FXML
    private TableColumn<medicineData, String> inventoryTableRetailPrice;

    @FXML
    private TableColumn<medicineData, String> inventoryTableSupplierPrice;

    @FXML
    private Button inventoryUpdateBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private BorderPane main_form;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button minimize;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button navClinicBtn;

    @FXML
    private Button navCustomerBtn;

    @FXML
    private Button navDistributorBtn;

    @FXML
    private Button navDunzoBtn;

    @FXML
    private Button navHomeBtn;

    @FXML
    private Button navInvenotryBtn;

    @FXML
    private Button navLogOutBtn;

    @FXML
    private Button navPurchaseBtn;

    @FXML
    private Button navReportsBtn;

    @FXML
    private Button navSaleBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private DatePicker purchaseStartPicker;

    @FXML
    private DatePicker purchaseLastPicker;

    @FXML
    private Button purchaseReportBtn;

    @FXML
    private TextField purchaseReportTotal;

    @FXML
    private Button purchaseAddBtn;

    @FXML
    private TextField purchaseBatchNo;

    @FXML
    private TextField purchaseBrandName;

    @FXML
    private Button purchaseClearBtn;

    @FXML
    private Button purchaseDeleteBtn;

    @FXML
    private TextField purchaseDiscount;

    @FXML
    private ComboBox<?> purchaseDistributor;

    @FXML
    private DatePicker purchaseExpiryNo;

    @FXML
    private ComboBox<?> purchaseGST;

    @FXML
    private ImageView purchaseImage;

    @FXML
    private Button purchaseImportBtn;

    @FXML
    private TextField purchaseMRP;

    @FXML
    private TextField purchaseMedicineName;

    @FXML
    private ComboBox<?> purchaseMedicineType;

    @FXML
    private TextField purchaseQty;

    @FXML
    private TextField purchaseRetailPrice;

    @FXML
    private TextField purchaseSearch;

    @FXML
    private TextField purchaseSupplierPrice;

    @FXML
    private TableView<medicineData> purchaseTable;

    @FXML
    private TableColumn<medicineData, Integer> purchaseTableBatchNo;

    @FXML
    private TableColumn<medicineData, String> purchaseTableBrandName;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDiscount;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDistributor;

    @FXML
    private TableColumn<medicineData, String> purchaseTableExpiryDate;

    @FXML
    private TableColumn<medicineData, String> purchaseTableGST;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMRP;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMedicineName;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMedicineType;

    @FXML
    private TableColumn<medicineData, String> purchaseTablePTR;

    @FXML
    private TableColumn<medicineData, String> purchaseTablePTS;

    @FXML
    private TableColumn<medicineData, String> purchaseTableQty;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDate;

    @FXML
    private TableView<medicineData> purchaseTable1;

    @FXML
    private TableColumn<medicineData, Integer> purchaseTableBatchNo1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableBrandName1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDiscount1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDistributor1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableExpiryDate1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableGST1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMRP1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMedicineName1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMedicineType1;

    @FXML
    private TableColumn<medicineData, String> purchaseTablePTR1;

    @FXML
    private TableColumn<medicineData, String> purchaseTablePTS1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableQty1;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDate1;

    @FXML
    private TableView<medicineData> purchaseTable2;

    @FXML
    private TableColumn<medicineData, Integer> purchaseTableBatchNo2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableBrandName2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDiscount2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDistributor2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableExpiryDate2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableGS2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMRP2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMedicineName2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableMedicineType2;

    @FXML
    private TableColumn<medicineData, String> purchaseTablePTR2;

    @FXML
    private TableColumn<medicineData, String> purchaseTablePTS2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableQty2;

    @FXML
    private TableColumn<medicineData, String> purchaseTableDate2;

    @FXML
    private Button purchaseUpdateBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button reportCustomerBtn;

    @FXML
    private Button reportDistributorBtn;

    @FXML
    private Button reportPurchaseBtn;

    @FXML
    private Button reportSaleBtn;

    @FXML
    private AnchorPane reportCustomerForm;

    @FXML
    private AnchorPane reportDistributorForm;

    @FXML
    private AnchorPane reportSaleForm;

    @FXML
    private AnchorPane reportPurchaseForm;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private DatePicker saleLastPicker;

    @FXML
    private DatePicker saleStartPicker;

    @FXML
    private Button saleReportBtn;

    @FXML
    private TextField saleReportTotal;

    @FXML
    private Button saleAddBtn;

    @FXML
    private TextField saleBatchNo;

    @FXML
    private TextField saleBatchNo1;

    @FXML
    private Button saleClearBtn;

    @FXML
    private Button saleGetTotal;

    @FXML
    private TextField saleCustomerAddress;

    @FXML
    private TextField saleCustomerCity;

    @FXML
    private TextField saleCustomerFirstName;

    @FXML
    private TextField saleCustomerGSTN;

    @FXML
    private TextField saleCustomerLastName;

    @FXML
    private TextField saleCustomerMobile;

    @FXML
    private TextField saleCustomerPincode;

    @FXML
    private TextField saleDPrice;

    @FXML
    private Button saleDeleteBtn;

    @FXML
    private TextField saleDiscount;

    @FXML
    private TextField saleExpiry;

    @FXML
    private ComboBox<String> saleGST;

    @FXML
    private ComboBox<String> saleGST1;

    @FXML
    private ImageView saleImage;

    @FXML
    private Button saleImportPrescriptionBtn;

    @FXML
    private TextField saleMRP;

    @FXML
    private TextField saleMedicineName;

    @FXML
    private TextField saleMedicineName1;

    @FXML
    private Button saleCustomerBtn;

    @FXML
    private Button salePayBtn;

    @FXML
    private Button salePrintReceiptBtn;

    @FXML
    private TextField saleQty;

    @FXML
    private TextField saleQty1;

    @FXML
    private TextField saleSearch;

    @FXML
    private TextField saleMedicineType;

    @FXML
    private TextField saleMedicineType1;

    @FXML
    private TextField saleBrandName;

    @FXML
    private TextField saleBrandName1;

    @FXML
    private TableView<saleData> saleTable;

    @FXML
    private TableColumn<saleData, String> saleTableAmount;

    @FXML
    private TableColumn<saleData, String> saleTableBatchNo;

    @FXML
    private TableColumn<saleData, String> saleTableBrandName;

    @FXML
    private TableColumn<saleData, String> saleTableGST;

    @FXML
    private TableColumn<saleData, String> saleTableMedicineName;

    @FXML
    private TableColumn<saleData, String> saleTableMedicineType;

    @FXML
    private TableColumn<saleData, String> saleTableQty;

    @FXML
    private TableColumn<saleData, String> saleTableDate;

    @FXML
    private TableView<saleData> saleTable1;

    @FXML
    private TableColumn<saleData, String> saleTableAmount1;

    @FXML
    private TableColumn<saleData, String> saleTableBatchNo1;

    @FXML
    private TableColumn<saleData, String> saleTableBrandName1;

    @FXML
    private TableColumn<saleData, String> saleTableGST1;

    @FXML
    private TableColumn<saleData, String> saleTableMedicineName1;

    @FXML
    private TableColumn<saleData, String> saleTableMedicineType1;

    @FXML
    private TableColumn<saleData, String> saleTableQty1;

    @FXML
    private TableColumn<saleData, String> saleTableDate1;

    @FXML
    private TableView<saleData> saleTable2;

    @FXML
    private TableColumn<saleData, String> saleTableAmount2;

    @FXML
    private TableColumn<saleData, String> saleTableBatchNo2;

    @FXML
    private TableColumn<saleData, String> saleTableBrandName2;

    @FXML
    private TableColumn<saleData, String> saleTableGST2;

    @FXML
    private TableColumn<saleData, String> saleTableMedicineName2;

    @FXML
    private TableColumn<saleData, String> saleTableMedicineType2;

    @FXML
    private TableColumn<saleData, String> saleTableQty2;

    @FXML
    private TableColumn<saleData, String> saleTableDate2;

    @FXML
    private TextField saleTotal;

    @FXML
    private TextField saleTotal1;

    @FXML
    private TextField saleTotal2;

    @FXML
    private TextField saleUnit;

    @FXML
    private TextField saleUnit1;

    @FXML
    private Button saleUpdateBtn;

    @FXML
    private Label saleFinalLabel;

    @FXML
    private AreaChart<?, ?> homeAreaChart;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private Connection connect;
    private PreparedStatement prepare;
    private java.sql.Statement statement;
    private ResultSet result;

    public void addMedicineAdd() {
        String sql = "INSERT INTO purchase"
                + "(Distributor, BatchNo, ExpiryDate, MedicineName, BrandName, MedicineType, MRP,RetailPrice, SupplierPrice, Qty, Discount, GST,date)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (purchaseDistributor.getSelectionModel().getSelectedItem() == null
                    || purchaseBatchNo.getText().isEmpty()
                    || purchaseExpiryNo.getValue() == null
                    || purchaseMedicineName.getText().isEmpty()
                    || purchaseBrandName.getText().isEmpty()
                    || purchaseMedicineType.getSelectionModel().getSelectedItem() == null
                    || purchaseMRP.getText().isEmpty()
                    || purchaseRetailPrice.getText().isEmpty()
                    || purchaseSupplierPrice.getText().isEmpty()
                    || purchaseQty.getText().isEmpty()
                    || purchaseDiscount.getText().isEmpty()
                    || purchaseGST.getSelectionModel().getSelectedItem() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all Blank fields");
                alert.showAndWait();
            } else {

                String checkData = "SELECT * FROM purchase WHERE BatchNo = '" +
                        purchaseBatchNo.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Batch No." + purchaseBatchNo.getText() + "was already exists");

                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, (String) purchaseDistributor.getSelectionModel().getSelectedItem());
                    prepare.setString(2, purchaseBatchNo.getText());

                    prepare.setString(3, String.valueOf(purchaseExpiryNo.getValue()));

                    prepare.setString(4, purchaseMedicineName.getText());
                    prepare.setString(5, purchaseBrandName.getText());
                    prepare.setString(6, (String) purchaseMedicineType.getSelectionModel().getSelectedItem());
                    prepare.setString(7, purchaseMRP.getText());
                    prepare.setString(8, purchaseRetailPrice.getText());
                    prepare.setString(9, purchaseSupplierPrice.getText());
                    prepare.setString(10, purchaseQty.getText());
                    prepare.setString(11, purchaseDiscount.getText());
                    prepare.setString(12, (String) purchaseGST.getSelectionModel().getSelectedItem());
                    LocalDate date = LocalDate.now();
                    String date1 = date.toString();
                    prepare.setString(13, date1);

                    prepare.executeUpdate();
                    addMedicinesShowListData();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] addMedicineDistributorT = { "Suresh Singh", "Ramesh Kumar", "Prithvi das", "Akash Gawahne",
            "Rohan chaugale", "Reddy iyer", "Pardeep Singh", "Swapnil Thakur", "Jatin sharma", "Aarush Bhola",
            "Riddhi Singh", "Omsai das", "Dogra Singh", "Samarth addarsh" };

    public void addMedicineDistributorType() {
        List<String> list = new ArrayList<>();
        for (String s : addMedicineDistributorT) {
            list.add(s);
        }
        ObservableList listData = FXCollections.observableArrayList(list);
        purchaseDistributor.setItems(listData);
        inventoryDistributor.setItems(listData);

    }

    private String[] addMedicineT = { "Capsule", "Lotion", "Tablets", "Syrup", "Cream", "Syringe", "Injection",
            "Other" };

    public void addMedicineType() {
        List<String> list = new ArrayList<>();
        for (String s : addMedicineT) {
            list.add(s);
        }
        ObservableList listData = FXCollections.observableArrayList(list);
        purchaseMedicineType.setItems(listData);
        inventoryMedicineType.setItems(listData);
    }

    private String[] addMedicineGST = { "18", "15", "12", "28" };

    public void addMedicineTypeGST() {
        List<String> list = new ArrayList<>();
        for (String s : addMedicineGST) {
            list.add(s);
        }
        ObservableList listData = FXCollections.observableArrayList(list);
        inventoryGST.setItems(listData);
        purchaseGST.setItems(listData);
    }

    public void addMedicineSearch() {

        FilteredList<medicineData> filter = new FilteredList<>(addMedicineList, e -> true);

        purchaseSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMedicineData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateMedicineData.getBatchNo().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMedicineName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getDistributor().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getGST().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getExpiryDate().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMRP().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getDiscount().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getRetailPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getSupplierPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getQty().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMedicineType().toLowerCase().contains(searchKey)) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<medicineData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(purchaseTable.comparatorProperty());
        purchaseTable.setItems(sortList);

    }

    public ObservableList<medicineData> addMedicinesListData() {
        String sql = "SELECT * FROM purchase";
        ObservableList<medicineData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            medicineData medData;
            while (result.next()) {
                medData = new medicineData(
                        result.getString("Distributor"),
                        result.getInt("BatchNo"),
                        result.getDate("ExpiryDate"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getDouble("MRP"),
                        result.getDouble("RetailPrice"),
                        result.getDouble("SupplierPrice"),
                        result.getInt("Qty"),
                        result.getDouble("Discount"),
                        result.getString("GST"),
                        result.getDate("date"));
                listData.add(medData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<medicineData> addMedicineList;

    public void addMedicinesShowListData() {
        addMedicineList = addMedicinesListData();

        purchaseTableDistributor.setCellValueFactory(new PropertyValueFactory<>("Distributor"));
        purchaseTableBatchNo.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        purchaseTableExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        purchaseTableMedicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        purchaseTableBrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        purchaseTableMedicineType.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        purchaseTableMRP.setCellValueFactory(new PropertyValueFactory<>("MRP"));
        purchaseTablePTR.setCellValueFactory(new PropertyValueFactory<>("RetailPrice"));
        purchaseTablePTS.setCellValueFactory(new PropertyValueFactory<>("SupplierPrice"));
        purchaseTableQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        purchaseTableDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        purchaseTableGST.setCellValueFactory(new PropertyValueFactory<>("GST"));
        purchaseTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        purchaseTable.setItems(addMedicineList);
    }

    public void addMedicineSelect() {
        medicineData medData = purchaseTable.getSelectionModel().getSelectedItem();
        int num = purchaseTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        purchaseBatchNo.setText(String.valueOf(medData.getBatchNo()));
        String a = String.valueOf(medData.getExpiryDate());
        LocalDate b = LocalDate.parse(a);
        purchaseExpiryNo.setValue(b);
        purchaseMedicineName.setText(medData.getMedicineName());
        purchaseBrandName.setText(medData.getBrandName());
        purchaseMRP.setText(String.valueOf(medData.getMRP()));
        purchaseRetailPrice.setText(String.valueOf(medData.getRetailPrice()));
        purchaseSupplierPrice.setText(String.valueOf(medData.getSupplierPrice()));
        purchaseQty.setText(String.valueOf(medData.getQty()));
        purchaseDiscount.setText(String.valueOf(medData.getDiscount()));
        purchaseDistributor.setPromptText(String.valueOf(medData.getDistributor()));
        purchaseMedicineType.setPromptText(String.valueOf(medData.getMedicineType()));
        purchaseGST.setPromptText(String.valueOf(medData.getGST()));

    }

    public void addMedicinesShowListData1() {
        addMedicineList = addMedicinesListData();

        purchaseTableDistributor1.setCellValueFactory(new PropertyValueFactory<>("Distributor"));
        purchaseTableBatchNo1.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        purchaseTableExpiryDate1.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        purchaseTableMedicineName1.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        purchaseTableBrandName1.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        purchaseTableMedicineType1.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        purchaseTableMRP1.setCellValueFactory(new PropertyValueFactory<>("MRP"));
        purchaseTablePTR1.setCellValueFactory(new PropertyValueFactory<>("RetailPrice"));
        purchaseTablePTS1.setCellValueFactory(new PropertyValueFactory<>("SupplierPrice"));
        purchaseTableQty1.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        purchaseTableDiscount1.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        purchaseTableGST1.setCellValueFactory(new PropertyValueFactory<>("GST"));
        purchaseTableDate1.setCellValueFactory(new PropertyValueFactory<>("date"));

        purchaseTable1.setItems(addMedicineList);
    }

    public void addMedicineSelect1() {
        medicineData medData = purchaseTable1.getSelectionModel().getSelectedItem();
        int num = purchaseTable1.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        saleBatchNo.setText(String.valueOf(medData.getBatchNo()));
        saleExpiry.setText(String.valueOf(medData.getExpiryDate()));
        // String a = String.valueOf(medData.getExpiryDate());
        // LocalDate b = LocalDate.parse(a);
        // saleExpiry.setValue(b);
        saleMedicineName.setText(medData.getMedicineName());
        saleBrandName.setText(medData.getBrandName());
        saleMedicineType.setText(medData.getMedicineType());
        saleMRP.setText(String.valueOf(medData.getMRP()));
        saleUnit.setText(String.valueOf(medData.getSupplierPrice()));
        saleGST.setPromptText(String.valueOf(medData.getGST()));

    }

    public ObservableList<medicineData> addMedicinesListData2() {
        String sql = "SELECT * FROM purchase";
        ObservableList<medicineData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            medicineData medData;
            while (result.next()) {
                medData = new medicineData(
                        result.getString("Distributor"),
                        result.getInt("BatchNo"),
                        result.getDate("ExpiryDate"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getDouble("MRP"),
                        result.getDouble("RetailPrice"),
                        result.getDouble("SupplierPrice"),
                        result.getInt("Qty"),
                        result.getDouble("Discount"),
                        result.getString("GST"),
                        result.getDate("date"));
                listData.add(medData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<medicineData> addMedicineList2;

    public void addMedicinesShowListData2() {
        addMedicineList2 = addMedicinesListData2();

        purchaseTableDistributor2.setCellValueFactory(new PropertyValueFactory<>("Distributor"));
        purchaseTableBatchNo2.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        purchaseTableExpiryDate2.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        purchaseTableMedicineName2.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        purchaseTableBrandName2.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        purchaseTableMedicineType2.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        purchaseTableMRP2.setCellValueFactory(new PropertyValueFactory<>("MRP"));
        purchaseTablePTR2.setCellValueFactory(new PropertyValueFactory<>("RetailPrice"));
        purchaseTablePTS2.setCellValueFactory(new PropertyValueFactory<>("SupplierPrice"));
        purchaseTableQty2.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        purchaseTableDiscount2.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        purchaseTableGS2.setCellValueFactory(new PropertyValueFactory<>("GST"));
        purchaseTableDate2.setCellValueFactory(new PropertyValueFactory<>("date"));

        purchaseTable2.setItems(addMedicineList2);
    }

    private double totalPurchase;

    public void addPurchaseResult() {
        LocalDate a;
        LocalDate b;
        a = purchaseStartPicker.getValue();
        b = purchaseLastPicker.getValue();

        String sql = "SELECT * FROM purchase where date >= '" + a + "' AND date <= '" + b + "'";
        ObservableList<medicineData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            medicineData medData;
            while (result.next()) {
                medData = new medicineData(
                        result.getString("Distributor"),
                        result.getInt("BatchNo"),
                        result.getDate("ExpiryDate"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getDouble("MRP"),
                        result.getDouble("RetailPrice"),
                        result.getDouble("SupplierPrice"),
                        result.getInt("Qty"),
                        result.getDouble("Discount"),
                        result.getString("GST"),
                        result.getDate("date"));
                listData.add(medData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql1 = "SELECT SUM(RetailPrice) FROM purchase where date >= '" + a + "' AND date <= '" + b + "'";

        try {
            prepare = connect.prepareStatement(sql1);
            result = prepare.executeQuery();

            if (result.next()) {
                totalPurchase = result.getDouble("SUM(RetailPrice)");
            }
            purchaseReportTotal.setText(String.valueOf(totalPurchase));

        } catch (Exception e) {
            e.printStackTrace();
        }

        purchaseTable2.setItems(listData);
    }

    public void addMedicineUpdate() {

        String sql = "UPDATE purchase SET Distributor = '"
                + purchaseDistributor.getSelectionModel().getSelectedItem() + "', ExpiryDate = '"
                + purchaseExpiryNo.getValue() + "', MedicineName = '"
                + purchaseMedicineName.getText() + "', MedicineType = '"
                + purchaseMedicineType.getSelectionModel().getSelectedItem() + "', BrandName = '"
                + purchaseBrandName.getText() + "', MRP = '" + purchaseMRP.getText() + "', RetailPrice = '"
                + purchaseRetailPrice.getText() + "', SupplierPrice = '" + purchaseSupplierPrice.getText()
                + "', Qty = '"
                + purchaseQty.getText() + "', Discount = '" + purchaseDiscount.getText() + "', GST = '"
                + purchaseGST.getSelectionModel().getSelectedItem() + "' WHERE BatchNo = '"
                + purchaseBatchNo.getText() + "'";
        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Medicine ID:" + purchaseBatchNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                addMedicinesShowListData();
                clearPurchaseForm();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addMedicineDelete() {

        String sql = "DELETE FROM purchase WHERE BatchNo = '" + purchaseBatchNo.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Medicine ID:" + purchaseBatchNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

                addMedicinesShowListData();
                clearPurchaseForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearPurchaseForm() {
        purchaseBatchNo.clear();
        purchaseBrandName.clear();
        purchaseExpiryNo.setValue(null);
        purchaseMedicineName.clear();
        purchaseDistributor.getSelectionModel().clearSelection();
        purchaseGST.getSelectionModel().clearSelection();
        purchaseMRP.clear();
        purchaseRetailPrice.clear();
        purchaseSupplierPrice.clear();
        purchaseQty.clear();
        purchaseDiscount.clear();
    }

    public void addDistributorAdd() {
        String sql = "INSERT INTO distributor(GSTIN, Name, DrugNo, BankName, BankAccount, IFSCCode, Email, Mobile, Address, Description,date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (distributorGSTIN.getText().isEmpty()
                    || distributorName.getText().isEmpty()
                    || distributorDrugLicenseNo.getText().isEmpty()
                    || distributorBankName.getText().isEmpty()
                    || distributorBankAccount.getText().isEmpty()
                    || distributorIFSCCode.getText().isEmpty()
                    || distributorEmail.getText().isEmpty()
                    || distributorMobile.getText().isEmpty()
                    || distributorAddress.getText().isEmpty()
                    || distributorDescription.getText().isEmpty())

            {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all Blank fields");
                alert.showAndWait();
            } else {

                String checkData = "SELECT * FROM distributor WHERE GSTIN = '" +
                        distributorGSTIN.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("GSTIN No." + distributorGSTIN.getText() + "was already exists");

                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, distributorGSTIN.getText());
                    prepare.setString(2, distributorName.getText());
                    prepare.setString(3, distributorDrugLicenseNo.getText());
                    prepare.setString(4, distributorBankName.getText());
                    prepare.setString(5, distributorBankAccount.getText());
                    prepare.setString(6, distributorIFSCCode.getText());
                    prepare.setString(7, distributorEmail.getText());
                    prepare.setString(8, distributorMobile.getText());
                    prepare.setString(9, distributorAddress.getText());
                    prepare.setString(10, distributorDescription.getText());
                    LocalDate date = LocalDate.now();
                    String date1 = date.toString();
                    prepare.setString(11, date1);
                    prepare.executeUpdate();
                    addDistributorShowListData();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<distributorData> addDistributorListData() {
        String sql = "SELECT * FROM distributor";
        ObservableList<distributorData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            distributorData disData;
            while (result.next()) {
                disData = new distributorData(
                        result.getString("GSTIN"),
                        result.getString("Name"),
                        result.getString("DrugNo"),
                        result.getString("BankName"),
                        result.getString("BankAccount"),
                        result.getString("IFSCCode"),
                        result.getString("Email"),
                        result.getString("Mobile"),
                        result.getString("Address"),
                        result.getString("Description"),
                        result.getDate("date"));
                listData.add(disData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<distributorData> addDistributorList;

    public void addDistributorShowListData() {
        addDistributorList = addDistributorListData();

        distributorTableGGSTIN.setCellValueFactory(new PropertyValueFactory<>("GSTIN"));
        distributorTableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        distributorTableDrugLicenseNo.setCellValueFactory(new PropertyValueFactory<>("DrugNo"));
        distributorTableBankName.setCellValueFactory(new PropertyValueFactory<>("BankName"));
        distributorTableBankAccount.setCellValueFactory(new PropertyValueFactory<>("BankAccount"));
        distributorTableIFSCCode.setCellValueFactory(new PropertyValueFactory<>("IFSCCode"));
        distributorTableEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        distributorTableMobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        distributorTableAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        distributorTableDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        distributorTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        distributorTable.setItems(addDistributorList);

    }

    public void addDistributorSelect() {
        distributorData disData = distributorTable.getSelectionModel().getSelectedItem();
        int num = distributorTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        distributorGSTIN.setText(disData.getGSTIN());
        distributorName.setText(disData.getName());
        distributorDrugLicenseNo.setText(disData.getDrugNo());
        distributorBankName.setText(disData.getBankName());
        distributorBankAccount.setText(disData.getBankAccount());
        distributorIFSCCode.setText(disData.getIFSCCode());
        distributorEmail.setText(disData.getEmail());
        distributorMobile.setText(disData.getMobile());
        distributorAddress.setText(disData.getAddress());
        distributorDescription.setText(disData.getDescription());

    }

    public ObservableList<distributorData> addDistributorListData1() {
        String sql = "SELECT * FROM distributor";
        ObservableList<distributorData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            distributorData disData;
            while (result.next()) {
                disData = new distributorData(
                        result.getString("GSTIN"),
                        result.getString("Name"),
                        result.getString("DrugNo"),
                        result.getString("BankName"),
                        result.getString("BankAccount"),
                        result.getString("IFSCCode"),
                        result.getString("Email"),
                        result.getString("Mobile"),
                        result.getString("Address"),
                        result.getString("Description"),
                        result.getDate("date"));
                listData.add(disData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<distributorData> addDistributorList1;

    public void addDistributorShowListData1() {
        addDistributorList1 = addDistributorListData1();

        distributorTableGGSTIN1.setCellValueFactory(new PropertyValueFactory<>("GSTIN"));
        distributorTableName1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        distributorTableDrugLicenseNo1.setCellValueFactory(new PropertyValueFactory<>("DrugNo"));
        distributorTableBankName1.setCellValueFactory(new PropertyValueFactory<>("BankName"));
        distributorTableBankAccount1.setCellValueFactory(new PropertyValueFactory<>("BankAccount"));
        distributorTableIFSCCode1.setCellValueFactory(new PropertyValueFactory<>("IFSCCode"));
        distributorTableEmail1.setCellValueFactory(new PropertyValueFactory<>("Email"));
        distributorTableMobile1.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        distributorTableAddress1.setCellValueFactory(new PropertyValueFactory<>("Address"));
        distributorTableDescription1.setCellValueFactory(new PropertyValueFactory<>("Description"));
        distributorTableDate1.setCellValueFactory(new PropertyValueFactory<>("date"));

        distributorTable1.setItems(addDistributorList1);

    }

    private int totalDistributor;

    public void addDistributorResult() {
        LocalDate a;
        LocalDate b;
        a = distributorStartPicker.getValue();
        b = distributorLastPicker.getValue();

        String sql = "SELECT * FROM distributor where date >= '" + a + "' AND date <= '" + b + "'";
        ObservableList<distributorData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            distributorData disData;
            while (result.next()) {
                disData = new distributorData(
                        result.getString("GSTIN"),
                        result.getString("Name"),
                        result.getString("DrugNo"),
                        result.getString("BankName"),
                        result.getString("BankAccount"),
                        result.getString("IFSCCode"),
                        result.getString("Email"),
                        result.getString("Mobile"),
                        result.getString("Address"),
                        result.getString("Description"),
                        result.getDate("date"));
                listData.add(disData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql1 = "SELECT COUNT(*) FROM distributor where date >= '" + a + "' AND date <= '" + b + "'";

        try {
            prepare = connect.prepareStatement(sql1);
            result = prepare.executeQuery();

            if (result.next()) {
                totalDistributor = result.getInt("COUNT(*)");
            }
            distributorReportTotal.setText(String.valueOf(totalDistributor));

        } catch (Exception e) {
            e.printStackTrace();
        }

        distributorTable1.setItems(listData);

    }

    public void addDistributorSearch() {

        FilteredList<distributorData> filter = new FilteredList<>(addDistributorList, e -> true);

        distributorSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateDistributorData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateDistributorData.getGSTIN().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getDrugNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getBankName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getBankAccount().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getIFSCCode().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getMobile().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateDistributorData.getDescription().toLowerCase().contains(searchKey)) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<distributorData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(distributorTable.comparatorProperty());
        distributorTable.setItems(sortList);

    }

    public void addDistributorUpdate() {

        String sql = "UPDATE distributor SET Name = '"
                + distributorName.getText() + "', DrugNo = '" + distributorDrugLicenseNo.getText() + "', BankName = '"
                + distributorBankName.getText() + "', BankAccount = '" + distributorBankAccount.getText()
                + "', IFSCCode = '"
                + distributorIFSCCode.getText() + "', Email = '" + distributorEmail.getText() + "', Mobile = '"
                + distributorMobile.getText() + "', Address = '" + distributorAddress.getText() + "', Description = '"
                + distributorDescription.getText() + "' WHERE GSTIN = '"
                + distributorGSTIN.getText() + "'";
        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Medicine ID:" + distributorGSTIN.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                addDistributorShowListData();
                clearDistributorForm();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addDistributorDelete() {

        String sql = "DELETE FROM distributor WHERE GSTIN = '" + distributorGSTIN.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Medicine ID:" + distributorGSTIN.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

                addDistributorShowListData();
                clearDistributorForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearDistributorForm() {
        distributorGSTIN.setText("");
        distributorName.setText("");
        distributorDrugLicenseNo.setText("");
        distributorBankName.setText("");
        distributorBankAccount.setText("");
        distributorIFSCCode.setText("");
        distributorEmail.setText("");
        distributorMobile.setText("");
        distributorAddress.setText("");
        distributorDescription.setText("");
    }

    public void addCustomerAdd() {
        String sql = "INSERT INTO `customer`(MobileNo, FirstName, Lastname, Address, City, Pincode, GSTN,date) VALUES (?,?,?,?,?,?,?,?)";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (customerMobileNo.getText().isEmpty()
                    || customerFirstName.getText().isEmpty()
                    || customerLastName.getText().isEmpty()
                    || customerAddress.getText().isEmpty()
                    || customerCity.getText().isEmpty()
                    || customerPincode.getText().isEmpty()
                    || customerGSTN.getText().isEmpty())

            {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all Blank fields");
                alert.showAndWait();
            } else {

                String checkData = "SELECT * FROM customer WHERE MobileNo = '" +
                        distributorGSTIN.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Mobile No." + distributorGSTIN.getText() + "was already exists");

                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, customerMobileNo.getText());
                    prepare.setString(2, customerFirstName.getText());
                    prepare.setString(3, customerLastName.getText());
                    prepare.setString(4, customerAddress.getText());
                    prepare.setString(5, customerCity.getText());
                    prepare.setString(6, customerPincode.getText());
                    prepare.setString(7, customerGSTN.getText());
                    LocalDate date = LocalDate.now();
                    String date1 = date.toString();
                    prepare.setString(8, date1);

                    prepare.executeUpdate();
                    addCustomerShowListData();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<customerData> addCustomerListData() {
        String sql = "SELECT * FROM customer";
        ObservableList<customerData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            customerData cusData;
            while (result.next()) {
                cusData = new customerData(
                        result.getString("MobileNo"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Address"),
                        result.getString("City"),
                        result.getString("Pincode"),
                        result.getString("GSTN"),
                        result.getDate("date"));

                listData.add(cusData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<customerData> addCustomerList;

    public void addCustomerShowListData() {
        addCustomerList = addCustomerListData();

        customerTableMobileNo.setCellValueFactory(new PropertyValueFactory<>("MobileNo"));
        customerTableFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        customerTableLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        customerTableAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customerTableCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        customerTablePincode.setCellValueFactory(new PropertyValueFactory<>("Pincode"));
        customerTableGSTN.setCellValueFactory(new PropertyValueFactory<>("GSTN"));
        customerTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        customerTable.setItems(addCustomerList);

    }

    public void addCustomerSelect() {
        customerData cusData = customerTable.getSelectionModel().getSelectedItem();
        int num = customerTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        customerMobileNo.setText(cusData.getMobileNo());
        customerFirstName.setText(cusData.getFirstName());
        customerLastName.setText(cusData.getLastName());
        customerAddress.setText(cusData.getAddress());
        customerCity.setText(cusData.getCity());
        customerPincode.setText(cusData.getPincode());
        customerGSTN.setText(cusData.getGSTN());

    }

    public ObservableList<customerData> addCustomerListData1() {

        String sql = "SELECT * FROM customer ";
        ObservableList<customerData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            customerData cusData;
            while (result.next()) {
                cusData = new customerData(
                        result.getString("MobileNo"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Address"),
                        result.getString("City"),
                        result.getString("Pincode"),
                        result.getString("GSTN"),
                        result.getDate("date"));

                listData.add(cusData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<customerData> addCustomerList1;

    public void addCustomerShowListData1() {
        addCustomerList1 = addCustomerListData1();

        customerTableMobileNo1.setCellValueFactory(new PropertyValueFactory<>("MobileNo"));
        customerTableFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        customerTableLastName1.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        customerTableAddress1.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customerTableCity1.setCellValueFactory(new PropertyValueFactory<>("City"));
        customerTablePincode1.setCellValueFactory(new PropertyValueFactory<>("Pincode"));
        customerTableGSTN1.setCellValueFactory(new PropertyValueFactory<>("GSTN"));
        customerTableDate1.setCellValueFactory(new PropertyValueFactory<>("date"));

        customerTable1.setItems(addCustomerList1);

    }

    private int totalCustomer;

    public void addCustomerResult() {
        LocalDate a;
        LocalDate b;
        a = customerStartPicker.getValue();
        b = customerLastPicker.getValue();

        String sql = "SELECT * FROM customer where date >= '" + a + "' AND date <= '" + b + "'";
        ObservableList<customerData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            customerData cusData;
            while (result.next()) {
                cusData = new customerData(
                        result.getString("MobileNo"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Address"),
                        result.getString("City"),
                        result.getString("Pincode"),
                        result.getString("GSTN"),
                        result.getDate("date"));

                listData.add(cusData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql1 = "SELECT COUNT(*) FROM customer where date >= '" + a + "' AND date <= '" + b + "'";

        try {
            prepare = connect.prepareStatement(sql1);
            result = prepare.executeQuery();

            if (result.next()) {
                totalCustomer = result.getInt("COUNT(*)");
            }
            customerReportTotal.setText(String.valueOf(totalCustomer));

        } catch (Exception e) {
            e.printStackTrace();
        }

        customerTable1.setItems(listData);
    }

    public void addCustomerSearch() {

        FilteredList<customerData> filter = new FilteredList<>(addCustomerList, e -> true);

        customerSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCustomerData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCustomerData.getMobileNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomerData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomerData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomerData.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomerData.getCity().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomerData.getGSTN().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomerData.getPincode().toLowerCase().contains(searchKey)) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<customerData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(customerTable.comparatorProperty());
        customerTable.setItems(sortList);

    }

    public void addCustomerUpdate() {

        String sql = "UPDATE customer SET FirstName = '"
                + customerFirstName.getText() + "', LastName = '" + customerLastName.getText() + "', Address = '"
                + customerAddress.getText() + "', City = '" + customerCity.getText() + "', PinCode = '"
                + customerPincode.getText() + "', GSTN = '" + customerGSTN.getText() + "' WHERE MobileNo = '"
                + customerMobileNo.getText() + "'";
        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Medicine ID:" + customerMobileNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                addCustomerShowListData();
                clearCustomerForm();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addCustomerDelete() {

        String sql = "DELETE FROM customer WHERE MobileNo = '" + customerMobileNo.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Medicine ID:" + customerMobileNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();

                addCustomerShowListData();
                clearCustomerForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearCustomerForm() {
        customerFirstName.setText("");
        customerLastName.setText("");
        customerAddress.setText("");
        customerCity.setText("");
        customerPincode.setText("");
        customerGSTN.setText("");
        customerMobileNo.setText("");
    }

    public ObservableList<medicineData> addInventoryListData() {
        String sql = "SELECT * FROM purchase";
        ObservableList<medicineData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            medicineData medData;
            while (result.next()) {
                medData = new medicineData(
                        result.getString("Distributor"),
                        result.getInt("BatchNo"),
                        result.getDate("ExpiryDate"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getDouble("MRP"),
                        result.getDouble("RetailPrice"),
                        result.getDouble("SupplierPrice"),
                        result.getInt("Qty"),
                        result.getDouble("Discount"),
                        result.getString("GST"),
                        result.getDate("date"));

                listData.add(medData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<medicineData> addInventoryList;

    public void addInventoryShowListData() {
        addInventoryList = addInventoryListData();

        inventoryTableDistributor.setCellValueFactory(new PropertyValueFactory<>("Distributor"));
        inventoryTableBatchNo.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        inventoryTableExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        inventoryTableMedicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        inventoryTableBrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        inventoryTableMedicineType.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        inventoryTableMRP.setCellValueFactory(new PropertyValueFactory<>("MRP"));
        inventoryTableRetailPrice.setCellValueFactory(new PropertyValueFactory<>("RetailPrice"));
        inventoryTableSupplierPrice.setCellValueFactory(new PropertyValueFactory<>("SupplierPrice"));
        inventoryTableQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        inventoryTableDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        inventoryTableGST.setCellValueFactory(new PropertyValueFactory<>("GST"));
        inventoryTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        inventoryTable.setItems(addInventoryList);

    }

    public void addInventorySelect() {
        medicineData medData = inventoryTable.getSelectionModel().getSelectedItem();
        int num = inventoryTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        inventoryBatchNo.setText(String.valueOf(medData.getBatchNo()));
        String a = String.valueOf(medData.getExpiryDate());
        LocalDate b = LocalDate.parse(a);
        inventoryExpiryDate.setValue(b);
        inventoryMedicineName.setText(medData.getMedicineName());
        inventoryBrandName.setText(medData.getBrandName());
        inventoryMRP.setText(String.valueOf(medData.getMRP()));
        purchaseRetailPrice.setText(String.valueOf(medData.getRetailPrice()));
        inventorySupplierPrice.setText(String.valueOf(medData.getSupplierPrice()));
        inventoryQty.setText(String.valueOf(medData.getQty()));
        inventoryDiscount.setText(String.valueOf(medData.getDiscount()));
        inventoryDistributor.setPromptText(String.valueOf(medData.getDistributor()));
        inventoryMedicineType.setPromptText(String.valueOf(medData.getMedicineType()));
        inventoryGST.setPromptText(String.valueOf(medData.getGST()));

    }

    public void addInventorySearch() {

        FilteredList<medicineData> filter = new FilteredList<>(addMedicineList, e -> true);

        inventorySearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMedicineData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateMedicineData.getBatchNo().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMedicineName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getDistributor().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getGST().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getExpiryDate().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMRP().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getDiscount().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getRetailPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getSupplierPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getQty().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMedicineType().toLowerCase().contains(searchKey)) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<medicineData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(inventoryTable.comparatorProperty());
        inventoryTable.setItems(sortList);

    }

    public void addInventoryUpdate() {

        String sql = "UPDATE purchase SET Distributor = '"
                + inventoryDistributor.getSelectionModel().getSelectedItem() + "', ExpiryDate = '"
                + inventoryExpiryDate.getValue() + "', MedicineName = '"
                + inventoryMedicineName.getText() + "', MedicineType = '"
                + inventoryMedicineType.getSelectionModel().getSelectedItem() + "', BrandName = '"
                + inventoryBrandName.getText() + "', MRP = '" + inventoryMRP.getText() + "', RetailPrice = '"
                + inventoryRetailPrice.getText() + "', SupplierPrice = '" + inventorySupplierPrice.getText()
                + "', Qty = '"
                + inventoryQty.getText() + "', Discount = '" + inventoryDiscount.getText() + "', GST = '"
                + inventoryGST.getSelectionModel().getSelectedItem() + "' WHERE BatchNo = '"
                + inventoryBatchNo.getText() + "'";
        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Medicine ID:" + inventoryBatchNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                addMedicinesShowListData();
                addInventoryShowListData();
                clearInventoryForm();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addInventoryDelete() {

        String sql = "DELETE FROM purchase WHERE BatchNo = '" + inventoryBatchNo.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Medicine ID:" + inventoryBatchNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();
                addMedicinesShowListData();
                addInventoryShowListData();
                clearInventoryForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearInventoryForm() {
        inventoryBatchNo.clear();
        inventoryBrandName.clear();
        inventoryExpiryDate.setValue(null);
        inventoryMedicineName.clear();
        inventoryMRP.clear();
        inventoryQty.clear();
        inventoryRetailPrice.clear();
        inventorySupplierPrice.clear();
        inventoryDistributor.getSelectionModel().clearSelection();
        inventoryMedicineType.getSelectionModel().clearSelection();
        inventoryGST.getSelectionModel().clearSelection();
    }

    private String[] addSaleGST = { "18", "15", "12", "28" };

    public void addSaleTypeGST() {
        List<String> list = new ArrayList<>();
        for (String s : addSaleGST) {
            list.add(s);
        }
        ObservableList listData = FXCollections.observableArrayList(list);
        saleGST.setItems(listData);
        saleGST1.setItems(listData);

    }

    public void addSaleAdd() {
        String sql = "INSERT INTO cart" + "(BatchNo,MedicineName,BrandName, MedicineType,Qty,GST,Amount,date)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        String sql1 = "INSERT INTO sale" + "(BatchNo,MedicineName,BrandName, MedicineType,Qty,GST,Amount,date)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        String sql2 = "SELECT SUM(Amount) FROM cart";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (saleBatchNo.getText().isEmpty()
                    || saleMedicineName.getText().isEmpty()
                    || saleBrandName.getText().isEmpty()
                    || saleMedicineType.getText().isEmpty()
                    || saleQty.getText().isEmpty()
                    || saleTotal.getText().isEmpty()
                    || saleGST.getSelectionModel().getSelectedItem() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all Blank fields");
                alert.showAndWait();
            } else {

                String checkData = "SELECT * FROM cart WHERE BatchNo = '" +
                        purchaseBatchNo.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Batch No." + purchaseBatchNo.getText() + "was already exists");

                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, saleBatchNo.getText());
                    prepare.setString(2, saleMedicineName.getText());
                    prepare.setString(3, saleBrandName.getText());
                    prepare.setString(4, saleMedicineType.getText());
                    prepare.setString(5, saleQty.getText());
                    prepare.setString(6, (String) saleGST.getSelectionModel().getSelectedItem());
                    prepare.setString(7, saleTotal.getText());
                    LocalDate date = LocalDate.now();
                    String date1 = date.toString();
                    prepare.setString(8, date1);

                    prepare.executeUpdate();
                    addSaleShowListData();
                    saleFinalTotal();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            prepare = connect.prepareStatement(sql1);
            prepare.setString(1, saleBatchNo.getText());
            prepare.setString(2, saleMedicineName.getText());
            prepare.setString(3, saleBrandName.getText());
            prepare.setString(4, saleMedicineType.getText());
            prepare.setString(5, saleQty.getText());
            prepare.setString(6, (String) saleGST.getSelectionModel().getSelectedItem());
            prepare.setString(7, saleTotal.getText());
            LocalDate date = LocalDate.now();
            String date1 = date.toString();
            prepare.setString(8, date1);

            prepare.executeUpdate();
            addSaleShowListData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            prepare = connect.prepareStatement(sql2);
            result = prepare.executeQuery();

            if (result.next()) {
                finalTotal = result.getDouble("SUM(Amount)");
            }
            saleTotal1.setText(String.valueOf(finalTotal));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<saleData> addSaleListData() {
        String sql = "SELECT * FROM cart";
        ObservableList<saleData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            saleData sData;
            while (result.next()) {
                sData = new saleData(
                        result.getInt("BatchNo"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getInt("Qty"),
                        result.getString("GST"),
                        result.getDouble("Amount"),
                        result.getDate("date"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<saleData> addSaleList;

    public void addSaleShowListData() {
        addSaleList = addSaleListData();

        saleTableBatchNo.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        saleTableMedicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        saleTableBrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        saleTableMedicineType.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        saleTableQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        saleTableGST.setCellValueFactory(new PropertyValueFactory<>("GST"));
        saleTableAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        saleTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        saleTable.setItems(addSaleList);
    }

    public void addSaleSearch() {

        FilteredList<medicineData> filter = new FilteredList<>(addMedicineList, e -> true);

        saleSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMedicineData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateMedicineData.getBatchNo().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMedicineName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getBrandName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getDistributor().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getGST().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getExpiryDate().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMRP().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getDiscount().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getRetailPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getSupplierPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getQty().toString().contains(searchKey)) {
                    return true;
                } else if (predicateMedicineData.getMedicineType().toLowerCase().contains(searchKey)) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<medicineData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(purchaseTable1.comparatorProperty());
        purchaseTable1.setItems(sortList);

    }

    public void addSaleCustomerAdd() {
        String sql = "INSERT INTO `customer`(MobileNo, FirstName, Lastname, Address, City, Pincode, GSTN,date) VALUES (?,?,?,?,?,?,?,?)";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (saleCustomerMobile.getText().isEmpty()
                    || saleCustomerFirstName.getText().isEmpty()
                    || saleCustomerLastName.getText().isEmpty()
                    || saleCustomerAddress.getText().isEmpty()
                    || saleCustomerCity.getText().isEmpty()
                    || saleCustomerPincode.getText().isEmpty()
                    || saleCustomerGSTN.getText().isEmpty())

            {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all Blank fields");
                alert.showAndWait();
            } else {

                String checkData = "SELECT * FROM customer WHERE MobileNo = '" +
                        distributorGSTIN.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Mobile No." + distributorGSTIN.getText() + "was already exists");

                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, saleCustomerMobile.getText());
                    prepare.setString(2, saleCustomerFirstName.getText());
                    prepare.setString(3, saleCustomerLastName.getText());
                    prepare.setString(4, saleCustomerAddress.getText());
                    prepare.setString(5, saleCustomerCity.getText());
                    prepare.setString(6, saleCustomerPincode.getText());
                    prepare.setString(7, saleCustomerGSTN.getText());
                    LocalDate date = LocalDate.now();
                    String date1 = date.toString();
                    prepare.setString(8, date1);

                    prepare.executeUpdate();
                    addCustomerShowListData();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTotal() {

        double mrp = Double.parseDouble(saleMRP.getText().toString());
        double qty = Double.parseDouble(saleQty.getText().toString());
        double discount = Double.parseDouble(saleDiscount.getText().toString());
        double a = (1 - (discount / 100));
        System.out.println(a);
        double dprice = (mrp * qty) * a;
        saleDPrice.setText(String.valueOf(dprice));
        // String gst=saleGST.getSelectionModel().getSelectedItem();
        // int b=Integer.parseInt(gst);
        // System.out.println(gst);
        String c = String.valueOf(dprice);
        saleTotal.setText(c);
    }

    public void addSaleSelect() {
        saleData sData = saleTable.getSelectionModel().getSelectedItem();
        int num = saleTable.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        saleBatchNo.setText(String.valueOf(sData.getBatchNo()));
        // saleExpiry.setText(String.valueOf(sData.getExpiryDate()));
        // String a = String.valueOf(medData.getExpiryDate());
        // LocalDate b = LocalDate.parse(a);
        // saleExpiry.setValue(b);
        saleMedicineName.setText(sData.getMedicineName());
        saleBrandName.setText(sData.getBrandName());
        saleMedicineType.setText(sData.getMedicineType());
        // saleMRP.setText(String.valueOf(sData.getMRP()));
        // saleUnit.setText(String.valueOf(sData.getSupplierPrice()));
        saleGST.setPromptText(String.valueOf(sData.getGST()));

    }

    public void addSaleUpdate() {

        String sql = "UPDATE cart SET MedicineName = '"
                + saleMedicineName.getText() + "', MedicineType = '"
                + saleMedicineType.getText() + "', BrandName = '"
                + saleBrandName.getText() + "', Qty = '"
                + saleQty.getText() + "', Amount = '" + saleTotal.getText() + "', GST = '"
                + saleGST.getSelectionModel().getSelectedItem() + "' WHERE BatchNo = '"
                + saleBatchNo.getText() + "'";
        connect = Database.connectDb();

        String sql1 = "UPDATE sale SET MedicineName = '"
                + saleMedicineName.getText() + "', MedicineType = '"
                + saleMedicineType.getText() + "', BrandName = '"
                + saleBrandName.getText() + "', Qty = '"
                + saleQty.getText() + "', Amount = '" + saleTotal.getText() + "', GST = '"
                + saleGST.getSelectionModel().getSelectedItem() + "' WHERE BatchNo = '"
                + saleBatchNo.getText() + "'";
        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Medicine ID:" + saleBatchNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                addSaleShowListData();
                clearSaleForm();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connect.createStatement();
            statement.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addSaleDelete() {

        String sql = "DELETE FROM cart WHERE BatchNo = '" + saleBatchNo.getText() + "'";
        String sql1 = "DELETE FROM sale WHERE BatchNo = '" + saleBatchNo.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Medicine ID:" + saleBatchNo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();
                addSaleShowListData();
                clearSaleForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            statement = connect.createStatement();
            statement.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearSaleForm() {
        saleBatchNo.clear();
        saleMedicineName.clear();
        saleBrandName.clear();
        saleMedicineType.clear();
        saleQty.clear();
        saleGST.getSelectionModel().clearSelection();
        saleTotal.clear();
        saleUnit.clear();
        saleExpiry.clear();
        saleMRP.clear();
        saleDPrice.clear();
        saleDiscount.clear();
    }

    public ObservableList<saleData> addSaleListData1() {
        String sql = "SELECT * FROM sale";
        ObservableList<saleData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            saleData sData;
            while (result.next()) {
                sData = new saleData(
                        result.getInt("BatchNo"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getInt("Qty"),
                        result.getString("GST"),
                        result.getDouble("Amount"),
                        result.getDate("date"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<saleData> addSaleList1;

    public void addSaleShowListData1() {
        addSaleList1 = addSaleListData1();

        saleTableBatchNo1.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        saleTableMedicineName1.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        saleTableBrandName1.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        saleTableMedicineType1.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        saleTableQty1.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        saleTableGST1.setCellValueFactory(new PropertyValueFactory<>("GST"));
        saleTableAmount1.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        saleTableDate1.setCellValueFactory(new PropertyValueFactory<>("date"));

        saleTable1.setItems(addSaleList1);
    }

    private double totalSale;

    public void addSaleResult() {
        LocalDate a;
        LocalDate b;
        a = saleStartPicker.getValue();
        b = saleLastPicker.getValue();

        String sql = "SELECT * FROM sale where date >= '" + a + "' AND date <= '" + b + "'";
        ObservableList<saleData> listData = FXCollections.observableArrayList();

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            saleData sData;
            while (result.next()) {
                sData = new saleData(
                        result.getInt("BatchNo"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getInt("Qty"),
                        result.getString("GST"),
                        result.getDouble("Amount"),
                        result.getDate("date"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql1 = "SELECT SUM(Amount) FROM sale where date >= '" + a + "' AND date <= '" + b + "'";

        try {
            prepare = connect.prepareStatement(sql1);
            result = prepare.executeQuery();

            if (result.next()) {
                totalSale = result.getDouble("SUM(Amount)");
            }
            saleReportTotal.setText(String.valueOf(totalSale));

        } catch (Exception e) {
            e.printStackTrace();
        }

        saleTable1.setItems(listData);
    }

    private double finalTotal;

    public void saleFinalTotal() {

        // String sql = "SELECT SUM(Amount) FROM sale WHERE BatchNo =
        // '"+saleBatchNo+"'";
        String sql2 = "SELECT SUM(Amount) FROM cart";

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql2);
            result = prepare.executeQuery();

            if (result.next()) {
                finalTotal = result.getDouble("SUM(Amount)");
            }
            saleTotal2.setText(String.valueOf(finalTotal));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void finalPayBtn() {

        String sql1 = "DELETE FROM cart";
        connect = Database.connectDb();
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Done");
            alert.showAndWait();
            statement = connect.createStatement();
            statement.executeUpdate(sql1);
            addSaleList = addSaleListData();

            saleTableBatchNo.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
            saleTableMedicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
            saleTableBrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
            saleTableMedicineType.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
            saleTableQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
            saleTableGST.setCellValueFactory(new PropertyValueFactory<>("GST"));
            saleTableAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            saleTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            saleTable.setItems(addSaleList);
            saleTotal2.setText("");
            // saleFinalTotal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<saleData> addSaleListData2() {
        String sql = "SELECT * FROM sale";
        ObservableList<saleData> listData = FXCollections.observableArrayList();
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            saleData sData;
            while (result.next()) {
                sData = new saleData(
                        result.getInt("BatchNo"),
                        result.getString("MedicineName"),
                        result.getString("BrandName"),
                        result.getString("MedicineType"),
                        result.getInt("Qty"),
                        result.getString("GST"),
                        result.getDouble("Amount"),
                        result.getDate("date"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<saleData> addSaleList2;

    public void addSaleShowListData2() {
        addSaleList2 = addSaleListData2();

        saleTableBatchNo2.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        saleTableMedicineName2.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        saleTableBrandName2.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        saleTableMedicineType2.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        saleTableQty2.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        saleTableGST2.setCellValueFactory(new PropertyValueFactory<>("GST"));
        saleTableAmount2.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        saleTableDate2.setCellValueFactory(new PropertyValueFactory<>("date"));

        saleTable2.setItems(addSaleList2);
    }

    public void addSaleSelect2() {
        saleData sData = saleTable2.getSelectionModel().getSelectedItem();
        int num = saleTable2.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        saleBatchNo1.setText(String.valueOf(sData.getBatchNo()));
        // saleExpiry.setText(String.valueOf(sData.getExpiryDate()));
        // String a = String.valueOf(medData.getExpiryDate());
        // LocalDate b = LocalDate.parse(a);
        // saleExpiry.setValue(b);
        saleMedicineName1.setText(sData.getMedicineName());
        saleBrandName1.setText(sData.getBrandName());
        saleMedicineType1.setText(sData.getMedicineType());
        saleTotal1.setText(String.valueOf(sData.getAmount()));
        saleQty1.setText(String.valueOf(sData.getQty()));
        // saleMRP.setText(String.valueOf(sData.getMRP()));
        // saleUnit.setText(String.valueOf(sData.getSupplierPrice()));
        saleGST1.setPromptText(String.valueOf(sData.getGST()));

    }

    public void addSaleUpdate2() {

        String sql1 = "UPDATE sale SET MedicineName = '"
                + saleMedicineName1.getText() + "', MedicineType = '"
                + saleMedicineType1.getText() + "', BrandName = '"
                + saleBrandName1.getText() + "', Qty = '"
                + saleQty1.getText() + "', Amount = '" + saleTotal1.getText() + "', GST = '"
                + saleGST1.getSelectionModel().getSelectedItem() + "' WHERE BatchNo = '"
                + saleBatchNo1.getText() + "'";
        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Medicine ID:" + saleBatchNo1.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql1);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                addSaleShowListData2();
                clearSaleForm2();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSaleDelete2() {

        String sql = "DELETE FROM sale WHERE BatchNo = '" + saleBatchNo1.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Medicine ID:" + saleBatchNo1.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();
                addSaleShowListData2();
                clearSaleForm2();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearSaleForm2() {
        saleBatchNo1.clear();
        saleMedicineName1.clear();
        saleBrandName1.clear();
        saleMedicineType1.clear();
        saleQty1.clear();
        saleGST1.getSelectionModel().clearSelection();
        saleTotal1.clear();
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == navHomeBtn) {
            HomeForm.setVisible(true);
            SaleFormDetails.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            headerText.setText("Home");
            homeAreaChart();

        } else if (event.getSource() == navPurchaseBtn) {
            HomeForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            PurchaseForm.setVisible(true);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            headerText.setText("Purchase");

            addMedicinesShowListData();
            addMedicineDistributorType();
            addMedicineType();
            addMedicineTypeGST();
            addMedicineSearch();

        } else if (event.getSource() == homeAddPurchaseBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(true);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            headerText.setText("Purchase");

            addMedicinesShowListData();
            addMedicineDistributorType();
            addMedicineType();
            addMedicineTypeGST();
            addMedicineSearch();

        } else if (event.getSource() == navSaleBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(true);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            headerText.setText("Sale");
            addSaleShowListData();
            addSaleTypeGST();
            addSaleSearch();
            saleFinalTotal();

        } else if (event.getSource() == homeAddSaleBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(true);
            headerText.setText("Sale");
            addMedicinesShowListData1();
            addSaleShowListData2();
            addSaleTypeGST();
            // addSaleSearch();
            // saleFinalTotal();

        } else if (event.getSource() == navInvenotryBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(true);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            headerText.setText("Inventory");
            addInventoryShowListData();
            addMedicineDistributorType();
            addMedicineType();
            addMedicineTypeGST();
            addInventorySearch();
        } else if (event.getSource() == navCustomerBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(true);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            headerText.setText("Customer");

            addCustomerShowListData();
            addCustomerSearch();
        } else if (event.getSource() == navDistributorBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(true);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            headerText.setText("Distributor");
            addDistributorShowListData();
            addDistributorSearch();

        } else if (event.getSource() == homeAddDistributorBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(true);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            SaleFormDetails.setVisible(false);
            headerText.setText("Distributor");

            addDistributorShowListData();

        } else if (event.getSource() == navReportsBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(true);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(false);
            headerText.setText("Reports");
            SaleFormDetails.setVisible(false);
        } else if (event.getSource() == navDunzoBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(true);
            EclinicForm.setVisible(false);
            headerText.setText("Dunzo");
            SaleFormDetails.setVisible(false);
        } else if (event.getSource() == navClinicBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(true);
            SaleFormDetails.setVisible(false);
            headerText.setText("E-Clinic");
        } else if (event.getSource() == homeClinicBtn) {
            HomeForm.setVisible(false);
            PurchaseForm.setVisible(false);
            SaleForm.setVisible(false);
            InventoryForm.setVisible(false);
            CustomerForm.setVisible(false);
            DistributorForm.setVisible(false);
            ReportsForm.setVisible(false);
            DunzoForm.setVisible(false);
            EclinicForm.setVisible(true);
            SaleFormDetails.setVisible(false);
            headerText.setText("E-Clinic");
        } else if (event.getSource() == eClinicSubscribeBtn) {
            eclinicBookForm.setVisible(false);
            eclinicSubcribeForm.setVisible(true);
            eclinicReferForm.setVisible(false);

        } else if (event.getSource() == eClinicBookBtn) {
            eclinicBookForm.setVisible(true);
            eclinicSubcribeForm.setVisible(false);
            eclinicReferForm.setVisible(false);

        } else if (event.getSource() == eClinicReferBtn) {
            eclinicBookForm.setVisible(false);
            eclinicSubcribeForm.setVisible(false);
            eclinicReferForm.setVisible(true);

        } else if (event.getSource() == reportPurchaseBtn) {
            reportPurchaseForm.setVisible(true);
            reportSaleForm.setVisible(false);
            reportDistributorForm.setVisible(false);
            reportCustomerForm.setVisible(false);
            headerText.setText("Purchase Report");

        } else if (event.getSource() == reportSaleBtn) {
            reportPurchaseForm.setVisible(false);
            reportSaleForm.setVisible(true);
            reportDistributorForm.setVisible(false);
            reportCustomerForm.setVisible(false);
            headerText.setText("Sale Report");
            addSaleShowListData1();

        } else if (event.getSource() == reportDistributorBtn) {
            reportPurchaseForm.setVisible(false);
            reportSaleForm.setVisible(false);
            reportDistributorForm.setVisible(true);
            reportCustomerForm.setVisible(false);
            headerText.setText("Distributor Report");
            addDistributorShowListData1();

        } else if (event.getSource() == reportCustomerBtn) {
            reportPurchaseForm.setVisible(false);
            reportSaleForm.setVisible(false);
            reportDistributorForm.setVisible(false);
            reportCustomerForm.setVisible(true);
            headerText.setText("Customer Report");
            addCustomerShowListData1();

        }

    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                // HIDE THE DASHBOARD FORM
                navLogOutBtn.getScene().getWindow().hide();
                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        System.exit(0);
    }

    public void Successful() {
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Successfully");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SuccessfulBooked() {
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Booked");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void homeAreaChart() {
        String sql = "SELECT date, SUM(Amount) FROM sale"
                + " GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 9";

        connect = Database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            homeAreaChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] addSpecialist = { "General Physician", "Gynaecologist", "Dermatologist", "Dentist",
            "Pulmonary Disease", "Neonatology", "Homeopathy", "Opthalmology", "Diabetologist", "Gastroenterology",
            "Psychologist", "Urologist", "Sexologist", "Pediatrician" };

    public void addSpecialistType() {
        List<String> list = new ArrayList<>();
        for (String s : addSpecialist) {
            list.add(s);
        }
        ObservableList listData = FXCollections.observableArrayList(list);
        eclinicBookSelectSpecialist.setItems(listData);
    }

    // public void eClinicWhatsappBtn() {
    // openURL("https://api.whatsapp.com/send?phone=YOUR_PHONE_NUMBER&text=Hello");
    // }

    public void eClinicWhatsappBtn() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop()
                        .browse(new URI("https://api.whatsapp.com/send?phone=YOUR_PHONE_NUMBER&text=Hello"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported.");
        }
    }

    public void salereceipt() {
  Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLReceipt.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

                stage.setOpacity(.8);
            });

            root.setOnMouseReleased((MouseEvent event) -> {
                stage.setOpacity(1);
            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        addMedicinesShowListData();
        addMedicinesShowListData1();
        addMedicinesShowListData2();
        addMedicineType();
        addMedicineTypeGST();
        addMedicineSearch();
        addInventoryShowListData();
        addInventorySearch();
        addCustomerShowListData();
        addCustomerShowListData1();
        addCustomerSearch();
        addDistributorShowListData();
        addDistributorShowListData1();
        addDistributorSearch();
        addSaleShowListData();
        addSaleShowListData1();
        addSaleShowListData2();
        addSaleTypeGST();
        addSaleSearch();
        saleFinalTotal();
        homeAreaChart();
        addSpecialistType();

    }

}
