import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

// observer will have methods to subscribe and unsubscribe
interface Observer {
    void subscribe(ObserverPatternPublisher publisher);

    void unsubscribe(ObserverPatternPublisher publisher);

    void onEvent(ObserverPatternPublisher event);
}

public class ObserverPatternPublisher {
    private List<Observer> observers;
    
    ObserverPatternPublisher(){
        this.observers = new ArrayList<>();
    }
    // add a observer
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }
    // remove an observer
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }
    // push results of publisher 
    public void publishRaceEvent(String result) {
        notifySubscribers(new RaceEvent(result));
    }
    // push money results 
    public void publishMoneyEvent(double amount) {
        notifySubscribers(new MoneyEvent(amount));
    }
    // push any other outcomes
    public void publishOutcomeEvent(String outcome) {
        notifySubscribers(new OutcomeEvent(outcome));
    }

}
// used to track raceevents for observer
class RaceEvent implements Observer {
    private String result;

    public RaceEvent(String result) {
        this.result = result;
    }
    // get race results 
    public String getResult() {
        return result;
    }
    // add race results 
    public String setResult(String newResult){
        this.result = newResult;
    }
}
// used to track money for observer 
class MoneyEvent implements Observer {
    private double amount;

    public MoneyEvent(double amount) {
        this.amount = amount;
    }
    // get amount 
    public double getAmount() {
        return amount;
    }
    // set amount
    public double setAmount(double newAmount){
        this.amount = newAmount;
    }
}


