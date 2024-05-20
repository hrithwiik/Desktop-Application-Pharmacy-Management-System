import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLRegisterDocument implements Initializable{

    @FXML
    private Button close;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    private Button registerbtn;

    @FXML
    private TextField username;

    @FXML
    private Button loginbtn;

    public void close() {
        System.exit(0);
    }

    private Connection connect;
    private PreparedStatement prepare;
    private java.sql.Statement statement;
    private ResultSet result;

    public void register(){
        connect = Database.connectDb();
        Alert alert;

        // CHECK IF WE HAVE EMPTY FIELDS
        if (username.getText().isEmpty() || password.getText().isEmpty()
                || password1.getText().isEmpty() ) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all Blank fields");
                    alert.showAndWait();
        } else if (password.getText() == password1.getText()) {
            // CHECK IF THE VALUE OF PASSWORD FIELDS IS EQUAL TO CONFIRM PASSWORD
            alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Password Doesn't Match");
                alert.showAndWait();
        } else if (password.getText().length() < 8) {
            // CHECK IF THE LENGTH OF PASSWORD VALUE IS LESS THAN TO 8
            //, WE WILL CHECK THE CHARACTERS OF PASSWORD 
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Password, at least 8 characters needed");
            alert.showAndWait();
        } else {
            // CHECK IF THE USERNAME IS ALREADY TAKEN
            String checkUsername = "SELECT * FROM admin WHERE username = '"
                    + username.getText() + "'";
         
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(username.getText() + " is already taken");
                    alert.showAndWait();
                } else {

                    String insertData = "INSERT INTO admin "
                            + "(username, password) "
                            + "VALUES(?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, username.getText());
                    prepare.setString(2, password.getText());

                    prepare.executeUpdate();
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Registered Successfully!");
                    alert.showAndWait();
                    registerClearFields();


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public void registerClearFields() {
        username.setText("");
        password.setText("");
        password1.setText("");
    }

    private double x = 0;
    private double y = 0;

    public void login() {
        registerbtn.getScene().getWindow().hide();

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
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
    
    }

}
