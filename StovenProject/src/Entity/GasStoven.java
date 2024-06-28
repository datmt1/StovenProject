package Entity;

import java.util.Date;

//Using inheritance concept to create GasStoven class extends from abstract base class Stoven
public class GasStoven extends Stoven{
    private boolean Fire;

    //Create constructor
    public GasStoven(String type, String stovenID, String brand, String productCode, String productionCountry, int productionYear, int noOfStoven, double price, double salePrice, int warrantYear, boolean Fire) {
        super(type, stovenID, brand, productCode, productionCountry, productionYear, noOfStoven, price, salePrice, warrantYear);
        this.Fire = Fire;
    }

    //Default constructor
    public GasStoven() {

    }

    //Getter & Setter
    public boolean isFire() {
        return Fire;
    }

    public void setFire(boolean fire) {
        Fire = fire;
    }


<<<<<<< HEAD
    //Subclass GasStoven creates the body of showInfo method which been created in the Stoven class.
=======
    //Subclass GasStoven creates the body of showInfo method which been created in the Stoven class
>>>>>>> 8b282353ae12b81cdd816cbd4d4ff52c97ec7654
    @Override
    public void showInfo(){
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
        System.out.println("Fire: " + (Fire ? "IC" : "Magneto"));
    }
}
