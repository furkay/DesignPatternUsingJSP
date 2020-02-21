
package models;

import Tablolar.tblproduct;


public class Drink extends tblproduct {

    private String ProductName;
    private String ProductType;
    private String ProductPrice;

    @Override
    public String getProductName() {
        return ProductName;
    }
    @Override
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    @Override
    public String getProductType() {
        return ProductType;
    }

    @Override
    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }
    @Override
    public String getProductPrice() {
        return ProductPrice;
    }
    @Override
    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }
}
