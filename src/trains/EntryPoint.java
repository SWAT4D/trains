package trains;

public class EntryPoint extends Rail {

    //Konstruktor mely kéri az EndVoidot
    EntryPoint(EndVoid ev){
        prevR = ev;
    }

    //Az entrypoint pályához csatlakozó felét köti egy sínhez
    @Override
    public void addNext(Rail next) {
        nextR =next;
    }

    //Ezzel lehet vonatot helyezni az entry pointra
    public void setTrain(Locomotive l){
        train = l;
    }

    @Override
    public String toString() {
        return "E";
    }
}
