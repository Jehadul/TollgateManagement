/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.model;

/**
 *
 * @author Kamrul
 */
public class TollRate {

    private int rateId;
    private String vehicleCategory;
    private double weight;
    private double charge;
    private double overWeightCharge;
    private String passType;

    public TollRate() {
    }

    public TollRate(int rateId, String vehicleCategory, double weight, double charge, double overWeightCharge, String passType) {
        this.rateId = rateId;
        this.vehicleCategory = vehicleCategory;
        this.weight = weight;
        this.charge = charge;
        this.overWeightCharge = overWeightCharge;
        this.passType = passType;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getOverWeightCharge() {
        return overWeightCharge;
    }

    public void setOverWeightCharge(double overWeightCharge) {
        this.overWeightCharge = overWeightCharge;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }
}
