import javax.swing.*;
import java.awt.*;
import PlayerPackage.Player;

public class Main extends JFrame {
    private final Font defaultFont = new Font("Ink Free",Font.BOLD,15);
    private final Font defaultFont2 = new Font ("tahome",Font.BOLD,10);
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
        initCenterPanel();
    }
    // put all the slot machines
    public void initLeftPanel (){
        JPanel LeftPanel = new JPanel();
        LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.Y_AXIS));
        LeftPanel.setBackground(Color.pink);
        LeftPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


        //adding a title for this part of amusement park
        JTextField SlotMachine = new JTextField("Slot Machines");
        SlotMachine.setPreferredSize(new Dimension(100,5));
        SlotMachine.setFont(defaultFont);
        SlotMachine.setMaximumSize(new Dimension(270,20));
        SlotMachine.setHorizontalAlignment(JTextField.CENTER);
        LeftPanel.add(SlotMachine);

        LeftPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        //adding Green slot machine
        Icon GreenMachine = new ImageIcon("D:/programming projects/Amusement Park/image/GreenMachine.PNG");
        JButton GreenSlotMachine = new JButton(GreenMachine);
        GreenSlotMachine.setBackground(Color.WHITE);
        GreenSlotMachine.setPreferredSize(new Dimension(100,5));
        LeftPanel.add(GreenSlotMachine);


        LeftPanel.add(Box.createRigidArea(new Dimension(0, 5)));


        //adding red slot machine
        Icon RedMachine = new ImageIcon("D:/programming projects/Amusement Park/image/RedMachine.PNG");
        JButton RedSlotMachine = new JButton(RedMachine);
        RedSlotMachine.setBackground(Color.WHITE);
        RedSlotMachine.setPreferredSize(new Dimension(100,5));
        LeftPanel.add(RedSlotMachine);


        LeftPanel.add(Box.createRigidArea(new Dimension(0, 5)));


        //adding blue slot machine
        Icon BlueMachine = new ImageIcon("D:/programming projects/Amusement Park/image/BlueMachine.PNG");
        JButton BlueSlotMachine = new JButton(BlueMachine);
        BlueSlotMachine.setBackground(Color.WHITE);
        BlueSlotMachine.setPreferredSize(new Dimension(100,5));
        LeftPanel.add(BlueSlotMachine);


        LeftPanel.add(Box.createRigidArea(new Dimension(0, 5)));


        //adding black slot machine
        Icon BlackMachine = new ImageIcon("D:/programming projects/Amusement Park/image/BlackMachine.PNG");
        JButton BlackSlotMachine = new JButton(BlackMachine);
        BlackSlotMachine.setBackground(Color.WHITE);
        BlackSlotMachine.setPreferredSize(new Dimension(100,5));
        LeftPanel.add(BlackSlotMachine);


        LeftPanel.add(Box.createRigidArea(new Dimension(0, 5)));


        //adding white slot machine
        Icon WhiteMachine = new ImageIcon("D:/programming projects/Amusement Park/image/WhiteMachine.PNG");
        JButton WhiteSlotMachine = new JButton(WhiteMachine);
        WhiteSlotMachine.setBackground(Color.BLACK);
        WhiteSlotMachine.setPreferredSize(new Dimension(100,5));
        LeftPanel.add(WhiteSlotMachine);


        add (LeftPanel , BorderLayout.WEST);
        setVisible(true);


    }
    // design store
    public void initRightPanel (){
        JPanel RightPanel = new JPanel(new GridBagLayout());
        gbc.insets = new Insets(4,2,4,2);
        RightPanel.setBackground(Color.pink);

        JTextField Store = new JTextField("Store");
        Store.setFont(defaultFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        Store.setHorizontalAlignment(JTextField.CENTER);
        RightPanel.add(Store , gbc);


        Icon PrizeClaw = new ImageIcon("D:/programming projects/Amusement Park/image/PrizeClawCard.PNG");
        JButton PrizeClaw1 = new JButton(PrizeClaw);
        gbc.gridx = 0;
        gbc.gridy = 1;
        PrizeClaw1.setPreferredSize(new Dimension(80,100));
        PrizeClaw1.setBackground(Color.WHITE);
        RightPanel.add(PrizeClaw1,gbc);

        JButton PrizeClaw2 = new JButton(PrizeClaw);
        gbc.gridx = 1;
        gbc.gridy = 1;
        PrizeClaw2.setPreferredSize(new Dimension(80,100));
        PrizeClaw2.setBackground(Color.WHITE);
        RightPanel.add(PrizeClaw2,gbc);

        JButton PrizeClaw3 = new JButton(PrizeClaw);
        gbc.gridx = 2;
        gbc.gridy = 1;
        PrizeClaw3.setPreferredSize(new Dimension(80,100));
        PrizeClaw3.setBackground(Color.WHITE);
        RightPanel.add(PrizeClaw3,gbc);

        Icon card1 = new ImageIcon("D:/programming projects/Amusement Park/image/cards1.PNG");
        Icon card2 = new ImageIcon("D:/programming projects/Amusement Park/image/cards2.PNG");
        Icon card3 = new ImageIcon("D:/programming projects/Amusement Park/image/cards3.PNG");


        JButton FirstLevel1 = new JButton(card1);
        gbc.gridx = 0;
        gbc.gridy = 2;
        FirstLevel1.setPreferredSize(new Dimension(80,130));
        FirstLevel1.setBackground(Color.WHITE);
        RightPanel.add(FirstLevel1,gbc);

        JButton FirstLevel2 = new JButton(card1);
        gbc.gridx = 1;
        gbc.gridy = 2;
        FirstLevel2.setPreferredSize(new Dimension(80,130));
        FirstLevel2.setBackground(Color.WHITE);
        RightPanel.add(FirstLevel2,gbc);

        JButton FirstLevel3 = new JButton(card1);
        gbc.gridx = 2;
        gbc.gridy = 2;
        FirstLevel3.setPreferredSize(new Dimension(80,130));
        FirstLevel3.setBackground(Color.WHITE);
        RightPanel.add(FirstLevel3,gbc);

        JButton FirstLevel4 = new JButton(card1);
        gbc.gridx = 3;
        gbc.gridy = 2;
        FirstLevel4.setPreferredSize(new Dimension(80,130));
        FirstLevel4.setBackground(Color.WHITE);
        RightPanel.add(FirstLevel4,gbc);

        JButton SecondLevel1 = new JButton(card2);
        gbc.gridx = 0;
        gbc.gridy = 3;
        SecondLevel1.setPreferredSize(new Dimension(80,130));
        SecondLevel1.setBackground(Color.WHITE);
        RightPanel.add(SecondLevel1,gbc);

        JButton SecondLevel2 = new JButton(card2);
        gbc.gridx = 1;
        gbc.gridy = 3;
        SecondLevel2.setPreferredSize(new Dimension(80,130));
        SecondLevel2.setBackground(Color.WHITE);
        RightPanel.add(SecondLevel2,gbc);

        JButton SecondLevel3 = new JButton(card2);
        gbc.gridx = 2;
        gbc.gridy = 3;
        SecondLevel3.setPreferredSize(new Dimension(80,130));
        SecondLevel3.setBackground(Color.WHITE);
        RightPanel.add(SecondLevel3,gbc);

        JButton SecondLevel4 = new JButton(card2);
        gbc.gridx = 3;
        gbc.gridy = 3;
        SecondLevel4.setPreferredSize(new Dimension(80,130));
        SecondLevel4.setBackground(Color.WHITE);
        RightPanel.add(SecondLevel4,gbc);

        JButton ThirdLevel1 = new JButton(card3);
        gbc.gridx = 0;
        gbc.gridy = 4;
        ThirdLevel1.setPreferredSize(new Dimension(80,130));
        ThirdLevel1.setBackground(Color.WHITE);
        RightPanel.add(ThirdLevel1,gbc);

        JButton ThirdLevel2 = new JButton(card3);
        gbc.gridx = 1;
        gbc.gridy = 4;
        ThirdLevel2.setPreferredSize(new Dimension(80,130));
        ThirdLevel2.setBackground(Color.WHITE);
        RightPanel.add(ThirdLevel2,gbc);

        JButton ThirdLevel3 = new JButton(card3);
        gbc.gridx = 2;
        gbc.gridy = 4;
        ThirdLevel3.setPreferredSize(new Dimension(80,130));
        ThirdLevel3.setBackground(Color.WHITE);
        RightPanel.add(ThirdLevel3,gbc);

        JButton ThirdLevel4 = new JButton(card3);
        gbc.gridx = 3;
        gbc.gridy = 4;
        ThirdLevel4.setPreferredSize(new Dimension(80,130));
        ThirdLevel4.setBackground(Color.WHITE);
        RightPanel.add(ThirdLevel4,gbc);


        add(RightPanel , BorderLayout.EAST);
        setVisible(true);



    }
    //adding player tables
    public void initCenterPanel (){
        Player Player1 = new Player();
        Player Player2 = new Player();

        JPanel CenterPanel = new JPanel(new BorderLayout(5,5));
        CenterPanel.setBackground(Color.pink);

        String alerts = "";
        JTextField Alerts = new JTextField(alerts);
        Alerts.setFont(defaultFont2);
        Alerts.setBackground(Color.LIGHT_GRAY);
        CenterPanel.add(Alerts,BorderLayout.CENTER);


        JPanel Player1Table = new JPanel();
        Player1Table.setLayout(new BoxLayout(Player1Table, BoxLayout.Y_AXIS));
        Player1Table.setBackground(Color.pink);


        JTextField Score1 = new JTextField("SCORE!");
        Score1.setFont(defaultFont);
        Score1.setHorizontalAlignment(JTextField.CENTER);
        JTextField SpecialCoins1 = new JTextField("SPECIAL COIN'S COUNT");
        SpecialCoins1.setFont(defaultFont);
        SpecialCoins1.setHorizontalAlignment(JTextField.CENTER);
        JTextField Coins1 = new JTextField("NORMAL COIN'S COUNT");
        Coins1.setFont(defaultFont);
        Coins1.setHorizontalAlignment(JTextField.CENTER);


        String CoinState1 = "red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin;
        JTextField Player1CoinCounter = new JTextField(CoinState1);
        Player1CoinCounter.setFont(defaultFont2);
        Player1CoinCounter.setHorizontalAlignment(JTextField.CENTER);


        String SpecialCoinState1 = "red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                ",gold = " + Player1.GoldCoin;
        JTextField Player1SpecialCoinCounter = new JTextField(SpecialCoinState1);
        Player1SpecialCoinCounter.setFont(defaultFont2);
        Player1SpecialCoinCounter.setHorizontalAlignment(JTextField.CENTER);


        JTextField Player1Score = new JTextField(String.valueOf(Player1.Score));
        Player1Score.setHorizontalAlignment(JTextField.CENTER);

        Player1Table.add(Score1);
        Player1Table.add(Player1Score);
        Player1Table.add(Coins1);
        Player1Table.add(Player1CoinCounter);
        Player1Table.add(SpecialCoins1);
        Player1Table.add(Player1SpecialCoinCounter);

        CenterPanel.add(Player1Table , BorderLayout.NORTH);



        JPanel Player2Table = new JPanel();
        Player2Table.setLayout(new BoxLayout(Player2Table, BoxLayout.Y_AXIS));
        Player2Table.setBackground(Color.pink);


        JTextField Score2 = new JTextField("SCORE!");
        Score2.setFont(defaultFont);
        Score2.setHorizontalAlignment(JTextField.CENTER);
        JTextField SpecialCoins2 = new JTextField("SPECIAL COIN'S COUNT");
        SpecialCoins2.setFont(defaultFont);
        SpecialCoins2.setHorizontalAlignment(JTextField.CENTER);
        JTextField Coins2 = new JTextField("NORMAL COIN'S COUNT");
        Coins2.setFont(defaultFont);
        Coins2.setHorizontalAlignment(JTextField.CENTER);


        String CoinState2 = "red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin;
        JTextField Player2CoinCounter = new JTextField(CoinState2);
        Player2CoinCounter.setFont(defaultFont2);
        Player2CoinCounter.setHorizontalAlignment(JTextField.CENTER);

        String SpecialCoinState2 = "red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                ",gold = " + Player2.GoldCoin;
        JTextField Player2SpecialCoinCounter = new JTextField(SpecialCoinState2);
        Player2SpecialCoinCounter.setFont(defaultFont2);
        Player2SpecialCoinCounter.setHorizontalAlignment(JTextField.CENTER);


        JTextField Player2Score = new JTextField(String.valueOf(Player2.Score));
        Player2Score.setHorizontalAlignment(JTextField.CENTER);


        Player2Table.add(Score2);
        Player2Table.add(Player2Score);
        Player2Table.add(Coins2);
        Player2Table.add(Player2CoinCounter);
        Player2Table.add(SpecialCoins2);
        Player2Table.add(Player2SpecialCoinCounter);

        CenterPanel.add(Player2Table , BorderLayout.SOUTH);

        add(CenterPanel , BorderLayout.CENTER);
        setVisible(true);



    }
    public static void main(String[] args) {

        new Main ();



    }
}


