package Entity;

import java.util.Date;

//Same with Subclass GasStoven, InfraraStoven class also using inheritance concept to create InfraraStoven class extends from abstract base class Stoven
public class InfrareStoven extends Stoven{
    private double Wattage;
    private boolean Cookmode;

    //Default constuctor
    public InfrareStoven () {

    }

    //Parameterless constructor
    public InfrareStoven(String type, String stovenID, String brand, String productCode, String productionCountry, int productionYear, int noOfStoven, double price, double salePrice, int warrantYear, double Wattage, boolean Cookmode) {
        super(type, stovenID, brand, productCode, productionCountry, productionYear, noOfStoven, price, salePrice, warrantYear);
        this.Wattage = Wattage;
        this.Cookmode = Cookmode;
    }

    //Getter & Setter
    public double getWattage() {
        return Wattage;
    }

    public void setWattage(double wattage) {
        Wattage = wattage;
    }

    public boolean isCookmode() {
        return Cookmode;
    }

    public void setCookmode(boolean cookmode) {
        Cookmode = cookmode;
    }

<<<<<<< HEAD
    //Subclass InfraraStoven creates the body of showInfo method which been created in the Stoven class.
=======
    //Subclass InfraraStoven creates the body of showInfo method which been created in the Stoven class
>>>>>>> 8b282353ae12b81cdd816cbd4d4ff52c97ec7654
    @Override
    public void showInfo() {
        System.out.println("Type: " + getType());
        System.out.println("StovenID: " + getStovenID());
        System.out.println("Brand: " + getBrand());
        System.out.println("ProductCode: " + getProductCode());
        System.out.println("ProductionCountry: " + getProductionCountry());
        System.out.println("ProductionYear: " + getProductionYear());
        System.out.println("NoOfStoven: " + getNoOfStoven());
        System.out.println("Price: " + getPrice());
        System.out.println("SalePrice: " + getSalePrice());
        System.out.println("WarrantYear: " + getWarrantYear());
        System.out.println("Wattage: " + Wattage);
        System.out.println("Cookmode: " + (Cookmode ? "Flexible" : "InFlexible"));
    }
}
