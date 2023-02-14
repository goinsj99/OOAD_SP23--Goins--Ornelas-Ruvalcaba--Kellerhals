import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class StaffTest {
    class Staff {
        private Double salaryRate;
        private Integer staffID;
        private Double salary;
        private Double hours;
        private String position;
        private String firstName;

        private Float Rate;

        public Staff(String firstName, Double salaryRate, Integer staffID, Double salary, Double hours, String position) {
            this.firstName = firstName;
            this.salaryRate = salaryRate;
            this.staffID = staffID;
            this.hours = hours;
            this.position = position;
            this.salary = salary;
        }


        public void setName(String firstName) {
            this.firstName = firstName;
        }

        public void setSalaryRate(Double salaryRate) {
            this.salaryRate = salaryRate;
        }

        public void setStaffID(Integer staffID) {
            this.staffID = staffID;
        }

        public void setHours(Double hours) {
            this.hours = hours;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setSalary(Double Salary) {
            this.salary = salary;
        }

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


    }

    // Subclass (inherit from Animal)
    class SalesPerson extends Staff{
        Double myRate = 1.25;

        public SalesPerson(String firstName, Double salaryRate, Integer staffID, Double salary, Double hours, String position) {
            super(firstName, salaryRate, staffID, salary, hours, position);
        }

        public void myRate() {

        }

    }

    class Intern extends Staff {
        Double myRate = 1.5;
        public Intern(String firstName, Double salaryRate, Integer staffID, Double salary, Double hours, String position) {
            super(firstName, salaryRate, staffID, salary, hours, position);
        }
        public void myRate() {

        }

    }

    class Mechanic extends Staff {
        Double myRate = 1.75;
        public Mechanic(String firstName, Double salaryRate, Integer staffID, Double salary, Double hours, String position) {
            super(firstName, salaryRate, staffID, salary, hours, position);
        }
        public void myRate() {

        }

    }

}
