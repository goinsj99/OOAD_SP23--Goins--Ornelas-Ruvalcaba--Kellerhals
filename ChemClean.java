import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter;
import java.io.FileOutputStream;  

public class ChemClean implements Cleans {
    public void behave(FNCD fncd){
        int index = 0;
        int washCount = 0;
        int internCount1 = 0;
        boolean flag = false;
        Random random = new Random();
        Intern intern = (Intern) fncd.getStaffList().get(index);

        for(Vehicle car: fncd.getVehicleList()){
            while(flag == false){
                if(fncd.getStaffList().get(index) instanceof Intern){
                    intern = (Intern) fncd.getStaffList().get(index);
                    index++;
                    flag = true;
                }
                else{
                    index++;
                }
            }
            if(car.getCleanliness() == "Dirty"){
                // %80 chance on becoming clean %10 chance of becoming sparkling
                double randomNumber = random.nextDouble();
                if(randomNumber < 0.1){
                    fncd.LoggerReport("          - Vehicle was dirty and is now Sparkling "+car.getName());
                    car.setCleanliness("Sparkling");
                    intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                    internCount1++;
    
                    washCount++;
                    double curr = fncd.getStaffTotalEarn();
                    fncd.setStaffTotalEarn(curr+=car.getVehicleBonus());
                    // increase bonus intern.bonus =
                }else if(randomNumber < 0.8){
                    fncd.LoggerReport("          - Vehicle was dirty and is now Clean "+car.getName());
                    car.setCleanliness("Clean");
                    internCount1++;
                    washCount++;
                }else{
                    //System.out.printf("Washing did not have an affect on the vehicle 1\n");
                    internCount1++;
                }
            }
            if(car.getCleanliness() == "Clean"){
                // %10 chance of becoming dirty, %20 chance on becoming sparkling
                double randomNumber = random.nextDouble();
                if(randomNumber < 0.1){
                    fncd.LoggerReport("          - Vehicle was Clean and is now Dirty "+car.getName());
                    car.setCleanliness("Dirty");
                    internCount1++;
                    washCount++;
                }else if(randomNumber < 0.2){
                    fncd.LoggerReport("          - Vehicle was Clean and is now Sparkling "+car.getName());
                    car.setCleanliness("Sparkling");
                    intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                    internCount1++;
    
                    washCount++;
                    double curr = fncd.getStaffTotalEarn();
                    fncd.setStaffTotalEarn(curr+=car.getVehicleBonus());
                }else{
                    //System.out.printf("Washing did not have an affect on the vehicle 2 \n");
                    internCount1++;
                }
            }
            flag = false;
        }
    }
}
