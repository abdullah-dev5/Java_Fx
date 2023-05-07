package com.example.loginpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Label status;
    @FXML
    private TextField txtusername ;
    @FXML
    private TextField txtpassword ;

    @FXML
    protected void Login(ActionEvent event) throws Exception {

        if(txtusername.getText().equals("User") && txtpassword.getText().equals("Password"))
        {
            Stage stage = new Stage();
            status.setText("SuccessFully login");

            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("main-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);
            //stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        else{
            status.setText("ErrorFully login failed");
        }
    }
}