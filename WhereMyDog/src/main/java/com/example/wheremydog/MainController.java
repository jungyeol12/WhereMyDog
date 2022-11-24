package com.example.wheremydog;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {

    @FXML
    private Button login;
    public void login() {
        Stage mainStage = (Stage) login.getScene().getWindow();

        login = new Stage(StageStyle.DECORATED);
        login.initModality(Modality.WINDOW_MODAL);
        login.initOwner(mainStage);

        try {
            Parent nextScene
                    =FXMLLoader.load(getClass().getResource("sign-up.fxml"));

            Scene scene = new Scene(nextScene);
            login.setScene(scene);
            login.setTitle("팝업 띄우기");
            login.setResizable(false);
            login.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }


}