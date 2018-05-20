/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.impl;

import info.diit.dao.Dao;
import info.diit.model.VehicleCompany;
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
public class VehicleCompanyIMPL implements Dao<VehicleCompany> {

    DataBaseUtil dataBaseUtil;

    public VehicleCompanyIMPL() {
        try {
            dataBaseUtil = new DataBaseUtil();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleCompanyIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(VehicleCompany value) {
        String sql = "insert into VehicleCompany values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setString(1, value.getCName());
            pstm.setString(2, value.getVehicleNumber());
            pstm.setString(3, value.getOwnerName());
            pstm.setString(4, value.getAddress());
            pstm.setString(5, value.getPhone());
            pstm.setString(6, value.getContactPerson());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(VehicleCompanyIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(VehicleCompany value) {
        String sql = "update VehicleCompany set vehicleNumber=?,OwnerName=?,"
                + "Address=?,Phone=?,ContactPerson=? where CName=?";
        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);

            pstm.setString(1, value.getVehicleNumber());
            pstm.setString(2, value.getOwnerName());
            pstm.setString(3, value.getAddress());
            pstm.setString(4, value.getPhone());
            pstm.setString(5, value.getContactPerson());
            pstm.setString(6, value.getCName());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(VehicleCompanyIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(VehicleCompany value) {
        String sql = "delete from VehicleCompany where CName=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setString(1, value.getCName());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleCompanyIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public VehicleCompany find(VehicleCompany value) {
        String sql = "select * from VehicleCompany where CName=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setString(1, value.getCName());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new VehicleCompany(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehicleCompanyIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<VehicleCompany> getAll() {
        String sql = "select * from VehicleCompany";
        ArrayList<VehicleCompany> vehiComList = new ArrayList<VehicleCompany>();

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                vehiComList.add(new VehicleCompany(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleCompanyIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiComList;
    }
}
