package com.tonyliu.androidstore;
//class to store information for products that will be passed to recyclerView
public class Product {
    int imgID;
    String prodName;
    String prodDesc;
    String prodPrice;

    public Product(int imgID, String prodName, String prodDesc, String prodPrice) {
        this.imgID = imgID;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }
}
