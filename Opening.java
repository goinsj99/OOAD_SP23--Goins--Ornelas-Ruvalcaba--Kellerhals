import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Opening{
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