import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FXMLReceiptDocument implements Initializable{

    @FXML
    private TableColumn<saleData,String> SaleTotal;

    @FXML
    private Button close;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button printBtn;

    @FXML
    private TableColumn<saleData,String> salMedicineName;

    @FXML
    private TableColumn<saleData,String> saleBatchNo;

    @FXML
    private TableColumn<saleData,String> saleBrandName;

    @FXML
    private TableColumn<saleData,String> saleDate;

    @FXML
    private TableColumn<saleData,String> saleGST;

    @FXML
    private TableColumn<saleData,String> saleMedicineType;
    @FXML
    private TableColumn<saleData,String> saleQty;

    @FXML
    private TableView<saleData> saleTable;

    @FXML
    private TextField total;

 private Connection connect;
    private PreparedStatement prepare;
    private java.sql.Statement statement;
    private ResultSet result;

    public ObservableList<saleData> addSaleListData2() {
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

    private ObservableList<saleData> addSaleList2;

    public void addSaleShowListData2() {
        addSaleList2 = addSaleListData2();

        saleBatchNo.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        salMedicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
        saleBrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        saleMedicineType.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
        saleQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        saleGST.setCellValueFactory(new PropertyValueFactory<>("GST"));
        SaleTotal.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        saleDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        saleTable.setItems(addSaleList2);
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
            total.setText(String.valueOf(finalTotal));

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
            alert.setContentText("Successfully Printed");
            alert.showAndWait();
            statement = connect.createStatement();
            statement.executeUpdate(sql1);
            addSaleList2 = addSaleListData2();

       
            saleBatchNo.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
            salMedicineName.setCellValueFactory(new PropertyValueFactory<>("MedicineName"));
            saleBrandName.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
            saleMedicineType.setCellValueFactory(new PropertyValueFactory<>("MedicineType"));
            saleQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
            saleGST.setCellValueFactory(new PropertyValueFactory<>("GST"));
            SaleTotal.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            saleDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            saleTable.setItems(addSaleList2);
            total.setText("");
            // saleFinalTotal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        printBtn.getScene().getWindow().hide();
    }

    public void close(){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
   addSaleShowListData2();
   saleFinalTotal();
    }

}
