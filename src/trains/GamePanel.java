package trains;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;


import javax.swing.JPanel;

public class GamePanel extends JPanel{
    Map<Koo, Rail> map;

    GamePanel(Map<Koo, Rail> map){
        super();
        this.map = map;
    }

    public void setMap(Map<Koo, Rail> map){
        this.map = map;
    }



    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        int rectwidth = 30;
        int rectheight = 30;

        for(int i=0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                Koo searched = new Koo(j, i);
                String s = ".";
                String sc = "";
                for (Map.Entry<Koo, Rail> entry : map.entrySet()) {
                    if (entry.getKey().compareTo(searched) == 0) {
                        if (entry.getValue().getTrain() != null) {
                            s = entry.getValue().getTrain().toString();
                        } else {
                            s = entry.getValue().toString();
                            sc = entry.getValue().getColor();
                        }
                    }
                }
                Color c = Color.WHITE;
                switch(s){
                    case "E":
                        c = new Color(153,76,0); break;
                    case "S":
                        switch(sc){
                            case "r":
                                c = new Color(255, 153, 153); break;
                            case "b":
                                c = new Color(153,204,255); break;
                            case "g":
                                c = new Color(153, 255, 153); break;
                            default:
                                c = Color.MAGENTA; break;
                        }break;
                    case "l":
                        c = Color.BLACK; break;
                    case "+":
                        c = new Color(153,76,0); break;
                    case "G":
                        switch(sc){
                            case "r":
                                c = new Color(204, 0, 0); break;
                            case "b":
                                c = new Color(0,102,204); break;
                            case "g":
                                c = new Color(0, 204, 0); break;
                            default:
                                c = Color.MAGENTA; break;
                        }break;
                    case "T":
                        c = new Color(128, 128, 128); break;
                    case "r":
                        c = new Color(255, 70, 70); break;
                    case "b":
                        c = new Color(70,160,255); break;
                    case "g":
                        c = new Color(70, 255, 70); break;
                    case "e":
                        c = Color.YELLOW; break;
                    default:
                        c = Color.WHITE; break;
                }

                g2.setColor(c);
                g.fillRect(j*rectwidth, i*rectheight , rectwidth, rectheight);
            }
        }


            }
}
