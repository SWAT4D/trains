package trains;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A játék ablaka
 */
public class TrainFrame extends JFrame{
    /**
     * A pálya kirajzolásáért felelős objektum
     */
    private final GamePanel gamePanel;
    
    /**
     * A pályán lévő objektumok tárolása pozició szerint
     */
    private static Map<Koo, Rail> map;

    /**
     * Egységméret a felületen lévő dolgokhoz
     */
    private final int ELEMENT_WIDTH = 30;
        /**
     * Egységméret a felületen lévő dolgokhoz
     */
    private final int ELEMENT_HEIGHT = 30;
    
    /**
     * Konstruktor, beállítja a felület elemeit
     * @param map 
     */
    public TrainFrame(Map<Koo, Rail> map){
        super.setTitle("The heresy train has no brakes!");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.map = map;
        gamePanel = new GamePanel(map, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        super.add(gamePanel);
        gamePanel.setPreferredSize(new Dimension(300,300));
        super.pack();
        super.setVisible( true );
    }
   
    /**
     * Meghívja a gamePanel rajzoló függvényét, mely újrarajzolja az egész pályát
     */
    public void repaintBoard() {
        gamePanel.repaint();
    }
    
    /**
     * Hozzáad egy létrehozott gombhoz, egy SwitchActionListener-t
     * @param pos 
     */
    public void CreateSwitchButton(Koo pos){
        CreateButton(pos).addActionListener(new SwitchActionListener(pos));
    }
    
    /**
     * Hozzáad egy létrehozott gombhoz, egy TunnelPlaceActionListener-t
     * @param pos 
     */
    public void CreateTunnelButton(Koo pos){
        CreateButton(pos).addActionListener(new TunnelPlaceActionListener(pos));
    }
    
    /**
     * Létrehoz egy új gombot és visszaadja azt
     * @param pos
     * @return 
     */
    private JButton CreateButton(Koo pos){
        JButton button = new JButton();
        button.setLayout(null);
        button.setBounds(pos.getX() * ELEMENT_WIDTH, pos.getY() * ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        this.add(button);
        return button;
    }

    /**
     * A váltóra való kattintás figyeléésért felelős
     */
    private class SwitchActionListener implements ActionListener {
        private final Koo koo;
        
                /**
         * Konstruktor
         * @param pos A megfigyelt Switch poziciója
         */
        public SwitchActionListener(Koo pos){
            koo = pos;
        }
        
        /**
         * Ha rákattintottak egy Switchre, akkor átváltja azt
         * @param arg0 
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {
            for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
                if (entry.getKey().compareTo(koo) == 0)
                  {
                      Switch sel = (Switch)entry.getValue();
                      sel.switchIt();
                      break;
                  }
            }
            gamePanel.repaint();
        }
    }
     
    /**
     * A TunnelPlacere való kattintás figyeléésért felelős
     */
    private class TunnelPlaceActionListener implements ActionListener {
        private final Koo koo;
        
        /**
         * Konstruktor
         * @param pos A megfigyelt TunnelPlace poziciója
         */
        public TunnelPlaceActionListener(Koo pos){
            koo = pos;
        }
        
        /**
         * Ha rákattintottak egy TunnelPlacere, akkor aktiválja azt
         * @param arg0 
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {
            for(Map.Entry<Koo, Rail> entry : map.entrySet()) {
                if (entry.getKey().compareTo(koo) == 0)
                {
                    TunnelPlace sel = (TunnelPlace) entry.getValue();
                    sel.setActive();
                    break;
                }
            }
            gamePanel.repaint();
        }
    }
    
    /**
     * Kiír a képernyőre egy dialógust, melyben értesíti a felhasználóta történtekről!
     * @param text A kiírandó szöveg
     */
    public void showGameMessage(String text) {
        JOptionPane.showMessageDialog(this, text);
    }
    
    
    /**
     * Program belépési pontja
     * @param args 
     */
    public static void main(String[] args){
        LinkedList<String> maplist = new LinkedList<>();
        maplist.add("maps/map03.txt");
        maplist.add("maps/map01.txt");
        maplist.add("maps/map02.txt");
        
        for (String maploc : maplist){
            GameBoard controll = new GameBoard();
            if (!controll.controllGame(maploc))
                break;
        }
        
    }
     
}
