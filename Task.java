import java.util.Random;

//import VehicleClass.Car;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

// opening
class Opening{

}

// selling
class Selling {
    private String weekDay;
    private Double buyType;
    private Double vehicleChance;
    private String vehicleType;
    private Double initialSale;
    private List<VehicleClass.Vehicle> tempVehicleList;
    private Double saleTemp;
    //    Do I need a vehicle price in this class ******
    private Double commissionBonus;
 
    Selling(String weekDay,Double buyType,Double vehicleChance,String vehicleType,Double initialSale ) {
        this.weekDay = weekDay;
        this.buyType = 0.0;
        this.vehicleChance = 0.0;
        this.vehicleType = vehicleType;
        this.initialSale = initialSale;
        this.tempVehicleList = new ArrayList();
        this.saleTemp = 0.0;
    }
    //Correct percents for buy? ******
    public void sellVehicle(StaffTest.Staff Staff){
        Random randomBuy = new Random();
        double randomNumber = randomBuy.nextDouble();
        Random randomCarType = new Random();
        double randomCar = randomCarType.nextDouble();

    }
 
    //random chance for prefered car
    public void chooseRandomCar(double randomCar){
        if(randomCar > 0.0 && randomCar <= 0.33){
            this.vehicleChance = 0.33;
            this.vehicleType = "Performance";
            
        }else if(randomCar > 0.5 && randomCar <= 0.66){
            this.vehicleChance = 0.66;
            this.vehicleType = "Cars";
        }else{
           this.vehicleChance = 0.99;
           this.vehicleType = "Pickups";
        }
    }

    //random chance for looking, wants one, needs one
    public void chanceLooking(double randomNumber){
        if(randomNumber > 0.0 && randomNumber <= 0.70){
            this.buyType = 0.7;
        }
        else if(randomNumber > 0.0 && randomNumber <= 0.40){
            this.buyType = 0.4;
        }
        else{
            this.buyType = 0.1;
        }
    }
public
    //highest selling vehicle
     void mostExpensive(FNCD fncd){
        List<VehicleClass.Vehicle> VehicleList = fncd.getVehicleList();

        for(VehicleClass.Vehicle car: VehicleList){
            if(car.getCondition() != "Broken"){
                if(car instanceof VehicleClass.Car && vehicleType == "Car"){
                    System.out.printf("A dirty Car");
                    if(saleTemp <= car.getSalesPrice()){
                        saleTemp = car.getSalesPrice();
                    }
                }else if(car instanceof VehicleClass.Performance_Car && vehicleType == "Performance Car"){
                    System.out.printf("A dirty Performance Car");
                    if(saleTemp <= car.getSalesPrice()){
                        saleTemp = car.getSalesPrice();
                    }
                }else if(car instanceof VehicleClass.Pickup_Car && vehicleType == "Pickup Car"){
                    System.out.printf("A dirty Pickup Car");
                    if(saleTemp <= car.getSalesPrice()){
                        saleTemp = car.getSalesPrice();
                    }
                }
            }
        }
    }
 }
 

// washing
class Washing{
    private int randomChoice1;
    private int randomChoice2;
    private String weekDay;
    private List<StaffTest.Intern> staffList;


    Washing(String WeekDay){
        this.randomChoice1 = 0;
        this.randomChoice2 = 0;
        this.weekDay = WeekDay;
        this.staffList = null;
    }

    // code to wash the vehicle
    public void washVehicle(List<VehicleClass.Vehicle> VehicleList, StaffTest.Intern intern) {
        // get two random staff
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int internCount1 = 0;

        // only can wash 2 cars per day
        while(internCount1 < 2){
            // start cleaning dirty cars
            for(VehicleClass.Vehicle car: VehicleList){
                if(car.getCleanliness() == "Dirty"){
                    // %80 chance on becoming clean %10 chance of becoming sparkling
                    double randomNumber = random.nextDouble();
                    if(randomNumber < 0.1){
                        car.setCondition("Sparkling");
                        internCount1 += 1;
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
            for(VehicleClass.Vehicle car: VehicleList){
                if(car.getCleanliness() == "Clean"){
                    // %5 chance of becoming dirty, %30 chance on becmoming sparkling
                    double randomNumber = random.nextDouble();
                    if(randomNumber < 0.05){
                        car.setCondition("Dirty");
                        internCount1 += 1;
                    }else if(randomNumber < 0.3){
                        car.setCondition("Sparkling");
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

// repair
class Repair{
    private double repairChance;
    private String day;
    private double bonus;

    Repair(String curr_day){
        this.repairChance = 0.8;
        this.day = curr_day;
        this.bonus = 0.0;

    }

    public void repairVehicle(VehicleClass.Vehicle vehicle) {
        // repair the vehicle
        Random random = new Random();
        double randomNumber = random.nextDouble();
        // mechanic can repair
        if(randomNumber > 0 && randomNumber <= 0.80){
            // upgrade condtition
            if(vehicle.getCondition() != "New"){
                if(vehicle.getCondition() == "Used"){
                    vehicle.setCondition("Like New");
                }else if(vehicle.getCondition() == "Broken"){
                    vehicle.setCondition("Used");
                }
            // downgrade cleanliness
            if(vehicle.getCleanliness() != "Dirty"){
                if(vehicle.getCleanliness() == "Sparkling"){
                    vehicle.setCleanliness("Clean");
                }else if(vehicle.getCleanliness() == "Clean"){
                    vehicle.setCleanliness("Dirty");
                }

            }
            }
            // mechanic cant repair
        }else{
            System.out.printf("The Mechanic cant repair");
        }
    }
}

// ending
class Ending{

}

// not needed right now
public class Task {
    
}
