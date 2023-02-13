public class Staff {
    private Double salaryRate;
    private Integer staffID;
    private Double salary;
    private Double hours;
    private String position;
    public String firstName;

    Float Rate;
    public String getName() {
        return firstName;
    }
    public Double getSalaryRate() {
        return salaryRate;
    }
    public Integer getStaffID() {
        return staffID;
    }
    public Double getHours() {
        return hours;
    }
    public String getPosition() {
        return position;
    }
    public Double getSalary() {
        return salary;
    }
    public static void setName(int newName){
        this.firstName = newName;
    }
    public static void setSalaryRate(Double newRate){
        this.salaryRate = newRate;
    }
    public static void setStaffID(Integer newID){
        this.staffID = newID;

    }
    public static void setHours(Double newHours){
        this.hours = newHours;
    }
    public static void setPosition(String newPosition){
        this.position = newPosition;
    }
    public static void setSalary(Double newSalary){
        this.salary = newSalary;
    }


}

// Subclass (inherit from Animal)
class SalesPerson extends Staff {
    float myRate = Rate * 1.25;
    public void myRate() {

    }

}
class Intern extends Staff {
    float myRate = Rate * 1.5;
    public void myRate() {

    }

}
class Mechanic extends Staff {
    float myRate = Rate * 1.75;
    public void myRate() {

    }

}

