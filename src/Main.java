import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private Font defaultFont = new Font("Bernard MT Condensed",Font.PLAIN,20);
    GridBagConstraints gbc = new GridBagConstraints();
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
    // put all the slot machines
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
    // design store
    private void initRightPanel (){
        JPanel RightPanel = new JPanel(new GridBagLayout());
        gbc.insets = new Insets(2,2,2,2);


        Icon PrizeClaw = new ImageIcon("D:/programming projects/Amusement Park/image/PrizeClawCard.PNG");
        JButton PrizeClaw1 = new JButton(PrizeClaw);
        PrizeClaw1.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        RightPanel.add(PrizeClaw1,gbc);

        JButton PrizeClaw2 = new JButton(PrizeClaw);
        PrizeClaw2.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        RightPanel.add(PrizeClaw2,gbc);

        JButton PrizeClaw3 = new JButton(PrizeClaw);
        PrizeClaw3.setBackground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 0;
        RightPanel.add(PrizeClaw3,gbc);

        JButton FirstLevel1 = new JButton();
        gbc.gridx = 0;
        gbc.gridy = 1;
        RightPanel.add(FirstLevel1,gbc);

        JButton FirstLevel2 = new JButton();
        gbc.gridx = 1;
        gbc.gridy = 1;
        RightPanel.add(FirstLevel2,gbc);

        JButton FirstLevel3 = new JButton();
        gbc.gridx = 2;
        gbc.gridy = 1;
        RightPanel.add(FirstLevel3,gbc);

        JButton FirstLevel4 = new JButton();
        gbc.gridx = 3;
        gbc.gridy = 1;
        RightPanel.add(FirstLevel4,gbc);

        JButton SecondLevel1 = new JButton();
        gbc.gridx = 0;
        gbc.gridy = 2;
        RightPanel.add(SecondLevel1,gbc);

        JButton SecondLevel2 = new JButton();
        gbc.gridx = 1;
        gbc.gridy = 2;
        RightPanel.add(SecondLevel2,gbc);

        JButton SecondLevel3 = new JButton();
        gbc.gridx = 2;
        gbc.gridy = 2;
        RightPanel.add(SecondLevel3,gbc);

        JButton SecondLevel4 = new JButton();
        gbc.gridx = 3;
        gbc.gridy = 2;
        RightPanel.add(SecondLevel4,gbc);

        JButton ThirdLevel1 = new JButton();
        gbc.gridx = 0;
        gbc.gridy = 3;
        RightPanel.add(ThirdLevel1,gbc);

        JButton ThirdLevel2 = new JButton();
        gbc.gridx = 1;
        gbc.gridy = 3;
        RightPanel.add(ThirdLevel2,gbc);

        JButton ThirdLevel3 = new JButton();
        gbc.gridx = 2;
        gbc.gridy = 3;
        RightPanel.add(ThirdLevel3,gbc);

        JButton ThirdLevel4 = new JButton();
        gbc.gridx = 3;
        gbc.gridy = 3;
        RightPanel.add(ThirdLevel4,gbc);


        add(RightPanel , BorderLayout.EAST);
        setVisible(true);



    }
    private void initBotPanel (){

    }
    public static void main(String[] args) {
        new Main ();


    }
}