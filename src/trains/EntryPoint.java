package trains;

public class EntryPoint extends Rail {

    //Konstruktor mely kéri az EndVoidot
    EntryPoint(EndVoid ev){
        prevR = ev;
    }

    public void setTrain(Locomotive l){
        train = l;
    }

    public void occupy(TrainElement trainElement) throws OccupyException {
        if (isOccupied){
            throw new OccupyException(this);
        }
        else {
            trainElement.moveNext();
            isOccupied = true;
            train = trainElement;
            trainElement.inside();
        }
    }

    @Override
    public String toString() {
        return "E";
    }
}
