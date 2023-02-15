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


    Washing(String WeekDay){
        this.randomChoice1 = 0;
        this.randomChoice2 = 0;
        this.weekDay = WeekDay;
    }

    public void washVehicle(VehicleClass.Vehicle vehicle) {
        // code to wash the vehicle
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
