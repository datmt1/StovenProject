package Dao;

import Entity.InfrareStoven;
import Utils.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfrareStovenDao {
    public void insert(InfrareStoven model){
        String sql="INSERT INTO DataStoven (Type, StovenID, Brand, ProductCode, ProductionCountry, NoOfStoven, Price, SalePrice, WarrantYear, Wattage, Cookmode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectDB.update(sql,
                model.getType(),
                model.getStovenID(),
                model.getBrand(),
                model.getProductCode(),
                model.getProductionCountry(),
                model.getProductionYear());
                model.getNoOfStoven();
                model.getPrice();
                model.getSalePrice();
                model.getWarrantYear();
                model.getWattage();
                model.isCookmode();
    }

    public void update(InfrareStoven model){
        String sql="UPDATE DataStoven SET Type=?, Brand=?, ProductCode=?, ProductionCountry=?, NoOfStoven=?, Price=?, SalePrice=?, WarrantYear=? , Wattage=?, Cookmode=? WHERE StovenID=?";
        ConnectDB.update(sql,
                model.getType(),
                model.getBrand(),
                model.getProductCode(),
                model.getProductionCountry(),
                model.getProductionYear());
                model.getNoOfStoven();
                model.getPrice();
                model.getSalePrice();
                model.getWarrantYear();
                model.getWattage();
                model.isCookmode();
    }

    public void delete(String StovenID){
        String sql="DELETE FROM DataStoven WHERE StovenID=?";
        ConnectDB.update(sql, StovenID);
    }

    public List<InfrareStoven> selectAll(){
        String sql="SELECT * FROM DataStoven";
        return selectBySql(sql);
    }

    public InfrareStoven selectById(String StovenID){
        String sql="SELECT * FROM DataStoven WHERE DataStoven=?";
        List<InfrareStoven> list = selectBySql(sql, StovenID);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<InfrareStoven> selectBySql(String sql, Object...args){
        List<InfrareStoven> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectDB.query(sql, args);
                while(rs.next()){
                    InfrareStoven entity=new InfrareStoven();
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
                    entity.setWattage(rs.getDouble("Wattage"));
                    entity.setCookmode(rs.getBoolean("Timer"));
                    list.add(entity);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
