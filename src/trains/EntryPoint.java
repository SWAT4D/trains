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
    public String toString(){
        return "E";
    }
}
