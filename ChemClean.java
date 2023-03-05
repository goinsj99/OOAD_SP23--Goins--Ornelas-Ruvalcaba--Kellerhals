import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class ChemClean extends Strategy {
    public void behave(FNCD fncd, Intern intern){
        int index = 0;
        int washCount = 0;
        int internCount1 = 0;
        boolean flag = false;
        Random random = new Random();
        double randomBroke = random.nextDouble();
        while(internCount1 <= 2) {
            for (Vehicle car : fncd.getVehicleList()) {
                if (car.getCleanliness() == "Dirty") {
                    // %80 chance on becoming clean %10 chance of becoming sparkling
                    double randomNumber = random.nextDouble();
                    if (randomNumber < 0.1) {
                        fncd.LoggerReport("          - Vehicle was dirty and is now Sparkling by chemical method " + car.getName());
                        car.setCleanliness("Sparkling");
                        intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                        internCount1++;

                        washCount++;
                        double curr = fncd.getStaffTotalEarn();
                        fncd.setStaffTotalEarn(curr += car.getVehicleBonus());
                        // increase bonus intern.bonus =
                    } else if (randomNumber < 0.8) {
                        fncd.LoggerReport("          - Vehicle was dirty and is now Clean by chemical method " + car.getName());
                        car.setCleanliness("Clean");
                        internCount1++;
                        washCount++;
                    } else {
                        //System.out.printf("Washing did not have an affect on the vehicle 1\n");
                        internCount1++;
                    }
                    if (randomBroke < 0.1) {
                        fncd.LoggerReport("          - Vehicle broke from chemical method " + car.getName());
                        car.setCondition("Broken");
                    }
                }
                if (car.getCleanliness() == "Clean") {
                    // %10 chance of becoming dirty, %20 chance on becoming sparkling
                    double randomNumber = random.nextDouble();
                    if (randomNumber < 0.1) {
                        fncd.LoggerReport("          - Vehicle was Clean and is now Dirty by chemical method" + car.getName());
                        car.setCleanliness("Dirty");
                        internCount1++;
                        washCount++;
                    } else if (randomNumber < 0.2) {
                        fncd.LoggerReport("          - Vehicle was Clean and is now Sparkling by chemical method " + car.getName());
                        car.setCleanliness("Sparkling");
                        intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                        internCount1++;

                        washCount++;
                        double curr = fncd.getStaffTotalEarn();
                        fncd.setStaffTotalEarn(curr += car.getVehicleBonus());
                    } else {
                        //System.out.printf("Washing did not have an affect on the vehicle 2 \n");
                        internCount1++;
                    }
                    if (randomBroke < 0.1) {
                        fncd.LoggerReport("          - Vehicle broke from chemical method " + car.getName());
                        car.setCondition("Broken");
                    }
                }
                flag = false;
                if(internCount1 == 2){
                    break;
                }
            }
            if(internCount1 == 2){
                break;
            }
        }
    }
}