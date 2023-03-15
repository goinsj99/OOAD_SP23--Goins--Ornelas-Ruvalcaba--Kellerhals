import java.util.List;

public class askInventory {
    public List<Vehicle> getInv(FNCD fncd){
        List <Vehicle> tempList = fncd.getVehicleList();
        return tempList;
    }
}
