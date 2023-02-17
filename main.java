import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class main {
    public static void main(String[] args) {
        double buget = 500000;
        FNCD fncd = new FNCD(buget);

        System.out.printf("FNCD Test: %f\n", fncd.opBudget);
        for(Staff str: fncd.staffList){
            System.out.printf("%s, %d, %s\n", str.getName(), str.getStaffID(), str.getPosition());
        }
        for(Vehicle staff: fncd.vehicleList){
            System.out.printf("%s, %f, %s\n", staff.getName(), staff.getCost(), staff.getType());
        }

        System.out.println();
        List<Staff> curr = fncd.getStaffList();
        curr.remove(2); curr.remove(5);
        fncd.setStaffList(curr);
        Opening open = new Opening(fncd);
        open.AddedCars();
        open.AddedStaff();




        // Vehicle vehicleTest = new Vehicle("Adrian", "Hes", "Cool");
        // Performance_Car carTest1 = new Performance_Car("Apple", "Its", "Good");
        
        
        // String name = vehicleTest.getName();
        // System.out.printf("Here's Vehicle name: %s\n", name);
        
        // String name2 = carTest1.getName();
        // // String price3 = carTest1.getCondition();
        // System.out.printf("Here's Car name: %s\n", name2);
        // System.out.printf("Here's Car name: %s\n", carTest1.getCondition());
        // System.out.printf("Here's Car name: %s\n", carTest1.getCondition());
        
        // Pickup_Car testpickup = fncd.createPickupCar();
        // System.out.printf("Here's Car name: %s\n", testpickup.getType());
        // System.out.printf("Here's Car name: %s\n", testpickup.getCondition());
        // System.out.printf("Here's Car name: %s\n", testpickup.getCondition());



    }
}
