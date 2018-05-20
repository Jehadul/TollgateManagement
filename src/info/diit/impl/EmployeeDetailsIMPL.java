/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.impl;

import info.diit.dao.Dao;
import info.diit.model.EmployeeDetails;
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
public class EmployeeDetailsIMPL implements Dao<EmployeeDetails> {

    DataBaseUtil dataBaseUtil;

    public EmployeeDetailsIMPL() {
        try {
            dataBaseUtil = new DataBaseUtil();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailsIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(EmployeeDetails value) {
        String sql = "insert into employeedetails values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getEmpId());
            pstm.setString(2, value.getName());
            pstm.setString(3, value.getPhone());
            pstm.setString(4, value.getDutyTime());
            pstm.setString(5, value.getPassword());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(EmployeeDetails value) {
        String sql = "update EmployeeDetails set Name=?,Phone=?,"
                + "DutyTime=?,password=? where empId=?";
        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);


            pstm.setString(1, value.getName());
            pstm.setString(2, value.getPhone());
            pstm.setString(3, value.getDutyTime());
            pstm.setString(4, value.getPassword());
            pstm.setInt(5, value.getEmpId());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(EmployeeDetails value) {

        String sql = "delete from EmployeeDetails where empId=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getEmpId());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public EmployeeDetails find(EmployeeDetails value) {
        String sql = "select * from EmployeeDetails where empId=?";

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            pstm.setInt(1, value.getEmpId());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new EmployeeDetails(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<EmployeeDetails> getAll() {
        String sql = "select * from EmployeeDetails";
        ArrayList<EmployeeDetails> empDetails = new ArrayList<EmployeeDetails>();

        try {
            PreparedStatement pstm = dataBaseUtil.getCon().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                empDetails.add(new EmployeeDetails(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empDetails;
    }
}
