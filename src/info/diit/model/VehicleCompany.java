/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.model;

/**
 *
 * @author Kamrul
 */
public class VehicleCompany {

    private String CName;
    private String vehicleNumber;
    private String OwnerName;
    private String Address;
    private String Phone;
    private String ContactPerson;

    public VehicleCompany() {
    }

    public VehicleCompany(String CName, String vehicleNumber, String OwnerName, String Address, String Phone, String ContactPerson) {
        this.CName = CName;
        this.vehicleNumber = vehicleNumber;
        this.OwnerName = OwnerName;
        this.Address = Address;
        this.Phone = Phone;
        this.ContactPerson = ContactPerson;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }
}
