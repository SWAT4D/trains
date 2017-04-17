package trains;

public class EntryPoint extends Rail {

    //Konstruktor mely kéri az EndVoidot
    EntryPoint(EndVoid ev){
        prevR = ev;
    }

    public void setTrain(Locomotive l){
        train = l;
    }

    @Override
    public String toString() {
        return "E";
    }
}
