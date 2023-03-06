import java.util.Random;
// create an interface for the vehicle 
public interface Vehicle_Interface {
    String getData();
    double getSellsPrice();
}

// now created a decorator abstract class
abstract class Decorator implements Vehicle_Interface {
    // create an interface
    Vehicle_Interface dec_car;
    // decorator sets vehicle
    public Decorator(Vehicle_Interface currDecCar) {
        this.dec_car = currDecCar;
    }
    // return its name+vim+type 
    public String getData() {
        return dec_car.getData();
    }
    // return its sales price 
    public double getSellsPrice() {
        return dec_car.getSellsPrice();
    }
}

// If customer wants to add Exteneded Warranty 
class Extended_Warranty extends Decorator {
    private double upSale;
    //private double randomChance;

    public Extended_Warranty(Vehicle_Interface decoratedVehicle) {
        super(decoratedVehicle);
        this.upSale = 1.2;
        //this.randomChance = 0.25;
    }
    // add extended warranty to discription 
    @Override
    public String getData() {
        return super.getData() + ", Added: Extended Warranty";
    }
    // add price difference to car sales price 
    @Override
    public double getSellsPrice() {
        // may need to logg
        //System.out.println("Customer Added Extended Warranty!");
        return(super.getSellsPrice() * this.upSale);
    }
}
// If customer wants to add Undercoating 
class Undercoating extends Decorator {
    private double upSale;
    //private double randomChance;

    public Undercoating(Vehicle_Interface decoratedVehicle) {
        super(decoratedVehicle);
        this.upSale = 1.05;
        //this.randomChance = 0.10;
    }
    // add undercoating to discription 
    @Override
    public String getData() {
        return super.getData() + ", Added: Undercoating!";
    }
    // add price difference to car sales price 
    @Override
    public double getSellsPrice() {
        // may need to logg
        //System.out.println("Customer Added Undercoating!");
        return(super.getSellsPrice() * this.upSale);
    }
}
// If customer wants to add Road Rescue Coverage 
class Road_Rescue_Coverage extends Decorator {
    private double upSale;
    //private double randomChance;

    public Road_Rescue_Coverage(Vehicle_Interface decoratedVehicle) {
        super(decoratedVehicle);
        this.upSale = 1.02;
        //this.randomChance = 0.05;
    }
    // add road rescue coverage to discription 
    @Override
    public String getData() {
        return super.getData() + ", Added: Road Rescue Coverage!";
    }
    // add price difference to car sales price 
    @Override
    public double getSellsPrice() {
        // may need to logg
        //System.out.println("Customer Added Road Rescue Coverage!");
        return(super.getSellsPrice() * this.upSale);
    }
}
// If customer wants to add Raido 
class Radio extends Decorator {
    private double upSale;
    //private double randomChance;

    public Radio(Vehicle_Interface decoratedVehicle) {
        super(decoratedVehicle);
        this.upSale = 1.05;
        //this.randomChance = 0.4;
    }
    // add radio to discription 
    @Override
    public String getData() {
        return super.getData() + ", Added: Satellite Radio!";
    }
    // add price difference to car sales price 
    @Override
    public double getSellsPrice() {
        // may need to logg
        //System.out.println("Customer Added Satellite Radio!");
        return(super.getSellsPrice() * this.upSale);
    }
}

