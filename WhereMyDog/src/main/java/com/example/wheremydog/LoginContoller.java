package com.example.wheremydog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.NumberFormat;


public class LoginContoller {

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField psdPassword;

    @FXML
    private Button sign_upBtn;

    @FXML
    private Stage sign;

    public void Login(ActionEvent event) throws Exception {
        if (txtUserName.getText().equals("user") && psdPassword.getText().equals("0000")) {
            lblStatus.setText("Login Success");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com.example.wheremydog/sign-in.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            lblStatus.setText("Login Failed");
        }
    }
    public void sign_up() {
        Stage mainStage = (Stage) sign_upBtn.getScene().getWindow();

        sign = new Stage(StageStyle.DECORATED);
        sign.initModality(Modality.WINDOW_MODAL);
        sign.initOwner(mainStage);

        try {
            Parent nextScene
                    =FXMLLoader.load(getClass().getResource("sign-up.fxml"));

            Scene scene = new Scene(nextScene);
            sign.setScene(scene);
            sign.setTitle("팝업 띄우기");
            sign.setResizable(false);
            sign.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
