//package OOAD_SP23--Goins--Ornelas-Ruvalcaba;
import Vehicle_States;

// super class for Vehicles
public class Vehicle {

    int unique_ID;
    String[] Name;
    float Cost;
    String Condition;
    float Sales_Price;
    String Cleanliness;

    Vehicle(){
        // constructor implementation
    }

    // setters method implementation
    void setID(int vim){
        unique_ID = vim;
    }
    
    void setName(String make, String model){
        Name[0] = make;
        Name[1] = model;
    }

    void setCost(float cost){
        Cost = cost;
    }

    void setCondition(String condition){
        Condition = condition;
    }

    void setSalesPrice(float price){
        Sales_Price = price;
    }

    void setBonus(){

    }

    void setCleanliness(){

    }

    // getters method implementation
    void getID(){

    }

    void getName(){

    }

    void getCost(){

    }

    void getCondition(){

    }

    void getSalesPrice(){

    }

    void getBonus(){

    }

    void getCleanliness(){

    }

    // display method of superclass
    public void display() {
        System.out.println("This is the display method of Vhicle superclass");
    }
}


// subclass of different Vehicles using inheritance
// performance car
class Performance_Car extends Vehicle {
    float my_Cost = Cost * 2;   

    // display method of subclass
    public void display() {
       System.out.println("This is the display method of subclass");
    }
 }

// car
class Car extends Vehicle {
    float my_Cost = Cost * 2;

    // display method of subclass
    public void display() {
       System.out.println("This is the display method of subclass");
    }
 }

 // pickup car
class Pickup_car extends Vehicle {
    float my_Cost = Cost * 2;

    Vehicle_States vehicleStates = new Vehicle_States();
    // display method of subclass
    public void display() {
       System.out.println("This is the display method of subclass");
    }
 }
