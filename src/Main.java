import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

import CardsPackage.FirstLevelCards;
import CardsPackage.SecondLevelCards;
import CardsPackage.ThirdLevelCards;
import PlayerPackage.Coins;
import PlayerPackage.Player;
import CardsPackage.ZeroLevelCards;

public class Main extends JFrame {
    private final Font defaultFont = new Font("Ink Free",Font.BOLD,15);
    private final Font defaultFont2 = new Font ("tahome",Font.BOLD,10);
    private final Font CardFont = new Font("tahoma" , Font.BOLD ,10);
    private final Font defaultFont3 = new Font("tahoma" , Font.BOLD , 8);
    private final Font defaultFont4 = new Font ("tahoma" , Font.PLAIN , 10);
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

        FirstLevelCards [] First = new FirstLevelCards[15] ;
        SecondLevelCards[] Second = new SecondLevelCards[15] ;
        ThirdLevelCards[] Third = new ThirdLevelCards[15] ;


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
        PrizeClaw1.setPreferredSize(new Dimension(110,100));
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
        PrizeClaw2.setPreferredSize(new Dimension(110,100));
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
        PrizeClaw3.setPreferredSize(new Dimension(110,100));
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
        FirstLevel1.setPreferredSize(new Dimension(130,130));
        FirstLevel1.setBackground(Color.WHITE);

        JPanel marksFirst1 = new JPanel(new BorderLayout());
        marksFirst1.setOpaque(false);

        FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
        First [FirstLevelCards.CountFirst] = new FirstLevelCards() ;

