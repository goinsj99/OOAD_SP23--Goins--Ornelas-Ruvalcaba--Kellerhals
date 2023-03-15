import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
public class RemoteControlTest {
    public static void main(String[] args){
        RemoteControl remote = new RemoteControl();
        Command command = new setLocation();
//        setLocation test = new setLocation();

        remote.setCommand(command);
        remote.executeCommand();
//        remote.getStaffName();

    }
}
