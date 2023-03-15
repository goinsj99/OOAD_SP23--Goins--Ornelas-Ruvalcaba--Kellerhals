import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;
public class setLocation implements Command{
    FNCD fncd;
    private Vehicle tempV;
    public setLocation (){
    }

    @Override
    public void execute() {
        double buget = 500000;
        FNCD fncd = new FNCD(buget);
        System.out.println("******* Welcome to the FNCD Simulator ********");
        System.out.println("******* Please select from the following menu by entering the associated number ********");
        System.out.println("******* 1. Choose FNCD ********");
        System.out.println("******* 2. Ask for salespersons name ********");
        System.out.println("******* 3. Ask what time it is ********");
        System.out.println("******* 4. Request a different sales representative ********");
        System.out.println("******* 5. View current inventory ********");
        System.out.println("******* 6. Details on selected item ********");
        System.out.println("******* 7. Buy selected item ********");
        System.out.println("******* 8. End ********");

        Scanner myObj = new Scanner(System.in);
        Integer menuSelect = Integer.parseInt(myObj.nextLine());
        System.out.println("You Entered: " + menuSelect);

        switch(menuSelect)
        {
            case 0:
                System.out.println("test");
                break;
            case 1:
                System.out.println("Choose FNCD");
                break;
            case 2:
                getStaffName test = new getStaffName();
                String tempName;
                System.out.println("Salesperson name is " + test.getTheName(fncd));
                break;
            case 3:
                getTime time2 = new getTime();

                System.out.println("The time is: " + time2.seeTime());
                break;
            case 4:
                System.out.println("Your new sales rep is ");
                break;
            case 5:
                askInventory see2 = new askInventory();
                System.out.println("******* FNCD Current Inventory ****** ");
                for(Vehicle t : see2.getInv(fncd)){
                    System.out.print(t);
                }

                break;
            case 6:
                System.out.println("Choose FNCD");
                break;
            case 7:
                System.out.println("Choose FNCD");
                break;
            default:
                System.out.println();
        }



    }
}