        JLabel scoreFirst1 = new JLabel(First[FirstLevelCards.CounterFirst1].ScoreFirst+"                  "+First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
        scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
        scoreFirst1.setFont(CardFont);
        JLabel coinFirst1 = new JLabel(First[FirstLevelCards.CounterFirst1].CardFirst);
        coinFirst1.setFont(defaultFont4);
        coinFirst1.setHorizontalAlignment(JLabel.CENTER);


        marksFirst1.add (coinFirst1 , BorderLayout.SOUTH);
        marksFirst1.add (scoreFirst1 , BorderLayout.NORTH);
        FirstLevel1.add(marksFirst1);
        RightPanel.add(FirstLevel1,gbc);

        FirstLevel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinFirst1 = 0;
                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] &&
                                Player1.RedCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - Player1.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] &&
                                Player1.BlueCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - Player1.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - Player1.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] &&
                                Player1.GreenCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - Player1.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] &&
                                Player1.BlackCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinFirst1 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0) {
                            if ((Player1.RedCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) >= 0) {
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0) {
                            if ((Player1.BlueCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) >= 0) {
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0) {
                            if ((Player1.WhiteCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) >= 0) {
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0) {
                            if ((Player1.GreenCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) >= 0) {
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0) {
                            if ((Player1.BlackCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) >= 0) {
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst1].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel1.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst1 = new JLabel(First[FirstLevelCards.CounterFirst1].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
                            scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst1.setFont(CardFont);
                            JLabel coinFirst1 = new JLabel(First[FirstLevelCards.CounterFirst1].CardFirst);
                            coinFirst1.setFont(defaultFont4);

                            marksFirst1.add(coinFirst1, BorderLayout.SOUTH);
                            marksFirst1.add(scoreFirst1, BorderLayout.NORTH);
                            FirstLevel1.add(marksFirst1);
                            RightPanel.add(FirstLevel1,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst1 = 0;
                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] &&
                                Player2.RedCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]){
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - Player2.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] &&
                                Player2.BlueCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]){
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - Player2.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]){
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - Player2.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] &&
                                Player2.GreenCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]){
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - Player2.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] &&
                                Player2.BlackCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]){
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinFirst1>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0){
                            if ((Player2.RedCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] ) >= 0) {
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0){
                            if ((Player2.BlueCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] ) >= 0) {
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0){
                            if ((Player2.WhiteCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] ) >= 0) {
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0){
                            if ((Player2.GreenCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] ) >= 0) {
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0){
                            if ((Player2.BlackCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] ) >= 0) {
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst1].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel1.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst1 = new JLabel(First[FirstLevelCards.CounterFirst1].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
                            scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst1.setFont(CardFont);
                            JLabel coinFirst1 = new JLabel(First[FirstLevelCards.CounterFirst1].CardFirst);
                            coinFirst1.setFont(defaultFont4);

                            marksFirst1.add(coinFirst1, BorderLayout.SOUTH);
                            marksFirst1.add(scoreFirst1, BorderLayout.NORTH);
                            FirstLevel1.add(marksFirst1);
                            RightPanel.add(FirstLevel1, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        JButton FirstLevel2 = new JButton(card1);
        gbc.gridx = 1;
        gbc.gridy = 2;
        FirstLevel2.setPreferredSize(new Dimension(130,130));
        FirstLevel2.setBackground(Color.WHITE);

        JPanel marksFirst2 = new JPanel(new BorderLayout());
        marksFirst2.setOpaque(false);

        FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
        First [FirstLevelCards.CountFirst] = new FirstLevelCards() ;

        JLabel scoreFirst2 = new JLabel(First[FirstLevelCards.CounterFirst3].ScoreFirst+"                  "+
                First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
        scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
        scoreFirst2.setFont(CardFont);
        JLabel coinFirst2 = new JLabel(First[FirstLevelCards.CounterFirst3].CardFirst);
        coinFirst2.setFont(defaultFont4);
        coinFirst2.setHorizontalAlignment(JLabel.CENTER);


        marksFirst2.add (coinFirst2 , BorderLayout.SOUTH);
        marksFirst2.add (scoreFirst2 , BorderLayout.NORTH);
        FirstLevel2.add(marksFirst2);
        RightPanel.add(FirstLevel2,gbc);

        FirstLevel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinFirst2 = 0;
                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] &&
                                Player1.RedCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - Player1.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] &&
                                Player1.BlueCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - Player1.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - Player1.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] &&
                                Player1.GreenCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - Player1.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] &&
                                Player1.BlackCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinFirst2 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0) {
                            if ((Player1.RedCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) >= 0) {
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0) {
                            if ((Player1.BlueCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) >= 0) {
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0) {
                            if ((Player1.WhiteCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) >= 0) {
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0) {
                            if ((Player1.GreenCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) >= 0) {
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0) {
                            if ((Player1.BlackCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) >= 0) {
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst2].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel2.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst2 = new JLabel(First[FirstLevelCards.CounterFirst2].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
                            scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst2.setFont(CardFont);
                            JLabel coinFirst2 = new JLabel(First[FirstLevelCards.CounterFirst2].CardFirst);
                            coinFirst2.setFont(defaultFont4);

                            marksFirst2.add(coinFirst2, BorderLayout.SOUTH);
                            marksFirst2.add(scoreFirst2, BorderLayout.NORTH);
                            FirstLevel2.add(marksFirst2);
                            RightPanel.add(FirstLevel2,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst2 = 0;
                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] &&
                                Player2.RedCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]){
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - Player2.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] &&
                                Player2.BlueCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]){
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - Player2.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]){
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - Player2.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] &&
                                Player2.GreenCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]){
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - Player2.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] &&
                                Player2.BlackCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]){
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - Player2.BlackCoin);
                        }
                    }

                    if (!sw || CountGoldCoinFirst2 > Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0){
                            if ((Player2.RedCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] ) >= 0) {
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0){
                            if ((Player2.BlueCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] ) >= 0) {
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0){
                            if ((Player2.WhiteCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] ) >= 0) {
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0){
                            if ((Player2.GreenCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] ) >= 0) {
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0){
                            if ((Player2.BlackCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] ) >= 0) {
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst2].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel2.setEnabled(false);

                        }
                        else {
                            FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst2 = new JLabel(First[FirstLevelCards.CounterFirst2].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
                            scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst2.setFont(CardFont);
                            JLabel coinFirst2 = new JLabel(First[FirstLevelCards.CounterFirst2].CardFirst);
                            coinFirst2.setFont(defaultFont4);

                            marksFirst2.add(coinFirst2, BorderLayout.SOUTH);
                            marksFirst2.add(scoreFirst2, BorderLayout.NORTH);
                            FirstLevel2.add(marksFirst2);
                            RightPanel.add(FirstLevel2, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        JButton FirstLevel3 = new JButton(card1);
        gbc.gridx = 2;
        gbc.gridy = 2;
        FirstLevel3.setPreferredSize(new Dimension(130,130));
        FirstLevel3.setBackground(Color.WHITE);


        JPanel marksFirst3 = new JPanel(new BorderLayout());
        marksFirst3.setOpaque(false);

        FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
        First [FirstLevelCards.CountFirst] = new FirstLevelCards() ;

        JLabel scoreFirst3 = new JLabel(First[FirstLevelCards.CounterFirst3].ScoreFirst+"                  "+
                First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
        scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
        scoreFirst3.setFont(CardFont);
        JLabel coinFirst3 = new JLabel(First[FirstLevelCards.CounterFirst3].CardFirst);
        coinFirst3.setFont(defaultFont4);
        coinFirst3.setHorizontalAlignment(JLabel.CENTER);


        marksFirst3.add (coinFirst3 , BorderLayout.SOUTH);
        marksFirst3.add (scoreFirst3 , BorderLayout.NORTH);
        FirstLevel3.add(marksFirst3);
        RightPanel.add(FirstLevel3,gbc);

        FirstLevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinFirst3 = 0;
                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] &&
                                Player1.RedCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - Player1.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] &&
                                Player1.BlueCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - Player1.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - Player1.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] &&
                                Player1.GreenCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - Player1.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] &&
                                Player1.BlackCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinFirst3 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0) {
                            if ((Player1.RedCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) >= 0) {
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0) {
                            if ((Player1.BlueCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) >= 0) {
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0) {
                            if ((Player1.WhiteCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) >= 0) {
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0) {
                            if ((Player1.GreenCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) >= 0) {
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0) {
                            if ((Player1.BlackCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) >= 0) {
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst3].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel3.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst3 = new JLabel(First[FirstLevelCards.CounterFirst3].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
                            scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst3.setFont(CardFont);
                            JLabel coinFirst3 = new JLabel(First[FirstLevelCards.CounterFirst3].CardFirst);
                            coinFirst3.setFont(defaultFont4);

                            marksFirst3.add(coinFirst3, BorderLayout.SOUTH);
                            marksFirst3.add(scoreFirst3, BorderLayout.NORTH);
                            FirstLevel3.add(marksFirst3);
                            RightPanel.add(FirstLevel3,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst3 = 0;
                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] &&
                                Player2.RedCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]){
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - Player2.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] &&
                                Player2.BlueCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]){
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - Player2.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]){
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - Player2.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] &&
                                Player2.GreenCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]){
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - Player2.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] &&
                                Player2.BlackCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]){
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - Player2.BlackCoin);
                        }
                    }

                    if (!sw || CountGoldCoinFirst3>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0){
                            if ((Player2.RedCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] ) >= 0) {
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0){
                            if ((Player2.BlueCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] ) >= 0) {
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0){
                            if ((Player2.WhiteCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ) >= 0) {
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0){
                            if ((Player2.GreenCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ) >= 0) {
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0){
                            if ((Player2.BlackCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] ) >= 0) {
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst3].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel3.setEnabled(false);

                        }
                        else {
                            FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst3 = new JLabel(First[FirstLevelCards.CounterFirst3].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
                            scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst3.setFont(CardFont);
                            JLabel coinFirst3 = new JLabel(First[FirstLevelCards.CounterFirst3].CardFirst);
                            coinFirst3.setFont(defaultFont4);

                            marksFirst3.add(coinFirst3, BorderLayout.SOUTH);
                            marksFirst3.add(scoreFirst3, BorderLayout.NORTH);
                            FirstLevel3.add(marksFirst3);
                            RightPanel.add(FirstLevel3, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton FirstLevel4 = new JButton(card1);
        gbc.gridx = 3;
        gbc.gridy = 2;
        FirstLevel4.setPreferredSize(new Dimension(130,130));
        FirstLevel4.setBackground(Color.WHITE);



        JPanel marksFirst4 = new JPanel(new BorderLayout());
        marksFirst4.setOpaque(false);

        FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
        First [FirstLevelCards.CountFirst] = new FirstLevelCards() ;

        JLabel scoreFirst4 = new JLabel(First[FirstLevelCards.CounterFirst4].ScoreFirst+"                  "+
                First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
        scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
        scoreFirst4.setFont(CardFont);
        JLabel coinFirst4 = new JLabel(First[FirstLevelCards.CounterFirst4].CardFirst);
        coinFirst4.setFont(defaultFont4);
        coinFirst4.setHorizontalAlignment(JLabel.CENTER);


        marksFirst4.add (coinFirst4 , BorderLayout.SOUTH);
        marksFirst4.add (scoreFirst4 , BorderLayout.NORTH);
        FirstLevel4.add(marksFirst4);
        RightPanel.add(FirstLevel4,gbc);

        FirstLevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinFirst4 = 0;
                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] &&
                                Player1.RedCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - Player1.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] &&
                                Player1.BlueCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - Player1.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - Player1.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] &&
                                Player1.GreenCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - Player1.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] &&
                                Player1.BlackCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinFirst4 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0) {
                            if ((Player1.RedCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) >= 0) {
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0) {
                            if ((Player1.BlueCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) >= 0) {
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0) {
                            if ((Player1.WhiteCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) >= 0) {
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0) {
                            if ((Player1.GreenCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) >= 0) {
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0) {
                            if ((Player1.BlackCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) >= 0) {
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                            } else {
                                Player1.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst4].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel4.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst4 = new JLabel(First[FirstLevelCards.CounterFirst4].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
                            scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst4.setFont(CardFont);
                            JLabel coinFirst4 = new JLabel(First[FirstLevelCards.CounterFirst4].CardFirst);
                            coinFirst4.setFont(defaultFont4);

                            marksFirst4.add(coinFirst4, BorderLayout.SOUTH);
                            marksFirst4.add(scoreFirst4, BorderLayout.NORTH);
                            FirstLevel4.add(marksFirst4);
                            RightPanel.add(FirstLevel4,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst4 = 0;
                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] &&
                                Player2.RedCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]){
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - Player2.RedCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] &&
                                Player2.BlueCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]){
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - Player2.BlueCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]){
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - Player2.WhiteCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] &&
                                Player2.GreenCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]){
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - Player2.GreenCoin);
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] &&
                                Player2.BlackCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]){
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - Player2.BlackCoin);
                        }
                    }

                    if (!sw || CountGoldCoinFirst4>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0){
                            if ((Player2.RedCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] ) >= 0) {
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0){
                            if ((Player2.BlueCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] ) >= 0) {
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0){
                            if ((Player2.WhiteCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ) >= 0) {
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2];
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0){
                            if ((Player2.GreenCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ) >= 0) {
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3];
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0){
                            if ((Player2.BlackCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] ) >= 0) {
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst4].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel4.setEnabled(false);

                        }
                        else {
                            FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            JLabel scoreFirst4 = new JLabel(First[FirstLevelCards.CounterFirst4].ScoreFirst + "    " +
                                    First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
                            scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst4.setFont(CardFont);
                            JLabel coinFirst4 = new JLabel(First[FirstLevelCards.CounterFirst4].CardFirst);
                            coinFirst4.setFont(defaultFont4);

                            marksFirst4.add(coinFirst4, BorderLayout.SOUTH);
                            marksFirst4.add(scoreFirst4, BorderLayout.NORTH);
                            FirstLevel4.add(marksFirst4);
                            RightPanel.add(FirstLevel4, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton SecondLevel1 = new JButton(card2);
        gbc.gridx = 0;
        gbc.gridy = 3;
        SecondLevel1.setPreferredSize(new Dimension(130,130));
        SecondLevel1.setBackground(Color.WHITE);


        JPanel marksSecond1 = new JPanel(new BorderLayout());
        marksSecond1.setOpaque(false);

        SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
        Second [SecondLevelCards.CountSecond] = new SecondLevelCards() ;

        JLabel scoreSecond1 = new JLabel(Second[SecondLevelCards.CounterSecond1].ScoreSecond+"                  "+
                Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
        scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
        scoreSecond1.setFont(CardFont);
        JLabel coinSecond1 = new JLabel(Second[SecondLevelCards.CounterSecond1].CardSecond);
        coinSecond1.setFont(defaultFont4);
        coinSecond1.setHorizontalAlignment(JLabel.CENTER);


        marksSecond1.add (coinSecond1 , BorderLayout.SOUTH);
        marksSecond1.add (scoreSecond1 , BorderLayout.NORTH);
        SecondLevel1.add(marksSecond1);
        RightPanel.add(SecondLevel1,gbc);

        SecondLevel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinSecond1 = 0;
                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] &&
                                Player1.RedCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - Player1.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] &&
                                Player1.BlueCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - Player1.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] &&
                                Player1.GreenCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - Player1.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] &&
                                Player1.BlackCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinSecond1 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second [SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0) {
                            if ((Player1.RedCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) >= 0) {
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0) {
                            if ((Player1.BlueCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) >= 0) {
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0) {
                            if ((Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) >= 0) {
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0) {
                            if ((Player1.GreenCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) >= 0) {
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0) {
                            if ((Player1.BlackCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) >= 0) {
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond1].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            JLabel scoreSecond1 = new JLabel(Second[SecondLevelCards.CounterSecond1].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
                            scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond1.setFont(CardFont);
                            JLabel coinSecond1 = new JLabel(Second[SecondLevelCards.CounterSecond1].CardSecond);
                            coinSecond1.setFont(defaultFont4);

                            marksSecond1.add(coinSecond1, BorderLayout.SOUTH);
                            marksSecond1.add(scoreSecond1, BorderLayout.NORTH);
                            SecondLevel1.add(marksSecond1);
                            RightPanel.add(SecondLevel1,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond1 = 0;
                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] &&
                                Player2.RedCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]){
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - Player2.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] &&
                                Player2.BlueCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]){
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - Player2.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]){
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] &&
                                Player2.GreenCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]){
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - Player2.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] &&
                                Player2.BlackCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]){
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinSecond1>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0){
                            if ((Player2.RedCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] ) >= 0) {
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0){
                            if ((Player2.BlueCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] ) >= 0) {
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0){
                            if ((Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ) >= 0) {
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0){
                            if ((Player2.GreenCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ) >= 0) {
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0){
                            if ((Player2.BlackCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] ) >= 0) {
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond1].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            JLabel scoreSecond1 = new JLabel(Second[SecondLevelCards.CounterSecond1].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
                            scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond1.setFont(CardFont);
                            JLabel coinSecond1 = new JLabel(Second[SecondLevelCards.CounterSecond1].CardSecond);
                            coinSecond1.setFont(defaultFont4);

                            marksSecond1.add(coinSecond1, BorderLayout.SOUTH);
                            marksSecond1.add(scoreSecond1, BorderLayout.NORTH);
                            SecondLevel1.add(marksSecond1);
                            RightPanel.add(SecondLevel1, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton SecondLevel2 = new JButton(card2);
        gbc.gridx = 1;
        gbc.gridy = 3;
        SecondLevel2.setPreferredSize(new Dimension(130,130));
        SecondLevel2.setBackground(Color.WHITE);


        JPanel marksSecond2 = new JPanel(new BorderLayout());
        marksSecond2.setOpaque(false);

        SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
        Second [SecondLevelCards.CountSecond] = new SecondLevelCards() ;

        JLabel scoreSecond2 = new JLabel(Second[SecondLevelCards.CounterSecond2].ScoreSecond+"                  "+
                Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
        scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
        scoreSecond2.setFont(CardFont);
        JLabel coinSecond2 = new JLabel(Second[SecondLevelCards.CounterSecond2].CardSecond);
        coinSecond2.setFont(defaultFont4);
        coinSecond2.setHorizontalAlignment(JLabel.CENTER);


        marksSecond2.add (coinSecond2 , BorderLayout.SOUTH);
        marksSecond2.add (scoreSecond2 , BorderLayout.NORTH);
        SecondLevel2.add(marksSecond2);
        RightPanel.add(SecondLevel2,gbc);


        SecondLevel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinSecond2 = 0;
                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] &&
                                Player1.RedCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - Player1.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] &&
                                Player1.BlueCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - Player1.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] &&
                                Player1.GreenCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - Player1.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] &&
                                Player1.BlackCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinSecond2 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second [SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0) {
                            if ((Player1.RedCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) >= 0) {
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0) {
                            if ((Player1.BlueCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) >= 0) {
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0) {
                            if ((Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) >= 0) {
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0) {
                            if ((Player1.GreenCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) >= 0) {
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0) {
                            if ((Player1.BlackCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) >= 0) {
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond2].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel2 . setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            JLabel scoreSecond2 = new JLabel(Second[SecondLevelCards.CounterSecond2].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
                            scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond2.setFont(CardFont);
                            JLabel coinSecond2 = new JLabel(Second[SecondLevelCards.CounterSecond2].CardSecond);
                            coinSecond2.setFont(defaultFont4);

                            marksSecond2.add(coinSecond2, BorderLayout.SOUTH);
                            marksSecond2.add(scoreSecond2, BorderLayout.NORTH);
                            SecondLevel2.add(marksSecond2);
                            RightPanel.add(SecondLevel2,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond2 = 0;
                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] &&
                                Player2.RedCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]){
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - Player2.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] &&
                                Player2.BlueCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]){
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - Player2.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]){
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] &&
                                Player2.GreenCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]){
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - Player2.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] &&
                                Player2.BlackCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]){
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinSecond2>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0){
                            if ((Player2.RedCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] ) >= 0) {
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0){
                            if ((Player2.BlueCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] ) >= 0) {
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0){
                            if ((Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ) >= 0) {
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0){
                            if ((Player2.GreenCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ) >= 0) {
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0){
                            if ((Player2.BlackCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] ) >= 0) {
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond2].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel2.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            JLabel scoreSecond2 = new JLabel(Second[SecondLevelCards.CounterSecond2].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
                            scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond2.setFont(CardFont);
                            JLabel coinSecond2 = new JLabel(Second[SecondLevelCards.CounterSecond2].CardSecond);
                            coinSecond2.setFont(defaultFont4);

                            marksSecond2.add(coinSecond2, BorderLayout.SOUTH);
                            marksSecond2.add(scoreSecond2, BorderLayout.NORTH);
                            SecondLevel2.add(marksSecond2);
                            RightPanel.add(SecondLevel2, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton SecondLevel3 = new JButton(card2);
        gbc.gridx = 2;
        gbc.gridy = 3;
        SecondLevel3.setPreferredSize(new Dimension(130,130));
        SecondLevel3.setBackground(Color.WHITE);


        JPanel marksSecond3 = new JPanel(new BorderLayout());
        marksSecond3.setOpaque(false);

        SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
        Second [SecondLevelCards.CountSecond] = new SecondLevelCards() ;

        JLabel scoreSecond3 = new JLabel(Second[SecondLevelCards.CounterSecond3].ScoreSecond+"                  "+
                Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
        scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
        scoreSecond3.setFont(CardFont);
        JLabel coinSecond3 = new JLabel(Second[SecondLevelCards.CounterSecond3].CardSecond);
        coinSecond3.setFont(defaultFont4);
        coinSecond3.setHorizontalAlignment(JLabel.CENTER);


        marksSecond3.add (coinSecond3 , BorderLayout.SOUTH);
        marksSecond3.add (scoreSecond3 , BorderLayout.NORTH);
        SecondLevel3.add(marksSecond3);
        RightPanel.add(SecondLevel3,gbc);

        SecondLevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinSecond3 = 0;
                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] &&
                                Player1.RedCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - Player1.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] &&
                                Player1.BlueCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - Player1.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] &&
                                Player1.GreenCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - Player1.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] &&
                                Player1.BlackCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinSecond3 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second [SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0) {
                            if ((Player1.RedCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) >= 0) {
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0) {
                            if ((Player1.BlueCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) >= 0) {
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0) {
                            if ((Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) >= 0) {
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0) {
                            if ((Player1.GreenCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) >= 0) {
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0) {
                            if ((Player1.BlackCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) >= 0) {
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond3].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel3 . setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            JLabel scoreSecond3 = new JLabel(Second[SecondLevelCards.CounterSecond3].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
                            scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond3.setFont(CardFont);
                            JLabel coinSecond3 = new JLabel(Second[SecondLevelCards.CounterSecond3].CardSecond);
                            coinSecond3.setFont(defaultFont4);

                            marksSecond3 .add(coinSecond3, BorderLayout.SOUTH);
                            marksSecond3.add(scoreSecond3, BorderLayout.NORTH);
                            SecondLevel3.add(marksSecond3);
                            RightPanel.add(SecondLevel3,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond3 = 0;
                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] &&
                                Player2.RedCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]){
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - Player2.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] &&
                                Player2.BlueCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]){
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - Player2.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]){
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] &&
                                Player2.GreenCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]){
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - Player2.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] &&
                                Player2.BlackCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]){
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinSecond3>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0){
                            if ((Player2.RedCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] ) >= 0) {
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0){
                            if ((Player2.BlueCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] ) >= 0) {
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0){
                            if ((Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ) >= 0) {
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0){
                            if ((Player2.GreenCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ) >= 0) {
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0){
                            if ((Player2.BlackCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] ) >= 0) {
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond3].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel3.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            JLabel scoreSecond3 = new JLabel(Second[SecondLevelCards.CounterSecond3].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
                            scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond3.setFont(CardFont);
                            JLabel coinSecond3 = new JLabel(Second[SecondLevelCards.CounterSecond3].CardSecond);
                            coinSecond3.setFont(defaultFont4);

                            marksSecond3.add(coinSecond3, BorderLayout.SOUTH);
                            marksSecond3.add(scoreSecond3, BorderLayout.NORTH);
                            SecondLevel3.add(marksSecond3);
                            RightPanel.add(SecondLevel3, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton SecondLevel4 = new JButton(card2);
        gbc.gridx = 3;
        gbc.gridy = 3;
        SecondLevel4.setPreferredSize(new Dimension(130,130));
        SecondLevel4.setBackground(Color.WHITE);

        JPanel marksSecond4 = new JPanel(new BorderLayout());
        marksSecond4.setOpaque(false);

        SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
        Second [SecondLevelCards.CountSecond] = new SecondLevelCards() ;

        JLabel scoreSecond4 = new JLabel(Second[SecondLevelCards.CounterSecond4].ScoreSecond+"                  "+
                Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
        scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
        scoreSecond4.setFont(CardFont);
        JLabel coinSecond4 = new JLabel(Second[SecondLevelCards.CounterSecond4].CardSecond);
        coinSecond4.setFont(defaultFont4);
        coinSecond4.setHorizontalAlignment(JLabel.CENTER);


        marksSecond4.add (coinSecond4 , BorderLayout.SOUTH);
        marksSecond4.add (scoreSecond4 , BorderLayout.NORTH);
        SecondLevel4.add(marksSecond4);
        RightPanel.add(SecondLevel4,gbc);

        SecondLevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinSecond4 = 0;
                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] &&
                                Player1.RedCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - Player1.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] &&
                                Player1.BlueCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - Player1.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] &&
                                Player1.GreenCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - Player1.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] &&
                                Player1.BlackCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinSecond4 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second [SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0) {
                            if ((Player1.RedCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) >= 0) {
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0) {
                            if ((Player1.BlueCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) >= 0) {
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0) {
                            if ((Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) >= 0) {
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0) {
                            if ((Player1.GreenCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) >= 0) {
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0) {
                            if ((Player1.BlackCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) >= 0) {
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond4].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel4.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            JLabel scoreSecond4 = new JLabel(Second[SecondLevelCards.CounterSecond4].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
                            scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond4.setFont(CardFont);
                            JLabel coinSecond4 = new JLabel(Second[SecondLevelCards.CounterSecond4].CardSecond);
                            coinSecond4.setFont(defaultFont4);

                            marksSecond4.add(coinSecond4, BorderLayout.SOUTH);
                            marksSecond4.add(scoreSecond4, BorderLayout.NORTH);
                            SecondLevel4.add(marksSecond4);
                            RightPanel.add(SecondLevel4,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond4 = 0;
                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] &&
                                Player2.RedCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]){
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - Player2.RedCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] &&
                                Player2.BlueCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]){
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - Player2.BlueCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]){
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] &&
                                Player2.GreenCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]){
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - Player2.GreenCoin);
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] &&
                                Player2.BlackCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]){
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinSecond4>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0){
                            if ((Player2.RedCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] ) >= 0) {
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0){
                            if ((Player2.BlueCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] ) >= 0) {
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0){
                            if ((Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ) >= 0) {
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2];
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0){
                            if ((Player2.GreenCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ) >= 0) {
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3];
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0){
                            if ((Player2.BlackCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] ) >= 0) {
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond4].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel4.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            JLabel scoreSecond4 = new JLabel(Second[SecondLevelCards.CounterSecond4].ScoreSecond + "    " +
                                    Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
                            scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond4.setFont(CardFont);
                            JLabel coinSecond4 = new JLabel(Second[SecondLevelCards.CounterSecond4].CardSecond);
                            coinSecond4.setFont(defaultFont4);

                            marksSecond4.add(coinSecond4, BorderLayout.SOUTH);
                            marksSecond4.add(scoreSecond4, BorderLayout.NORTH);
                            SecondLevel4.add(marksSecond4);
                            RightPanel.add(SecondLevel4, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton ThirdLevel1 = new JButton(card3);
        gbc.gridx = 0;
        gbc.gridy = 4;
        ThirdLevel1.setPreferredSize(new Dimension(130,130));
        ThirdLevel1.setBackground(Color.WHITE);

        JPanel marksThird1 = new JPanel(new BorderLayout());
        marksThird1.setOpaque(false);

        ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
        Third [ThirdLevelCards.CountThird] = new ThirdLevelCards() ;

        JLabel scoreThird1 = new JLabel(Third[ThirdLevelCards.CounterThird1].ScoreThird+"                  "+
                Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
        scoreThird1.setHorizontalAlignment(JLabel.CENTER);
        scoreThird1.setFont(CardFont);
        JLabel coinThird1 = new JLabel(Third[ThirdLevelCards.CounterThird1].CardThird);
        coinThird1.setFont(defaultFont4);
        coinThird1.setHorizontalAlignment(JLabel.CENTER);


        marksThird1.add (coinThird1 , BorderLayout.SOUTH);
        marksThird1.add (scoreThird1 , BorderLayout.NORTH);
        ThirdLevel1.add(marksThird1);
        RightPanel.add(ThirdLevel1,gbc);


        ThirdLevel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinThird1 = 0;
                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] &&
                                Player1.RedCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - Player1.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] &&
                                Player1.BlueCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - Player1.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] &&
                                Player1.WhiteCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] &&
                                Player1.GreenCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - Player1.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] &&
                                Player1.BlackCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinThird1 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third [ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0) {
                            if ((Player1.RedCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) >= 0) {
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0) {
                            if ((Player1.BlueCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) >= 0) {
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0) {
                            if ((Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) >= 0) {
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0) {
                            if ((Player1.GreenCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) >= 0) {
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0) {
                            if ((Player1.BlackCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) >= 0) {
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird1].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            JLabel scoreThird1 = new JLabel(Third[ThirdLevelCards.CounterThird1].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
                            scoreThird1.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird1.setFont(CardFont);
                            JLabel coinThird1 = new JLabel(Third[ThirdLevelCards.CounterThird1].CardThird);
                            coinThird1.setFont(defaultFont4);

                            marksThird1.add(coinThird1, BorderLayout.SOUTH);
                            marksThird1.add(scoreThird1, BorderLayout.NORTH);
                            ThirdLevel1.add(marksThird1);
                            RightPanel.add(ThirdLevel1,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird1 = 0;
                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] &&
                                Player2.RedCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]){
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - Player2.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] &&
                                Player2.BlueCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]){
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - Player2.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] &&
                                Player2.WhiteCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]){
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] &&
                                Player2.GreenCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]){
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - Player2.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] &&
                                Player2.BlackCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]){
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinThird1>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0){
                            if ((Player2.RedCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] ) >= 0) {
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0){
                            if ((Player2.BlueCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] ) >= 0) {
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0){
                            if ((Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ) >= 0) {
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0){
                            if ((Player2.GreenCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ) >= 0) {
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0){
                            if ((Player2.BlackCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] ) >= 0) {
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird1].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            JLabel scoreThird1 = new JLabel(Third[ThirdLevelCards.CounterThird1].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
                            scoreThird1.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird1.setFont(CardFont);
                            JLabel coinThird1 = new JLabel(Third[ThirdLevelCards.CounterThird1].CardThird);
                            coinThird1.setFont(defaultFont4);

                            marksThird1.add(coinThird1, BorderLayout.SOUTH);
                            marksThird1.add(scoreThird1, BorderLayout.NORTH);
                            ThirdLevel1.add(marksThird1);
                            RightPanel.add(ThirdLevel1, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton ThirdLevel2 = new JButton(card3);
        gbc.gridx = 1;
        gbc.gridy = 4;
        ThirdLevel2.setPreferredSize(new Dimension(130,130));
        ThirdLevel2.setBackground(Color.WHITE);


        JPanel marksThird2 = new JPanel(new BorderLayout());
        marksThird2.setOpaque(false);

        ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
        Third [ThirdLevelCards.CountThird] = new ThirdLevelCards() ;

        JLabel scoreThird2 = new JLabel(Third[ThirdLevelCards.CounterThird2].ScoreThird+"                  "+
                Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
        scoreThird2.setHorizontalAlignment(JLabel.CENTER);
        scoreThird2.setFont(CardFont);
        JLabel coinThird2 = new JLabel(Third[ThirdLevelCards.CounterThird2].CardThird);
        coinThird2.setFont(defaultFont4);
        coinThird2.setHorizontalAlignment(JLabel.CENTER);


        marksThird2.add (coinThird2 , BorderLayout.SOUTH);
        marksThird2.add (scoreThird2 , BorderLayout.NORTH);
        ThirdLevel2.add(marksThird2);
        RightPanel.add(ThirdLevel2,gbc);

        ThirdLevel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinThird2 = 0;
                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] &&
                                Player1.RedCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - Player1.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] &&
                                Player1.BlueCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - Player1.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] &&
                                Player1.WhiteCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] &&
                                Player1.GreenCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - Player1.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] &&
                                Player1.BlackCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinThird2 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third [ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0) {
                            if ((Player1.RedCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) >= 0) {
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0) {
                            if ((Player1.BlueCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) >= 0) {
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0) {
                            if ((Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) >= 0) {
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0) {
                            if ((Player1.GreenCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) >= 0) {
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0) {
                            if ((Player1.BlackCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) >= 0) {
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird2].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel2 . setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            JLabel scoreThird2 = new JLabel(Third[ThirdLevelCards.CounterThird2].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
                            scoreThird2.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird2.setFont(CardFont);
                            JLabel coinThird2 = new JLabel(Third[ThirdLevelCards.CounterThird2].CardThird);
                            coinThird2.setFont(defaultFont4);

                            marksThird2.add(coinThird2, BorderLayout.SOUTH);
                            marksThird2.add(scoreThird2, BorderLayout.NORTH);
                            ThirdLevel2.add(marksThird2);
                            RightPanel.add(ThirdLevel2,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird2 = 0;
                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] &&
                                Player2.RedCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]){
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - Player2.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] &&
                                Player2.BlueCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]){
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - Player2.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] &&
                                Player2.WhiteCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]){
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] &&
                                Player2.GreenCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]){
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - Player2.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] &&
                                Player2.BlackCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]){
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinThird2>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0){
                            if ((Player2.RedCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] ) >= 0) {
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0){
                            if ((Player2.BlueCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] ) >= 0) {
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0){
                            if ((Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ) >= 0) {
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0){
                            if ((Player2.GreenCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ) >= 0) {
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0){
                            if ((Player2.BlackCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] ) >= 0) {
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird2].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel2.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            JLabel scoreThird2 = new JLabel(Third[ThirdLevelCards.CounterThird2].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
                            scoreThird2.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird2.setFont(CardFont);
                            JLabel coinThird2 = new JLabel(Third[ThirdLevelCards.CounterThird2].CardThird);
                            coinThird2.setFont(defaultFont4);

                            marksThird2.add(coinThird2, BorderLayout.SOUTH);
                            marksThird2.add(scoreThird2, BorderLayout.NORTH);
                            ThirdLevel2.add(marksThird2);
                            RightPanel.add(ThirdLevel2, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        JButton ThirdLevel3 = new JButton(card3);
        gbc.gridx = 2;
        gbc.gridy = 4;
        ThirdLevel3.setPreferredSize(new Dimension(130,130));
        ThirdLevel3.setBackground(Color.WHITE);

        JPanel marksThird3 = new JPanel(new BorderLayout());
        marksThird3.setOpaque(false);

        ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
        Third [ThirdLevelCards.CountThird] = new ThirdLevelCards() ;

        JLabel scoreThird3 = new JLabel(Third[ThirdLevelCards.CounterThird3].ScoreThird+"                  "+
                Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
        scoreThird3.setHorizontalAlignment(JLabel.CENTER);
        scoreThird3.setFont(CardFont);
        JLabel coinThird3 = new JLabel(Third[ThirdLevelCards.CounterThird3].CardThird);
        coinThird3.setFont(defaultFont4);
        coinThird3.setHorizontalAlignment(JLabel.CENTER);


        marksThird3.add (coinThird3 , BorderLayout.SOUTH);
        marksThird3.add (scoreThird3 , BorderLayout.NORTH);
        ThirdLevel3.add(marksThird3);
        RightPanel.add(ThirdLevel3,gbc);


        ThirdLevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinThird3 = 0;
                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] &&
                                Player1.RedCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - Player1.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] &&
                                Player1.BlueCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - Player1.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] &&
                                Player1.WhiteCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] &&
                                Player1.GreenCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - Player1.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] &&
                                Player1.BlackCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinThird3 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third [ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0) {
                            if ((Player1.RedCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) >= 0) {
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0) {
                            if ((Player1.BlueCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) >= 0) {
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0) {
                            if ((Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) >= 0) {
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0) {
                            if ((Player1.GreenCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) >= 0) {
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0) {
                            if ((Player1.BlackCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) >= 0) {
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird3].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel3 . setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            JLabel scoreThird3 = new JLabel(Third[ThirdLevelCards.CounterThird3].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
                            scoreThird3.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird3.setFont(CardFont);
                            JLabel coinThird3 = new JLabel(Third[ThirdLevelCards.CounterThird3].CardThird);
                            coinThird3.setFont(defaultFont4);

                            marksThird3 .add(coinThird3, BorderLayout.SOUTH);
                            marksThird3.add(scoreThird3, BorderLayout.NORTH);
                            ThirdLevel3.add(marksThird3);
                            RightPanel.add(ThirdLevel3,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird3 = 0;
                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] &&
                                Player2.RedCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]){
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - Player2.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] &&
                                Player2.BlueCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]){
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - Player2.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] &&
                                Player2.WhiteCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]){
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] &&
                                Player2.GreenCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]){
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - Player2.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] &&
                                Player2.BlackCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]){
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinThird3>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0){
                            if ((Player2.RedCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] ) >= 0) {
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0){
                            if ((Player2.BlueCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] ) >= 0) {
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0){
                            if ((Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ) >= 0) {
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0){
                            if ((Player2.GreenCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ) >= 0) {
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0){
                            if ((Player2.BlackCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] ) >= 0) {
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird3].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel3.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            JLabel scoreThird3 = new JLabel(Third[ThirdLevelCards.CounterThird3].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
                            scoreThird3.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird3.setFont(CardFont);
                            JLabel coinThird3 = new JLabel(Third[ThirdLevelCards.CounterThird3].CardThird);
                            coinThird3.setFont(defaultFont4);

                            marksThird3.add(coinThird3, BorderLayout.SOUTH);
                            marksThird3.add(scoreThird3, BorderLayout.NORTH);
                            ThirdLevel3.add(marksThird3);
                            RightPanel.add(ThirdLevel3, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });


        JButton ThirdLevel4 = new JButton(card3);
        gbc.gridx = 3;
        gbc.gridy = 4;
        ThirdLevel4.setPreferredSize(new Dimension(130,130));
        ThirdLevel4.setBackground(Color.WHITE);

        JPanel marksThird4 = new JPanel(new BorderLayout());
        marksThird4.setOpaque(false);

        ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
        Third [ThirdLevelCards.CountThird] = new ThirdLevelCards() ;

        JLabel scoreThird4 = new JLabel(Third[ThirdLevelCards.CounterThird4].ScoreThird+"                  "+
                Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
        scoreThird4.setHorizontalAlignment(JLabel.CENTER);
        scoreThird4.setFont(CardFont);
        JLabel coinThird4 = new JLabel(Third[ThirdLevelCards.CounterThird4].CardThird);
        coinThird4.setFont(defaultFont4);
        coinThird4.setHorizontalAlignment(JLabel.CENTER);


        marksThird4.add (coinThird4 , BorderLayout.SOUTH);
        marksThird4.add (scoreThird4 , BorderLayout.NORTH);
        ThirdLevel4.add(marksThird4);
        RightPanel.add(ThirdLevel4,gbc);

        ThirdLevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinThird4 = 0;
                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] &&
                                Player1.RedCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - Player1.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] &&
                                Player1.BlueCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - Player1.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] &&
                                Player1.WhiteCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - Player1.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] &&
                                Player1.GreenCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - Player1.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] &&
                                Player1.BlackCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - Player1.BlackCoin);
                        }
                    }


                    if (!sw || CountGoldCoinThird4 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third [ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0) {
                            if ((Player1.RedCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) >= 0) {
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - Player1.RedCoin);
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0) {
                            if ((Player1.BlueCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) >= 0) {
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - Player1.BlueCoin);
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0) {
                            if ((Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) >= 0) {
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - Player1.WhiteCoin);
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0) {
                            if ((Player1.GreenCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) >= 0) {
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - Player1.GreenCoin);
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0) {
                            if ((Player1.BlackCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) >= 0) {
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                            } else {
                                Player1.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - Player1.BlackCoin);
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird4].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel4.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            JLabel scoreThird4 = new JLabel(Third[ThirdLevelCards.CounterThird4].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
                            scoreThird4.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird4.setFont(CardFont);
                            JLabel coinThird4 = new JLabel(Third[ThirdLevelCards.CounterThird4].CardThird);
                            coinThird4.setFont(defaultFont4);

                            marksThird4.add(coinThird4, BorderLayout.SOUTH);
                            marksThird4.add(scoreThird4, BorderLayout.NORTH);
                            ThirdLevel4.add(marksThird4);
                            RightPanel.add(ThirdLevel4,gbc);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird4 = 0;
                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0){
                        if(Player2.RedCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]){
                            sw=false;
                        }
                        if(Player2.RedCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] &&
                                Player2.RedCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]){
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - Player2.RedCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0){
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]){
                            sw=false;
                        }
                        if(Player2.BlueCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] &&
                                Player2.BlueCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]){
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - Player2.BlueCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0){
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]){
                            sw=false;
                        }
                        if(Player2.WhiteCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] &&
                                Player2.WhiteCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]){
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - Player2.WhiteCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0){
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]){
                            sw=false;
                        }
                        if(Player2.GreenCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] &&
                                Player2.GreenCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]){
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - Player2.GreenCoin);
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0){
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]){
                            sw=false;
                        }
                        if(Player2.BlackCoin + Player2.SpecialGoldCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] &&
                                Player2.BlackCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]){
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - Player2.BlackCoin);
                        }
                    }




                    if (!sw || CountGoldCoinThird4>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0){
                            if ((Player2.RedCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] ) >= 0) {
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - Player2.RedCoin);
                                Coins.RedCoin += Player2.RedCoin ;
                                Player2.RedCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0){
                            if ((Player2.BlueCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] ) >= 0) {
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - Player2.BlueCoin);
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0){
                            if ((Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ) >= 0) {
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2];
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - Player2.WhiteCoin);
                                Coins.WhiteCoin += Player2.WhiteCoin ;
                                Player2.WhiteCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0){
                            if ((Player2.GreenCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ) >= 0) {
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3];
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - Player2.GreenCoin);
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0 ;
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0){
                            if ((Player2.BlackCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] ) >= 0) {
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                            }
                            else {
                                Player2.SpecialGoldCoin -= (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.GoldCoin += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - Player2.BlackCoin);
                                Coins.BlackCoin += Player2.BlackCoin ;
                                Player2.BlackCoin = 0 ;
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird4].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel4.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            JLabel scoreThird4 = new JLabel(Third[ThirdLevelCards.CounterThird4].ScoreThird + "    " +
                                    Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
                            scoreThird4.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird4.setFont(CardFont);
                            JLabel coinThird4 = new JLabel(Third[ThirdLevelCards.CounterThird4].CardThird);
                            coinThird4.setFont(defaultFont4);

                            marksThird4.add(coinThird4, BorderLayout.SOUTH);
                            marksThird4.add(scoreThird4, BorderLayout.NORTH);
                            ThirdLevel4.add(marksThird4);
                            RightPanel.add(ThirdLevel4, gbc);
                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });



        add(RightPanel , BorderLayout.EAST);
        setVisible(true);



    }
    //add player tables
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


