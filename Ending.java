import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter;
import java.io.FileOutputStream; 

public class Ending{
    private Double tempPay;
    private List<Staff> tempReport;
    List<Staff> quitList = new ArrayList<>();
    Random random2 = new Random();

    Ending(){
        this.tempPay = 0.0;
        this.tempReport = new ArrayList<>();
        this.quitList = new ArrayList<>();
    }
    public void payStaff(FNCD fncd){
        List<Staff> staffList = fncd.getStaffList();
        Double quitChance = 0.1;
        Double mechChance = random2.nextDouble();
        Double salesChance = random2.nextDouble();
        Double internChance = random2.nextDouble();
        double staffTotalEarning = 0;
        //Staff tempIntern1;
        Staff tempIntern2;
        // should I make a payStaff option in
        for(Staff staff: staffList){
            if(fncd.getOpBudget() >= staff.getSalary()){
                fncd.setOpBudget(fncd.getOpBudget() - staff.getSalary());
                staff.setHours(staff.getHours() +8.0);
                double curr = fncd.getStaffTotalEarn();
                fncd.setStaffTotalEarn(curr+=staff.getSalary());
            }
        }
        // if the random intern chance is within 10% fire/quit intern
        List<Staff> copyList5 = List.copyOf(staffList); 
        if(internChance < quitChance){
            for (Staff staff : copyList5) {
                if (staff instanceof Intern) {
                    this.quitList.add(staff);
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                    break;
                }
            }

        }
        // mechanic quits
        if(mechChance < quitChance){
            Staff tempIntern1 = new Staff("",0.0,0,0.0,0.0,"",0.0);
            List<Staff> copyList = List.copyOf(staffList); 
            for (Staff staff : copyList) {
                if (staff instanceof Mechanic) {
                    this.quitList.add(staff);
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                }
            }
            // grabbing an intern to replace a mechanic
            List<Staff> copyList2 = List.copyOf(staffList);
            for (Staff staff : copyList2) {
                if (staff instanceof Intern) {
                    tempIntern1 = fncd.createMecanicStaff();
                    tempIntern1.setName(staff.getName());
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                }
                break;
            }
        }
        // sales person quites
        List<Staff> copyList3 = List.copyOf(staffList);
        if(salesChance < quitChance){
            for(Staff staff : copyList3) {
                if(staff instanceof SalesPerson) {
                    this.quitList.add(staff);
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                }
            }
            // grabbing an intern to replace a salesperson
            List<Staff> copyList4 = List.copyOf(staffList);
            for(Staff staff : copyList4) {
                if(staff instanceof Intern) {
                    tempIntern2 = fncd.createSalesPersonStaff();
                    tempIntern2.setName(staff.getName());
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                }
                break;
            }
        }
    }

    public void pReport(FNCD fncd){
        List<Staff> staffList = fncd.getStaffList();
        List<Vehicle> vehicleList = fncd.getVehicleList();
        List<Staff> tempQuit = this.quitList;
        Double totalSales = 0.0;

        fncd.LoggerReport("| Staff that quit |");
        for (Staff staff : tempQuit){
        // staff.setHours(staff.getHours() + 8.0);
            fncd.LoggerReport("      * "+staff.getName() + ", " + staff.getHours() + ", "+ staff.getSalary() + ", " + staff.getBonusTemp() + ", Quits" );
        }
        fncd.LoggerReport("| Staff still working that |");
        for (Staff staff : staffList){
        // staff.setHours(8.0);
            fncd.LoggerReport("      * "+staff.getName() + ", " + staff.getHours() + ", " + staff.getSalary() + ", "+ staff.getBonus() + ", "+staff.getPosition() + ", Working" );
        }
        fncd.LoggerReport("| Sold Vehicles |");
        for (Vehicle car : fncd.getSoldVehicle() ){
        // staff.setHours(8.0);
            fncd.LoggerReport("      * "+car.getName() + ", " + car.getCost() + ", "+ car.getSalesPrice() + ","+ car.getCondition()+ "," +car.getCleanliness()+  ", Sold" );
        }
        fncd.LoggerReport("| Current Vehicle Inventory |");
        for (Vehicle car : fncd.getVehicleList()){
        // staff.setHours(8.0);
            fncd.LoggerReport("      * "+car.getName() + ", " + car.getCost() + ", "+ car.getSalesPrice() + ","+ car.getCondition()+ "," +car.getCleanliness()+  ", In Stock" );
        }
        fncd.LoggerReport("|O ur Budget & Total Sale Number? |");
        for (Vehicle car : fncd.getSoldVehicle()){
            totalSales += car.getSalesPrice();
        }
        fncd.LoggerReport("      * "+fncd.getOpBudget()+" "+totalSales);
    }
}
