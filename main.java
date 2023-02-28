import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

class Opening{
    private double currBudget = 0;
    private int internCount = 0;
    private int carCount;
    private int performanceCarCount;
    private int pickupCarCount;
    private int electricCarCount;
    private int motorcycleCount;
    private int monsterTruck;
    private List<Staff> interList = new ArrayList<>();

    Opening(FNCD fncd){
        this.internCount = threeInterns(fncd.getStaffList(), fncd);
        this.interList = retrunListInterns(fncd.getStaffList(), fncd);
        // defult 3 cars
        fncd.LoggerReport("      * Current Vehicle Owned ");
        fncd.LoggerReport("       * Regular Cars ");
        this.carCount = fourCars(true, false, false, false, false, fncd);
        fncd.LoggerReport("       * Performance Cars ");
        this.performanceCarCount = fourCars(false, true, false, false, false, fncd);
        fncd.LoggerReport("       * PickUp Cars ");
        this.pickupCarCount = fourCars(false, false, true, false, false, fncd);
        // new vehicles 
        fncd.LoggerReport("       * Electric Cars ");
        this.electricCarCount = this.pickupCarCount = fourCars(false, false, false, true, false, fncd);
        fncd.LoggerReport("       * Motorcycle ");
        this.motorcycleCount = this.pickupCarCount = fourCars(false, false, false, false, true, fncd);
        fncd.LoggerReport("       * Monster Truck ");
        this.monsterTruck = this.pickupCarCount = fourCars(false, false, false, false, false, fncd);
    }
    // check intern
    public int threeInterns(List<Staff> curentStaff, FNCD fncd){
        int count = 0;
        for(Staff staff: curentStaff){
            if(staff instanceof Intern){
                count++;
            }
        }
        fncd.LoggerReport("      * Current Intern Count " + count);
        return count;
    }
    public List<Staff> retrunListInterns(List<Staff> curentStaff, FNCD fncd){
        List<Staff> temp = new ArrayList<>();
        for(Staff staff: curentStaff){
            if(staff instanceof Intern){
                //fncd.LoggerReport("      * Intern Currently Working "+staff.getName());
                fncd.LoggerReport("          - "+staff.getName());
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
                fncd.LoggerReport("      * Intern Hired "+ tempstaffie.getName());
                this.internCount+=1;
            }
        }
        return curentStaff;
    }  
    // check Car
    public int fourCars(boolean car, boolean pc, boolean pu, boolean ec, boolean m, FNCD fncd){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        // new cars 
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        String tempHold = "          - ";
        for(Vehicle cars: fncd.getVehicleList()){
            if(cars instanceof Car && car == true){
                count1++;
                tempHold += cars.getName()+", ";
            }else if(cars instanceof Performance_Car && pc == true){
                count2++;
                tempHold += cars.getName()+", ";
            }else if(cars instanceof Pickup_Car && pu == true){
                count3++;
                tempHold += cars.getName()+", ";
            }else if(cars instanceof Electric_Car && ec == true){
                count4++;
                tempHold += cars.getName()+", ";
            }else if(cars instanceof Motorcycle && m  == true){
                count5++;
                tempHold += cars.getName()+", ";
            }else if(cars instanceof Monster_Truck){
                count6++;
                tempHold += cars.getName()+", ";
            }
        }
        fncd.LoggerReport(tempHold);
        if(car == true){
            return count1;
        }else if(pc == true){
            return count2;
        }else if(pu == true){
            return count3;
        }else if(ec == true){
            return count4;
        }else if(m == true){
            return count5;
        }else{
            return count6;
        }
    }
    public List<Vehicle> AddVehicle(FNCD fncd){
        // now what every dosnt have 4 go until their is four each or buget reached
        boolean flag = false;
        while((this.carCount < 4 || this.performanceCarCount < 4 || this.pickupCarCount < 4 || this.electricCarCount < 4 || this.motorcycleCount < 4 || this.motorcycleCount < 4) || flag == true){
            if(this.carCount < 4){
                Vehicle tempCar = fncd.createCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    fncd.LoggerReport("      * Bought Regular Car " + tempCar.getName());
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
                    fncd.LoggerReport("      * Bought Performance Car "+ tempCar.getName());
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
                    fncd.LoggerReport("      * Adding PickUp Car "+ tempCar.getName());
                    this.pickupCarCount+=1;
                }
            }
            if(this.electricCarCount < 4){
                Vehicle tempCar = fncd.createElectricCar();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    fncd.LoggerReport("      * Adding Electric Car "+ tempCar.getName());
                    this.pickupCarCount+=1;
                }
            }
            if(this.motorcycleCount < 4){
                Vehicle tempCar = fncd.createMotorcycle();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    fncd.LoggerReport("      * Adding Motorcycle "+ tempCar.getName());
                    this.pickupCarCount+=1;
                }
            }
            if(this.monsterTruck < 4){
                Vehicle tempCar = fncd.createMonsterTruck();
                if(fncd.getOpBudget() - tempCar.getCost() < 0){
                    flag = true;
                    break;
                }else{
                    fncd.setOpBudget(fncd.getOpBudget() - tempCar.getCost());
                    fncd.addVehicle(tempCar);
                    fncd.LoggerReport("      * Adding Monster Truck "+ tempCar.getName());
                    this.pickupCarCount+=1;
                }
            }
        }
        fncd.LoggerReport("");
        return fncd.getVehicleList();
    }
}
class Washing{
    private int randomChoice1;
    private int randomChoice2;
    private String weekDay;
    private List<Staff> staffList = new ArrayList<>();


