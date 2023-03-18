import java.util.List;
import java.util.Scanner;

public class askInventory {
    Integer carSelect2;
    public Integer getInv(FNCD fncd){
        List <Vehicle> tempList = fncd.getVehicleList();
        Integer index = 1;
        for (Vehicle car : fncd.getVehicleList()){

            System.out.println(index + ": "+car.getName() );
            index ++;
        }

        System.out.println("If you would like to select a car from inventory please enter the number next to the vehicle");
        Scanner myObj2 = new Scanner(System.in);
        Integer carSelect2 = Integer.parseInt(myObj2.nextLine());
        return carSelect2;
    }
}
