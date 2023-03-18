public class RemoteControl {
    Command slot;
    public RemoteControl(){}
    public void setCommand(Command command){
        slot = command;
    }
    public void executeCommand(FNCD fncd){
        Integer test = 0;
        if(test == 0) {
            slot.execute();
        }
        else{
            System.out.println("******* 1. e ********");
        }
    }
    public void execute2(FNCD fncd){
        slot.execute2(fncd);
    }
    public void execute3(){
        slot.execute3();
    }
    public void execute4(FNCD fncd){
        slot.execute4(fncd);
    }
    public void execute5(FNCD fncd){
        slot.execute5(fncd);
    }
    public void execute6(FNCD fncd){
        slot.execute6(fncd);
    }
    public void execute7(){
        slot.execute7();
    }
//    public void executeSet(){
//        slot.executeSet();
//    }

}
