import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class main {
    public static void main(String[] args) {
        double buget = 500000;
        FNCD fncd = new FNCD(buget);

        System.out.printf("FNCD Test: %f\n", fncd.opBudget);
        for(String str: fncd.CarNames){
            System.out.println(str);
        }
        for(String staff: fncd.staffnames){
            System.out.println(staff);
        }

        Vehicle vehicleTest = new Vehicle("Adrian", "Hes", "Cool");
        Performance_Car carTest1 = new Performance_Car("Apple", "Its", "Good");
        
        
        String name = vehicleTest.getName();
        System.out.printf("Here's Vehicle name: %s\n", name);
        
        String name2 = carTest1.getName();
        // String price3 = carTest1.getCondition();
        System.out.printf("Here's Car name: %s\n", name2);
        System.out.printf("Here's Car name: %s\n", carTest1.getCondition());
        System.out.printf("Here's Car name: %s\n", carTest1.getCondition());
        
        Pickup_Car testpickup = fncd.createPickupCar();
        System.out.printf("Here's Car name: %s\n", testpickup.getType());
        System.out.printf("Here's Car name: %s\n", testpickup.getCondition());
        System.out.printf("Here's Car name: %s\n", testpickup.getCondition());

    }
}
