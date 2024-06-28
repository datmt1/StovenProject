package Dao;

import Entity.GasStoven;
import Utils.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GasStovenDao extends StovenProjectDao<GasStoven, String>{

    public static GasStovenDao getInstance(){
        return new GasStovenDao();
    }

    public void insert(GasStoven model){
        // SQL query to insert data into DataStoven table
        String sql="INSERT INTO DataStoven (Type, StovenID, Brand, ProductCode, ProductionCountry, NoOfStoven, Price, SalePrice, WarrantYear, Fire) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // Execute the SQL query with model's data
        ConnectDB.update(sql,
                model.getType(),
                model.getStovenID(),
                model.getBrand(),
                model.getProductCode(),
                model.getProductionCountry(),
                model.getProductionYear(),
                model.getNoOfStoven(),
                model.getPrice(),
                model.getSalePrice(),
                model.getWarrantYear(),
                model.isFire());
    }

    public void update(GasStoven model){
        // SQL query to update data into DataStoven table
        String sql="UPDATE DataStoven SET Type=?, Brand=?, ProductCode=?, ProductionCountry=?, NoOfStoven=?, Price=?, SalePrice=?, WarrantYear=? , Fire=? WHERE StoveID=?";
        // Execute the SQL query with model's data
        ConnectDB.update(sql,
                model.getType(),
                model.getBrand(),
                model.getProductCode(),
                model.getProductionCountry(),
                model.getProductionYear(),
                model.getNoOfStoven(),
                model.getPrice(),
                model.getSalePrice(),
                model.getWarrantYear(),
                model.isFire());
    }

    public void delete(String StovenID){
        // SQL query to delete a record from DataStoven table based on StovenID
        String sql="DELETE FROM DataStoven WHERE StoveID=?";
        // Execute the SQL query with StovenID parameter
        ConnectDB.update(sql, StovenID);
    }

    public List<GasStoven> selectAll(){
        // SQL query to select all records from DataStoven table
        String sql="SELECT * FROM DataStoven";
        return selectBySql(sql);
    }

    public GasStoven selectById(String StovenID){
        // SQL query to select a record from DataStoven table based on StovenID
        String sql="SELECT * FROM DataStoven WHERE DataStoven=?";
        List<GasStoven> list = selectBySql(sql, StovenID);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<GasStoven> selectBySql(String sql, Object...args){
        // Initialize list to store GasStoven objects retrieved from database
        List<GasStoven> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                // Execute SQL query with parameters and obtain ResultSet
                rs = ConnectDB.query(sql, args);
                // Iterate through ResultSet and populate GasStoven objects
                while(rs.next()){
                    GasStoven entity=new GasStoven();
                    // Set GasStoven object fields from ResultSet columns
                    entity.setType(rs.getString("Type"));
                    entity.setStovenID(rs.getString("StoveID"));
                    entity.setBrand(rs.getString("Brand"));
                    entity.setProductCode(rs.getString("ProductCode"));
                    entity.setProductionCountry(rs.getString("ProductionCountry"));
                    entity.setProductionYear(rs.getInt("ProductionYear"));
                    entity.setNoOfStoven(rs.getInt("NoOfStoven"));
                    entity.setPrice(rs.getDouble("Price"));
                    entity.setSalePrice(rs.getDouble("SalePrice"));
                    entity.setWarrantYear(rs.getInt("WarrantYear"));
                    entity.setFire(rs.getBoolean("Fire"));
                    list.add(entity);
                }
            }
            finally{
                // Close ResultSet, Statement, and Connection
                rs.getStatement().getConnection().close();
            }
        }
        catch (SQLException ex) {
            // Handle SQL exception and throw RuntimeException
            throw new RuntimeException(ex);
        }
        return list;
    }
}