    Washing(FNCD fncd){
        this.randomChoice1 = 0;
        this.randomChoice2 = 0;
        this.staffList = retrunListInterns(fncd.getStaffList(), fncd);
    }
    // code to wash the vehicle
    public void washVehicle(FNCD fncd) {
        // get two random staff
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int internCount1 = 0;

        for(Staff intern: this.staffList){
            // only can wash 2 cars per day
            while(internCount1 < 2){
                fncd.LoggerReport("      * "+intern.getName()+" Washing Report");
                // start cleaning dirty cars
                for(Vehicle car: fncd.getVehicleList()){
                    if(car.getCleanliness() == "Dirty"){
                        // %80 chance on becoming clean %10 chance of becoming sparkling
                        double randomNumber = random.nextDouble();
                        if(randomNumber < 0.1){
                            fncd.LoggerReport("          - Vehicle was dirty and is now Sparkling "+car.getName());
                            car.setCleanliness("Sparkling");
                            intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                            internCount1++;
                            // increase bonus intern.bonus = 
                        }else if(randomNumber < 0.8){
                            fncd.LoggerReport("          - Vehicle was dirty and is now Clean "+car.getName());
                            car.setCleanliness("Clean");
                            internCount1++;
                        }else{
                            //System.out.printf("Washing did not have an affect on the vehicle 1\n");
                            internCount1++;
                        }
                    }
                    if(internCount1 == 2){
                        break;
                    }
                }
                if(internCount1 == 2){
                    break;
                }
                // move on to clean cars
                for(Vehicle car: fncd.getVehicleList()){
                    if(car.getCleanliness() == "Clean"){
                        // %5 chance of becoming dirty, %30 chance on becmoming sparkling
                        double randomNumber = random.nextDouble();
                        if(randomNumber < 0.05){
                            fncd.LoggerReport("          - Vehicle was Clean and is now Dirty "+car.getName());
                            car.setCleanliness("Dirty");
                            internCount1++;
                        }else if(randomNumber < 0.3){
                            fncd.LoggerReport("          - Vehicle was Clean and is now Sparkling "+car.getName());
                            car.setCleanliness("Sparkling");
                            intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                            internCount1++;
                        }else{
                            //System.out.printf("Washing did not have an affect on the vehicle 2 \n");
                            internCount1++;
                        }
                    }
                    if(internCount1 == 2){
                        break;
                    }
                }
            }
            internCount1=0;
        }
        fncd.LoggerReport("");
    }
    public List<Staff> retrunListInterns(List<Staff> curentStaff, FNCD fncd){
        int count = 0;
        List<Staff> temp = new ArrayList<>();
        fncd.LoggerReport("      * Intern Currently Working ");
        for(Staff staff: curentStaff){
            if(staff instanceof Intern){
                fncd.LoggerReport("          - "+ staff.getName());
                temp.add(staff);
                count+=1;
            }
            if(count == 3){
                break;
            }
        }
        return temp;
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

    public void repairVehicle(List<Vehicle> VehicleList, Staff mech, FNCD fncd) {
        // repair the vehicle
        Random random = new Random();
        double randomNumber = random.nextDouble();
        int mecCount = 0;
        fncd.LoggerReport("      * "+mech.getName()+" Repairing Report");
        while(mecCount < 2){
            for(Vehicle vehicle: VehicleList){
                // upgrade condtition
                if(vehicle.getCondition() != "New"){
                // mechanic can repair
                    if(randomNumber < 0.80){
                        if(vehicle.getCondition() == "Used"){
                            fncd.LoggerReport("          - Vehicle was Used and is now Like New "+vehicle.getName());
                            vehicle.setCondition("Like New");
                            vehicle.setSalesPrice(vehicle.getSalesPrice() * 1.5);
                        }else if(vehicle.getCondition() == "Broken"){
                            fncd.LoggerReport("          - Vehicle was Broken and is now Used "+vehicle.getName());
                            vehicle.setCondition("Used");
                            vehicle.setSalesPrice(vehicle.getSalesPrice() * 1.25);
                        }
                        mech.setBonusTemp(mech.getBonusTemp()+vehicle.getVehicleBonus());
                    }
                    if(vehicle.getCleanliness() != "Dirty"){
                        if(vehicle.getCleanliness() == "Sparkling"){
                            fncd.LoggerReport("          - Vehicle was Sparkling and is now clean "+vehicle.getName());
                            vehicle.setCleanliness("Clean");
                        }else if(vehicle.getCleanliness() == "Clean"){
                            fncd.LoggerReport("          - Vehicle was Clean and is now Dirty "+vehicle.getName());
                            vehicle.setCleanliness("Dirty");
                        }
                    }
                    mecCount+=1;
                    if(mecCount == 2){
                        break;
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
    public List<String> vehicleTypes = Arrays.asList("Performance Car", "Car", "Pickup Car");
    public List<Staff> salesStaff;
    public int numOfBuys;
    private Double saleTemp;
    private Boolean car4Sale;
    private Double commissionBonus;

    Selling() {
        this.tempVehicleList = new ArrayList();
        this.saleChance = chanceLooking();
        this.saleTemp = 0.0;
        this.salesStaff = new ArrayList();
        this.car4Sale = false;
    }

    public Staff whoSold(FNCD fncd) {
        List<Staff> staffList = fncd.getStaffList();
        Staff tempStaff;
        for (Staff staff : staffList) {
            if (staff instanceof SalesPerson) {
                salesStaff.add(staff);
            }
        }
        if(salesStaff.size() == 0){
            //System.out.printf("      * ! No current Sales person works here !%s\n");
            return null;
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

        String vehicleType1 = vehicleTypes.get(temp);
        return vehicleType1;
    }

    //random chance for looking, wants one, needs one
    public Double chanceLooking() {
        Random random2 = new Random();
        buyType = random2.nextDouble();
        double ranDob = 0;
        if (buyType < 0.1) {
            ranDob = 0.1;
        } else if (buyType < 0.4) {
            ranDob = 0.4;
        } else {
            ranDob = 0.7;
        }
        return ranDob;
    }

    //highest selling vehicle
    public Vehicle mostExpensive(FNCD fncd) {
        String tempt = chooseRandomCar();
        Double saleTemp1 = 0.0;
        Vehicle tempCar = new Vehicle("", "", "");

        for (Vehicle car : fncd.getVehicleList()) {
            if (car.getCondition() != "Broken" && car.getType() == tempt) {
                if (saleTemp1 <= car.getSalesPrice()) {
                    saleTemp1 = car.getSalesPrice();
                    tempCar = car;
                }
                this.car4Sale = false;
            }else if (car.getCondition() != "Broken") {
                if (saleTemp <= car.getSalesPrice()) {
                    saleTemp = car.getSalesPrice();
                    tempCar = car;
                }
                this.car4Sale = true;
            }
        }
        return tempCar;
    }

    public List<Vehicle> sellThisCar(FNCD fncd) {
        Staff tempStaff;
        List<Vehicle> VehicleList = fncd.getVehicleList();
        List<Staff> staffList = fncd.getStaffList();
        Vehicle sVehicle = mostExpensive(fncd);

        if(sVehicle.getVim() == ""){
            fncd.LoggerReport("\n            * Didn't Find a Valid Vehicle!");
            return fncd.getSoldVehicle();
        }else{
            if (sVehicle.getCondition() == "New") {
                this.saleChance += 0.1;
                if (this.car4Sale == true) {
                    this.saleChance -= 0.2;
                }
            } else if (sVehicle.getCleanliness() == "Sparkling") {
                this.saleChance += 0.1;
                if (this.car4Sale == true) {
                    this.saleChance -= 0.2;
                }
            }
            //selling vehicle and removing/adding to appropriate list
            Random random2 = new Random();
            Double temp3 = random2.nextDouble();
            //System.out.printf("This is the sales Chance: %f | %f", this.saleChance, temp3);
            if (temp3 < this.saleChance) {
                
                fncd.addVehiclesSold(sVehicle);
                VehicleList.remove(sVehicle);
                tempStaff = whoSold(fncd);
                if(tempStaff == null){
                    fncd.LoggerReport("            * Customer Interested but No current Sales person works here !");
                    return fncd.getSoldVehicle();
                }
                //Double bnus = sVehicle.getVehicleBonus();
                for(Staff staff : staffList) {
                    if(staff.getName() == tempStaff.getName()) {
                        staff.setBonus(staff.getBonus() + staff.getBonus());
                        fncd.setOpBudget(fncd.getOpBudget() + sVehicle.getSalesPrice());
                        fncd.LoggerReport("            * Vehicle was Sold "+sVehicle.getName()+". It was fixed by "+staff.getName());
                    }
                }
            }else{
                fncd.LoggerReport("            * Customer Didnt Want A Car");
            }
            return fncd.getSoldVehicle();
        }
    }
}
// should occur only sunday and wednesday 
class RacingEvent{
    private List<Vehicle> carList = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    RacingEvent(FNCD fncd){
        this.carList = racableCars(fncd);
        this.staffList = racingStaff(fncd);
    }

    // can only race on wendsday and sunday
    public void racingDay(FNCD fncd){
        Random random = new Random();
        List<Vehicle> VehicleList = fncd.getVehicleList();
        List<Staff> sList = fncd.getStaffList();
        // check if we are on a day to race
        fncd.LoggerReport("Racing... ");
        if(fncd.getDay() == "Wensday" || fncd.getDay() == "Sunday"){
            for(Vehicle car: VehicleList){
                for(Staff staff: sList){
                    if(this.carList.contains(car) && this.staffList.contains(staff)){
                        int place = 1 + (20 - 1) * random.nextInt();
                        if(place == 1 || place == 2 || place == 3){
                            car.addWinCount();
                            car.setSalesPrice(car.getSalesPrice()*1.10);
                            staff.setBonus(staff.getBonus()+300);
                            fncd.LoggerReport("      * Vehicle that won in the race: "+car.getName()+" came in position "+place+" with a win count of "+car.getWinCount()+". The Driver was "+staff.getName());
                        }else{
                            car.setCondition("Broken");
                            double injuryChance = random.nextDouble();
                            // 30% chance person is injured
                            if(injuryChance < 0.30){
                                // set driver to injured 
                                staff.giveInjury();
                                staff.quit();
                                fncd.LoggerReport("      * Vehicle that lost in the race: "+car.getName()+" came in position "+place+" with a win count of "+car.getWinCount()+". The Injured Driver was "+staff.getName());
                            }else{
                                fncd.LoggerReport("      * Vehicle that lost in the race: "+car.getName()+" came in position "+place+" with a win count of "+car.getWinCount()+". The Driver was "+staff.getName());
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("You will not be racing today!");
        }
    } 
    public List<Staff> racingStaff(FNCD fncd){
        Random random1 = new Random();
        List<Staff> staffList = fncd.getStaffList();
        List<Staff> sL = new ArrayList();
        // check vehicles race elagability 
        for(Staff person: staffList){
            if(person instanceof Driver){
                sL.add(person);
            }
        }
        if(sL.size() > 3 && this.carList.size() == 3){
                int index1 = random1.nextInt(sL.size());
                int index2 = random1.nextInt(sL.size());
                int index3 = random1.nextInt(sL.size());
            List<Staff> threestaff = new ArrayList();
                threestaff.add(sL.get(index1));
                threestaff.add(sL.get(index2));
                threestaff.add(sL.get(index3));
            return threestaff;
        }else if(sL.size() > 3 && this.carList.size() < 3){
            List<Staff> threestaff = new ArrayList();
            for(int i = 0; i < this.carList.size(); i++){
                int index = random1.nextInt(sL.size());
                threestaff.add(sL.get(index));
            }
            return threestaff;
        }else{
            return sL;
        }
    }
    public List<Vehicle> racableCars(FNCD fncd){
        List<Vehicle> vehicleList = fncd.getVehicleList();
        List<Vehicle> carL = new ArrayList();
        // check vehicles race elagability 
        for(Vehicle car: vehicleList){
            if(car instanceof Car || car instanceof Electric_Car){
                continue;
            }else{
                if(car.getCondition() == "Broken"){
                    continue;
                }else{
                    carL.add(car);
                }
            }
        }
        if(carL.size() > 3){
            Random random1 = new Random();
                int index1 = random1.nextInt(carL.size());
                int index2 = random1.nextInt(carL.size());
                int index3 = random1.nextInt(carL.size());
            List<Vehicle> threecars = new ArrayList();
                threecars.add(carL.get(index1));
                threecars.add(carL.get(index2));
                threecars.add(carL.get(index3));
            return threecars;
        }else{
            return carL;
        }
    }
} 
class Ending{
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
        //Staff tempIntern1;
        Staff tempIntern2;
        // should I make a payStaff option in
        for(Staff staff: staffList){
            if(fncd.getOpBudget() >= staff.getSalary()){
                fncd.setOpBudget(fncd.getOpBudget() - staff.getSalary());
                staff.setHours(staff.getHours() +8.0);
            }
        }
        // if the random intern chance is within 10% fire/quit intern
        if(internChance < quitChance){
            for (Staff staff : staffList) {
                if (staff instanceof Intern) {
                    this.quitList.add(staff);
                    staffList.remove(staff);
                    break;
                }
            }

        }
        // mechanic quits
        if(mechChance < quitChance){
            Staff tempIntern1 = new Staff("",0.0,0,0.0,0.0,"",0.0);
            List<Staff> copyList = staffList; 
            for (Staff staff : copyList) {
                if (staff instanceof Mechanic) {
                    this.quitList.add(staff);
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                }
            }
            // grabbing an intern to replace a mechanic
            List<Staff> copyList2 = new ArrayList<Staff>(fncd.getStaffList()); 
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
        List<Staff> copyList3 = staffList; 
        if(salesChance < quitChance){
            for(Staff staff : copyList3) {
                if(staff instanceof SalesPerson) {
                    this.quitList.add(staff);
                    staffList.remove(staff);
                    fncd.setStaffList(staffList);
                }
            }
            // grabbing an intern to replace a salesperson
            List<Staff> copyList4 = staffList;
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
            fncd.LoggerReport("      * "+staff.getName() + ", " + staff.getHours() + ", "+ staff.getSalary() + ", " + staff.getBonusTemp() + ", Quits\n" );
        }
        fncd.LoggerReport("| Staff still working that |");
        for (Staff staff : staffList){
        // staff.setHours(8.0);
            fncd.LoggerReport("      * "+staff.getName() + ", " + staff.getHours() + ", " + staff.getSalary() + ", "+ staff.getBonus() + ", Working" );
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
public class main {
    public static void main(String[] args) {
        // verables 
        double buget = 500000;
        FNCD fncd = new FNCD(buget); 
        Random random = new Random();
        // used to calculate for costomers on day 
        List<Integer> weekDays = Arrays.asList(0,1,2,3,4,5);
        List<Integer> weekEnds = Arrays.asList(2,3,4,5,6,7,8);

        // now open all 30 days 
        for(int i = 0; i < 5; i++){
            fncd.LoggerReport("----------------------------------------------");
            fncd.LoggerReport("***** FNCD Day "+fncd.getDay()+" "+(i+1)+ "****\n");

            // run every senerio with openeing
            fncd.LoggerReport("Opening... (current budget "+fncd.getOpBudget()+")");
            Opening open = new Opening(fncd);
            open.internHire(fncd.getStaffList(), fncd);
            open.AddVehicle(fncd);

            // run washing
            fncd.LoggerReport("Washing...");
            Washing wash = new Washing(fncd);
            wash.washVehicle(fncd);
            

            //run repair
            fncd.LoggerReport("Repairing... ");
            Repair repair = new Repair();
            for(Staff mec: fncd.getStaffList()){
                if(mec instanceof Mechanic){
                    repair.repairVehicle(fncd.getVehicleList(), mec, fncd);
                }
            }

            //run Selling
            fncd.LoggerReport("Selling... ");
            Selling mop = new Selling();
            if(fncd.getDayIndex() < 5){
                int indext = random.nextInt(weekDays.size());
                fncd.LoggerReport("      * Number of customers came in on a week day are "+indext);
                for(int j = 0; j < weekDays.get(indext); j++){
                    fncd.LoggerReport("      * Customer "+(j+1));
                    mop.sellThisCar(fncd);
                }
            }else{
                int index = random.nextInt(weekEnds.size());
                fncd.LoggerReport("      * Number of customers came in on a weekend day are "+index+"\n");
                for(int j = 0; j < weekEnds.get(index); j++){
                    mop.sellThisCar(fncd);
                }
            }
            // ending
            Ending end = new Ending();
            end.payStaff(fncd);
            end.pReport(fncd);
            //System.out.println("\n");
            
            fncd.LoggerReport("\nChecking Staff... \n");
            for(Staff pp: fncd.getStaffList()){
                String newline = "      * "+pp.getName()+" "+pp.getPosition()+" "+pp.getBonus()+" "+pp.getBonusTemp();
                fncd.LoggerReport(newline);
            }

            fncd.nextDay();
        }    
    }
}
