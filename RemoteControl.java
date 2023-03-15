public class RemoteControl {
    Command slot;
    public RemoteControl(){}
    public void setCommand(Command command){
        slot = command;
    }
    public void executeCommand(){
        Integer test = 0;
        if(test == 0) {
            slot.execute();
        }
        else{
            System.out.println("******* 1. Choose FNCD ********");
        }
    }
}
