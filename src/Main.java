import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private Font defaultFont = new Font("Bernard MT Condensed",Font.PLAIN,20);
    public Main (){
        // initial designs
        setTitle("Amusement Park");
        setSize(800,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.pink);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        initLeftPanel();
        initRightPanel();
        initBotPanel();
    }
    private void initLeftPanel (){
        JPanel LeftPanel = new JPanel();
        LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.Y_AXIS));


        //adding a title for this part of amusement park
        JTextField SlotMachine = new JTextField("Slot Machines");
        SlotMachine.setPreferredSize(new Dimension(1,1));
        SlotMachine.setFont(defaultFont);
        LeftPanel.add(SlotMachine);

        //adding Green slot machine
        Icon GreenMachine = new ImageIcon("D:/programming projects/Amusement Park/image/GreenMachine.PNG");
        JButton GreenSlotMachine = new JButton(GreenMachine);
        GreenSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(GreenSlotMachine);


        //adding red slot machine
        Icon RedMachine = new ImageIcon("D:/programming projects/Amusement Park/image/RedMachine.PNG");
        JButton RedSlotMachine = new JButton(RedMachine);
        RedSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(RedSlotMachine);


        //adding blue slot machine
        Icon BlueMachine = new ImageIcon("D:/programming projects/Amusement Park/image/BlueMachine.PNG");
        JButton BlueSlotMachine = new JButton(BlueMachine);
        BlueSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(BlueSlotMachine);


        //adding black slot machine
        Icon BlackMachine = new ImageIcon("D:/programming projects/Amusement Park/image/BlackMachine.PNG");
        JButton BlackSlotMachine = new JButton(BlackMachine);
        BlackSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(BlackSlotMachine);


        //adding white slot machine
        Icon WhiteMachine = new ImageIcon("D:/programming projects/Amusement Park/image/WhiteMachine.PNG");
        JButton WhiteSlotMachine = new JButton(WhiteMachine);
        WhiteSlotMachine.setBackground(Color.BLACK);
        LeftPanel.add(WhiteSlotMachine);


        add (LeftPanel , BorderLayout.WEST);
        setVisible(true);


    }
    private void initRightPanel (){

    }
    private void initBotPanel (){

    }
    public static void main(String[] args) {
        new Main ();


    }
}