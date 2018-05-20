/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.model;

/**
 *
 * @author Kamrul
 */
public class EmployeeDetails {

    private int empId;
    private String Name;
    private String phone;
    private String DutyTime;
    private String password;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDutyTime() {
        return DutyTime;
    }

    public void setDutyTime(String DutyTime) {
        this.DutyTime = DutyTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeDetails() {
    }

    public EmployeeDetails(int empId, String Name, String phone, String DutyTime, String password) {
        this.empId = empId;
        this.Name = Name;
        this.phone = phone;
        this.DutyTime = DutyTime;
        this.password = password;
    }

   
}
