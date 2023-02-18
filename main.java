import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

class Opening{
    private double currBudget = 0;
    private int internCount = 0;
    private int carCount = 0;
    private int performanceCarCount;
    private int pickupCarCount;
    private List<Staff> interList = new ArrayList<>();

    Opening(FNCD fncd){
        //this.staffList = fncd.getStaffList();
        this.interList = retrunListInterns(fncd.getStaffList());
        this.currBudget = fncd.getOpBudget();
        this.internCount = threeInterns(fncd.getStaffList());
        this.carCount = fourCars(true, false, fncd);
        this.performanceCarCount = fourCars(false, true, fncd);
        this.pickupCarCount = fourCars(false, false, fncd);
    }
    // check intern
    public int threeInterns(List<Staff> curentStaff){
        int count = 0;
        for(Staff staff: curentStaff){
            if(staff instanceof Intern){
                count++;
            }
        }
        return count;
    }
    public List<Staff> retrunListInterns(List<Staff> curentStaff){
        List<Staff> temp = new ArrayList<>();
        for(Staff staff: curentStaff){
            if(staff instanceof Intern){
                temp.add(staff);
            }
        }
        return temp;
    }
    public int returnInternCount(){
        return this.internCount;
    }
    public List<Staff> returnList(){
        return this.interList;
    }
    public List<Staff> internHire(List<Staff> curentStaff, FNCD fncd){
        Staff tempstaffie;
        if(this.internCount < 3){
            while(this.internCount < 3){
                tempstaffie = fncd.createInternStaff();
                curentStaff.add(tempstaffie);
                this.internCount+=1;
            }
        }
        return curentStaff;
    }  
    // check Car
    public int fourCars(boolean car, boolean pc, FNCD fncd){
        int count = 0;
        int count2 = 0;
        int count3= 0;
        for(Vehicle cars: fncd.getVehicleList()){
            if(cars instanceof Car){
                count++;
            }else if(cars instanceof Performance_Car){
                count2++;
            }else if(cars instanceof Pickup_Car){
                count3++;
            }
        }
        if(car == true){
            return count;
        }else if(pc == true){
            return count2;
        }else{
            return count3;
        }
    }
    public List<Vehicle> AddVehicle(FNCD fncd){
        // now what every dosnt have 4 go until their is four each or buget reached
        boolean flag = false;
        while((this.carCount < 4 || this.performanceCarCount < 4 || this.pickupCarCount < 4) || flag == true){
            if(this.carCount < 4){
                Vehicle tempCar = fncd.createCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    this.carCount+=1;

                }
            }
            if(this.performanceCarCount < 4){
                Vehicle tempCar = fncd.createPerformanceCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    this.performanceCarCount+=1;
                }
            }
            if(this.pickupCarCount < 4){
                Vehicle tempCar = fncd.createPickupCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    this.pickupCarCount+=1;
                }
            }
        }
        return fncd.getVehicleList();
    }
}
class Washing{
    private int randomChoice1;
    private int randomChoice2;
    private String weekDay;
    private List<Intern> staffList;


    Washing(){
        this.randomChoice1 = 0;
        this.randomChoice2 = 0;
        this.staffList = null;
    }
    // code to wash the vehicle
    public void washVehicle(List<Vehicle> VehicleList, Staff intern) {
        // get two random staff
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int internCount1 = 0;

        // only can wash 2 cars per day
        while(internCount1 < 2){
            // start cleaning dirty cars
            for(Vehicle car: VehicleList){
                if(car.getCleanliness() == "Dirty"){
                    // %80 chance on becoming clean %10 chance of becoming sparkling
                    double randomNumber = random.nextDouble();
                    if(randomNumber < 0.1){
                        car.setCondition("Sparkling");
                        intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                        internCount1 += 1;
                        // increase bonus intern.bonus = 
                    }else if(randomNumber < 0.8){
                        car.setCondition("Clean");
                        internCount1 += 1;
                    }else{
                        System.out.printf("Washing did not have an affect on the vehicle\n");
                        internCount1 += 1;
                    }
                }
            }
            // move on to clean cars
            for(Vehicle car: VehicleList){
                if(car.getCleanliness() == "Clean"){
                    // %5 chance of becoming dirty, %30 chance on becmoming sparkling
                    double randomNumber = random.nextDouble();
                    if(randomNumber < 0.05){
                        car.setCondition("Dirty");
                        internCount1 += 1;
                    }else if(randomNumber < 0.3){
                        car.setCondition("Sparkling");
                        intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                        internCount1 += 1;
                    }else{
                        System.out.printf("Washing did not have an affect on the vehicle\n");
                        internCount1 += 1;
                    }
                }
            }
        }
    }
}
class Repair{
    private double repairChance;
    private String day;
    private double bonus;

