import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class Vehicle{
    private String vim;
    private String make;
    private String model;
    private int year;
    private double cost;
    private String condition;
    private double sales_price;
    private String cleanliness;
    private String type;
    private Double vehicleBonus;
    // temp list
    private List<String> conditionList = Arrays.asList("New", "Used", "Broken");
    private List<String> cleanlinessList = Arrays.asList("Sparkling", "Clean", "Dirty");

    // constructor
    public Vehicle(String vim, String make, String model, Integer year, Double cost, String type, Double vehicleBonus){
        this.vim = vim;
        this.make =  make;
        this.model = model;
        this.year = year;
        this.cost = cost;
        this.type = type;
        this.vehicleBonus = vehicleBonus;
        // choose condition randomly per car
        Random random = new Random();// https://www.baeldung.com/java-random-list-element#:~:text=Picking%20a%20Random%20Item%2FItems,that%20exceeds%20your%20List%27s%20size |AND| https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        int index = random.nextInt(conditionList.size());
        this.condition = conditionList.get(index);

        // set sales price depending on condition
        if(this.condition == "New"){
            this.sales_price = cost * 2;
        }else if(this.condition == "Used"){
            this.sales_price = (cost * 2) * 0.8;
        }else{
            this.sales_price = cost;
        }

        // given a random state of cleanliness
        double randomNumber = random.nextDouble();
        if(randomNumber < 0.05){
            this.cleanliness = cleanlinessList.get(0);
        }else if(randomNumber < 0.35){
            this.cleanliness = cleanlinessList.get(1);

        }else{
            this.cleanliness = cleanlinessList.get(2);
        }

    }

    // setters method implementation
    public void setVim(String vim){
        this.vim = vim;
    }

    public void setName(String make, String model){
        this.make = make;
        this.model = model;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public void setSalesPrice(float sales_price){
        this.sales_price = sales_price;
    }

    public void setCleanliness(String cleanliness){
        this.cleanliness = cleanliness;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setVehicleBonus(Double vehicleBonus){
        this.vehicleBonus = vehicleBonus;
    }

    // getters method implementation
    public String getVim(){
        return vim;
    }

    public String getName(){
        return make + model;
    }

    public Integer getYear(){
        return year;
    }

    public Double getCost(){
        return cost;
    }

    public String getCondition(){
        return condition;
    }

    public Double getSalesPrice(){
        return sales_price;
    }

    public String getCleanliness(){
        return cleanliness;
    }
    public String getType(){
        return type;
    }
    public Double getVehicleBonus(){
        return vehicleBonus;
    }


}
// car sub class
// cost $10,000 - $20,0000
class Car extends Vehicle{
    private String type;
    private Double vehicleBonus;
    //private float sales_price;

    public Car(String vim, String make, String model, Integer year, Double cost, Double sales_price, String type, Double vehicleBonus){
        super(vim, make, model, year, cost, type, vehicleBonus);
        // super.condition = "hello";
        this.type = "Car";
        this.vehicleBonus = 1.05;
    }
    @Override
    public String getType(){
        return type;
    }
    public Double getVehicleBonus(){
        return vehicleBonus;
    }
    @Override
    public String setCost(){
        // used https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range 
        double min = 10000;
        double max = 20000;
        Random random = new Random();
        double randomValue = min + (max - min) * random.nextDouble();
    }


}
// performance car sub class
// cost $20,000 - $40,000
class Performance_Car extends Vehicle{
    private String type;
    //private float sales_price;
    private Double vehicleBonus;

    public Performance_Car(String vim, String make, String model, Integer year, Double cost, Double sales_price, String type, Double vehicleBonus){
        super(vim, make, model, year, cost, type, vehicleBonus);
        //this.sales_price = sales_price;
        this.type = "Performance Car";
        this.vehicleBonus = 1.15;
    }
    @Override
    public String getType(){
        return type;
    }
    public Double getVehicleBonus(){
        return vehicleBonus;
    }


}
// puck up sub class
// cost $10,000 - $40,000
class Pickup_Car extends Vehicle{
    private String type;
    //private float sales_price;
    private Double vehicleBonus;

    public Pickup_Car(String vim, String make, String model, Integer year, Double cost, Double sales_price, String type , Double vehicleBonus){
        super(vim, make, model, year, cost, type, vehicleBonus);
        //this.sales_price = sales_price;
        this.type = "Pickup Car";
        this.vehicleBonus = 1.1;
    }
    @Override
    public String getType(){
        return type;
    }
    public Double getVehicleBonus(){
        return vehicleBonus;
    }

}