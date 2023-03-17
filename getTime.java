import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class getTime {
        public String seeTime(){
            //Getting the current time value
            LocalTime time = LocalTime.now();
            // System.out.println("Current time: "+time);
            return "Current time: "+time;
        }

}
