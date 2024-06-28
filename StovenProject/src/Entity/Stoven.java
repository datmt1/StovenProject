package Entity;

import java.util.Date;
import java.util.Scanner;

//Create abstract base class for all types of stoves.
public abstract class Stoven {
    private String Type;
    private String StovenID;
    private String Brand;
    private String ProductCode;
    private String ProductionCountry;
    private int ProductionYear;
    private int NoOfStoven;
    private double Price;
    private double SalePrice;
    private int WarrantYear;

    //Create constructor
    public Stoven(String type, String stovenID, String brand, String productCode, String productionCountry, int productionYear, int noOfStoven, double price, double salePrice, int warrantYear) {
        Type = type;
        StovenID = stovenID;
        Brand = brand;
        ProductCode = productCode;
        ProductionCountry = productionCountry;
        ProductionYear = productionYear;
        NoOfStoven = noOfStoven;
        Price = price;
        SalePrice = salePrice;
        WarrantYear = warrantYear;
    }

    //Default constructor
    public Stoven() {

    }

    //Create Getter & Setter
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStovenID() {
        return StovenID;
    }

    public void setStovenID(String stovenID) {
        StovenID = stovenID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductionCountry() {
        return ProductionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        ProductionCountry = productionCountry;
    }

    public int getProductionYear() {
        return ProductionYear;
    }

    public void setProductionYear(int productionYear) {
        ProductionYear = productionYear;
    }

    public int getNoOfStoven() {
        return NoOfStoven;
    }

    public void setNoOfStoven(int noOfStoven) {
        NoOfStoven = noOfStoven;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }

    public int getWarrantYear() {
        return WarrantYear;
    }

    public void setWarrantYear(int warrantYear) {
        WarrantYear = warrantYear;
    }

    //Create method Sale
    void Sale(String StovenID, String BuyerType){
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE INPUT STOVEN'S ID AND YOUR BUYER TYPE: ");
        System.out.println("STOVEN'S ID: ");
        StovenID = scanner.nextLine();
        System.out.println("BUYER TYPE: ");
        BuyerType = scanner.nextLine();
        while (true) {
            if (!this.StovenID.equals(StovenID)) {
                System.out.println("Stoven : "+ StovenID +"does not exist!");
            } else if (BuyerType != "SV" && BuyerType != "CN" && BuyerType != "VC") {
                System.out.println("Buyer type must be SV or CN or VC");
            } else {
                break;
            }
        }
    }

    //Create an abstract method to show information
    public abstract void showInfo();
}
