import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class setLocation implements Command{

    Staff staff;
    double buget;
    private Vehicle tempV;
    askInventory tee;
    ask4All tee2;

    public setLocation (){
        this.tee = new askInventory();
        this.tee2 = new ask4All();

    }

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
    public void execute3(FNCD fncd) {
        LocalTime time = LocalTime.now();
        System.out.println("Current time: "+time);
    }
    public void execute4(FNCD fncd) {

    }
    public void execute5(FNCD fncd) {
//        askInventory tee = new askInventory();
        tempV = tee.getInv(fncd);
    }public void execute6(FNCD fncd) {
        tempV = tee.getInv(fncd);
        tee2.getInv2(tempV);
    }public void execute7(FNCD fncd) {
        Vehicle test =  tee.getInv(fncd);
        System.out.println(test.getName());
    }
    public void executeSet() {

    }

//    public void seeTime{
//            //Getting the current time value
//            LocalTime time = LocalTime.now();
//            System.out.println("Current time: "+time);
//    }


}
