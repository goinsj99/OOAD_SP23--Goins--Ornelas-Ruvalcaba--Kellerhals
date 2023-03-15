import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.text.DecimalFormat;

//
public class getStaffName {
    Staff tempStaff;
    private String tname;
    getStaffName(){
        this.tname = tname;
    }
    public String getTheName(FNCD fncd){
        List<Staff> staffList = fncd.getStaffList();
        Staff tempStaff;
        for (Staff staff : staffList) {
            if (staff instanceof SalesPerson) {
                tname = staff.getName();
            }
        }
        return tname;
    }
}