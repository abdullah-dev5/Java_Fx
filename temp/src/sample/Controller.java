
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField F_TEMP;
    @FXML public TextField C_TEMP;
    @FXML public TextField K_TEMP;

    public void printData()
    {
        System.out.println("F_TEMP : "+F_TEMP.getText());
        System.out.println("K_TEMP : "+K_TEMP.getText());
        System.out.println("C_TEMP : "+C_TEMP.getText());

    }
    public void convertF(ActionEvent actionEvent)
    {

        double F = Double.parseDouble(F_TEMP.getText());
        double K = (F - 32) * 5/9 + 273.15;
        double C = (F - 32) * 5/9;

        C_TEMP.setText(String.valueOf(C));
        K_TEMP.setText(String.valueOf(K));
        
    }

    public void convertC(ActionEvent actionEvent) {
        double C = Double.parseDouble(C_TEMP.getText());
        double F =  (C * 9/5) + 32 ;
        double K  =  C + 273.15;
        K_TEMP.setText(String.valueOf(K));
        F_TEMP.setText(String.valueOf(F));



    }

    public void convertK(ActionEvent actionEvent) {
        double K = Double.parseDouble(K_TEMP.getText());
        double F = (K - 273.15) * 9/5 + 32;

        double C  = 273.15 - K  ;
        C_TEMP.setText(String.valueOf(C));
        F_TEMP.setText(String.valueOf(F));
    }
}
