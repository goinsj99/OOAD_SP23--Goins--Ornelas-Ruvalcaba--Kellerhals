import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class setLocation implements Command{
//    FNCD fncd;

    Staff staff;
    double buget;
    private Vehicle tempV;
    public setLocation (){
//        this.staff = test.createNewStaff(Create.(CreateSalesPerson.),fncd);
//        this.buget = 500000;
//        this.fncd = new FNCD(buget);
    }
//    public void seeTime{
//        //Getting the current time value
//        LocalTime time = LocalTime.now();
//        System.out.println("Current time: "+time);
//    }

    @Override
    public void execute() {

    }
    public void execute2(FNCD fncd) {
        getStaffName test = new getStaffName(fncd);
        test.getTheName();
        String tempName;
//        System.out.println("Salesperson name is " + test.getTheName());
    }
//    Time command
    public void execute3() {
        LocalTime time = LocalTime.now();
        System.out.println("Current time: "+time);
    }
    public void execute4(FNCD fncd) {

    }
    public void execute5(FNCD fncd) {
        askInventory tee = new askInventory();
        tee.getInv(fncd);
    }public void execute6(FNCD fncd) {
        System.out.println("If you would like to select a car from inventory please enter the number next to the vehicle");
        Scanner myObj2 = new Scanner(System.in);
        Integer carSelect2 = Integer.parseInt(myObj2.nextLine());
        askInventory tee2 = new askInventory();
//        if car choice in range
        if(carSelect2 > 0 && carSelect2 <= fncd.getVehicleList().size()){
            Vehicle t4 = fncd.getVehicleList().get(carSelect2);
            System.out.println("      * "+t4.getName() + ", " + t4.getCost() + ", "+ t4.getSalesPrice() + ","+ t4.getCondition()+ "," + t4.getCleanliness() );
            ask4All me = new ask4All();
            me.getInv2(t4);
        }
        else{
            System.out.println("******* No Vehicle Selected, Please view inventory again *****");
        }

    }public void execute7() {

    }
    public void executeSet() {

    }

//    public void seeTime{
//            //Getting the current time value
//            LocalTime time = LocalTime.now();
//            System.out.println("Current time: "+time);
//    }


}
