// state condition
class Condition{
    String likeNew = "Like New";
    String used = "Used";
    String broken = "Broken";
}
// state bonus
class Bonus{
    boolean sale = false;
    boolean repair = false;
    boolean wash = false;
}
// state cleanliness
class Cleanliness{
    String sparkling = "Sparkling";
    String clean = "Clean";
    String dirty = "Dirty"; 
}

public class Vehicle_States {
    // States
    private Condition condition;
    private Bonus bonus;
    private Cleanliness clean;

    // constructor 
    public Vehicle_States(){
        condition = null;
        bonus = null;
        clean = null;
    }

    // state set and get condition
    public void setCondition(Condition new_condition){
        condition = new_condition;
    }
    public Condition getCondition(){
        return condition;
    }

    //state set and get bonus 
    public void setBonus(Bonus new_bonus){
        bonus = new_bonus;
    }
    public Bonus getBonus(){
        return bonus;
    }

    // state set and get cleanliness 
    public void setcleanliness(Cleanliness new_cleanliness){
        clean = new_cleanliness;
    }
    public Cleanliness getcleanliness(){
        return clean;
    }
}
