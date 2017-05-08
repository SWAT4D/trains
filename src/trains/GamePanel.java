package trains;

import java.awt.*;
import java.util.Map;

import javax.swing.JPanel;

/**
 * A pálya kirajzolásáért felelős
 */
public class GamePanel extends JPanel{
    Map<Koo, Rail> map;
    int rectwidth;
    int rectheight;


    /**
     * Konstruktor, csak inicializálás
     * @param map
     * @param width
     * @param height 
     */
    GamePanel(Map<Koo, Rail> map, int width, int height){
        super();
        rectwidth = width;
        rectheight = height;
        this.map = map;
    }

    /**
     * Kirajzolja a pályát
     * @param g 
     */
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;



        for(int i=0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                Koo searched = new Koo(j, i);
                String sMap = ".";
                String scMap = "";

                String sTrain= ".";
                boolean isTrain = false;
                for (Map.Entry<Koo, Rail> entry : map.entrySet()) {
                    if (entry.getKey().compareTo(searched) == 0) {
                        if (entry.getValue().getTrain() != null) {
                            sTrain = entry.getValue().getTrain().toString();
                            isTrain = true;
                        }
                        sMap = entry.getValue().toString();
                        scMap = entry.getValue().getColor();
                    }
                }
                Color c = Color.WHITE;
                boolean isSwitch = false;
                boolean fo = true;
                boolean isTunnelPlace = false;
                boolean isTpAct = false;
                switch(sMap){
                    case "E":
                        c = new Color(153,76,0); break;
                    case "S":
                        switch(scMap){
                            case "r":
                                c = new Color(255, 153, 153); break;
                            case "b":
                                c = new Color(153,204,255); break;
                            case "g":
                                c = new Color(153, 255, 153); break;
                            default:
                                c = Color.MAGENTA; break;
                        }break;
                    case "+":
                        c = new Color(153,76,0); break;
                    case "G":
                        switch(scMap){
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
                        c = new Color(128, 128, 128); 
                        isTunnelPlace = true;
                        isTpAct = true;
                        break;
                    case "V":
                        c = new Color(128, 128, 128); 
                        isTunnelPlace = true;
                        isTpAct = false;
                        break;
                    case "M":
                        c = new Color(153,76,0);
                        isSwitch = true;
                        fo = false;
                        break;
                    case "F":
                        c = new Color(153,76,0);
                        isSwitch = true;
                        fo = true;
                        break;
                    case "C":
                        c = Color.MAGENTA;
                        break;
                    default:
                        c = Color.WHITE; break;
                }
                Color cTrain = Color.WHITE;
                if(isTrain) {
                    switch (sTrain) {
                        case "l":
                            cTrain = Color.BLACK; break;
                        case "r":
                            cTrain = new Color(255, 70, 70); break;
                        case "b":
                            cTrain = new Color(70,160,255); break;
                        case "g":
                            cTrain = new Color(70, 255, 70); break;
                        case "k":
                            cTrain = new Color(60, 60, 60); break;
                        case "e":
                            cTrain = Color.YELLOW; break;
                        default:
                            isTrain = false; break;
                    }
                }
                
                g2.setColor(c);
                g.fillRect(j*rectwidth, i*rectheight , rectwidth, rectheight);
                if(isTrain){
                    g2.setColor(cTrain);
                    g.fillOval(j*rectwidth, i*rectheight , rectwidth, rectheight);
                }
                else{
                    if(isSwitch){
                        if(fo) {
                            g2.setColor(Color.BLACK);
                            g.fillRoundRect(j*rectwidth + rectwidth/4, i*rectheight + rectheight/4, rectwidth/2, rectheight/2, 2,2);
                        }
                        else{
                            g2.setColor(Color.WHITE);
                            g.fillRoundRect(j*rectwidth + rectwidth/4, i*rectheight + rectheight/4, rectwidth/2, rectheight/2, 2,2);
                        }
                    }
                    if(isTunnelPlace){
                        if(isTpAct) {
                            g2.setColor(Color.GREEN);
                            g.fillRoundRect(j*rectwidth + rectwidth/4, i*rectheight + rectheight/4, rectwidth/2, rectheight/2, 2,2);
                        }
                        else{
                            g2.setColor(Color.RED);
                            g.fillRoundRect(j*rectwidth + rectwidth/4, i*rectheight + rectheight/4, rectwidth/2, rectheight/2, 2,2);
                        }
                    }
                }
            }
        }
    }
}
