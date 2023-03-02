public class ElbowClean implements Cleans {

    public void behave(){
        if(car.getCleanliness() == "Dirty"){
            // %70 chance on becoming clean %5 chance of becoming sparkling
            double randomNumber = random.nextDouble();
            if(randomNumber < 0.05){
                fncd.LoggerReport("          - Vehicle was dirty and is now Sparkling "+car.getName());
                car.setCleanliness("Sparkling");
                intern.setBonusTemp(intern.getBonusTemp() + car.getVehicleBonus());
                internCount1++;

                this.washCount++;
                double curr = fncd.getStaffTotalEarn();
                fncd.setStaffTotalEarn(curr+=car.getVehicleBonus());
                // increase bonus intern.bonus =
            }else if(randomNumber < 0.7){
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
            // %15 chance of becoming dirty, %15 chance on becmoming sparkling
            double randomNumber = random.nextDouble();
            if(randomNumber < 0.15){
                fncd.LoggerReport("          - Vehicle was Clean and is now Dirty "+car.getName());
                car.setCleanliness("Dirty");
                internCount1++;
                this.washCount++;
            }else if(randomNumber < 0.15){
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
