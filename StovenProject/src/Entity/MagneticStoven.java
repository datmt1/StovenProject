package Entity;

import java.util.Date;

//Subclass MagneticStoven extends from base class Stoven
public class MagneticStoven extends Stoven{
    private double Wattage;
    private boolean Timer;

    public MagneticStoven() {

    }

    public MagneticStoven(String type, String stovenID, String brand, String productCode, String productionCountry, int productionYear, int noOfStoven, double price, double salePrice, int warrantYear, double Wattage, boolean Timer) {
        super(type, stovenID, brand, productCode, productionCountry, productionYear, noOfStoven, price, salePrice, warrantYear);
        this.Wattage = Wattage;
        this.Timer = Timer;
    }

    //Getter & setter
    public double getWattage() {
        return Wattage;
    }

    public void setWattage(double wattage) {
        Wattage = wattage;
    }

    public boolean isTimer() {
        return Timer;
    }

    public void setTimer(boolean timer) {
        Timer = timer;
    }

<<<<<<< HEAD
    ///Subclass MagneticStoven creates the body of showInfo method which been created in the Stoven class.
=======
    ///Subclass MagneticStoven creates the body of showInfo method which been created in the Stoven class
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
        System.out.println("Timer: " + (Timer ? "Yes" : "No"));
    }
}
