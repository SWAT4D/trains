package trains;

public class Koo implements Comparable {
    public Koo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int x,y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean around(Koo oth){
        if(
                (oth.x==x-1&&oth.y==y)||
                        (oth.x==x+1&&oth.y==y)||
                        (oth.x==x&&oth.y==y+1)||
                        (oth.x==x&&oth.y==y-1)
                )
            return true;
        return false;
    }



    @Override
    public int compareTo(Object o) {
        Koo oth = (Koo)o;
        if(oth.getX() == x && oth.getY() == y)
            return 0;
        return -1;
    }

    public static Koo parseKoo(String str){
        String[] c = str.replace('(',' ').replace(')',' ').trim().split(",");
        return new Koo(Integer.parseInt(c[0]),Integer.parseInt(c[1]));
    }
    public Koo dec(){
        return new Koo(x-1,y-1);
    }
}
