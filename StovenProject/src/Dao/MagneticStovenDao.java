package Dao;

import Entity.MagneticStoven;
import Utils.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagneticStovenDao {
    public void insert(MagneticStoven model){
        String sql = "INSERT INTO DataStoven (Type, StovenID, Brand, ProductCode, ProductionCountry, ProductionYear, NoOfStoven, Price, SalePrice, WarrantYear, Wattage, Timer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                model.getWattage(),
                model.isTimer());
    }

    public void update(MagneticStoven model){
        String sql = "UPDATE DataStoven SET Type=?, Brand=?, ProductCode=?, ProductionCountry=?, ProductionYear=?, " +
                "NoOfStoven=?, Price=?, SalePrice=?, WarrantYear=?, Wattage=?, Timer=? WHERE StovenID=?";
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
                model.getWattage(),
                model.isTimer(),
                model.getStovenID());
    }

    public void delete(String StovenID){
        String sql = "DELETE FROM DataStoven WHERE StovenID=?";
        ConnectDB.update(sql, StovenID);
    }

    public List<MagneticStoven> selectAll(){
        String sql = "SELECT * FROM DataStoven";
        return selectBySql(sql);
    }

    public MagneticStoven selectById(String StovenID){
<<<<<<< HEAD
        String sql = "select * FROM DataStoven WHERE StovenID=?";
=======
        String sql = "SELECT * FROM DataStoven WHERE StovenID=?";
>>>>>>> 8b282353ae12b81cdd816cbd4d4ff52c97ec7654
        List<MagneticStoven> list = selectBySql(sql, StovenID);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<MagneticStoven> selectBySql(String sql, Object...args){
        List<MagneticStoven> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectDB.query(sql, args);
                while(rs.next()){
                    MagneticStoven entity = new MagneticStoven();
                    entity.setType(rs.getString("Type"));
                    entity.setStovenID(rs.getString("StovenID"));
                    entity.setBrand(rs.getString("Brand"));
                    entity.setProductCode(rs.getString("ProductCode"));
                    entity.setProductionCountry(rs.getString("ProductionCountry"));
                    entity.setProductionYear(rs.getInt("ProductionYear"));
                    entity.setNoOfStoven(rs.getInt("NoOfStoven"));
                    entity.setPrice(rs.getDouble("Price"));
                    entity.setSalePrice(rs.getDouble("SalePrice"));
                    entity.setWarrantYear(rs.getInt("WarrantYear"));
                    entity.setWattage(rs.getInt("Wattage"));
                    entity.setTimer(rs.getBoolean("Timer"));
                    list.add(entity);
                }
            }
            finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Failed to retrieve MagneticStoven entities from database", ex);
        }
        return list;
    }
}
