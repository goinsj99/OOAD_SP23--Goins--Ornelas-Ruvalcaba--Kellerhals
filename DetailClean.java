import java.util.Random;

public class DetailClean implements Cleans {
    public void behave(FNCD fncd){
        int index = 0;
        int washCount = 0;
        int internCount1 = 0;
        boolean flag = false;
        Random random = new Random();
        Intern intern = (Intern) fncd.getStaffList().get(index);
        double randomBroke = random.nextDouble();
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
                // %60 chance on becoming clean %20 chance of becoming sparkling
                double randomNumber = random.nextDouble();
                if(randomNumber < 0.2){
                    fncd.LoggerReport("          - Vehicle was dirty and is now Sparkling "+car.getName());
                    car.setCleanliness("Sparkling");
                    intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                    internCount1++;

                    washCount++;
                    double curr = fncd.getStaffTotalEarn();
                    fncd.setStaffTotalEarn(curr+=car.getVehicleBonus());
                    // increase bonus intern.bonus =
                }else if(randomNumber < 0.6){
                    fncd.LoggerReport("          - Vehicle was dirty and is now Clean "+car.getName());
                    car.setCleanliness("Clean");
                    internCount1++;
                    washCount++;
                }else{
                    //System.out.printf("Washing did not have an affect on the vehicle 1\n");
                    internCount1++;
                }
                if(randomBroke < 0.1){
                    fncd.LoggerReport("          - Vehicle broke from clean "+car.getName());
                    car.setCondition("Broken");
                }
            }
            if(car.getCleanliness() == "Clean"){
                // %05 chance of becoming dirty, %40 chance on becoming sparkling
                double randomNumber = random.nextDouble();
                if(randomNumber < 0.05){
                    fncd.LoggerReport("          - Vehicle was Clean and is now Dirty "+car.getName());
                    car.setCleanliness("Dirty");
                    internCount1++;
                    washCount++;
                }else if(randomNumber < 0.4){
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
                if(randomBroke < 0.1){
                    fncd.LoggerReport("          - Vehicle broke from clean "+car.getName());
                    car.setCondition("Broken");
                }
            }
            flag = false;
        }
    }
}
