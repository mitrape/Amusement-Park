import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

import PlayerPackage.Player;
import CardsPackage.ZeroLevelCards;

public class Main extends JFrame {
    private final Font defaultFont = new Font("Ink Free",Font.BOLD,15);
    private final Font defaultFont2 = new Font ("tahome",Font.BOLD,10);
    private final Font CardFont = new Font("tahoma" , Font.BOLD ,15);
    private final Font defaultFont3 = new Font("tahoma" , Font.BOLD , 5);
    public boolean PlayerTurn ; //true for player1 and false for player2


    GridBagConstraints gbc = new GridBagConstraints();
    Player Player1 = new Player();
    Player Player2 = new Player();
    public Main (){
        // initial designs
        setTitle("Amusement Park");
        setSize(1000,800);
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
        JLabel SlotMachine = new JLabel("Slot Machines");
        SlotMachine.setFont(defaultFont);
        SlotMachine.setMaximumSize(new Dimension(270,20));
        SlotMachine.setHorizontalAlignment(JLabel.CENTER);
        SlotMachine.setOpaque(true);
        SlotMachine.setBackground(Color.WHITE);
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

        JLabel Store = new JLabel("Store");
        Store.setFont(defaultFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        Store.setPreferredSize(new Dimension( 100 , 40));
        Store.setHorizontalAlignment(JLabel.CENTER);
        Store.setOpaque(true);
        Store.setBackground(Color.WHITE);
        RightPanel.add(Store , gbc);


        Icon PrizeClaw = new ImageIcon("D:/programming projects/Amusement Park/image/PrizeClawCard.PNG");
        JButton PrizeClaw1 = new JButton(PrizeClaw);
        gbc.gridx = 0;
        gbc.gridy = 1;
        PrizeClaw1.setPreferredSize(new Dimension(80,100));
        PrizeClaw1.setBackground(Color.WHITE);

        JPanel marks1 = new JPanel(new BorderLayout());
        marks1.setOpaque(false);

        ZeroLevelCards first = new ZeroLevelCards();

        JLabel score1 = new JLabel(String.valueOf(first.Score));
        score1.setFont(CardFont);

        JLabel coin1 = new JLabel(first.Color1+"="+first.Count1+ ","+first.Color2+"="+first.Count2);
        coin1.setFont(defaultFont3);

        marks1.add(score1 , BorderLayout.NORTH);
        marks1.add (coin1 , BorderLayout.SOUTH);
        PrizeClaw1.add(marks1);
        RightPanel.add(PrizeClaw1,gbc);

        PrizeClaw1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    //player1 turn
                    if(Player1.SpecialRedCoin >= 4 && Player1.SpecialWhiteCoin >= 4){
                        if (Coins.GoldCoin > 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin++;
                        }
                        Player1.Score += 3 ;
                        PrizeClaw1.setEnabled(false);
                        PlayerTurn=false;
                    }
                    else {
                       showMessageDialog(null, "you can't buy this card");
                    }
                }
                else{
                    //player2 turn
                    if(Player2.SpecialRedCoin >= 4 && Player2.SpecialWhiteCoin >= 4){
                        if (Coins.GoldCoin > 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin++;
                        }
                        Player2.Score += 3 ;
                        PrizeClaw1.setEnabled(false);
                        PlayerTurn = true ;
                    }
                    else {
                        showMessageDialog(null , "you can't buy this card");
                    }
                }
            }
        });

        JButton PrizeClaw2 = new JButton(PrizeClaw);
        gbc.gridx = 1;
        gbc.gridy = 1;
        PrizeClaw2.setPreferredSize(new Dimension(80,100));
        PrizeClaw2.setBackground(Color.WHITE);

        JPanel marks2 = new JPanel(new BorderLayout());
        marks2.setOpaque(false);

        ZeroLevelCards second = new ZeroLevelCards();

        JLabel score2 = new JLabel(String.valueOf(second.Score));
        score2.setFont(CardFont);

        JLabel coin2 = new JLabel(second.Color1+"="+second.Count1+","+second.Color2+"="+second.Count2);
        coin2.setFont(defaultFont3);

        marks2.add(score2 , BorderLayout.NORTH);
        marks2.add (coin2 , BorderLayout.SOUTH);
        PrizeClaw2.add(marks2);
        RightPanel.add(PrizeClaw2,gbc);

        PrizeClaw2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    //player1 turn
                    if(Player1.SpecialBlueCoin >= 5 && Player1.SpecialGreenCoin >= 5){
                        if (Coins.GoldCoin > 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin++;
                        }
                        Player1.Score += 4 ;
                        PrizeClaw2.setEnabled(false);
                        PlayerTurn = false ;
                    }
                    else {
                        showMessageDialog(null, "you can't buy this card");
                    }
                }
                else{
                    //player2 turn
                    if(Player2.SpecialBlueCoin >= 5 && Player2.SpecialGreenCoin >= 5){
                        if (Coins.GoldCoin > 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin++;
                        }
                        Player2.Score += 4 ;
                        PrizeClaw2.setEnabled(false);
                        PlayerTurn = true ;
                    }
                    else {
                        showMessageDialog(null, "you can't buy this card");
                    }
                }
            }
        });

        JButton PrizeClaw3 = new JButton(PrizeClaw);
        gbc.gridx = 2;
        gbc.gridy = 1;
        PrizeClaw3.setPreferredSize(new Dimension(80,100));
        PrizeClaw3.setBackground(Color.WHITE);

        JPanel marks3 = new JPanel(new BorderLayout());
        marks3.setOpaque(false);

        ZeroLevelCards third = new ZeroLevelCards();

        JLabel score3 = new JLabel(String.valueOf(third.Score));
        score3.setFont(CardFont);

        JLabel coin3 = new JLabel(third.Color1+"="+third.Count1+","+third.Color2+"="+third.Count2);
        coin3.setFont(defaultFont3);


        marks3.add(score3 , BorderLayout.NORTH);
        marks3.add (coin3 , BorderLayout.SOUTH);
        PrizeClaw3.add(marks3);
        RightPanel.add(PrizeClaw3,gbc);

        PrizeClaw3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    //player1 turn
                    if(Player1.SpecialBlackCoin >= 6 && Player1.SpecialRedCoin >= 6){
                        if (Coins.GoldCoin > 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin++;
                        }
                        Player1.Score += 3 ;
                        PrizeClaw3.setEnabled(false);
                        PlayerTurn = false ;
                    }
                    else {
                        showMessageDialog(null, "you can't buy this card");
                    }
                }
                else{
                    //player2 turn
                    if(Player2.SpecialBlackCoin >= 6 && Player2.SpecialRedCoin >= 6){
                        if (Coins.GoldCoin > 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin++;
                        }
                        Player2.Score += 3 ;
                        PrizeClaw3.setEnabled(false);
                        PlayerTurn = true ;
                    }
                    else {
                        showMessageDialog(null, "you can't buy this card");
                    }
                }
            }
        });

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


        JPanel CenterPanel = new JPanel(new BorderLayout(5,5));
        CenterPanel.setBackground(Color.pink);

