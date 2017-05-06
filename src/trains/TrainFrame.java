package trains;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;


public class TrainFrame extends JFrame{
    private final GamePanel gamePanel;
    private static Map<Koo, Rail> map;

    private final int ELEMENT_WIDTH = 30;
    private final int ELEMENT_HEIGHT = 30;
    
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
   
    public void repaintBoard() {
        gamePanel.repaint();
    }
    
    public void CreateSwitchButton(Koo pos){
        CreateButton(pos).addActionListener(new SwitchActionListener(pos));
    }
    
    public void CreateTunnelButton(Koo pos){
        CreateButton(pos).addActionListener(new TunnelPlaceActionListener(pos));
    }
    
    private JButton CreateButton(Koo pos){
        JButton button = new JButton();
        button.setLayout(null);
        button.setBounds(pos.getX() * ELEMENT_WIDTH, pos.getY() * ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        this.add(button);
        return button;
    }

    private class SwitchActionListener implements ActionListener {
        private final Koo koo;
        
        public SwitchActionListener(Koo pos){
            koo = pos;
        }
        
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
     
    private class TunnelPlaceActionListener implements ActionListener {
        private final Koo koo;
        
        public TunnelPlaceActionListener(Koo pos){
            koo = pos;
        }
        
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
    
    public static void main(String[] args){
        LinkedList<String> maplist = new LinkedList<>();
        maplist.add("maps/map1.txt");
        maplist.add("maps/map2.txt");
        maplist.add("maps/map3.txt");
        
        for (String maploc : maplist){
            GameBoard controll = new GameBoard();
            if (!controll.controllGame(maploc))
                break;
        }
        
    }
     
}
