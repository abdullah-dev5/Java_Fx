package com.example.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ProductController  implements Initializable {

    private  Connection connection =null;
    private PreparedStatement preStatement = null;
    private ResultSet rs =null;

    private ObservableList<ProductList>data;
    @FXML
    TextField product;
    @FXML
    TextField code;
    @FXML
    TextField Pin;
    @FXML
    TextField Pout;
    @FXML
    Button save;
    @FXML
    TableView<ProductList> tableview;
    @FXML
    TableColumn<ProductList,String>productColumn;
    @FXML
    TableColumn<ProductList,String>codeColumn;
    @FXML
    TableColumn<ProductList,String>priceInColumn;
    @FXML
    TableColumn<ProductList,String>priceOutColumn;



    @FXML
    protected void onHelloButtonClick() {

        System.out.println("loading Direct from Interface");
        data.add(new ProductList(product.getText(), code.getText(),Pin.getText(),Pout.getText()));
        System.out.println("loaded Direct from Interface");
        String sql = "INSERT INTO  productlist(product,code,pricein,priceout) VALUES (?,?,?,?)";

    String prod =  product.getText();
    String codeQR= code.getText();
    double priceIn = Double.valueOf(Pin.getText());
    double priceOut = Double.valueOf(Pout.getText());
    try{
        preStatement= connection.prepareStatement(sql);
        preStatement.setString(1,prod);
        preStatement.setString(2,codeQR);
        preStatement.setDouble(3,priceIn);
        preStatement.setDouble(4,priceOut);
       /* preStatement.setString(3, String.valueOf(priceIn));
        preStatement.setString(4,String.valueOf(priceOut)); we are using Double instead String
*/
        preStatement.execute();

        System.out.println("Insert Sucessfully");
    }
    catch (SQLException e){
            e.printStackTrace();
        }
        finally {
        try {
            rs.close();
            preStatement.close();
            connection.close();
        }catch (SQLException e)
        {
            System.err.println("Error while closing");
            e.printStackTrace();
        }
    }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        connection =DBConnection.connector();
        data= FXCollections.observableArrayList();
        setCellTable();
        System.out.println("after SetCell Table method called");

        loadDataFromDatabase();
        System.out.println("After Calling LoadDataFromDatabase method");
    }
    void setCellTable()
    {
        try {
        productColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("product"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("code"));
        priceInColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("price_In"));
        priceOutColumn.setCellValueFactory(new PropertyValueFactory<ProductList, String>("price_Out"));
        }
    catch(Exception e)
        {
            System.err.println("Error in SetCell Table method called"+e.getMessage());

        }
    }

   private  void loadDataFromDatabase()
   {
       System.out.println("I'm in the Load database method");
       String sql ="SELECT * FROM productList ";

       try {
           preStatement = connection.prepareStatement(sql);
            rs = preStatement.executeQuery();
            while(rs.next())
            {
                data.add(new ProductList(rs.getString(1), rs.getString(2),""+rs.getDouble(3),""+rs.getDouble(4) ));

            }

       }
       catch (SQLException e) {
           System.out.println("Error while executing And Fetching Data");
       }

        tableview.setItems(data);


   }
}