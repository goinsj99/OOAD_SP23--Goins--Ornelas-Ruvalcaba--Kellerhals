import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

// opening
class Opening{

}

// selling
class Selling{

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
