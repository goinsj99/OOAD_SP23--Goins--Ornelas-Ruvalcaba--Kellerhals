import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

class Opening{
    private int internCount = 0;
    private int carCount;
    private int performanceCarCount;
    private double currBudget = 0;
    private int pickupCarCount;
    private List<Staff> addStaffList = new ArrayList();
    private List<Vehicle> addCarList = new ArrayList();


    Opening(FNCD fncd){
        //this.staffList = fncd.getStaffList();
        this.internCount = fourInterns(fncd.getStaffList());
        this.currBudget = fncd.getOpBudget();
        if(this.internCount < 3){
            this.addStaffList = internHire(fncd.getStaffList(), fncd);
        }else{
            this.addStaffList = null;
        }
        // now check vehicles
        this.addCarList = CarCount(fncd);
        this.carCount = 0;
        this.performanceCarCount = 0;
        this.pickupCarCount = 0;
        for(Vehicle car: fncd.getVehicleList()){
            if(car instanceof Car){
                carCount++;
            }else if(car instanceof Performance_Car){
                performanceCarCount++;
            }else if(car instanceof Pickup_Car){
                pickupCarCount++;
            }
        }
    }
    // check intern
    public int fourInterns(List<Staff> curentStaff){
        int count = 0;
        for(Staff staff: curentStaff){
            if(staff instanceof Intern){
                count++;
            }
        }
        return count;
    }
    // add intern
    public List<Staff> internHire(List<Staff> curentStaff, FNCD fncd){
        Staff tempstaffie;
        if(internCount < 3){
            while(internCount != 3){
                tempstaffie = fncd.createInternStaff();
                //fncd.addStaff(tempstaffie);
                //this.staffList.add(fncd.createInternStaff());
                curentStaff.add(tempstaffie);
                this.internCount+=1;
            }
        }
        return curentStaff;
    }
    // check Car
    public List<Vehicle> CarCount(FNCD fncd){
        // now what every dosnt have 4 go until their is four each or buget reached
        Vehicle tempCar;
        boolean flag = false;
        while((carCount < 4 && performanceCarCount < 4 && pickupCarCount < 4) || flag == true){
            if(carCount < 4){
                tempCar = fncd.createCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.addVehicle(tempCar);
                    addCarList.add(tempCar);
                }
            }
            if(performanceCarCount < 4){
                tempCar = fncd.createPerformanceCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.addVehicle(tempCar);
                    addCarList.add(tempCar);
                }
            }
            if(pickupCarCount < 4){
                tempCar = fncd.createPickupCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.addVehicle(tempCar);
                    addCarList.add(tempCar);
                }
            }
        }
        return fncd.getVehicleList();
    }
    // see what staff was added
    public void AddedStaff(){
        for(Staff inter: this.addStaffList){
            System.out.println(inter);
        }
    }
    // see what new cars where bought
    public void AddedCars(){
        for(Vehicle car: this.addCarList){
            System.out.println(car);
        }
    }
}

class Selling {
    private String weekDay;
    private Double buyType;
    private String vehicleChance;
    private String vehicleType;
    private Double initialSale;
    private Double saleChance;
    private List<Vehicle> tempVehicleList;
    public List<String> vehicleChances = Arrays.asList("Just looking", "Wants one", "Needs one");
    public List<String> vehicleTypes = Arrays.asList("Performance", "Cars", "Pickups");
    public List<Staff> salesStaff;
    public List<Vehicle> vehiclesSold;
    private Double saleTemp;
    private Boolean car4Sale;
    private Double commissionBonus;

    Selling(String weekDay, Double buyType, String vehicleChance, String vehicleType, Double initialSale, Boolean car4Sale) {
        this.weekDay = weekDay;
        this.buyType = 0.0;
        this.vehicleChance = vehicleChance;
        this.vehicleType = vehicleType;
        this.initialSale = initialSale;
        this.tempVehicleList = new ArrayList();
        this.saleChance = 0.0;
        this.vehiclesSold = new ArrayList();
        this.car4Sale = car4Sale;
        this.saleTemp = 0.0;
        this.salesStaff = new ArrayList();

    }

