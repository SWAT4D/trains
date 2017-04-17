package trains;

public class Cross extends Rail {
    Rail altnext;
    Rail altprev;
    public void addNextAlt(Rail r){
        altnext = r;
    }
    public void addPrevAlt(Rail r){
        altprev = r;
    }
}
