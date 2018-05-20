/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.impl;

import info.diit.dao.Dao;
import info.diit.model.Bank;
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
public class BankIMPL implements Dao<Bank> {

    DataBaseUtil dataBaseUtil;

    public BankIMPL() {
        try {
            dataBaseUtil = new DataBaseUtil();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Bank value) {
        String sql = "insert into bank values(?,?,?,?,?)";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getAccountNo());
            pstm.setInt(2, value.getEmpId());
            pstm.setDouble(3, value.getAmount());
            pstm.setString(4, value.getDate());
            pstm.setString(5, value.getTime());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Bank value) {
        String sql = "update Bank set empId=?,Amount=?,Date=?,Time=? where AccountNo=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);

            pstm.setInt(1, value.getEmpId());
            pstm.setDouble(2, value.getAmount());
            pstm.setString(3, value.getDate());
            pstm.setString(4, value.getTime());
            pstm.setInt(5, value.getAccountNo());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(BankIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Bank value) {
        String sql = "delete from Bank where AccountNo=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getAccountNo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Bank find(Bank value) {
        String sql = "select * from Bank where AccountNo=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getAccountNo());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Bank(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BankIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Bank> getAll() {
        String sql = "select * from Bank";
        ArrayList<Bank> bank = new ArrayList<Bank>();

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                bank.add(new Bank(rs.getInt(1), rs.getInt(2), rs.getDouble(3),
                        rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bank;
    }
}