//        String alerts = "";
//        JLabel Alerts = new JLabel(alerts);
//        Alerts.setFont(defaultFont2);
//        Alerts.setHorizontalAlignment(JLabel.CENTER);
//        Alerts.setOpaque(true);
//        Alerts.setBackground(Color.LIGHT_GRAY);
//        CenterPanel.add(Alerts,BorderLayout.CENTER);


        JPanel Player1Table = new JPanel();
        Player1Table.setLayout(new GridLayout(7,1));
        Player1Table.setBackground(Color.pink);


        JLabel player1 = new JLabel("<PLAYER ONE>");
        player1.setHorizontalAlignment(SwingConstants.CENTER);
        player1.setFont(defaultFont);
        player1.setPreferredSize(new Dimension(200, 30));
        player1.setHorizontalAlignment(SwingConstants.CENTER);
        player1.setOpaque(true);
        player1.setBackground(Color.YELLOW);

        JLabel Score1 = new JLabel("SCORE!");
        Score1.setHorizontalAlignment(SwingConstants.CENTER);
        Score1.setFont(defaultFont);
        Score1.setPreferredSize(new Dimension(200, 30));
        Score1.setHorizontalAlignment(SwingConstants.CENTER);
        Score1.setOpaque(true);
        Score1.setBackground(Color.LIGHT_GRAY);

        JLabel SpecialCoins1 = new JLabel("SPECIAL COIN'S COUNT");
        SpecialCoins1.setFont(defaultFont);
        SpecialCoins1.setPreferredSize(new Dimension(200, 30));
        SpecialCoins1.setHorizontalAlignment(JLabel.CENTER);
        SpecialCoins1.setOpaque(true);
        SpecialCoins1.setBackground(Color.LIGHT_GRAY);

        JLabel Coins1 = new JLabel("NORMAL COIN'S COUNT");
        Coins1.setFont(defaultFont);
        Coins1.setPreferredSize(new Dimension(200, 30));
        Coins1.setHorizontalAlignment(JLabel.CENTER);
        Coins1.setOpaque(true);
        Coins1.setBackground(Color.LIGHT_GRAY);


        String CoinState1 = "red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin;
        JLabel Player1CoinCounter = new JLabel(CoinState1);
        Player1CoinCounter.setFont(defaultFont2);
        Player1CoinCounter.setPreferredSize(new Dimension(200, 30));
        Player1CoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player1CoinCounter.setOpaque(true);
        Player1CoinCounter.setBackground(Color.WHITE);


        String SpecialCoinState1 = "red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                ",gold = " + Player1.SpecialGoldCoin;
        JLabel Player1SpecialCoinCounter = new JLabel(SpecialCoinState1);
        Player1SpecialCoinCounter.setFont(defaultFont2);
        Player1SpecialCoinCounter.setPreferredSize(new Dimension(200, 30));
        Player1SpecialCoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player1SpecialCoinCounter.setOpaque(true);
        Player1SpecialCoinCounter.setBackground(Color.WHITE);


        JLabel Player1Score = new JLabel(String.valueOf(Player1.Score));
        Player1Score.setPreferredSize(new Dimension(200, 30));
        Player1Score.setHorizontalAlignment(JLabel.CENTER);
        Player1Score.setOpaque(true);
        Player1Score.setBackground(Color.WHITE);

        Player1Table.add(player1);
        Player1Table.add(Score1);
        Player1Table.add(Player1Score);
        Player1Table.add(Coins1 );
        Player1Table.add(Player1CoinCounter );
        Player1Table.add(SpecialCoins1 );
        Player1Table.add(Player1SpecialCoinCounter);

        CenterPanel.add(Player1Table , BorderLayout.NORTH);



        JPanel Player2Table = new JPanel();
        Player2Table.setLayout(new GridLayout(7,1));
        Player2Table.setBackground(Color.pink);


        JLabel player2 = new JLabel("<PLAYER TWO>");
        player2.setHorizontalAlignment(SwingConstants.CENTER);
        player2.setFont(defaultFont);
        player2.setPreferredSize(new Dimension(200, 30));
        player2.setHorizontalAlignment(SwingConstants.CENTER);
        player2.setOpaque(true);
        player2.setBackground(Color.YELLOW);

        JLabel Score2 = new JLabel("SCORE!");
        Score2.setFont(defaultFont);
        Score2.setPreferredSize(new Dimension(200, 30));
        Score2.setHorizontalAlignment(JLabel.CENTER);
        Score2.setOpaque(true);
        Score2.setBackground(Color.LIGHT_GRAY);

        JLabel SpecialCoins2 = new JLabel("SPECIAL COIN'S COUNT");
        SpecialCoins2.setFont(defaultFont);
        SpecialCoins2.setPreferredSize(new Dimension(200, 30));
        SpecialCoins2.setHorizontalAlignment(JLabel.CENTER);
        SpecialCoins2.setOpaque(true);
        SpecialCoins2.setBackground(Color.LIGHT_GRAY);

        JLabel Coins2 = new JLabel("NORMAL COIN'S COUNT");
        Coins2.setFont(defaultFont);
        Coins2.setPreferredSize(new Dimension(200, 30));
        Coins2.setHorizontalAlignment(JLabel.CENTER);
        Coins2.setOpaque(true);
        Coins2.setBackground(Color.LIGHT_GRAY);


        String CoinState2 = "red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin;
        JLabel Player2CoinCounter = new JLabel(CoinState2);
        Player2CoinCounter.setFont(defaultFont2);
        Player2CoinCounter.setPreferredSize(new Dimension(200, 30));
        Player2CoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player2CoinCounter.setOpaque(true);
        Player2CoinCounter.setBackground(Color.WHITE);

        String SpecialCoinState2 = "red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                ",gold = " + Player2.SpecialGoldCoin;
        JLabel Player2SpecialCoinCounter = new JLabel(SpecialCoinState2);
        Player2SpecialCoinCounter.setFont(defaultFont2);
        Player2SpecialCoinCounter.setPreferredSize(new Dimension(200, 30));
        Player2SpecialCoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player2SpecialCoinCounter.setOpaque(true);
        Player2SpecialCoinCounter.setBackground(Color.WHITE);


        JLabel Player2Score = new JLabel(String.valueOf(Player2.Score));
        Player2Score.setHorizontalAlignment(JLabel.CENTER);
        Player2Score.setPreferredSize(new Dimension(200, 30));
        Player2Score.setOpaque(true);
        Player2Score.setBackground(Color.WHITE);

        Player2Table.add(player2);
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


