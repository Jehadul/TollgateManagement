/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.model;

/**
 *
 * @author Kamrul
 */
public class Vehicle {

    private String VehicleNumber;
    private String VehicleName;
    private String VehicleCategory;
    private String Weight;

    public Vehicle() {
    }

    public Vehicle(String VehicleNumber, String VehicleName, String VehicleCategory, String Weight) {
        this.VehicleNumber = VehicleNumber;
        this.VehicleName = VehicleName;
        this.VehicleCategory = VehicleCategory;
        this.Weight = Weight;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String VehicleNumber) {
        this.VehicleNumber = VehicleNumber;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String VehicleName) {
        this.VehicleName = VehicleName;
    }

    public String getVehicleCategory() {
        return VehicleCategory;
    }

    public void setVehicleCategory(String VehicleCategory) {
        this.VehicleCategory = VehicleCategory;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
