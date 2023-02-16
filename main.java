import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class main {
    public static void main(String[] args) {
        double buget = 500000;
        FNCD fncd = new FNCD(buget);

        Vehicle vehicleTest = new Vehicle("Adrian", "Hes", "Cool");
        Car carTest1 = new Car("Apple", "Its", "Good");

        String name = vehicleTest.getName();
        System.out.printf("Here's Vehicle name: %s\n", name);

        String name2 = carTest1.getName();
        System.out.printf("Here's Car name: %s\n", name2);

        
        
    }
}
