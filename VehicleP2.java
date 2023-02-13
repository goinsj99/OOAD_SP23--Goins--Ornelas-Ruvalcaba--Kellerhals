import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class VehicleP2 {
    class VehiclePP{
        private String vim;
        private String make;
        private String model;
        private int year;
        private float cost;
        private String condition;
        private double sales_price;
        private String cleanliness;
        // temp list
        private List<String> conditionList = Arrays.asList("New", "Used", "Broken");
        private List<String> cleanlinessList = Arrays.asList("Sparkling", "Clean", "Dirty");

    
        public VehiclePP(String vim, String make, String model, int year, float cost){
            this.vim = vim;
            this.make =  make;
            this.model = model;
            this.year = year;
            this.cost = cost;

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
            if(randomNumber > 0 && randomNumber <= 0.5){
                this.cleanliness = cleanlinessList.get(0);
            }else if(randomNumber > 0.5 && randomNumber <= 0.35){
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
    
        // getters method implementation
        public String getVim(){
            return vim;
        }
    
        public String getName(){
            return make + model;
        }
    
        public int getYear(){
            return year;
        }
    
        public float getCost(){
            return cost;
        }
    
        public String getCondition(){
            return condition;
        }
    
        public double getSalesPrice(){
            return sales_price;
        }
    
        public String getCleanliness(){
            return cleanliness;
        }


    }
    // car sub class
    // cost $10,000 - $20,0000
    class Car extends VehiclePP{
        //private float sales_price;
        private String cleanliness;
    
        public Car(String vim, String make, String model, int year, float cost, float sales_price){
            super(vim, make, model, year, cost);
            // super.condition = "hello";
            
            
            
        }

        @
    
    
    }
    // performance car sub class
    // cost $20,000 - $40,000
    class Performance_Car extends VehiclePP{
        //private float sales_price;
    
        public Performance_Car(String vim, String make, String model, int year, float cost, float sales_price){
            super(vim, make, model, year, cost);
            //this.sales_price = sales_price;
        }
    
        
    }
    // puck up sub class
    // cost $10,000 - $40,000
    class Pickup_Car extends VehiclePP{
        //private float sales_price;
    
        public Pickup_Car(String vim, String make, String model, int year, float cost, float sales_price){
            super(vim, make, model, year, cost);
            //this.sales_price = sales_price;
        }
    
     }
    
    
}
