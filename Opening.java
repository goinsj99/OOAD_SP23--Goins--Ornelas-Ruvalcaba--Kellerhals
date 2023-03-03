import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter;
import java.io.FileOutputStream; 

public class Opening{
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

