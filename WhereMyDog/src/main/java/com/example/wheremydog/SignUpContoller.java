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

public class SignUpContoller {

    @FXML
    private TextField Nickname;

    @FXML
    private TextField id;

    @FXML
    private PasswordField urpassword;
    
    @FXML
    private Label lbStatus;

    @FXML
    private Button BackBtn;

    private Stage Back;


    public void Sign_up(ActionEvent event) throws Exception {
        if (Nickname.getText().equals("김찬우") && id.getText().equals("user") && urpassword.getText().equals("0000")) {
            lbStatus.setText("Sign Up Success");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com.example.wheremydog/sign-up.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            lbStatus.setText("Sign Up Failed");
        }

    }

    public void Back() {
        Stage subStage = (Stage) BackBtn.getScene().getWindow();

          Back = new Stage(StageStyle.DECORATED);
          Back.initModality(Modality.WINDOW_MODAL);
          Back.initOwner(subStage);

        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Main.java"));

              Scene scene = new Scene(nextScene);
              Back.setScene(scene);
              Back.setTitle("로그인");
              Back.setResizable(true);
              Back.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
