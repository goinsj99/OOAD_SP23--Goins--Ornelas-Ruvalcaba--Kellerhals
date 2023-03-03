import java.util.Random;
import java.util.*;

public class ChemClean implements Cleans {
    public void behave(){
        if(car.getCleanliness() == "Dirty"){
            // %80 chance on becoming clean %10 chance of becoming sparkling
            double randomNumber = random.nextDouble();
            if(randomNumber < 0.1){
                fncd.LoggerReport("          - Vehicle was dirty and is now Sparkling "+car.getName());
                car.setCleanliness("Sparkling");
                intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                internCount1++;

                this.washCount++;
                double curr = fncd.getStaffTotalEarn();
                fncd.setStaffTotalEarn(curr+=car.getVehicleBonus());
                // increase bonus intern.bonus =
            }else if(randomNumber < 0.8){
                fncd.LoggerReport("          - Vehicle was dirty and is now Clean "+car.getName());
                car.setCleanliness("Clean");
                internCount1++;
                this.washCount++;
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
                this.washCount++;
            }else if(randomNumber < 0.2){
                fncd.LoggerReport("          - Vehicle was Clean and is now Sparkling "+car.getName());
                car.setCleanliness("Sparkling");
                intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                internCount1++;

                this.washCount++;
                double curr = fncd.getStaffTotalEarn();
                fncd.setStaffTotalEarn(curr+=car.getVehicleBonus());
            }else{
                //System.out.printf("Washing did not have an affect on the vehicle 2 \n");
                internCount1++;
            }
        }
    }
}
