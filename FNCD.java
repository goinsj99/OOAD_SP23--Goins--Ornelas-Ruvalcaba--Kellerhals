import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
public class FNCD {
    public Double opBudget;
    public List<String> staffList = Arrays.asList(staffID, firstName, Position);
    public List<String> vehicleList = Arrays.asList(String vim, String make, String model, int year, float cost);
    public List<String> report = Arrays.asList();

//    report parameters need to be filled
    public Integer staffCount;

    public FNCD(Double opBudget, List<String> staffList, List<String> vehicleList, Integer staffCount, List<String> report){
        this.opBudget = opBudget;
        this.vehicleList = vehicleList;
        this.staffList = staffList;
        this.staffCount = staffCount;
        this.report = report;
    }


    public void setOpBudget(Double opBudget){
        this.opBudget = opBudget;
    }
    public void setVehicleList(List<String> vehicleList){
        this.vehicleList = vehicleList;
    }
    public void setStaffList(List<String> staffList){
        this.staffList = staffList;
    }
    public void setStaffCount(Integer staffCount){
        this.staffCount = staffCount;
    }
    public void setReport(List<String> report){
        this.report = report;
    }
    public Double getOpBudget(){
        return opBudget;
    }
    public List<String> getVehicleList(){
        return vehicleList;
    }
    public List<String> getStaffList(){
        return staffList;
    }
    public Integer getStaffCount(){
        return staffCount;
    }
    public List<String> setReport(){
        return report;
    }
}