    Repair(){
        this.repairChance = 0.8;
        this.bonus = 0.0;

    }

    public void repairVehicle(List<Vehicle> VehicleList, Staff mech) {
        // repair the vehicle
        Random random = new Random();
        double randomNumber = random.nextDouble();
        int mecCount = 0;
        while(mecCount < 2){
            for(Vehicle vehicle: VehicleList){
                // upgrade condtition
                if(vehicle.getCondition() != "New"){
                // mechanic can repair
                    if(randomNumber <= 0.80){
                        if(vehicle.getCondition() == "Used"){
                            vehicle.setCondition("Like New");
                            vehicle.setSalesPrice(vehicle.getSalesPrice() * 1.5);
                        }else if(vehicle.getCondition() == "Broken"){
                            vehicle.setCondition("Used");
                            vehicle.setSalesPrice(vehicle.getSalesPrice() * 1.25);
                        }
                        mech.setBonusTemp(mech.getBonusTemp()+vehicle.getVehicleBonus());
                        mecCount+=1;
                    }
                    //else{
                    //     System.out.printf("The Mechanic cant repair");
                    // }
                    // downgrade cleanliness
                    if(vehicle.getCleanliness() != "Dirty"){
                        if(vehicle.getCleanliness() == "Sparkling"){
                            vehicle.setCleanliness("Clean");
                        }else if(vehicle.getCleanliness() == "Clean"){
                            vehicle.setCleanliness("Dirty");
                        }
                    }
                }
            }
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

    private Double saleTemp;
    private Boolean car4Sale;
    private Double commissionBonus;

    Selling() {
        this.tempVehicleList = new ArrayList();
        this.saleChance = chanceLooking();

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
    public String chooseRandomCar() {
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
        return vehicleType;
    }

    //random chance for looking, wants one, needs one
    public Double chanceLooking() {
        Random random2 = new Random();
        buyType = random2.nextDouble();
        double ranDob = 0;
        if (this.buyType < 0.1) {
            ranDob = 0.1;
        } else if (this.buyType < 0.4) {
            ranDob = 0.4;
        } else {
            ranDob = 0.7;
        }
        return ranDob;
    }

    //highest selling vehicle
    public Vehicle mostExpensive(FNCD fncd) {
        List<Vehicle> VehicleList = fncd.getVehicleList();
        String tempt = chooseRandomCar();
        Vehicle tempCar = new Vehicle("", "", "");
        for (Vehicle car : VehicleList) {
            if (car.getCondition() != "Broken" && car.getType() == tempt) {
                // System.out.printf("%s | %s \n", car.getCondition(), chooseRandomCar());
                if (saleTemp <= car.getSalesPrice()) {
                    saleTemp = car.getSalesPrice();
                    tempCar = car;
                }
                car4Sale = false;
            } else if (car.getCondition() != "Broken" && car.getType() != tempt) {
                if (saleTemp <= car.getSalesPrice()) {
                    saleTemp = car.getSalesPrice();
                    tempCar = car;
                }
                car4Sale = true;
            }
            // else {
            //     System.out.println("No cars for sale");
            //     break;
            // }
        }
        //System.out.println("No cars for sale");
        return tempCar;
    }

    public List<Vehicle> sellThisCar(FNCD fncd) {
        Staff tempStaff;
        List<Vehicle> VehicleList = fncd.getVehicleList();
        List<Staff> staffList = fncd.getStaffList();
        Vehicle sVehicle;
        sVehicle = mostExpensive(fncd);
        if (sVehicle.getCondition() == "New") {
            this.saleChance += 0.1;
            if (car4Sale == true) {
                this.saleChance -= 0.2;
            }
        } else if (sVehicle.getCleanliness() == "Sparkling") {
            this.saleChance += 0.1;
            if (car4Sale == true) {
                this.saleChance -= 0.2;
            }
        }
        //selling vehicle and removing/adding to appropriate list
        Random random2 = new Random();
        Double temp3 = random2.nextDouble();
        Double bnus;
        System.out.printf("This is the sales Chance: %f | %f", this.saleChance, temp3);
        if (temp3 < this.saleChance) {
            fncd.addVehiclesSold(sVehicle);
            VehicleList.remove(sVehicle);
            tempStaff = whoSold(fncd);
            bnus = sVehicle.getVehicleBonus();
            for(Staff staff : staffList) {
                if(staff.getName() == tempStaff.getName()) {
                    staff.setBonus(staff.getBonus() + staff.getBonus());
                }
            }
            System.out.println("A car was sold");
        }else{
            System.out.println("A car was not sold");
        }
        return fncd.getSoldVehicle();
    }
}

class Ending{
    private Double tempPay;
    private List<Staff> tempReport;
    List<Staff> quittList = new ArrayList<>();
    List<Vehicle>
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

        this.quittList = quitList;
        tempReport = quitList;
    }
    public void pReport(FNCD fncd){
        List<Staff> staffList = fncd.getStaffList();
        List<Staff> tempQuit = new ArrayList<>();
        List<Vehicle> vehicleList = fncd.getVehicleList();
        tempQuit = this.quittList;

        System.out.printf("Staff that that\n");
        for (Staff staff : tempQuit){
//            staff.setHours(staff.getHours() + 8.0);
            System.out.printf(staff.getName() + ", " + staff.getHours() + ", "+ staff.getBonus() + ", Quits\n" );
        }
        System.out.printf("Staff still working that\n");
        for (Staff staff : staffList){
//            staff.setHours(8.0);
            System.out.printf(staff.getName() + ", " + staff.getHours() + ", "+ staff.getBonus() + ", Working\n" );
        }
        for (Vehicle car : fncd.getSoldVehicle() ){
//            staff.setHours(8.0);
            System.out.printf(car.getName() + ", " + car.getCost() + ", "+ car.getSalesPrice() + ","+ car.getCondition()+ "," +car.getCleanliness()+  ", Sold\n" );
        }

        for (Vehicle car : vehicleList){
//            staff.setHours(8.0);
            System.out.printf(car.getName() + ", " + car.getCost() + ", "+ car.getSalesPrice() + ","+ car.getCondition()+ "," +car.getCleanliness()+  ", In Stock\n" );
        }
    }
}
public class main {
    public static void main(String[] args) {
        double buget = 500000;
        List<String> workDays;
        FNCD fncd = new FNCD(buget); 


        for(int i = 0; i < 30; i++){
            // run every senerio with openeing
            Opening open = new Opening(fncd);

            // run washing
            Washing wash = new Washing();
            for(Staff intern: open.returnList()){
                wash.washVehicle(fncd.getVehicleList(), intern);
            }

            // run repair
            Repair repair = new Repair();
            for(Staff mec: fncd.getStaffList()){
                if(mec instanceof Mechanic){
                    repair.repairVehicle(fncd.getVehicleList(), mec);
                }
            }

            // // selling
            // Selling sell = new Selling();


            // // ending
            // Ending end = new Ending();
            // end.pReport(fncd);
        }
            
    }
}