    public void sellVehicle(Staff Staff) {
        Random randomBuy = new Random();
        double randomNumber = randomBuy.nextDouble();
        Random randomCarType = new Random();
        double randomCar = randomCarType.nextDouble();
    }

    public Staff whoSold(FNCD fncd) {
        List<Staff> staffList = fncd.getStaffList();
        Staff tempStaff;
        for (Staff staff : staffList) {
            if (staff.getPosition() == "Sales") {
                salesStaff.add(staff);
            }
        }
        Random randoms = new Random();
        int temp = randoms.nextInt(salesStaff.size());
        tempStaff = salesStaff.get(temp);
        return tempStaff;
    }

    //random chance for preferred car
    public void chooseRandomCar(double randomCar) {
        Random random1 = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int temp = random1.nextInt(vehicleTypes.size());
        this.vehicleType = vehicleTypes.get(temp);
        if (this.vehicleType == "Performance") {
            this.vehicleType = "Performance";
        } else if (this.vehicleType == "Cars") {
            this.vehicleType = "Cars";
        } else {
            this.vehicleType = "Pickups";
        }
    }

    //random chance for looking, wants one, needs one
    public Double chanceLooking(double randomNumber) {
        Random random2 = new Random();
        buyType = random2.nextDouble();
        if (this.buyType < 0.1) {
            this.saleChance = 0.1;
        } else if (this.buyType < 0.4) {
            this.saleChance = 0.4;
        } else {
            this.saleChance = 0.7;
        }
        return saleChance;
    }

    //highest selling vehicle
    public Vehicle mostExpensive(FNCD fncd) {
        List<Vehicle> VehicleList = fncd.getVehicleList();
        Vehicle tempCar = new Vehicle("", "", "");
        for (Vehicle car : VehicleList) {
            if (car.getCondition() != "Broken" && car.getType() == vehicleType) {
                if (saleTemp <= car.getSalesPrice()) {
                    saleTemp = car.getSalesPrice();
                    tempCar = car;
                }
                car4Sale = false;
            } else if (car.getCondition() != "Broken" && car.getType() != vehicleType) {
                if (saleTemp <= car.getSalesPrice()) {
                    saleTemp = car.getSalesPrice();
                    tempCar = car;
                }
                car4Sale = true;
            } else {
                System.out.println("No cars for sale");
            }
        }
        return tempCar;
    }

