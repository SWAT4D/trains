package trains;

public class EntryPoint extends Rail {

    EntryPoint(EndVoid ev){
        prevR = ev;
    }

    public void setTrain(Locomotive l){
        train = l;
    }
    
    @Override
    public String toString(){
        return "E";
    }
}
