package com.example.tableview;

import javafx.beans.property.SimpleStringProperty;

public class ProductList {


    private SimpleStringProperty product,code,price_In,price_Out;


    public String getProduct() {
        return product.get();
    }

    public SimpleStringProperty productProperty() {
        return product;
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getPrice_In() {
        return price_In.get();
    }

    public SimpleStringProperty price_InProperty() {
        return price_In;
    }

    public void setPrice_In(String price_In) {
        this.price_In.set(price_In);
    }

    public String getPrice_Out() {
        return price_Out.get();
    }

    public SimpleStringProperty price_OutProperty() {
        return price_Out;
    }

    public void setPrice_Out(String price_Out) {
        this.price_Out.set(price_Out);
    }
    public ProductList(String product,String code,String price_In,String price_Out) {

        this.product = new SimpleStringProperty(product);
        this.code = new SimpleStringProperty(code);
        this.price_In = new SimpleStringProperty(price_In);
        this.price_Out = new SimpleStringProperty(price_Out);

    }
}