    public Vehicle sellThisCar(FNCD fncd) {
        Staff tempStaff;
        List<Vehicle> VehicleList = fncd.getVehicleList();
        Vehicle sVehicle;
        sVehicle = mostExpensive(fncd);
        if (sVehicle.getCondition() == "New") {
            saleChance += 0.1;
            if (car4Sale == true) {
                saleChance -= 0.2;
            }
        } else if (sVehicle.getCleanliness() == "Sparkling") {
            saleChance += 0.1;
            if (car4Sale == true) {
                saleChance -= 0.2;
            }
        }
//        selling vehicle and removing/adding to appropriate list
        Random random2 = new Random();
        Double temp3 = random2.nextDouble();
        Double bnus;
        if (temp3 < saleChance) {
            vehiclesSold.add(sVehicle);
            VehicleList.remove(sVehicle);
            tempStaff = whoSold(fncd);
            bnus = sVehicle.getVehicleBonus();
            tempStaff.setBonus(bnus);
        }

    }
}
// ending
class Ending{
    private Double tempPay;
    private List<Staff> tempReport;
    Ending(Double tempPay){
        this.tempPay = tempPay;
    }
    public void payStaff(FNCD fncd){
        List<Staff> staffList = fncd.getStaffList();
        List<Staff> quitList = new ArrayList<>();
        Double quitChance = 0.1;
        Random random2 = new Random();
        Integer zero = 0;
        Double mechChance = random2.nextDouble();
        Double salesChance = random2.nextDouble();
        Double internChance = random2.nextDouble();
        List<Staff> StaffList = fncd.getStaffList();
//        Staff tempIntern1;
        Staff tempIntern2;
//      should I make a payStaff option in
        for(Staff staff: StaffList){
            if(fncd.opBudget >= staff.getSalary()){
                fncd.opBudget -= staff.getSalary();
                staff.getSalary();
            }
        }
//        if the random intern chance is within 10% fire/quit intern
//        **** while
        if(internChance < quitChance){
            for (Staff staff : StaffList) {
                if (staff.getPosition() == "Intern") {
                    quitList.add(staff);
                    staffList.remove(staff);
                    zero = 1;
                    break;
                }
            }

        }
        else{
            if(mechChance < quitChance){
                Staff tempIntern1 = new Staff("",0.0,0,0.0,0.0,"",0.0);

                for (Staff staff : StaffList) {
                    if (staff.getPosition() == "Mechanic") {
                        quitList.add(staff);
                        staffList.remove(staff);
                    }
                }
//                grabbing an intern to replace a mechanic
                for (Staff staff : StaffList) {
                    if (staff.getPosition() == "Intern") {
                        tempIntern1 = fncd.createSalesPersonStaff();
                        tempIntern1.setName(staff.getName());
                        staffList.remove(staff);
                    }
                    break;
                }
            }
            if(salesChance < quitChance){
                for (Staff staff : StaffList) {
                    if (staff.getPosition() == "Sales") {
                        quitList.add(staff);
                        staffList.remove(staff);
                    }
                }//                grabbing an intern to replace a salesperson

                for (Staff staff : StaffList) {
                    if (staff.getPosition() == "Intern") {
                        tempIntern2 = fncd.createSalesPersonStaff();
                        tempIntern2.setName(staff.getName());
                        staffList.remove(staff);
                    }
                    break;

                }
            }
        }
        tempReport = quitList;
    }
    public List<String> pReport(FNCD fncd){
        List<Staff> staffList = fncd.getStaffList();
        List<Staff> tempQuit = new ArrayList<>();
        tempQuit =
        for (Staff staff : staffList){
            staff.setHours(8.0);
            tempQuit.add(staff.getName() + ", " + staff.getHours() + ", "+ staff.getBonus() + ", Working" );
        }
        for (Staff staff : staffList){
            staff.setHours(8.0);
            tempReport.add(staff.getName() + ", " + staff.getHours() + ", "+ staff.getBonus() + ", Working" );
        }
        return tempReport;
    }


}
public class main {
    public static void main(String[] args) {
        double buget = 500000;
        FNCD fncd = new FNCD(buget);

        System.out.printf("FNCD Test: %f\n", fncd.opBudget);
        for(Staff str: fncd.staffList){
            System.out.printf("%s, %d, %s\n", str.getName(), str.getStaffID(), str.getPosition());
        }
        for(Vehicle staff: fncd.vehicleList){
            System.out.printf("%s, %f, %s\n", staff.getName(), staff.getCost(), staff.getType());
        }

        System.out.println();
        List<Staff> curr = fncd.getStaffList();
        curr.remove(2); curr.remove(5);
        fncd.setStaffList(curr);
        Opening open = new Opening(fncd);
        System.out.println(open.fourInterns(fncd.getStaffList()));

        // open.AddedCars();
        // open.AddedStaff();




        // Vehicle vehicleTest = new Vehicle("Adrian", "Hes", "Cool");
        // Performance_Car carTest1 = new Performance_Car("Apple", "Its", "Good");


        // String name = vehicleTest.getName();
        // System.out.printf("Here's Vehicle name: %s\n", name);

        // String name2 = carTest1.getName();
        // // String price3 = carTest1.getCondition();
        // System.out.printf("Here's Car name: %s\n", name2);
        // System.out.printf("Here's Car name: %s\n", carTest1.getCondition());
        // System.out.printf("Here's Car name: %s\n", carTest1.getCondition());

        // Pickup_Car testpickup = fncd.createPickupCar();
        // System.out.printf("Here's Car name: %s\n", testpickup.getType());
        // System.out.printf("Here's Car name: %s\n", testpickup.getCondition());
        // System.out.printf("Here's Car name: %s\n", testpickup.getCondition());



    }
}
