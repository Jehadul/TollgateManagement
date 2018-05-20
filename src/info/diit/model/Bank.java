/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.model;

/**
 *
 * @author Kamrul
 */
public class Bank {

    private int AccountNo;
    private int empId;
    private double Amount;
    private String date;
    private String time;

    public Bank() {
    }

    public Bank(int AccountNo, int empId, double Amount, String date, String time) {
        this.AccountNo = AccountNo;
        this.empId = empId;
        this.Amount = Amount;
        this.date = date;
        this.time = time;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(int AccountNo) {
        this.AccountNo = AccountNo;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
