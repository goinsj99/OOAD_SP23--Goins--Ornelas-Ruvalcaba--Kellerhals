import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

// used user guide to implement unit test
// https://junit.org/junit5/docs/current/user-guide/
public class FncdTest {

    @Test
    public void testOpendingDay(){
        FNCD fncdTest = new FNCD(50000.0);
        Opening openTest = new Opening(fncdTest);
        openTest.internHire(fncdTest.getStaffList(), fncdTest);
        int internCount = 0;
        for(Staff s: fncdTest.getStaffList()){
            if(s instanceof Intern){
                internCount++;
            }
        }
        assertEquals(3, internCount);
    }

    @Test
    public void testOpendingCarCountDay(){
        FNCD fncdTest = new FNCD(50000.0);
        Opening openTest = new Opening(fncdTest);
        openTest.AddVehicle(fncdTest);
        int carCount = 0;
        for(Vehicle v: fncdTest.getVehicleList()){
            if(v instanceof Car){
                carCount++;
            }
        }
        assertEquals(6, carCount);
    }

    @Test
    public void testRacingDay(){
        FNCD fncdTest = new FNCD(50000.0);
        RacingEvent raceTest = new RacingEvent(fncdTest);
        Boolean tes = raceTest.racingDay(fncdTest);
        if(fncdTest.getDay() == "Wensday" || fncdTest.getDay() == "Sunday"){
            assertEquals(true, tes);
        }else{
            assertEquals(false, tes);
        }
    }

}
