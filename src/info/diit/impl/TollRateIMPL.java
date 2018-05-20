/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.impl;

import info.diit.dao.Dao;
import info.diit.model.TollRate;
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
public class TollRateIMPL implements Dao<TollRate> {

    DataBaseUtil dataBaseUtil;

    public TollRateIMPL() {
        try {
            dataBaseUtil = new DataBaseUtil();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TollRateIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(TollRate value) {
        String sql = "insert into TollRate values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getRateId());
            pstm.setString(2, value.getVehicleCategory());
            pstm.setDouble(3, value.getWeight());
            pstm.setDouble(4, value.getCharge());
            pstm.setDouble(5, value.getOverWeightCharge());
            pstm.setString(6, value.getPassType());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(TollRateIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TollRate value) {
        String sql = "update TollRate set vehicleCategory=?,weight=?,"
                + "charge=?,overWeightCharge=?,passType=? where rateId=?";
        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);


            pstm.setString(1, value.getVehicleCategory());
            pstm.setDouble(2, value.getWeight());
            pstm.setDouble(3, value.getCharge());
            pstm.setDouble(4, value.getOverWeightCharge());
            pstm.setString(5, value.getPassType());
            pstm.setInt(5, value.getRateId());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(TollRateIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(TollRate value) {
        String sql = "delete from TollRate where rateId=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getRateId());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(TollRateIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TollRate find(TollRate value) {
        String sql = "select * from TollRate where rateId=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getRateId());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new TollRate(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TollRateIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TollRate> getAll() {
        String sql = "select * from TollRate";
        ArrayList<TollRate> tollRate = new ArrayList<TollRate>();

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tollRate.add(new TollRate(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TollRateIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tollRate;
    }
}
