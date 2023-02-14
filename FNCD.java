import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class FNCD {
    public Double opBudget;
    public List<StaffTest.Staff> staffList;
    public List<VehicleClass.Vehicle> vehicleList;
    public List<String> report = Arrays.asList();

//    report parameters need to be filled
    public Integer staffCount;

    public FNCD(Double opBudget){
        this.opBudget = opBudget;
        this.vehicleList = new ArrayList();
        this.staffList = new ArrayList();
        this.staffCount = staffCount;
        this.report = report;
    }
    // Setters 
    // set new budget
    public void setOpBudget(Double opBudget){
        this.opBudget = opBudget;
    }
    // add all vehicle in list
    public void setVehicleList(List<VehicleClass.Vehicle> vehicleList){
        this.vehicleList = vehicleList;
    }
    // add all staff in list
    public void setStaffList(List<StaffTest.Staff> staffList){
        this.staffList = staffList;
    }
    // set new staff count
    public void setStaffCount(Integer staffCount){
        this.staffCount = staffCount;
    }
    // set a report
    public void setReport(List<String> report){
        this.report = report;
    }
    // Getters
    // return budget
    public Double getOpBudget(){
        return opBudget;
    }
    // return vehicle list
    public List<VehicleClass.Vehicle> getVehicleList(){
        return vehicleList;
    }
    // return staff list
    public List<StaffTest.Staff>  getStaffList(){
        return staffList;
    }
    public Integer getStaffCount(){
        return staffCount;
    }
    public List<String> setReport(){
        return report;
    }
}
