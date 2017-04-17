package trains;

public class EntryPoint extends Rail {

    EntryPoint(EndVoid ev){
        prevR = ev;
    }

    @Override
    public void addNext(Rail next) {
        nextR =next;
    }

    public void setTrain(Locomotive l){
        train = l;
    }
}
