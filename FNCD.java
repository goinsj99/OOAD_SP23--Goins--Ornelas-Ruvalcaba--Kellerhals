import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FNCD {
    public Double opBudget;
    public List<Staff> staffList;
    public List<Vehicle> vehicleList;
    public List<String> staffnames;
    public List<String> vehicleNames;
    public List<String> report = Arrays.asList();

//    report parameters need to be filled
    public Integer staffCount;

    public FNCD(Double opBudget){
        this.opBudget = opBudget;
        // lead list of vehicles
        this.vehicleList = new ArrayList();
        try {
            File file1 = new File("RegularCars.txt");
            File file2 = new File("PickupCars.txt");
            File file3 = new File("PerformanceCars.txt");
            Scanner scanner1 = new Scanner(file1);
            Scanner scanner2 = new Scanner(file2);
            Scanner scanner3 = new Scanner(file3);

            while (scanner1.hasNextLine()) {
                String line1 = scanner1.nextLine();
                String line2 = scanner2.nextLine();
                String line3 = scanner3.nextLine();
                this.vehicleNames.add(line1);
                this.vehicleNames.add(line2);
                this.vehicleNames.add(line3);
            }

            scanner1.close(); 
            scanner2.close(); 
            scanner3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // load list of staff
        this.staffList = new ArrayList();
        try {
            File file = new File("filename.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.staffnames.add(line); 
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.staffCount = 0;
        this.report = null;
    }
    // Setters 
    // set new budget
    public void setOpBudget(Double opBudget){
        this.opBudget = opBudget;
    }
    // add all vehicle in list
    public void setVehicleList(List<Vehicle> vehicleList){
        this.vehicleList = vehicleList;
    }
    // add all staff in list
    public void setStaffList(List<Staff> staffList){
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
    // add a staff to list
    public void addStaff(Staff newStaff){
        staffList.add(newStaff);
    }
    // Getters
    // return budget
    public Double getOpBudget(){
        return opBudget;
    }
    // return vehicle list
    public List<Vehicle> getVehicleList(){
        return vehicleList;
    }
    // return staff list
    public List<Staff>  getStaffList(){
        return staffList;
    }
    public Integer getStaffCount(){
        return staffCount;
    }
    public List<String> setReport(){
        return report;
    }
    // creates a random 5 digit id for each employee 
    public int generateID(){
        UUID uuid = UUID.randomUUID();
        String uniqueId = uuid.toString().replaceAll("-", "").substring(0, 5);
        return Integer.parseInt(uniqueId);
    }
    // create a SalesPerson
    public Staff createSalesPersonStaff(){
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int index = random.nextInt(this.staffnames.size());
        String name = this.staffnames.get(index);
        this.staffnames.remove(index);

        Staff newStaff = new Staff(name, 120.0, generateID(), 1400.88, 9.5, "Sales Person", 200.5);
        return newStaff;
    }
    // create a intern
    public Staff createInternStaff(){
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int index = random.nextInt(this.staffnames.size());
        String name = this.staffnames.get(index);
        this.staffnames.remove(index);

        Staff newStaff = new Staff(name, 140.0, generateID(), 1700.88, 9.5, "Intern", 300.5);
        return newStaff;
    }
    // create a Machanic
    public Staff createMecanicStaff(){
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int index = random.nextInt(this.staffnames.size());
        String name = this.staffnames.get(index);
        this.staffnames.remove(index);

        Staff newStaff = new Staff(name, 160.0, generateID(), 1900.88, 9.1, "Mechanic", 500.5);
        return newStaff;
    }

    // create a Car
    public Vehicle createCar(){
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int index = random.nextInt(this.vehicleNames.size());
        // split list. Should be in order (car, performance, pickup) used https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space 
        for(String str: vehicleNames){
            String[] splitstr = str.split("\\s+"); // make, model, vim
            
        }
        String name = this.staffnames.get(index);
        this.staffnames.remove(index);

        Staff newStaff = new Staff(name, 140.0, generateID(), 1700.88, 9.5, "Intern", 300.5);
        return newStaff;
    }
    // create a Performance Car
    public Vehicle createPerformanceCar(){
        
    }
    // create Pickup car
    public Vehicle createPickupCar(){
        
    }
}
 