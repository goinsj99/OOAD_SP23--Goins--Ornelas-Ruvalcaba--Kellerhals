import java.util.List;

public class getStaffName {
    Staff tempStaff;
    private String tname;
    getStaffName(){
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