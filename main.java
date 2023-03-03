import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter;
import java.io.FileOutputStream;  

public class main {
    public static void main(String[] args) {
        // verables 
        double buget = 500000;
        FNCD fncd = new FNCD(buget); 
        Random random = new Random();
        // used to calculate for costomers on day 
        List<Integer> weekDays = Arrays.asList(0,1,2,3,4,5);
        List<Integer> weekEnds = Arrays.asList(2,3,4,5,6,7,8);

        // now open all 30 days 
        for(int i = 0; i < 30; i++){
            // create instances
            Event_Publisher publisher = new Event_Publisher();
            Logger logger = new Logger(i+1);
            Tracker tracker = new Tracker();
            // start observers of logger and tracker
            publisher.registerSub(logger);
            publisher.registerSub(tracker);
            fncd.LoggerReport("----------------------------------------------");
            fncd.LoggerReport("***** FNCD Day "+fncd.getDay()+" "+(i+1)+ "****\n");
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            // run every senerio with openeing
            fncd.LoggerReport("Opening... (current budget "+fncd.getOpBudget()+")");
            Opening open = new Opening(fncd);
            open.internHire(fncd.getStaffList(), fncd);
            open.AddVehicle(fncd);

            // publish event to notify observers that opening is complete
            Fncd_Event openingEvent = new Fncd_Event("opening_complete", "Opening is complete for day " + (i+1), fncd.getOpBudget());
            publisher.publishEvent(openingEvent.getType(), openingEvent.getMessage(), openingEvent.getData());
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            // run racing
            RacingEvent race = new RacingEvent(fncd);
            race.racingDay(fncd);
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            // run washing
            fncd.LoggerReport("Washing...");
            Washing wash = new Washing(fncd);
            wash.washVehicle(fncd); 
            
            // publish event to notify observers that opening is complete
            Fncd_Event racingEvent = new Fncd_Event("opening_complete", "Opening is complete for day " + (i+1), fncd.getOpBudget());
            publisher.publishEvent(racingEvent.getType(), racingEvent.getMessage(), racingEvent.getData());
            
            // publish event to notify observers that washing is complete
            Fncd_Event washingEvent = new Fncd_Event("washing_complete", "Washing is complete for day " + (i+1), wash.getWashCount());
            publisher.publishEvent(washingEvent.getType(), washingEvent.getMessage(), washingEvent.getData());
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //run repair
            fncd.LoggerReport("Repairing... ");
            Repair repair = new Repair();
            for(Staff mec: fncd.getStaffList()){
                if(mec instanceof Mechanic){
                    repair.repairVehicle(fncd.getVehicleList(), mec, fncd);
                }
            }
            // publish event to notify observers that repair is complete
            Fncd_Event repairEvent = new Fncd_Event("repair_complete", "Repair is complete for day " + (i+1), repair.getRepairCount());
            publisher.publishEvent(repairEvent.getType(), repairEvent.getMessage(), repairEvent.getData());
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //run Selling
            fncd.LoggerReport("Selling... ");
            Selling mop = new Selling();
            if(fncd.getDayIndex() < 5){
                int indext = random.nextInt(weekDays.size());
                fncd.LoggerReport("      * Number of customers came in on a week day are "+indext);
                for(int j = 0; j < weekDays.get(indext); j++){
                    fncd.LoggerReport("      * Customer "+(j+1));
                    mop.sellThisCar(fncd);
                }
            }else{
                int index = random.nextInt(weekEnds.size());
                fncd.LoggerReport("      * Number of customers came in on a weekend day are "+index+"\n");
                for(int j = 0; j < weekEnds.get(index); j++){
                    mop.sellThisCar(fncd);
                }
            }
            // publish event to notify observers that selling is complete
            Fncd_Event sellingEvent = new Fncd_Event("selling_complete", "Selling is complete for day " + (i+1), mop.getSellCount());
            publisher.publishEvent(sellingEvent.getType(), sellingEvent.getMessage(), sellingEvent.getData());
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            // ending
            Ending end = new Ending();
            end.payStaff(fncd);
            end.pReport(fncd);

            // tracker.update(fncd.getStaffTotalEarn());
            Fncd_Event staffEarnedEvent = new Fncd_Event("staff_money_earned", " Total money staff earned ",fncd.getStaffTotalEarn());
            tracker.update(staffEarnedEvent);

            Fncd_Event fncdEarnedEvent = new Fncd_Event("fncd_money_earned", " Total money fncd earned ",fncd.getFncdEarning());
            tracker.update(fncdEarnedEvent);


            fncd.LoggerReport("\nChecking Staff... \n");
            for(Staff pp: fncd.getStaffList()){
                String newline = "      * "+pp.getName()+" "+pp.getPosition()+" "+pp.getBonus()+" "+pp.getBonusTemp();
                fncd.LoggerReport(newline);
            }
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            // Unsubscribe logger after day 1
            publisher.removeSub(logger);
            // print summary report
            tracker.printSummary(i+1);
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            fncd.nextDay();
        }    
    }
}
