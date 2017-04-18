package trains;

public class Placeable {
    //Koordináták
    private int x;
    private int y;

    //Elhelyezkedés lekérdezése
    public int[] getPlace(){
        return new int[]{x,y};
    }

    //Elhelyezés
    public void setPlace(int vertical, int horizontal){
        x = vertical;
        y = horizontal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
