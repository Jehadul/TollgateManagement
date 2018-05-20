/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.impl;

import info.diit.dao.Dao;
import info.diit.model.Vehicle;
import info.diit.util.DataBaseUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kamrul
 */
public class VehicleIMPL implements Dao<Vehicle> {

    DataBaseUtil databaseutil;

    public VehicleIMPL() {
        try {
            databaseutil = new DataBaseUtil();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Vehicle value) {
        String sql = "insert into vehicle values(?,?,?,?)";

        try {
            PreparedStatement pstm = databaseutil.getCon().prepareStatement(sql);
            pstm.setString(1, value.getVehicleNumber());
            pstm.setString(2, value.getVehicleName());
            pstm.setString(3, value.getVehicleCategory());
            pstm.setString(4, value.getWeight());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Vehicle value) {
        String sql = "update vehicle set VehicleName=?,VehicleCategory=?,Weight=? where VehicleNumber=?";

        try {
            PreparedStatement pstm = databaseutil.getCon().prepareStatement(sql);

            pstm.setString(1, value.getVehicleName());
            pstm.setString(2, value.getVehicleCategory());
            pstm.setString(3, value.getWeight());
            pstm.setString(4, value.getVehicleNumber());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(VehicleIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Vehicle value) {
        String sql = "delete from vehicle where VehicleNumber=?";

        try {
            PreparedStatement pstm = databaseutil.getCon().prepareStatement(sql);
            pstm.setString(1, value.getVehicleNumber());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Vehicle find(Vehicle value) {
        String sql = "select * from vehicle where VehicleNumber=?";

        try {
            PreparedStatement pstm = databaseutil.getCon().prepareStatement(sql);
            pstm.setString(1, value.getVehicleNumber());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehicleIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        String sql = "select * from vehicle";
        ArrayList<Vehicle> vehiList = new ArrayList<Vehicle>();

        try {
            PreparedStatement pstm = databaseutil.getCon().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                vehiList.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiList;
    }
}
