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
    private final Font reserveFont = new Font("tahoma" , Font.PLAIN , 5);
    public boolean PlayerTurn = true ; //true for player1 and false for player2
    public int count;
    public boolean sw;





    GridBagConstraints gbc = new GridBagConstraints();
    Player Player1 = new Player();
    Player Player2 = new Player();

    public String CoinState1 = "red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
            + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin;
    public JLabel Player1CoinCounter = new JLabel(CoinState1);

    public String SpecialCoinState1 = "red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
            + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
            ",gold = " + Player1.SpecialGoldCoin;
    public JLabel Player1Score = new JLabel(String.valueOf(Player1.Score));

    public JLabel Player1SpecialCoinCounter = new JLabel(SpecialCoinState1);


    public String CoinState2 = "red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
            + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin;
    public JLabel Player2CoinCounter = new JLabel(CoinState2);

    public String SpecialCoinState2 = "red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
            + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
            ",gold = " + Player2.SpecialGoldCoin;
    public JLabel Player2SpecialCoinCounter = new JLabel(SpecialCoinState2);

    public JLabel Player2Score = new JLabel(String.valueOf(Player2.Score));


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


        JPanel ChooseTypeOfCoinSelection = new JPanel();
        ChooseTypeOfCoinSelection.setLayout(new BoxLayout(ChooseTypeOfCoinSelection, BoxLayout.Y_AXIS));
        ChooseTypeOfCoinSelection.setBackground(Color.pink);
        JButton TwoCoin = new JButton("2 Coin");
        JButton ThreeCoin = new JButton("3 Coin");
        ButtonGroup TypeSelection = new ButtonGroup();
        TypeSelection.add(TwoCoin);
        TypeSelection.add(ThreeCoin);
        ChooseTypeOfCoinSelection.add(TwoCoin);
        ChooseTypeOfCoinSelection.add(ThreeCoin);
        LeftPanel.add(ChooseTypeOfCoinSelection);


        JLabel TwoCoinOption = new JLabel("Two Coin Options");
        LeftPanel.add(TwoCoinOption);

        JPanel TwoCoinSelection = new JPanel();
        TwoCoinSelection.setLayout(new BoxLayout(TwoCoinSelection, BoxLayout.Y_AXIS));


        JRadioButton Red1 = new JRadioButton("Red Slot Machine");
        JRadioButton Blue1 = new JRadioButton("Blue Slot Machine");
        JRadioButton Green1 = new JRadioButton("Green Slot Machine");
        JRadioButton Black1 = new JRadioButton("Black Slot Machine");
        JRadioButton White1 = new JRadioButton("White Slot Machine");
        ButtonGroup TwoCoinOptions = new ButtonGroup();
        TwoCoinOptions.add(Red1);
        TwoCoinOptions.add(Black1);
        TwoCoinOptions.add(Green1);
        TwoCoinOptions.add(Blue1);
        TwoCoinOptions.add(White1);
        Red1.setEnabled(false);
        Blue1.setEnabled(false);
        Green1.setEnabled(false);
        Black1.setEnabled(false);
        White1.setEnabled(false);

        TwoCoinSelection.add(Red1);
        TwoCoinSelection.add(Blue1);
        TwoCoinSelection.add(Green1);
        TwoCoinSelection.add(Black1);
        TwoCoinSelection.add(White1);

        LeftPanel.add(TwoCoinSelection);


        TwoCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThreeCoin.setEnabled(false);
                TwoCoin.setEnabled(false);
                Red1.setEnabled(true);
                Blue1.setEnabled(true);
                Green1.setEnabled(true);
                Black1.setEnabled(true);
                White1.setEnabled(true);
            }
        });
        Red1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Coins.RedCoin == 4){
                    Coins.RedCoin -= 2;
                    if(PlayerTurn){
                        Player1.RedCoin += 2;
                        PlayerTurn = false;
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Red1.setSelected(false);
                        Red1.setEnabled(false);
                        Blue1.setEnabled(false);
                        Green1.setEnabled(false);
                        Black1.setEnabled(false);
                        White1.setEnabled(false);
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);

                    }
                    else{
                        Player2.RedCoin += 2;
                        PlayerTurn = true;
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Red1.setSelected(false);
                        Red1.setEnabled(false);
                        Blue1.setEnabled(false);
                        Green1.setEnabled(false);
                        Black1.setEnabled(false);
                        White1.setEnabled(false);
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);
                    }
                }
                else {
                    showMessageDialog(null,"you can't have these coins");
                    Red1.setSelected(false);
                    Red1.setEnabled(false);
                    Blue1.setEnabled(false);
                    Green1.setEnabled(false);
                    Black1.setEnabled(false);
                    White1.setEnabled(false);
                    ThreeCoin.setEnabled(true);
                    TwoCoin.setEnabled(true);

                }
            }
        });


        Blue1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Coins.BlueCoin == 4){
                    Coins.BlueCoin -= 2;
                    if(PlayerTurn){
                        Player1.BlueCoin += 2;
                        PlayerTurn = false;
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Blue1.setSelected(false);
                        Red1.setEnabled(false);
                        Blue1.setEnabled(false);
                        Green1.setEnabled(false);
                        Black1.setEnabled(false);
                        White1.setEnabled(false);
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);

                    }
                    else{
                        Player2.BlueCoin += 2;
                        PlayerTurn = true;
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Blue1.setSelected(false);
                        Red1.setEnabled(false);
                        Blue1.setEnabled(false);
                        Green1.setEnabled(false);
                        Black1.setEnabled(false);
                        White1.setEnabled(false);
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);
                    }
                }
                else {
                    showMessageDialog(null,"you can't have these coins");
                    Blue1.setSelected(false);
                    Red1.setEnabled(false);
                    Blue1.setEnabled(false);
                    Green1.setEnabled(false);
                    Black1.setEnabled(false);
                    White1.setEnabled(false);
                    ThreeCoin.setEnabled(true);
                    TwoCoin.setEnabled(true);

                }
            }
        });

        Green1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Coins.GreenCoin == 4){
                    Coins.GreenCoin -= 2;
                    if(PlayerTurn){
                        Player1.GreenCoin += 2;
                        PlayerTurn = false;
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Green1.setSelected(false);
                        Red1.setEnabled(false);
                        Blue1.setEnabled(false);
                        Green1.setEnabled(false);
                        Black1.setEnabled(false);
                        White1.setEnabled(false);
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);

                    }
                    else{
                        Player2.GreenCoin += 2;
                        PlayerTurn = true;
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Green1.setSelected(false);
                        Red1.setEnabled(false);
                        Blue1.setEnabled(false);
                        Green1.setEnabled(false);
                        Black1.setEnabled(false);
                        White1.setEnabled(false);
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);
                    }
                }
                else {
                    showMessageDialog(null,"you can't have these coins");
                    Green1.setSelected(false);
                    Red1.setEnabled(false);
                    Blue1.setEnabled(false);
                    Green1.setEnabled(false);
                    Black1.setEnabled(false);
                    White1.setEnabled(false);
                    ThreeCoin.setEnabled(true);
                    TwoCoin.setEnabled(true);

                }
            }
        });

        Black1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(Coins.BlackCoin == 4){
                   Coins.BlackCoin -= 2;
                   if(PlayerTurn){
                       Player1.BlackCoin += 2;
                       PlayerTurn = false;
                       Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                               + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                       Black1.setSelected(false);
                       Red1.setEnabled(false);
                       Blue1.setEnabled(false);
                       Green1.setEnabled(false);
                       Black1.setEnabled(false);
                       White1.setEnabled(false);
                       ThreeCoin.setEnabled(true);
                       TwoCoin.setEnabled(true);

                   }
                   else{
                       Player2.BlackCoin += 2;
                       PlayerTurn = true;
                       Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                               + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                       Black1.setSelected(false);
                       Red1.setEnabled(false);
                       Blue1.setEnabled(false);
                       Green1.setEnabled(false);
                       Black1.setEnabled(false);
                       White1.setEnabled(false);
                       ThreeCoin.setEnabled(true);
                       TwoCoin.setEnabled(true);
                   }
               }
               else {
                   showMessageDialog(null,"you can't have these coins");
                   Black1.setSelected(false);
                   Red1.setEnabled(false);
                   Blue1.setEnabled(false);
                   Green1.setEnabled(false);
                   Black1.setEnabled(false);
                   White1.setEnabled(false);
                   ThreeCoin.setEnabled(true);
                   TwoCoin.setEnabled(true);

               }
           }
       });

        White1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(Coins.WhiteCoin == 4){
                   Coins.WhiteCoin -= 2;
                   if(PlayerTurn){
                       Player1.WhiteCoin += 2;
                       PlayerTurn = false;
                       Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                               + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                       White1.setSelected(false);
                       Red1.setEnabled(false);
                       Blue1.setEnabled(false);
                       Green1.setEnabled(false);
                       Black1.setEnabled(false);
                       White1.setEnabled(false);
                       ThreeCoin.setEnabled(true);
                       TwoCoin.setEnabled(true);

                   }
                   else{
                       Player2.WhiteCoin += 2;
                       PlayerTurn = true;
                       Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                               + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                       White1.setSelected(false);
                       Red1.setEnabled(false);
                       Blue1.setEnabled(false);
                       Green1.setEnabled(false);
                       Black1.setEnabled(false);
                       White1.setEnabled(false);
                       ThreeCoin.setEnabled(true);
                       TwoCoin.setEnabled(true);
                   }
               }
               else {
                   showMessageDialog(null,"you can't have these coins");
                   White1.setSelected(false);
                   Red1.setEnabled(false);
                   Blue1.setEnabled(false);
                   Green1.setEnabled(false);
                   Black1.setEnabled(false);
                   White1.setEnabled(false);
                   ThreeCoin.setEnabled(true);
                   TwoCoin.setEnabled(true);

               }
           }
       });


        JLabel ThreeCoinOption = new JLabel("Three Coin Options");
        LeftPanel.add(ThreeCoinOption);

        JPanel ThreeCoinSelection = new JPanel();
        ThreeCoinSelection.setLayout(new BoxLayout(ThreeCoinSelection, BoxLayout.Y_AXIS));


        JCheckBox Red2 = new JCheckBox("Red Slot Machine");
        JCheckBox Blue2 = new JCheckBox("Blue Slot Machine");
        JCheckBox Green2 = new JCheckBox("Green Slot Machine");
        JCheckBox Black2 = new JCheckBox("Black Slot Machine");
        JCheckBox White2 = new JCheckBox("White Slot Machine");
        JButton finish = new JButton("finish");


        Red2.setEnabled(false);
        Blue2.setEnabled(false);
        Green2.setEnabled(false);
        Black2.setEnabled(false);
        White2.setEnabled(false);
        finish.setEnabled(false);

        ThreeCoinSelection.add(Red2);
        ThreeCoinSelection.add(Blue2);
        ThreeCoinSelection.add(Green2);
        ThreeCoinSelection.add(Black2);
        ThreeCoinSelection.add(White2);
        ThreeCoinSelection.add(finish);

        LeftPanel.add(ThreeCoinSelection);


        JPanel ReturnCoin = new JPanel();
        ReturnCoin.setLayout(new BoxLayout(ReturnCoin , BoxLayout.Y_AXIS));
        ReturnCoin.setBackground(Color.pink);
        ReturnCoin.setPreferredSize(new Dimension(50,500));

        JLabel BlackCoin = new JLabel("Black Coin");
        JPanel BlackOptions = new JPanel(new FlowLayout());
        JRadioButton OneBlack = new JRadioButton("1");
        JRadioButton TwoBlack = new JRadioButton("2");
        JRadioButton ThreeBlack = new JRadioButton("3");
        JRadioButton FourBlack = new JRadioButton("4");
        ButtonGroup BlackGroup = new ButtonGroup() ;
        BlackGroup.add(OneBlack);
        BlackGroup.add(TwoBlack);
        BlackGroup.add(ThreeBlack);
        BlackGroup.add(FourBlack);
        BlackOptions.add(OneBlack);
        BlackOptions.add(TwoBlack);
        BlackOptions.add(ThreeBlack);
        BlackOptions.add(FourBlack);
        ReturnCoin.add(BlackCoin);
        ReturnCoin.add(BlackOptions);

        JLabel RedCoin = new JLabel("Red Coin");
        JPanel RedOptions = new JPanel(new FlowLayout());
        JRadioButton OneRed = new JRadioButton("1");
        JRadioButton TwoRed = new JRadioButton("2");
        JRadioButton ThreeRed = new JRadioButton("3");
        JRadioButton FourRed = new JRadioButton("4");
        ButtonGroup RedGroup = new ButtonGroup() ;
        RedGroup.add(OneRed);
        RedGroup.add(TwoRed);
        RedGroup.add(ThreeRed);
        RedGroup.add(FourRed);
        RedOptions.add(OneRed);
        RedOptions.add(TwoRed);
        RedOptions.add(ThreeRed);
        RedOptions.add(FourRed);
        ReturnCoin.add(RedCoin);
        ReturnCoin.add(RedOptions);

        JLabel BlueCoin = new JLabel("Blue Coin");
        JPanel BlueOptions = new JPanel(new FlowLayout());
        JRadioButton OneBlue = new JRadioButton("1");
        JRadioButton TwoBlue = new JRadioButton("2");
        JRadioButton ThreeBlue = new JRadioButton("3");
        JRadioButton FourBlue = new JRadioButton("4");
        ButtonGroup BlueGroup = new ButtonGroup() ;
        BlueGroup.add(OneBlue);
        BlueGroup.add(TwoBlue);
        BlueGroup.add(ThreeBlue);
        BlueGroup.add(FourBlue);
        BlueOptions.add(OneBlue);
        BlueOptions.add(TwoBlue);
        BlueOptions.add(ThreeBlue);
        BlueOptions.add(FourBlue);
        ReturnCoin.add(BlueCoin);
        ReturnCoin.add(BlueOptions);

        JLabel GreenCoin = new JLabel("Green Coin");
        JPanel GreenOptions = new JPanel(new FlowLayout());
        JRadioButton OneGreen = new JRadioButton("1");
        JRadioButton TwoGreen = new JRadioButton("2");
        JRadioButton ThreeGreen = new JRadioButton("3");
        JRadioButton FourGreen = new JRadioButton("4");
        ButtonGroup GreenGroup = new ButtonGroup() ;
        GreenGroup.add(OneGreen);
        GreenGroup.add(TwoGreen);
        GreenGroup.add(ThreeGreen);
        GreenGroup.add(FourGreen);
        GreenOptions.add(OneGreen);
        GreenOptions.add(TwoGreen);
        GreenOptions.add(ThreeGreen);
        GreenOptions.add(FourGreen);
        ReturnCoin.add(GreenCoin);
        ReturnCoin.add(GreenOptions);

        JLabel WhiteCoin = new JLabel("White Coin");
        JPanel WhiteOptions = new JPanel(new FlowLayout());
        JRadioButton OneWhite = new JRadioButton("1");
        JRadioButton TwoWhite = new JRadioButton("2");
        JRadioButton ThreeWhite = new JRadioButton("3");
        JRadioButton FourWhite = new JRadioButton("4");
        ButtonGroup WhiteGroup = new ButtonGroup() ;
        WhiteGroup.add(OneWhite);
        WhiteGroup.add(TwoWhite);
        WhiteGroup.add(ThreeWhite);
        WhiteGroup.add(FourWhite);
        WhiteOptions.add(OneWhite);
        WhiteOptions.add(TwoWhite);
        WhiteOptions.add(ThreeWhite);
        WhiteOptions.add(FourWhite);
        ReturnCoin.add(WhiteCoin);
        ReturnCoin.add(WhiteOptions);

        LeftPanel.add(ReturnCoin);

        OneBlack.setEnabled(false);
        TwoBlack.setEnabled(false);
        ThreeBlack.setEnabled(false);
        FourBlack.setEnabled(false);
        OneRed.setEnabled(false);
        TwoRed.setEnabled(false);
        ThreeRed.setEnabled(false);
        FourRed.setEnabled(false);
        OneBlue.setEnabled(false);
        TwoBlue.setEnabled(false);
        ThreeBlue.setEnabled(false);
        FourBlue.setEnabled(false);
        OneGreen.setEnabled(false);
        TwoGreen.setEnabled(false);
        ThreeGreen.setEnabled(false);
        FourGreen.setEnabled(false);
        OneWhite.setEnabled(false);
        TwoWhite.setEnabled(false);
        ThreeWhite.setEnabled(false);
        FourWhite.setEnabled(false);

        JButton FinishReturning = new JButton("finish");
        FinishReturning.setEnabled(false);
        LeftPanel.add(FinishReturning);
        // this method would return possible coins and if it's not, it won't show any messages
        FinishReturning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PlayerTurn){
                    if(OneBlack.isSelected() && Player1.BlackCoin>=1){
                        Player1.BlackCoin -- ;
                        Coins.BlackCoin ++;
                    }
                    if(TwoBlack.isSelected() && Player1.BlackCoin>=2){
                        Player1.BlackCoin -= 2;
                        Coins.BlackCoin += 2;
                    }
                    if(ThreeBlack.isSelected() && Player1.BlackCoin>=3){
                        Player1.BlackCoin -= 3;
                        Coins.BlackCoin += 3;
                    }
                    if(FourBlack.isSelected() && Player1.BlackCoin==4){
                        Player1.BlackCoin -= 4;
                        Coins.BlackCoin += 4;
                    }
                    if(OneRed.isSelected() && Player1.RedCoin>=1){
                        Player1.RedCoin -- ;
                        Coins.RedCoin ++;
                    }
                    if(TwoRed.isSelected() && Player1.RedCoin>=2){
                        Player1.RedCoin -= 2;
                        Coins.RedCoin += 2;
                    }
                    if(ThreeRed.isSelected() && Player1.RedCoin>=3){
                        Player1.RedCoin -= 3;
                        Coins.RedCoin += 3;
                    }
                    if(FourRed.isSelected() && Player1.RedCoin==4){
                        Player1.RedCoin -= 4;
                        Coins.RedCoin += 4;
                    }
                    if(OneWhite.isSelected() && Player1.WhiteCoin>=1){
                        Player1.WhiteCoin -- ;
                        Coins.WhiteCoin ++;
                    }
                    if(TwoWhite.isSelected() && Player1.WhiteCoin>=2){
                        Player1.WhiteCoin -= 2;
                        Coins.WhiteCoin += 2;
                    }
                    if(ThreeWhite.isSelected() && Player1.WhiteCoin>=3){
                        Player1.WhiteCoin -= 3;
                        Coins.WhiteCoin += 3;
                    }
                    if(FourWhite.isSelected() && Player1.WhiteCoin==4){
                        Player1.WhiteCoin -= 4;
                        Coins.WhiteCoin += 4;
                    }
                    if(OneBlue.isSelected() && Player1.BlueCoin>=1){
                        Player1.BlueCoin -- ;
                        Coins.BlueCoin ++;
                    }
                    if(TwoBlue.isSelected() && Player1.BlueCoin>=2){
                        Player1.BlueCoin -= 2;
                        Coins.BlueCoin += 2;
                    }
                    if(ThreeBlue.isSelected() && Player1.BlueCoin>=3){
                        Player1.BlueCoin -= 3;
                        Coins.BlueCoin += 3;
                    }
                    if(FourBlue.isSelected() && Player1.BlueCoin==4){
                        Player1.BlueCoin -= 4;
                        Coins.BlueCoin += 4;
                    }
                    if(OneGreen.isSelected() && Player1.GreenCoin>=1){
                        Player1.GreenCoin -- ;
                        Coins.GreenCoin ++;
                    }
                    if(TwoGreen.isSelected() && Player1.GreenCoin>=2){
                        Player1.GreenCoin -= 2;
                        Coins.GreenCoin += 2;
                    }
                    if(ThreeGreen.isSelected() && Player1.GreenCoin>=3){
                        Player1.GreenCoin -= 3;
                        Coins.GreenCoin += 3;
                    }
                    if(FourGreen.isSelected() && Player1.GreenCoin==4){
                        Player1.GreenCoin -= 4;
                        Coins.GreenCoin += 4;
                    }
                    if(Player1.RedCoin + Player1.BlackCoin + Player1.BlueCoin + Player1.WhiteCoin + Player1.GreenCoin >10){
                        showMessageDialog(null,"you still have more than 10 coins, you must return them");
                    }
                    else {

                        OneBlack.setEnabled(true);
                        TwoBlack.setEnabled(true);
                        ThreeBlack.setEnabled(true);
                        FourBlack.setEnabled(true);
                        OneRed.setEnabled(true);
                        TwoRed.setEnabled(true);
                        ThreeRed.setEnabled(true);
                        FourRed.setEnabled(true);
                        OneBlue.setEnabled(true);
                        TwoBlue.setEnabled(true);
                        ThreeBlue.setEnabled(true);
                        FourBlue.setEnabled(true);
                        OneGreen.setEnabled(true);
                        TwoGreen.setEnabled(true);
                        ThreeGreen.setEnabled(true);
                        FourGreen.setEnabled(true);
                        OneWhite.setEnabled(true);
                        TwoWhite.setEnabled(true);
                        ThreeWhite.setEnabled(true);
                        FourWhite.setEnabled(true);
                        FinishReturning.setEnabled(true);
                        PlayerTurn = false ;

                    }
                }
                else {
                    if(OneBlack.isSelected() && Player2.BlackCoin>=1){
                        Player2.BlackCoin -- ;
                        Coins.BlackCoin ++;
                    }
                    if(TwoBlack.isSelected() && Player2.BlackCoin>=2){
                        Player2.BlackCoin -= 2;
                        Coins.BlackCoin += 2;
                    }
                    if(ThreeBlack.isSelected() && Player2.BlackCoin>=3){
                        Player2.BlackCoin -= 3;
                        Coins.BlackCoin += 3;
                    }
                    if(FourBlack.isSelected() && Player2.BlackCoin==4){
                        Player2.BlackCoin -= 4;
                        Coins.BlackCoin += 4;
                    }
                    if(OneRed.isSelected() && Player2.RedCoin>=1){
                        Player2.RedCoin -- ;
                        Coins.RedCoin ++;
                    }
                    if(TwoRed.isSelected() && Player2.RedCoin>=2){
                        Player2.RedCoin -= 2;
                        Coins.RedCoin += 2;
                    }
                    if(ThreeRed.isSelected() && Player2.RedCoin>=3){
                        Player2.RedCoin -= 3;
                        Coins.RedCoin += 3;
                    }
                    if(FourRed.isSelected() && Player2.RedCoin==4){
                        Player2.RedCoin -= 4;
                        Coins.RedCoin += 4;
                    }
                    if(OneWhite.isSelected() && Player2.WhiteCoin>=1){
                        Player2.WhiteCoin -- ;
                        Coins.WhiteCoin ++;
                    }
                    if(TwoWhite.isSelected() && Player2.WhiteCoin>=2){
                        Player2.WhiteCoin -= 2;
                        Coins.WhiteCoin += 2;
                    }
                    if(ThreeWhite.isSelected() && Player2.WhiteCoin>=3){
                        Player2.WhiteCoin -= 3;
                        Coins.WhiteCoin += 3;
                    }
                    if(FourWhite.isSelected() && Player2.WhiteCoin==4){
                        Player2.WhiteCoin -= 4;
                        Coins.WhiteCoin += 4;
                    }
                    if(OneBlue.isSelected() && Player2.BlueCoin>=1){
                        Player2.BlueCoin -- ;
                        Coins.BlueCoin ++;
                    }
                    if(TwoBlue.isSelected() && Player2.BlueCoin>=2){
                        Player2.BlueCoin -= 2;
                        Coins.BlueCoin += 2;
                    }
                    if(ThreeBlue.isSelected() && Player2.BlueCoin>=3){
                        Player2.BlueCoin -= 3;
                        Coins.BlueCoin += 3;
                    }
                    if(FourBlue.isSelected() && Player2.BlueCoin==4){
                        Player2.BlueCoin -= 4;
                        Coins.BlueCoin += 4;
                    }
                    if(OneGreen.isSelected() && Player2.GreenCoin>=1){
                        Player2.GreenCoin -- ;
                        Coins.GreenCoin ++;
                    }
                    if(TwoGreen.isSelected() && Player2.GreenCoin>=2){
                        Player2.GreenCoin -= 2;
                        Coins.GreenCoin += 2;
                    }
                    if(ThreeGreen.isSelected() && Player2.GreenCoin>=3){
                        Player2.GreenCoin -= 3;
                        Coins.GreenCoin += 3;
                    }
                    if(FourGreen.isSelected() && Player2.GreenCoin==4){
                        Player2.GreenCoin -= 4;
                        Coins.GreenCoin += 4;
                    }
                    if(Player2.RedCoin + Player2.BlackCoin + Player2.BlueCoin + Player2.WhiteCoin + Player2.GreenCoin >10){
                        showMessageDialog(null,"you still have more than 10 coins, you must return them");
                    }
                    else {
                        OneBlack.setEnabled(true);
                        TwoBlack.setEnabled(true);
                        ThreeBlack.setEnabled(true);
                        FourBlack.setEnabled(true);
                        OneRed.setEnabled(true);
                        TwoRed.setEnabled(true);
                        ThreeRed.setEnabled(true);
                        FourRed.setEnabled(true);
                        OneBlue.setEnabled(true);
                        TwoBlue.setEnabled(true);
                        ThreeBlue.setEnabled(true);
                        FourBlue.setEnabled(true);
                        OneGreen.setEnabled(true);
                        TwoGreen.setEnabled(true);
                        ThreeGreen.setEnabled(true);
                        FourGreen.setEnabled(true);
                        OneWhite.setEnabled(true);
                        TwoWhite.setEnabled(true);
                        ThreeWhite.setEnabled(true);
                        FourWhite.setEnabled(true);
                        FinishReturning.setEnabled(true);
                        PlayerTurn = true ;
                    }
                }
        });





        ThreeCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThreeCoin.setEnabled(false);
                TwoCoin.setEnabled(false);
                Red2.setEnabled(true);
                Blue2.setEnabled(true);
                Green2.setEnabled(true);
                Black2.setEnabled(true);
                White2.setEnabled(true);
                finish.setEnabled(true);
                count = 0;
            }
        });
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Red2.isSelected()){
                    count ++;
                }
                if(Black2.isSelected()){
                    count ++;
                }
                if(Blue2.isSelected()){
                    count ++;
                }
                if(Green2.isSelected()){
                    count++;
                }
                if(White2.isSelected()){
                    count++;
                }
                sw = true ;
                if(count!=3) {
                    showMessageDialog(null, "you can't pick these coins");
                    ThreeCoin.setEnabled(true);
                    TwoCoin.setEnabled(true);
                    Red2.setEnabled(false);
                    Blue2.setEnabled(false);
                    Green2.setEnabled(false);
                    Black2.setEnabled(false);
                    White2.setEnabled(false);
                    finish.setEnabled(false);
                }
                else {
                    if(Red2.isSelected() && Coins.RedCoin == 0){
                        sw = false;
                    }
                    if(Blue2.isSelected() && Coins.BlueCoin == 0){
                        sw = false;
                    }
                    if(Green2.isSelected() && Coins.GreenCoin == 0){
                        sw = false;
                    }
                    if(Black2.isSelected() && Coins.BlackCoin == 0){
                        sw = false;
                    }
                    if(White2.isSelected() && Coins.WhiteCoin == 0){
                        sw = false;
                    }
                    if(!sw){
                        showMessageDialog(null, "you can't pick these coins");
                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);
                        Red2.setEnabled(false);
                        Blue2.setEnabled(false);
                        Green2.setEnabled(false);
                        Black2.setEnabled(false);
                        White2.setEnabled(false);
                        finish.setEnabled(false);
                    }
                    else {
                        if(Red2.isSelected()){
                            Coins.RedCoin --;
                            if(PlayerTurn){
                                Player1.RedCoin++;
                            }
                            else{
                                Player2.RedCoin++;
                            }
                        }
                        if(Blue2.isSelected()){
                            Coins.BlueCoin --;
                            if(PlayerTurn){
                                Player1.BlueCoin++;
                            }
                            else{
                                Player2.BlueCoin++;
                            }
                        }
                        if(Green2.isSelected()){
                            Coins.GreenCoin --;
                            if(PlayerTurn){
                                Player1.GreenCoin++;
                            }
                            else{
                                Player2.GreenCoin++;
                            }
                        }
                        if(Black2.isSelected()){
                            Coins.BlackCoin --;
                            if(PlayerTurn){
                                Player1.BlackCoin++;
                            }
                            else{
                                Player2.BlackCoin++;
                            }
                        }
                        if(White2.isSelected()){
                            Coins.WhiteCoin --;
                            if(PlayerTurn){
                                Player1.WhiteCoin++;
                            }
                            else{
                                Player2.WhiteCoin++;
                            }
                        }
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);

                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);

                        ThreeCoin.setEnabled(true);
                        TwoCoin.setEnabled(true);
                        Red2.setEnabled(false);
                        Blue2.setEnabled(false);
                        Green2.setEnabled(false);
                        Black2.setEnabled(false);
                        White2.setEnabled(false);
                        finish.setEnabled(false);
                        if (PlayerTurn) {
                            if(Player1.RedCoin +Player1.BlueCoin+Player1.GreenCoin +Player1.WhiteCoin+Player1.BlackCoin > 10){
                                showMessageDialog(null , "your coins are more than 10, you must return them!");

                            }
                            PlayerTurn = false;
                        }
                        else {
                            PlayerTurn = true;
                        }
                    }
                }
            }
        });

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
                        Player1Score.setText(String.valueOf(Player1.Score));
                        PrizeClaw1.setEnabled(false);
                        PlayerTurn=false;
                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }
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
                        Player2Score.setText(String.valueOf(Player2.Score));
                        PrizeClaw1.setEnabled(false);
                        PlayerTurn = true ;
                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }
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
                        Player1Score.setText(String.valueOf(Player1.Score));
                        PrizeClaw2.setEnabled(false);
                        PlayerTurn = false ;
                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }
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
                        Player2Score.setText(String.valueOf(Player2.Score));
                        PrizeClaw2.setEnabled(false);
                        PlayerTurn = true ;
                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }
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
                        Player1Score.setText(String.valueOf(Player1.Score));
                        PrizeClaw3.setEnabled(false);
                        PlayerTurn = false ;
                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }
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
                        Player2Score.setText(String.valueOf(Player2.Score));
                        PrizeClaw3.setEnabled(false);
                        PlayerTurn = true ;
                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }
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

        JButton ReserveCardFirst1 = new JButton("");
        ReserveCardFirst1.setPreferredSize( new Dimension(15,10));
        ReserveCardFirst1.setBackground(Color.red);



        marksFirst1.add (coinFirst1 , BorderLayout.SOUTH);
        marksFirst1.add (scoreFirst1 , BorderLayout.NORTH);
        marksFirst1.add (ReserveCardFirst1 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinFirst1 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] >= 0){
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] >= 0){
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] >= 0){
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] >= 0){
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] >= 0){
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst1].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);


                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel1.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst1.setText(First[FirstLevelCards.CounterFirst1].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
                            scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst1.setFont(CardFont);
                            coinFirst1.setText(First[FirstLevelCards.CounterFirst1].CardFirst);
                            coinFirst1.setFont(defaultFont4);
                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst1 = 0;
                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst1 += (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }




                    if (!sw || CountGoldCoinFirst1>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] >= 0){
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] >= 0){
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] >= 0){
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] >= 0){
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin ;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] >= 0){
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[4];
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst1].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel1.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst1.setText(First[FirstLevelCards.CounterFirst1].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
                            scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst1.setFont(CardFont);
                            coinFirst1.setText(First[FirstLevelCards.CounterFirst1].CardFirst);
                            coinFirst1.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });
        ReserveCardFirst1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = First[FirstLevelCards.CounterFirst1].ScoreFirst;
                            Player1.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = First[FirstLevelCards.CounterFirst1].ScoreFirst;
                            Player1.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = First[FirstLevelCards.CounterFirst1].ScoreFirst;
                            Player1.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel1.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst1.setText(First[FirstLevelCards.CounterFirst1].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
                            scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst1.setFont(CardFont);
                            coinFirst1.setText(First[FirstLevelCards.CounterFirst1].CardFirst);
                            coinFirst1.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = First[FirstLevelCards.CounterFirst1].ScoreFirst;
                            Player2.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = First[FirstLevelCards.CounterFirst1].ScoreFirst;
                            Player2.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = First[FirstLevelCards.CounterFirst1].ScoreFirst;
                            Player2.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = First[FirstLevelCards.CounterFirst1].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel1.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst1 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst1.setText(First[FirstLevelCards.CounterFirst1].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst1].ColorSpecialCoinFirst);
                            scoreFirst1.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst1.setFont(CardFont);
                            coinFirst1.setText(First[FirstLevelCards.CounterFirst1].CardFirst);
                            coinFirst1.setFont(defaultFont4);

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

        FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
        First [FirstLevelCards.CountFirst] = new FirstLevelCards() ;

        JLabel scoreFirst2 = new JLabel(First[FirstLevelCards.CounterFirst2].ScoreFirst+"                  "+
                First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
        scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
        scoreFirst2.setFont(CardFont);
        JLabel coinFirst2 = new JLabel(First[FirstLevelCards.CounterFirst2].CardFirst);
        coinFirst2.setFont(defaultFont4);
        coinFirst2.setHorizontalAlignment(JLabel.CENTER);

        JButton ReserveCardFirst2 = new JButton("");
        ReserveCardFirst2.setPreferredSize( new Dimension(15,10));
        ReserveCardFirst2.setBackground(Color.red);


        marksFirst2.add (coinFirst2 , BorderLayout.SOUTH);
        marksFirst2.add (scoreFirst2 , BorderLayout.NORTH);
        marksFirst2.add (ReserveCardFirst2 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinFirst2 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] >= 0){
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] >= 0){
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] >= 0){
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] >= 0){
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] >= 0){
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst2].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel2.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst2.setText(First[FirstLevelCards.CounterFirst2].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
                            scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst2.setFont(CardFont);
                            coinFirst2 .setText(First[FirstLevelCards.CounterFirst2].CardFirst);
                            coinFirst2.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst2 = 0;
                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst2 += (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }

                    if (!sw || CountGoldCoinFirst2 > Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] >= 0){
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] >= 0){
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] >= 0){
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] >= 0){
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] >= 0){
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[4];
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst2].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel2.setEnabled(false);

                        }
                        else {
                            FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst2.setText(First[FirstLevelCards.CounterFirst2].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
                            scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst2.setFont(CardFont);
                            coinFirst2.setText(First[FirstLevelCards.CounterFirst2].CardFirst);
                            coinFirst2.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardFirst2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = First[FirstLevelCards.CounterFirst2].ScoreFirst;
                            Player1.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = First[FirstLevelCards.CounterFirst2].ScoreFirst;
                            Player1.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = First[FirstLevelCards.CounterFirst2].ScoreFirst;
                            Player1.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel2.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst2.setText(First[FirstLevelCards.CounterFirst2].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
                            scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst2.setFont(CardFont);
                            coinFirst2.setText(First[FirstLevelCards.CounterFirst2].CardFirst);
                            coinFirst2.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = First[FirstLevelCards.CounterFirst2].ScoreFirst;
                            Player2.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = First[FirstLevelCards.CounterFirst2].ScoreFirst;
                            Player2.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = First[FirstLevelCards.CounterFirst2].ScoreFirst;
                            Player2.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = First[FirstLevelCards.CounterFirst2].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel2.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst2 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst2.setText(First[FirstLevelCards.CounterFirst2].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst2].ColorSpecialCoinFirst);
                            scoreFirst2.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst2.setFont(CardFont);
                            coinFirst2.setText(First[FirstLevelCards.CounterFirst2].CardFirst);
                            coinFirst2.setFont(defaultFont4);

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


        JButton ReserveCardFirst3 = new JButton("");
        ReserveCardFirst3.setPreferredSize( new Dimension(15,10));
        ReserveCardFirst3.setBackground(Color.red);


        marksFirst3.add (coinFirst3 , BorderLayout.SOUTH);
        marksFirst3.add (scoreFirst3 , BorderLayout.NORTH);
        marksFirst3.add (ReserveCardFirst3 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinFirst3 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] >= 0){
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] >= 0){
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] >= 0){
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] >= 0){
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] >= 0){
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst3].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel3.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst3.setText(First[FirstLevelCards.CounterFirst3].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
                            scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst3.setFont(CardFont);
                            coinFirst3.setText(First[FirstLevelCards.CounterFirst3].CardFirst);
                            coinFirst3.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst3 = 0;
                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst3 += (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinFirst3>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] >= 0){
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] >= 0){
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] >= 0){
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] >= 0){
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] >= 0){
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[4];
                            }
                        }

                        Player2.Score += First[FirstLevelCards.CounterFirst3].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel3.setEnabled(false);

                        }
                        else {
                            FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst3.setText(First[FirstLevelCards.CounterFirst3].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
                            scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst3.setFont(CardFont);
                            coinFirst3.setText(First[FirstLevelCards.CounterFirst3].CardFirst);
                            coinFirst3.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardFirst3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = First[FirstLevelCards.CounterFirst3].ScoreFirst;
                            Player1.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = First[FirstLevelCards.CounterFirst3].ScoreFirst;
                            Player1.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = First[FirstLevelCards.CounterFirst3].ScoreFirst;
                            Player1.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel3.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst3.setText(First[FirstLevelCards.CounterFirst3].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
                            scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst3.setFont(CardFont);
                            coinFirst3.setText(First[FirstLevelCards.CounterFirst3].CardFirst);
                            coinFirst3.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = First[FirstLevelCards.CounterFirst3].ScoreFirst;
                            Player2.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = First[FirstLevelCards.CounterFirst3].ScoreFirst;
                            Player2.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = First[FirstLevelCards.CounterFirst3].ScoreFirst;
                            Player2.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = First[FirstLevelCards.CounterFirst3].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel3.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst3 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst3.setText(First[FirstLevelCards.CounterFirst3].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst3].ColorSpecialCoinFirst);
                            scoreFirst3.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst3.setFont(CardFont);
                            coinFirst3.setText(First[FirstLevelCards.CounterFirst3].CardFirst);
                            coinFirst3.setFont(defaultFont4);

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


        JButton ReserveCardFirst4 = new JButton("");
        ReserveCardFirst4.setPreferredSize( new Dimension(15,10));
        ReserveCardFirst4.setBackground(Color.red);


        marksFirst4.add (coinFirst4 , BorderLayout.SOUTH);
        marksFirst4.add (scoreFirst4 , BorderLayout.NORTH);
        marksFirst4.add (ReserveCardFirst4 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinFirst4 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] >= 0){
                                Player1.RedCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] >= 0){
                                Player1.BlueCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] >= 0){
                                Player1.WhiteCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] >= 0){
                                Player1.GreenCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] >= 0){
                                Player1.BlackCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                            }
                        }

                        Player1.Score += First[FirstLevelCards.CounterFirst4].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst == "Blue")
                            Player1.SpecialBlueCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel4.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst4.setText(First[FirstLevelCards.CounterFirst4].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
                            scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst4.setFont(CardFont);
                            coinFirst4.setText(First[FirstLevelCards.CounterFirst4].CardFirst);
                            coinFirst4.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinFirst4 = 0;
                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4]) {
                            CountGoldCoinFirst4 += (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }

                    if (!sw || CountGoldCoinFirst4>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }

                    else {
                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] >= 0){
                                Player2.RedCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] ;
                                Coins.RedCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[0];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] >= 0){
                                Player2.BlueCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] ;
                                Coins.BlueCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[1];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] >= 0){
                                Player2.WhiteCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ;
                                Coins.WhiteCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[2];
                            }

                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] >= 0){
                                Player2.GreenCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ;
                                Coins.GreenCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3] ;
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[3];
                            }
                        }

                        if (First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] != 0) {
                            First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] >= 0){
                                Player2.BlackCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] ;
                                Coins.BlackCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] ;
                            }
                            else {
                                First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                                Coins.GoldCoin += First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[4];
                            }
                        }


                        Player2.Score += First[FirstLevelCards.CounterFirst4].ScoreFirst;

                        if (First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst == "Blue")
                            Player2.SpecialBlueCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel4.setEnabled(false);

                        }
                        else {
                            FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst4.setText(First[FirstLevelCards.CounterFirst4].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
                            scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst4.setFont(CardFont);
                            coinFirst4.setText(First[FirstLevelCards.CounterFirst4].CardFirst);
                            coinFirst4.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardFirst4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = First[FirstLevelCards.CounterFirst4].ScoreFirst;
                            Player1.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = First[FirstLevelCards.CounterFirst4].ScoreFirst;
                            Player1.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = First[FirstLevelCards.CounterFirst4].ScoreFirst;
                            Player1.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel4.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst4.setText(First[FirstLevelCards.CounterFirst4].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
                            scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst4.setFont(CardFont);
                            coinFirst4.setText(First[FirstLevelCards.CounterFirst4].CardFirst);
                            coinFirst4.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = First[FirstLevelCards.CounterFirst4].ScoreFirst;
                            Player2.SpecialCoinReserve1 = First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = First[FirstLevelCards.CounterFirst4].ScoreFirst;
                            Player2.SpecialCoinReserve2 = First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = First[FirstLevelCards.CounterFirst4].ScoreFirst;
                            Player2.SpecialCoinReserve3 = First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = First[FirstLevelCards.CounterFirst4].ColorAndCountFirst[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (FirstLevelCards.CountFirst == 15){
                            FirstLevel4.setEnabled(false);
                        }
                        else {
                            FirstLevelCards.CounterFirst4 = FirstLevelCards.CountFirst;
                            First[FirstLevelCards.CountFirst] = new FirstLevelCards();

                            scoreFirst4.setText(First[FirstLevelCards.CounterFirst4].ScoreFirst + "                  " +
                                    First[FirstLevelCards.CounterFirst4].ColorSpecialCoinFirst);
                            scoreFirst4.setHorizontalAlignment(JLabel.CENTER);
                            scoreFirst4.setFont(CardFont);
                            coinFirst4.setText(First[FirstLevelCards.CounterFirst4].CardFirst);
                            coinFirst4.setFont(defaultFont4);

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

        JButton ReserveCardSecond1 = new JButton("");
        ReserveCardSecond1.setPreferredSize( new Dimension(15,10));
        ReserveCardSecond1.setBackground(Color.red);


        marksSecond1.add (coinSecond1 , BorderLayout.SOUTH);
        marksSecond1.add (scoreSecond1 , BorderLayout.NORTH);
        marksSecond1.add (ReserveCardSecond1 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinSecond1 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] >= 0){
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] >= 0){
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] >= 0){
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] >= 0){
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] >= 0){
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond1].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            scoreSecond1.setText(Second[SecondLevelCards.CounterSecond1].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
                            scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond1.setFont(CardFont);
                            coinSecond1.setText(Second[SecondLevelCards.CounterSecond1].CardSecond);
                            coinSecond1.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond1 = 0;
                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond1 += (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinSecond1>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] >= 0){
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] >= 0){
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] >= 0){
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] >= 0){
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] >= 0){
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[4];
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond1].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond1.setText(Second[SecondLevelCards.CounterSecond1].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
                            scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond1.setFont(CardFont);
                            coinSecond1.setText(Second[SecondLevelCards.CounterSecond1].CardSecond);
                            coinSecond1.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardSecond1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Second[SecondLevelCards.CounterSecond1].ScoreSecond;
                            Player1.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Second[SecondLevelCards.CounterSecond1].ScoreSecond;
                            Player1.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Second[SecondLevelCards.CounterSecond1].ScoreSecond;
                            Player1.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond1.setText(Second[SecondLevelCards.CounterSecond1].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
                            scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond1.setFont(CardFont);
                            coinSecond1.setText(Second[SecondLevelCards.CounterSecond1].CardSecond);
                            coinSecond1.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Second[SecondLevelCards.CounterSecond1].ScoreSecond;
                            Player2.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Second[SecondLevelCards.CounterSecond1].ScoreSecond;
                            Player2.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Second[SecondLevelCards.CounterSecond1].ScoreSecond;
                            Player2.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond1].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond1 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond1.setText(Second[SecondLevelCards.CounterSecond1].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond1].ColorSpecialCoinSecond);
                            scoreSecond1.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond1.setFont(CardFont);
                            coinSecond1.setText(Second[SecondLevelCards.CounterSecond1].CardSecond);
                            coinSecond1.setFont(defaultFont4);

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

        JButton ReserveCardSecond2 = new JButton("");
        ReserveCardSecond2.setPreferredSize( new Dimension(15,10));
        ReserveCardSecond2.setBackground(Color.red);


        marksSecond2.add (coinSecond2 , BorderLayout.SOUTH);
        marksSecond2.add (scoreSecond2 , BorderLayout.NORTH);
        marksSecond2.add (ReserveCardSecond2 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinSecond2 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] >= 0){
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] >= 0){
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] >= 0){
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] >= 0){
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] >= 0){
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond2].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            scoreSecond2.setText(Second[SecondLevelCards.CounterSecond2].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
                            scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond2.setFont(CardFont);
                            coinSecond2.setText(Second[SecondLevelCards.CounterSecond2].CardSecond);
                            coinSecond2.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond2 = 0;
                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond2 += (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinSecond2>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] >= 0){
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] >= 0){
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] >= 0){
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] >= 0){
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] >= 0){
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[4];
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond2].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond2.setText(Second[SecondLevelCards.CounterSecond2].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
                            scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond2.setFont(CardFont);
                            coinSecond2.setText(Second[SecondLevelCards.CounterSecond2].CardSecond);
                            coinSecond2.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardSecond2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Second[SecondLevelCards.CounterSecond2].ScoreSecond;
                            Player1.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Second[SecondLevelCards.CounterSecond2].ScoreSecond;
                            Player1.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Second[SecondLevelCards.CounterSecond2].ScoreSecond;
                            Player1.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel2.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond2.setText(Second[SecondLevelCards.CounterSecond2].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
                            scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond2.setFont(CardFont);
                            coinSecond2.setText(Second[SecondLevelCards.CounterSecond2].CardSecond);
                            coinSecond2.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Second[SecondLevelCards.CounterSecond2].ScoreSecond;
                            Player2.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Second[SecondLevelCards.CounterSecond2].ScoreSecond;
                            Player2.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Second[SecondLevelCards.CounterSecond2].ScoreSecond;
                            Player2.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond2].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel2.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond2 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond2.setText(Second[SecondLevelCards.CounterSecond2].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond2].ColorSpecialCoinSecond);
                            scoreSecond2.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond2.setFont(CardFont);
                            coinSecond2.setText(Second[SecondLevelCards.CounterSecond2].CardSecond);
                            coinSecond2.setFont(defaultFont4);

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

        JButton ReserveCardSecond3 = new JButton("");
        ReserveCardSecond3.setPreferredSize( new Dimension(15,10));
        ReserveCardSecond3.setBackground(Color.red);


        marksSecond3.add (coinSecond3 , BorderLayout.SOUTH);
        marksSecond3.add (scoreSecond3 , BorderLayout.NORTH);
        marksSecond3.add (ReserveCardSecond3 , BorderLayout.WEST);
        SecondLevel3.add(marksSecond3);
        RightPanel.add(SecondLevel3,gbc);

        SecondLevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinSecond3 = 0;
                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinSecond3 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] >= 0){
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] >= 0){
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] >= 0){
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] >= 0){
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] >= 0){
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond3].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            scoreSecond3.setText(Second[SecondLevelCards.CounterSecond3].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
                            scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond3.setFont(CardFont);
                            coinSecond3.setText(Second[SecondLevelCards.CounterSecond3].CardSecond);
                            coinSecond3.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond3 = 0;
                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond3 += (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinSecond3>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] >= 0){
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] >= 0){
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] >= 0){
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] >= 0){
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] >= 0){
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[4];
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond3].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond3.setText(Second[SecondLevelCards.CounterSecond3].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
                            scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond3.setFont(CardFont);
                            coinSecond3.setText(Second[SecondLevelCards.CounterSecond3].CardSecond);
                            coinSecond3.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardSecond3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Second[SecondLevelCards.CounterSecond3].ScoreSecond;
                            Player1.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Second[SecondLevelCards.CounterSecond3].ScoreSecond;
                            Player1.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Second[SecondLevelCards.CounterSecond3].ScoreSecond;
                            Player1.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel3.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond3.setText(Second[SecondLevelCards.CounterSecond3].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
                            scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond3.setFont(CardFont);
                            coinSecond3.setText(Second[SecondLevelCards.CounterSecond3].CardSecond);
                            coinSecond3.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Second[SecondLevelCards.CounterSecond3].ScoreSecond;
                            Player2.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Second[SecondLevelCards.CounterSecond3].ScoreSecond;
                            Player2.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Second[SecondLevelCards.CounterSecond3].ScoreSecond;
                            Player2.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond3].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel3.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond3 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond3.setText(Second[SecondLevelCards.CounterSecond3].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond3].ColorSpecialCoinSecond);
                            scoreSecond3.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond3.setFont(CardFont);
                            coinSecond3.setText(Second[SecondLevelCards.CounterSecond3].CardSecond);
                            coinSecond3.setFont(defaultFont4);

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

        JButton ReserveCardSecond4 = new JButton("");
        ReserveCardSecond4.setPreferredSize( new Dimension(15,10));
        ReserveCardSecond4.setBackground(Color.red);


        marksSecond4.add (coinSecond4 , BorderLayout.SOUTH);
        marksSecond4.add (scoreSecond4 , BorderLayout.NORTH);
        marksSecond4.add (ReserveCardSecond4 , BorderLayout.WEST);
        SecondLevel4.add(marksSecond4);
        RightPanel.add(SecondLevel4,gbc);

        SecondLevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinSecond4 = 0;
                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinSecond4 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] >= 0){
                                Player1.RedCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] >= 0){
                                Player1.BlueCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] >= 0){
                                Player1.WhiteCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] >= 0){
                                Player1.GreenCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] >= 0){
                                Player1.BlackCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                            }
                        }

                        Player1.Score += Second[SecondLevelCards.CounterSecond4].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond == "Black")
                            Player1.SpecialBlackCoin++;
                        else
                            Player1.SpecialRedCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards ();

                            scoreSecond4.setText(Second[SecondLevelCards.CounterSecond4].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
                            scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond4.setFont(CardFont);
                            coinSecond4.setText(Second[SecondLevelCards.CounterSecond4].CardSecond);
                            coinSecond4.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinSecond4 = 0;
                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4]) {
                            CountGoldCoinSecond4 += (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinSecond4>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] >= 0){
                                Player2.RedCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] ;
                                Coins.RedCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[0];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] >= 0){
                                Player2.BlueCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] ;
                                Coins.BlueCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[1];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] >= 0){
                                Player2.WhiteCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ;
                                Coins.WhiteCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[2];
                            }

                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] >= 0){
                                Player2.GreenCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ;
                                Coins.GreenCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3] ;
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[3];
                            }
                        }

                        if (Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] != 0) {
                            Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] >= 0){
                                Player2.BlackCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] ;
                                Coins.BlackCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] ;
                            }
                            else {
                                Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                                Coins.GoldCoin += Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[4];
                            }
                        }

                        Player2.Score += Second[SecondLevelCards.CounterSecond4].ScoreSecond;

                        if (Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond == "Black")
                            Player2.SpecialBlackCoin ++;
                        else
                            Player2.SpecialRedCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel1.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond4.setText(Second[SecondLevelCards.CounterSecond4].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
                            scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond4.setFont(CardFont);
                            coinSecond4.setText(Second[SecondLevelCards.CounterSecond4].CardSecond);
                            coinSecond4.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardSecond4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Second[SecondLevelCards.CounterSecond4].ScoreSecond;
                            Player1.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Second[SecondLevelCards.CounterSecond4].ScoreSecond;
                            Player1.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Second[SecondLevelCards.CounterSecond4].ScoreSecond;
                            Player1.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel4.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond4.setText(Second[SecondLevelCards.CounterSecond4].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
                            scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond4.setFont(CardFont);
                            coinSecond4.setText(Second[SecondLevelCards.CounterSecond4].CardSecond);
                            coinSecond4.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Second[SecondLevelCards.CounterSecond4].ScoreSecond;
                            Player2.SpecialCoinReserve1 = Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Second[SecondLevelCards.CounterSecond4].ScoreSecond;
                            Player2.SpecialCoinReserve2 = Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Second[SecondLevelCards.CounterSecond4].ScoreSecond;
                            Player2.SpecialCoinReserve3 = Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Second[SecondLevelCards.CounterSecond4].ColorAndCountSecond[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (SecondLevelCards.CountSecond == 15){
                            SecondLevel4.setEnabled(false);
                        }
                        else {
                            SecondLevelCards.CounterSecond4 = SecondLevelCards.CountSecond;
                            Second[SecondLevelCards.CountSecond] = new SecondLevelCards();

                            scoreSecond4.setText(Second[SecondLevelCards.CounterSecond4].ScoreSecond + "                  " +
                                    Second[SecondLevelCards.CounterSecond4].ColorSpecialCoinSecond);
                            scoreSecond4.setHorizontalAlignment(JLabel.CENTER);
                            scoreSecond4.setFont(CardFont);
                            coinSecond4.setText(Second[SecondLevelCards.CounterSecond4].CardSecond);
                            coinSecond4.setFont(defaultFont4);

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

        JButton ReserveCardThird1 = new JButton("");
        ReserveCardThird1.setPreferredSize( new Dimension(15,10));
        ReserveCardThird1.setBackground(Color.red);


        marksThird1.add (coinThird1 , BorderLayout.SOUTH);
        marksThird1.add (scoreThird1 , BorderLayout.NORTH);
        marksThird1.add (ReserveCardThird1 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinThird1 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] >= 0){
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] >= 0){
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] >= 0){
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] >= 0){
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] >= 0){
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird1].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            scoreThird1.setText(Third[ThirdLevelCards.CounterThird1].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
                            scoreThird1.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird1.setFont(CardFont);
                            coinThird1.setText(Third[ThirdLevelCards.CounterThird1].CardThird);
                            coinThird1.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird1 = 0;
                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4]) {
                            CountGoldCoinThird1 += (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinThird1>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] >= 0){
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] >= 0){
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] >= 0){
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] >= 0){
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] >= 0){
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[4];
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird1].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird1.setText(Third[ThirdLevelCards.CounterThird1].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
                            scoreThird1.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird1.setFont(CardFont);
                            coinThird1.setText(Third[ThirdLevelCards.CounterThird1].CardThird);
                            coinThird1.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardThird1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Third[ThirdLevelCards.CounterThird1].ScoreThird;
                            Player1.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Third[ThirdLevelCards.CounterThird1].ScoreThird;
                            Player1.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Third[ThirdLevelCards.CounterThird1].ScoreThird;
                            Player1.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird1.setText(Third[ThirdLevelCards.CounterThird1].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
                            scoreThird1.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird1.setFont(CardFont);
                            coinThird1.setText(Third[ThirdLevelCards.CounterThird1].CardThird);
                            coinThird1.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Third[ThirdLevelCards.CounterThird1].ScoreThird;
                            Player2.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Third[ThirdLevelCards.CounterThird1].ScoreThird;
                            Player2.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Third[ThirdLevelCards.CounterThird1].ScoreThird;
                            Player2.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird1].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird1 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird1.setText(Third[ThirdLevelCards.CounterThird1].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird1].ColorSpecialCoinThird);
                            scoreThird1.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird1.setFont(CardFont);
                            coinThird1.setText(Third[ThirdLevelCards.CounterThird1].CardThird);
                            coinThird1.setFont(defaultFont4);

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

        JButton ReserveCardThird2 = new JButton("");
        ReserveCardThird2.setPreferredSize( new Dimension(15,10));
        ReserveCardThird2.setBackground(Color.red);


        marksThird2.add (coinThird2 , BorderLayout.SOUTH);
        marksThird2.add (scoreThird2 , BorderLayout.NORTH);
        marksThird2.add (ReserveCardThird2 , BorderLayout.WEST);
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
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinThird2 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] >= 0){
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] >= 0){
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] >= 0){
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] >= 0){
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] >= 0){
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird2].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            scoreThird2.setText(Third[ThirdLevelCards.CounterThird2].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
                            scoreThird2.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird2.setFont(CardFont);
                            coinThird2.setText(Third[ThirdLevelCards.CounterThird2].CardThird);
                            coinThird2.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird2 = 0;
                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4]) {
                            CountGoldCoinThird2 += (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinThird2>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] >= 0){
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] >= 0){
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] >= 0){
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] >= 0){
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] >= 0){
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[4];
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird2].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird2.setText(Third[ThirdLevelCards.CounterThird2].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
                            scoreThird2.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird2.setFont(CardFont);
                            coinThird2.setText(Third[ThirdLevelCards.CounterThird2].CardThird);
                            coinThird2.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardThird2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Third[ThirdLevelCards.CounterThird2].ScoreThird;
                            Player1.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Third[ThirdLevelCards.CounterThird2].ScoreThird;
                            Player1.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Third[ThirdLevelCards.CounterThird2].ScoreThird;
                            Player1.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel2.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird2.setText(Third[ThirdLevelCards.CounterThird2].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
                            scoreThird2.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird2.setFont(CardFont);
                            coinThird2.setText(Third[ThirdLevelCards.CounterThird2].CardThird);
                            coinThird2.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Third[ThirdLevelCards.CounterThird2].ScoreThird;
                            Player2.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Third[ThirdLevelCards.CounterThird2].ScoreThird;
                            Player2.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Third[ThirdLevelCards.CounterThird2].ScoreThird;
                            Player2.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird2].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel2.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird2 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird2.setText(Third[ThirdLevelCards.CounterThird2].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird2].ColorSpecialCoinThird);
                            scoreThird2.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird2.setFont(CardFont);
                            coinThird2.setText(Third[ThirdLevelCards.CounterThird2].CardThird);
                            coinThird2.setFont(defaultFont4);

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

        JButton ReserveCardThird3 = new JButton("");
        ReserveCardThird3.setPreferredSize( new Dimension(15,10));
        ReserveCardThird3.setBackground(Color.red);


        marksThird3.add (coinThird3 , BorderLayout.SOUTH);
        marksThird3.add (scoreThird3 , BorderLayout.NORTH);
        marksThird3.add (ReserveCardThird3 , BorderLayout.WEST);
        ThirdLevel3.add(marksThird3);
        RightPanel.add(ThirdLevel3,gbc);


        ThirdLevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinThird3 = 0;
                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinThird3 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] >= 0){
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] >= 0){
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] >= 0){
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] >= 0){
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] >= 0){
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird3].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            scoreThird3.setText(Third[ThirdLevelCards.CounterThird3].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
                            scoreThird3.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird3.setFont(CardFont);
                            coinThird3.setText(Third[ThirdLevelCards.CounterThird3].CardThird);
                            coinThird3.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird3 = 0;
                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4]) {
                            CountGoldCoinThird3 += (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinThird3>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] >= 0){
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] >= 0){
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] >= 0){
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] >= 0){
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] >= 0){
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[4];
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird3].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird3.setText(Third[ThirdLevelCards.CounterThird3].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
                            scoreThird3.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird3.setFont(CardFont);
                            coinThird3.setText(Third[ThirdLevelCards.CounterThird3].CardThird);
                            coinThird3.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardThird3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Third[ThirdLevelCards.CounterThird3].ScoreThird;
                            Player1.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Third[ThirdLevelCards.CounterThird3].ScoreThird;
                            Player1.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Third[ThirdLevelCards.CounterThird3].ScoreThird;
                            Player1.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel3.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird3.setText(Third[ThirdLevelCards.CounterThird3].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
                            scoreThird3.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird3.setFont(CardFont);
                            coinThird3.setText(Third[ThirdLevelCards.CounterThird3].CardThird);
                            coinThird3.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Third[ThirdLevelCards.CounterThird3].ScoreThird;
                            Player2.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Third[ThirdLevelCards.CounterThird3].ScoreThird;
                            Player2.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Third[ThirdLevelCards.CounterThird3].ScoreThird;
                            Player2.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird3].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel3.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird3 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird3.setText(Third[ThirdLevelCards.CounterThird3].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird3].ColorSpecialCoinThird);
                            scoreThird3.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird3.setFont(CardFont);
                            coinThird3.setText(Third[ThirdLevelCards.CounterThird3].CardThird);
                            coinThird3.setFont(defaultFont4);

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

        JButton ReserveCardThird4 = new JButton("");
        ReserveCardThird4.setPreferredSize( new Dimension(15,10));
        ReserveCardThird4.setBackground(Color.red);


        marksThird4.add (coinThird4 , BorderLayout.SOUTH);
        marksThird4.add (scoreThird4 , BorderLayout.NORTH);
        marksThird4.add (ReserveCardThird4 , BorderLayout.WEST);
        ThirdLevel4.add(marksThird4);
        RightPanel.add(ThirdLevel4,gbc);

        ThirdLevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn) {
                    //player1 turn
                    boolean sw = true;
                    int CountGoldCoinThird4 = 0;
                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] &&
                                Player1.RedCoin +Player1.SpecialRedCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - (Player1.RedCoin+Player1.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoinThird4 > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    }

                    else {
                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] >= 0){
                                Player1.RedCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] -= Player1.SpecialBlueCoin ;
                            if (Player1.BlueCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] >= 0){
                                Player1.BlueCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] -= Player1.BlueCoin ;
                                Coins.BlueCoin += Player1.BlueCoin ;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] -= Player1.SpecialWhiteCoin ;
                            if (Player1.WhiteCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] >= 0){
                                Player1.WhiteCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] -= Player1.SpecialGreenCoin;
                            if(Player1.GreenCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] >= 0){
                                Player1.GreenCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] -= Player1.SpecialBlackCoin ;
                            if(Player1.BlackCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] >= 0){
                                Player1.BlackCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                            }
                        }

                        Player1.Score += Third[ThirdLevelCards.CounterThird4].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialGreenCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15){
                            showMessageDialog(null,"PLAYER ONE WON!");
                            System.exit(0);
                        }

                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards ();

                            scoreThird4.setText(Third[ThirdLevelCards.CounterThird4].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
                            scoreThird4.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird4.setFont(CardFont);
                            coinThird4.setText(Third[ThirdLevelCards.CounterThird4].CardThird);
                            coinThird4.setFont(defaultFont4);

                        }
                        PlayerTurn = false;


                    }
                }
                else {
                    // player2 turn
                    boolean sw = true ;
                    int CountGoldCoinThird4 = 0;
                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] &&
                                Player2.RedCoin +Player2.SpecialRedCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] - (Player2.RedCoin+Player2.SpecialRedCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin< Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin ));
                        }
                    }

                    if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin>= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4]) {
                            CountGoldCoinThird4 += (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }





                    if (!sw || CountGoldCoinThird4>Player2.SpecialGoldCoin){
                        showMessageDialog(null,"you can't buy this card");
                    }



                    else {
                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] >= 0){
                                Player2.RedCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] ;
                                Coins.RedCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[0];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] -= Player2.SpecialBlueCoin ;
                            if (Player2.BlueCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] >= 0){
                                Player2.BlueCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] ;
                                Coins.BlueCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1] -= Player2.BlueCoin ;
                                Coins.BlueCoin += Player2.BlueCoin ;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[1];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] -= Player2.SpecialWhiteCoin ;
                            if (Player2.WhiteCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] >= 0){
                                Player2.WhiteCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ;
                                Coins.WhiteCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[2];
                            }

                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] -= Player2.SpecialGreenCoin;
                            if(Player2.GreenCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] >= 0){
                                Player2.GreenCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ;
                                Coins.GreenCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3] ;
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[3];
                            }
                        }

                        if (Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] != 0) {
                            Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] -= Player2.SpecialBlackCoin ;
                            if(Player2.BlackCoin - Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] >= 0){
                                Player2.BlackCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] ;
                                Coins.BlackCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] ;
                            }
                            else {
                                Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                                Coins.GoldCoin += Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[4];
                            }
                        }

                        Player2.Score += Third[ThirdLevelCards.CounterThird4].ScoreThird;

                        if (Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird == "White")
                            Player2.SpecialWhiteCoin ++;
                        else
                            Player2.SpecialGreenCoin ++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15){
                            showMessageDialog(null,"PLAYER TWO WON!");
                            System.exit(0);
                        }


                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel1.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird4.setText(Third[ThirdLevelCards.CounterThird4].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
                            scoreThird4.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird4.setFont(CardFont);
                            coinThird4.setText(Third[ThirdLevelCards.CounterThird4].CardThird);
                            coinThird4.setFont(defaultFont4);

                        }
                        PlayerTurn = true ;
                    }

                }

            }
        });

        ReserveCardThird4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn){
                    if(Player1.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player1.CountReserveCard++;
                        if(Player1.CountReserveCard == 1) {
                            Player1.ScoreReserve1 = Third[ThirdLevelCards.CounterThird4].ScoreThird;
                            Player1.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[i];
                            }
                        }
                        else if (Player1.CountReserveCard == 2 ){
                            Player1.ScoreReserve2 = Third[ThirdLevelCards.CounterThird4].ScoreThird;
                            Player1.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player1.ScoreReserve3 = Third[ThirdLevelCards.CounterThird4].ScoreThird;
                            Player1.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player1.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player1.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel4.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird4.setText(Third[ThirdLevelCards.CounterThird4].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
                            scoreThird4.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird4.setFont(CardFont);
                            coinThird4.setText(Third[ThirdLevelCards.CounterThird4].CardThird);
                            coinThird4.setFont(defaultFont4);

                        }
                        PlayerTurn = false ;
                    }
                }
                else{
                    if(Player2.CountReserveCard == 3){
                        showMessageDialog(null,"you can't reserve this card!");
                    }
                    else {
                        Player2.CountReserveCard++;
                        if (Player2.CountReserveCard == 1) {
                            Player2.ScoreReserve1 = Third[ThirdLevelCards.CounterThird4].ScoreThird;
                            Player2.SpecialCoinReserve1 = Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve1[i] = Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[i];
                            }
                        }
                        else if (Player2.CountReserveCard == 2){
                            Player2.ScoreReserve2 = Third[ThirdLevelCards.CounterThird4].ScoreThird;
                            Player2.SpecialCoinReserve2 = Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve2[i] = Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[i];
                            }
                        }
                        else {
                            Player2.ScoreReserve3 = Third[ThirdLevelCards.CounterThird4].ScoreThird;
                            Player2.SpecialCoinReserve3 = Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird;
                            for (int i = 0; i < 5; i++) {
                                Player2.CoinReserve3[i] = Third[ThirdLevelCards.CounterThird4].ColorAndCountThird[i];
                            }
                        }
                        if( Coins.GoldCoin != 0){
                            Coins.GoldCoin -- ;
                            Player2.SpecialGoldCoin ++ ;
                        }
                        if (ThirdLevelCards.CountThird == 15){
                            ThirdLevel4.setEnabled(false);
                        }
                        else {
                            ThirdLevelCards.CounterThird4 = ThirdLevelCards.CountThird;
                            Third[ThirdLevelCards.CountThird] = new ThirdLevelCards();

                            scoreThird4.setText(Third[ThirdLevelCards.CounterThird4].ScoreThird + "                  " +
                                    Third[ThirdLevelCards.CounterThird4].ColorSpecialCoinThird);
                            scoreThird4.setHorizontalAlignment(JLabel.CENTER);
                            scoreThird4.setFont(CardFont);
                            coinThird4.setText(Third[ThirdLevelCards.CounterThird4].CardThird);
                            coinThird4.setFont(defaultFont4);

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

        JPanel Player1Table = new JPanel();
        Player1Table.setLayout(new GridLayout(9,1));
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

        JLabel ReserveCards1 = new JLabel("RESERVE CARDS");
        ReserveCards1.setFont(defaultFont);
        ReserveCards1.setPreferredSize(new Dimension(200, 30));
        ReserveCards1.setHorizontalAlignment(JLabel.CENTER);
        ReserveCards1.setOpaque(true);
        ReserveCards1.setBackground(Color.LIGHT_GRAY);



        Player1CoinCounter.setFont(defaultFont2);
        Player1CoinCounter.setPreferredSize(new Dimension(200, 30));
        Player1CoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player1CoinCounter.setOpaque(true);
        Player1CoinCounter.setBackground(Color.WHITE);




        Player1SpecialCoinCounter.setFont(defaultFont2);
        Player1SpecialCoinCounter.setPreferredSize(new Dimension(200, 30));
        Player1SpecialCoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player1SpecialCoinCounter.setOpaque(true);
        Player1SpecialCoinCounter.setBackground(Color.WHITE);



        Player1Score.setPreferredSize(new Dimension(200, 30));
        Player1Score.setHorizontalAlignment(JLabel.CENTER);
        Player1Score.setOpaque(true);
        Player1Score.setBackground(Color.WHITE);

        JPanel PlayerOneReserveCards = new JPanel(new FlowLayout());
        PlayerOneReserveCards.add(Player1.ReserveCard1);
        PlayerOneReserveCards.add(Player1.ReserveCard2);
        PlayerOneReserveCards.add(Player1.ReserveCard3);

        Player1.ReserveCard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PlayerTurn || Player1.SpecialCoinReserve1 == null) {
                    showMessageDialog(null, "you can't buy this card");
                }
                else {
                    boolean sw = true;
                    int CountGoldCoin = 0;
                    if (Player1.CoinReserve1[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Player1.CoinReserve1[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Player1.CoinReserve1[0] &&
                                Player1.RedCoin + Player1.SpecialRedCoin < Player1.CoinReserve1[0]) {
                            CountGoldCoin += (Player1.CoinReserve1[0] - (Player1.RedCoin + Player1.SpecialRedCoin));
                        }
                    }

                    if (Player1.CoinReserve1[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Player1.CoinReserve1[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Player1.CoinReserve1[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Player1.CoinReserve1[1]) {
                            CountGoldCoin += (Player1.CoinReserve1[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Player1.CoinReserve1[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Player1.CoinReserve1[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Player1.CoinReserve1[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin < Player1.CoinReserve1[2]) {
                            CountGoldCoin += (Player1.CoinReserve1[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Player1.CoinReserve1[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Player1.CoinReserve1[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Player1.CoinReserve1[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Player1.CoinReserve1[3]) {
                            CountGoldCoin += (Player1.CoinReserve1[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin));
                        }
                    }

                    if (Player1.CoinReserve1[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Player1.CoinReserve1[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin >= Player1.CoinReserve1[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Player1.CoinReserve1[4]) {
                            CountGoldCoin += (Player1.CoinReserve1[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoin > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    } else {
                        if (Player1.CoinReserve1[0] != 0) {
                            Player1.CoinReserve1[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Player1.CoinReserve1[0] >= 0) {
                                Player1.RedCoin -= Player1.CoinReserve1[0];
                                Coins.RedCoin += Player1.CoinReserve1[0];
                            } else {
                                Player1.CoinReserve1[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve1[0];
                                Coins.GoldCoin += Player1.CoinReserve1[0];
                            }
                        }

                        if (Player1.CoinReserve1[1] != 0) {
                            Player1.CoinReserve1[1] -= Player1.SpecialBlueCoin;
                            if (Player1.BlueCoin - Player1.CoinReserve1[1] >= 0) {
                                Player1.BlueCoin -= Player1.CoinReserve1[1];
                                Coins.BlueCoin += Player1.CoinReserve1[1];
                            } else {
                                Player1.CoinReserve1[1] -= Player1.BlueCoin;
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve1[1];
                                Coins.GoldCoin += Player1.CoinReserve1[1];
                            }
                        }

                        if (Player1.CoinReserve1[2] != 0) {
                            Player1.CoinReserve1[2] -= Player1.SpecialWhiteCoin;
                            if (Player1.WhiteCoin - Player1.CoinReserve1[2] >= 0) {
                                Player1.WhiteCoin -= Player1.CoinReserve1[2];
                                Coins.WhiteCoin += Player1.CoinReserve1[2];
                            } else {
                                Player1.CoinReserve1[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve1[2];
                                Coins.GoldCoin += Player1.CoinReserve1[2];
                            }

                        }

                        if (Player1.CoinReserve1[3] != 0) {
                            Player1.CoinReserve1[3] -= Player1.SpecialGreenCoin;
                            if (Player1.GreenCoin - Player1.CoinReserve1[3] >= 0) {
                                Player1.GreenCoin -= Player1.CoinReserve1[3];
                                Coins.GreenCoin += Player1.CoinReserve1[3];
                            } else {
                                Player1.CoinReserve1[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve1[3];
                                Coins.GoldCoin += Player1.CoinReserve1[3];
                            }
                        }

                        if (Player1.CoinReserve1[4] != 0) {
                            Player1.CoinReserve1[4] -= Player1.SpecialBlackCoin;
                            if (Player1.BlackCoin - Player1.CoinReserve1[4] >= 0) {
                                Player1.BlackCoin -= Player1.CoinReserve1[4];
                                Coins.BlackCoin += Player1.CoinReserve1[4];
                            } else {
                                Player1.CoinReserve1[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve1[4];
                                Coins.GoldCoin += Player1.CoinReserve1[4];
                            }
                        }

                        Player1.Score += Player1.ScoreReserve1;

                        if (Player1.SpecialCoinReserve1 == "Blue")
                            Player1.SpecialBlueCoin++;
                        else if (Player1.SpecialCoinReserve1 == "Red")
                            Player1.SpecialRedCoin++;
                        else if (Player1.SpecialCoinReserve1 == "Green")
                            Player1.SpecialGreenCoin++;
                        else if (Player1.SpecialCoinReserve1 == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialBlackCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15) {
                            showMessageDialog(null, "PLAYER ONE WON!");
                            System.exit(0);
                        }
                    }
                }
            }
        });
        Player1.ReserveCard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PlayerTurn || Player1.SpecialCoinReserve2 == null) {
                    showMessageDialog(null, "you can't buy this card");
                }
                else {
                    boolean sw = true;
                    int CountGoldCoin = 0;
                    if (Player1.CoinReserve2[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Player1.CoinReserve2[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Player1.CoinReserve2[0] &&
                                Player1.RedCoin + Player1.SpecialRedCoin < Player1.CoinReserve2[0]) {
                            CountGoldCoin += (Player1.CoinReserve2[0] - (Player1.RedCoin + Player1.SpecialRedCoin));
                        }
                    }

                    if (Player1.CoinReserve2[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Player1.CoinReserve2[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Player1.CoinReserve2[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Player1.CoinReserve2[1]) {
                            CountGoldCoin += (Player1.CoinReserve2[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Player1.CoinReserve2[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Player1.CoinReserve2[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Player1.CoinReserve2[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin < Player1.CoinReserve2[2]) {
                            CountGoldCoin += (Player1.CoinReserve2[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Player1.CoinReserve2[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Player1.CoinReserve2[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Player1.CoinReserve2[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Player1.CoinReserve2[3]) {
                            CountGoldCoin += (Player1.CoinReserve2[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin));
                        }
                    }

                    if (Player1.CoinReserve2[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Player1.CoinReserve2[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin >= Player1.CoinReserve2[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Player1.CoinReserve2[4]) {
                            CountGoldCoin += (Player1.CoinReserve2[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoin > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    } else {
                        if (Player1.CoinReserve2[0] != 0) {
                            Player1.CoinReserve2[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Player1.CoinReserve2[0] >= 0) {
                                Player1.RedCoin -= Player1.CoinReserve2[0];
                                Coins.RedCoin += Player1.CoinReserve2[0];
                            } else {
                                Player1.CoinReserve2[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve2[0];
                                Coins.GoldCoin += Player1.CoinReserve2[0];
                            }
                        }

                        if (Player1.CoinReserve2[1] != 0) {
                            Player1.CoinReserve2[1] -= Player1.SpecialBlueCoin;
                            if (Player1.BlueCoin - Player1.CoinReserve2[1] >= 0) {
                                Player1.BlueCoin -= Player1.CoinReserve2[1];
                                Coins.BlueCoin += Player1.CoinReserve2[1];
                            } else {
                                Player1.CoinReserve2[1] -= Player1.BlueCoin;
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve2[1];
                                Coins.GoldCoin += Player1.CoinReserve2[1];
                            }
                        }

                        if (Player1.CoinReserve2[2] != 0) {
                            Player1.CoinReserve2[2] -= Player1.SpecialWhiteCoin;
                            if (Player1.WhiteCoin - Player1.CoinReserve2[2] >= 0) {
                                Player1.WhiteCoin -= Player1.CoinReserve2[2];
                                Coins.WhiteCoin += Player1.CoinReserve2[2];
                            } else {
                                Player1.CoinReserve2[2] -= Player1.WhiteCoin;
                                Coins.WhiteCoin += Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve2[2];
                                Coins.GoldCoin += Player1.CoinReserve2[2];
                            }

                        }

                        if (Player1.CoinReserve2[3] != 0) {
                            Player1.CoinReserve2[3] -= Player1.SpecialGreenCoin;
                            if (Player1.GreenCoin - Player1.CoinReserve2[3] >= 0) {
                                Player1.GreenCoin -= Player1.CoinReserve2[3];
                                Coins.GreenCoin += Player1.CoinReserve2[3];
                            } else {
                                Player1.CoinReserve2[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve2[3];
                                Coins.GoldCoin += Player1.CoinReserve2[3];
                            }
                        }

                        if (Player1.CoinReserve2[4] != 0) {
                            Player1.CoinReserve2[4] -= Player1.SpecialBlackCoin;
                            if (Player1.BlackCoin - Player1.CoinReserve2[4] >= 0) {
                                Player1.BlackCoin -= Player1.CoinReserve2[4];
                                Coins.BlackCoin += Player1.CoinReserve2[4];
                            } else {
                                Player1.CoinReserve2[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve2[4];
                                Coins.GoldCoin += Player1.CoinReserve2[4];
                            }
                        }

                        Player1.Score += Player1.ScoreReserve2;

                        if (Player1.SpecialCoinReserve2 == "Blue")
                            Player1.SpecialBlueCoin++;
                        else if (Player1.SpecialCoinReserve2 == "Red")
                            Player1.SpecialRedCoin++;
                        else if (Player1.SpecialCoinReserve2 == "Green")
                            Player1.SpecialGreenCoin++;
                        else if (Player1.SpecialCoinReserve2 == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialBlackCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15) {
                            showMessageDialog(null, "PLAYER ONE WON!");
                            System.exit(0);
                        }
                    }
                }
            }
        });
        Player1.ReserveCard3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PlayerTurn || Player1.SpecialCoinReserve3 == null) {
                    showMessageDialog(null, "you can't buy this card");
                }
                else {
                    boolean sw = true;
                    int CountGoldCoin = 0;
                    if (Player1.CoinReserve3[0] != 0) {
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin < Player1.CoinReserve3[0]) {
                            sw = false;
                        }
                        if (Player1.RedCoin + Player1.SpecialGoldCoin + Player1.SpecialRedCoin >= Player1.CoinReserve3[0] &&
                                Player1.RedCoin + Player1.SpecialRedCoin < Player1.CoinReserve3[0]) {
                            CountGoldCoin += (Player1.CoinReserve3[0] - (Player1.RedCoin + Player1.SpecialRedCoin));
                        }
                    }

                    if (Player1.CoinReserve3[1] != 0) {
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin < Player1.CoinReserve3[1]) {
                            sw = false;
                        }
                        if (Player1.BlueCoin + Player1.SpecialGoldCoin + Player1.SpecialBlueCoin >= Player1.CoinReserve3[1] &&
                                Player1.BlueCoin + Player1.SpecialBlueCoin < Player1.CoinReserve3[1]) {
                            CountGoldCoin += (Player1.CoinReserve3[1] - (Player1.BlueCoin + Player1.SpecialBlueCoin));
                        }
                    }

                    if (Player1.CoinReserve3[2] != 0) {
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin < Player1.CoinReserve3[2]) {
                            sw = false;
                        }
                        if (Player1.WhiteCoin + Player1.SpecialGoldCoin + Player1.SpecialWhiteCoin >= Player1.CoinReserve3[2] &&
                                Player1.WhiteCoin + Player1.SpecialWhiteCoin < Player1.CoinReserve3[2]) {
                            CountGoldCoin += (Player1.CoinReserve3[2] - (Player1.WhiteCoin + Player1.SpecialWhiteCoin));
                        }
                    }

                    if (Player1.CoinReserve3[3] != 0) {
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin < Player1.CoinReserve3[3]) {
                            sw = false;
                        }
                        if (Player1.GreenCoin + Player1.SpecialGoldCoin + Player1.SpecialGreenCoin >= Player1.CoinReserve3[3] &&
                                Player1.GreenCoin + Player1.SpecialGreenCoin < Player1.CoinReserve3[3]) {
                            CountGoldCoin += (Player1.CoinReserve3[3] - (Player1.GreenCoin + Player1.SpecialGreenCoin));
                        }
                    }

                    if (Player1.CoinReserve3[4] != 0) {
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin < Player1.CoinReserve3[4]) {
                            sw = false;
                        }
                        if (Player1.BlackCoin + Player1.SpecialGoldCoin + Player1.SpecialBlackCoin >= Player1.CoinReserve3[4] &&
                                Player1.BlackCoin + Player1.SpecialBlackCoin < Player1.CoinReserve3[4]) {
                            CountGoldCoin += (Player1.CoinReserve3[4] - (Player1.BlackCoin + Player1.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoin > Player1.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    } else {
                        if (Player1.CoinReserve3[0] != 0) {
                            Player1.CoinReserve3[0] -= Player1.SpecialRedCoin;
                            if (Player1.RedCoin - Player1.CoinReserve3[0] >= 0) {
                                Player1.RedCoin -= Player1.CoinReserve3[0];
                                Coins.RedCoin += Player1.CoinReserve3[0];
                            } else {
                                Player1.CoinReserve3[0] -= Player1.RedCoin;
                                Coins.RedCoin += Player1.RedCoin;
                                Player1.RedCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve3[0];
                                Coins.GoldCoin += Player1.CoinReserve3[0];
                            }
                        }

                        if (Player1.CoinReserve3[1] != 0) {
                            Player1.CoinReserve3[1] -= Player1.SpecialBlueCoin;
                            if (Player1.BlueCoin - Player1.CoinReserve3[1] >= 0) {
                                Player1.BlueCoin -= Player1.CoinReserve3[1];
                                Coins.BlueCoin += Player1.CoinReserve3[1];
                            } else {
                                Player1.CoinReserve3[1] -= Player1.BlueCoin;
                                Coins.BlueCoin += Player1.BlueCoin;
                                Player1.BlueCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve3[1];
                                Coins.GoldCoin += Player1.CoinReserve3[1];
                            }
                        }

                        if (Player1.CoinReserve3[2] != 0) {
                            Player1.CoinReserve3[2] -= Player1.SpecialWhiteCoin;
                            if (Player1.WhiteCoin - Player1.CoinReserve3[2] >= 0) {
                                Player1.WhiteCoin -= Player1.CoinReserve3[2];
                                Coins.WhiteCoin += Player1.CoinReserve3[2];
                            } else {
                                Player1.CoinReserve3[2] -= Player1.WhiteCoin;
                                Player1.WhiteCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve3[2];
                                Coins.GoldCoin += Player1.CoinReserve3[2];
                            }

                        }

                        if (Player1.CoinReserve3[3] != 0) {
                            Player1.CoinReserve3[3] -= Player1.SpecialGreenCoin;
                            if (Player1.GreenCoin - Player1.CoinReserve3[3] >= 0) {
                                Player1.GreenCoin -= Player1.CoinReserve3[3];
                                Coins.GreenCoin = Player1.CoinReserve3[3];
                            } else {
                                Player1.CoinReserve3[3] -= Player1.GreenCoin;
                                Coins.GreenCoin += Player1.GreenCoin;
                                Player1.GreenCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve3[3];
                                Coins.GoldCoin += Player1.CoinReserve3[3];
                            }
                        }

                        if (Player1.CoinReserve3[4] != 0) {
                            Player1.CoinReserve3[4] -= Player1.SpecialBlackCoin;
                            if (Player1.BlackCoin - Player1.CoinReserve3[4] >= 0) {
                                Player1.BlackCoin -= Player1.CoinReserve3[4];
                                Coins.BlackCoin += Player1.CoinReserve3[4];
                            } else {
                                Player1.CoinReserve3[4] -= Player1.BlackCoin;
                                Coins.BlackCoin += Player1.BlackCoin;
                                Player1.BlackCoin = 0;
                                Player1.SpecialGoldCoin -= Player1.CoinReserve3[4];
                                Coins.GoldCoin += Player1.CoinReserve3[4];
                            }
                        }

                        Player1.Score += Player1.ScoreReserve3;

                        if (Player1.SpecialCoinReserve3 == "Blue")
                            Player1.SpecialBlueCoin++;
                        else if (Player1.SpecialCoinReserve3 == "Red")
                            Player1.SpecialRedCoin++;
                        else if (Player1.SpecialCoinReserve3 == "Green")
                            Player1.SpecialGreenCoin++;
                        else if (Player1.SpecialCoinReserve3 == "White")
                            Player1.SpecialWhiteCoin++;
                        else
                            Player1.SpecialBlackCoin++;

                        Player1Score.setText(String.valueOf(Player1.Score));
                        Player1CoinCounter.setText("red = " + Player1.RedCoin + ",green = " + Player1.GreenCoin + ",blue = "
                                + Player1.BlueCoin + ",white = " + Player1.WhiteCoin + ",black = " + Player1.BlackCoin);
                        Player1SpecialCoinCounter.setText("red = " + Player1.SpecialRedCoin + ",green = " + Player1.SpecialGreenCoin + ",blue = "
                                + Player1.SpecialBlueCoin + ",white = " + Player1.SpecialWhiteCoin + ",black = " + Player1.SpecialBlackCoin +
                                ",gold = " + Player1.SpecialGoldCoin);

                        if (Player1.Score >= 15) {
                            showMessageDialog(null, "PLAYER ONE WON!");
                            System.exit(0);
                        }
                    }
                }
            }
        });


        Player1Table.add(player1);
        Player1Table.add(Score1);
        Player1Table.add(Player1Score);
        Player1Table.add(Coins1 );
        Player1Table.add(Player1CoinCounter );
        Player1Table.add(SpecialCoins1 );
        Player1Table.add(Player1SpecialCoinCounter);
        Player1Table.add(ReserveCards1);
        Player1Table.add(PlayerOneReserveCards);

        CenterPanel.add(Player1Table , BorderLayout.NORTH);



            JPanel Player2Table = new JPanel();
        Player2Table.setLayout(new GridLayout(9,1));
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

            JLabel ReserveCards2 = new JLabel("RESERVE CARDS");
        ReserveCards2.setFont(defaultFont);
        ReserveCards2.setPreferredSize(new Dimension(200, 30));
        ReserveCards2.setHorizontalAlignment(JLabel.CENTER);
        ReserveCards2.setOpaque(true);
        ReserveCards2.setBackground(Color.LIGHT_GRAY);



        Player2CoinCounter.setFont(defaultFont2);
        Player2CoinCounter.setPreferredSize(new Dimension(200, 30));
        Player2CoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player2CoinCounter.setOpaque(true);
        Player2CoinCounter.setBackground(Color.WHITE);


        Player2SpecialCoinCounter.setFont(defaultFont2);
        Player2SpecialCoinCounter.setPreferredSize(new Dimension(200, 30));
        Player2SpecialCoinCounter.setHorizontalAlignment(JLabel.CENTER);
        Player2SpecialCoinCounter.setOpaque(true);
        Player2SpecialCoinCounter.setBackground(Color.WHITE);



        Player2Score.setHorizontalAlignment(JLabel.CENTER);
        Player2Score.setPreferredSize(new Dimension(200, 30));
        Player2Score.setOpaque(true);
        Player2Score.setBackground(Color.WHITE);


            JPanel PlayerTwoReserveCards = new JPanel(new FlowLayout());
        PlayerTwoReserveCards.add(Player2.ReserveCard1);
        PlayerTwoReserveCards.add(Player2.ReserveCard2);
        PlayerTwoReserveCards.add(Player2.ReserveCard3);

        Player2.ReserveCard1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (PlayerTurn || Player2.SpecialCoinReserve1 == null) {
                        showMessageDialog(null, "you can't buy this card");
                    }
                    else {
                        boolean sw = true;
                        int CountGoldCoin = 0;
                        if (Player2.CoinReserve1[0] != 0) {
                            if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Player2.CoinReserve1[0]) {
                                sw = false;
                            }
                            if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Player2.CoinReserve1[0] &&
                                    Player2.RedCoin + Player2.SpecialRedCoin < Player2.CoinReserve1[0]) {
                                CountGoldCoin += (Player2.CoinReserve1[0] - (Player2.RedCoin + Player2.SpecialRedCoin));
                            }
                        }

                        if (Player2.CoinReserve1[1] != 0) {
                            if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Player2.CoinReserve1[1]) {
                                sw = false;
                            }
                            if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Player2.CoinReserve1[1] &&
                                    Player2.BlueCoin + Player2.SpecialBlueCoin < Player2.CoinReserve1[1]) {
                                CountGoldCoin += (Player2.CoinReserve1[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                            }
                        }

                        if (Player2.CoinReserve1[2] != 0) {
                            if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Player2.CoinReserve1[2]) {
                                sw = false;
                            }
                            if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Player2.CoinReserve1[2] &&
                                    Player2.WhiteCoin + Player2.SpecialWhiteCoin < Player2.CoinReserve1[2]) {
                                CountGoldCoin += (Player2.CoinReserve1[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                            }
                        }

                        if (Player2.CoinReserve1[3] != 0) {
                            if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Player2.CoinReserve1[3]) {
                                sw = false;
                            }
                            if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Player2.CoinReserve1[3] &&
                                    Player2.GreenCoin + Player2.SpecialGreenCoin < Player2.CoinReserve1[3]) {
                                CountGoldCoin += (Player2.CoinReserve1[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin));
                            }
                        }

                        if (Player2.CoinReserve1[4] != 0) {
                            if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Player2.CoinReserve1[4]) {
                                sw = false;
                            }
                            if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin >= Player2.CoinReserve1[4] &&
                                    Player2.BlackCoin + Player2.SpecialBlackCoin < Player2.CoinReserve1[4]) {
                                CountGoldCoin += (Player2.CoinReserve1[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                            }
                        }


                        if (!sw || CountGoldCoin > Player2.SpecialGoldCoin) {
                            showMessageDialog(null, "you can't buy this card");
                        } else {
                            if (Player2.CoinReserve1[0] != 0) {
                                Player2.CoinReserve1[0] -= Player2.SpecialRedCoin;
                                if (Player2.RedCoin - Player2.CoinReserve1[0] >= 0) {
                                    Player2.RedCoin -= Player2.CoinReserve1[0];
                                    Coins.RedCoin += Player2.CoinReserve1[0];
                                } else {
                                    Player2.CoinReserve1[0] -= Player2.RedCoin;
                                    Coins.RedCoin += Player2.RedCoin;
                                    Player2.RedCoin = 0;
                                    Player2.SpecialGoldCoin -= Player2.CoinReserve1[0];
                                    Coins.GoldCoin += Player2.CoinReserve1[0];
                                }
                            }

                            if (Player2.CoinReserve1[1] != 0) {
                                Player2.CoinReserve1[1] -= Player2.SpecialBlueCoin;
                                if (Player2.BlueCoin - Player2.CoinReserve1[1] >= 0) {
                                    Player2.BlueCoin -= Player2.CoinReserve1[1];
                                    Coins.BlueCoin += Player2.CoinReserve1[1];
                                } else {
                                    Player2.CoinReserve1[1] -= Player2.BlueCoin;
                                    Coins.BlueCoin += Player2.BlueCoin;
                                    Player2.BlueCoin = 0;
                                    Player2.SpecialGoldCoin -= Player2.CoinReserve1[1];
                                    Coins.GoldCoin += Player2.CoinReserve1[1];
                                }
                            }

                            if (Player2.CoinReserve1[2] != 0) {
                                Player2.CoinReserve1[2] -= Player2.SpecialWhiteCoin;
                                if (Player2.WhiteCoin - Player2.CoinReserve1[2] >= 0) {
                                    Player2.WhiteCoin -= Player2.CoinReserve1[2];
                                    Coins.WhiteCoin += Player2.CoinReserve1[2];
                                } else {
                                    Player2.CoinReserve1[2] -= Player2.WhiteCoin;
                                    Coins.WhiteCoin += Player2.WhiteCoin;
                                    Player2.WhiteCoin = 0;
                                    Player2.SpecialGoldCoin -= Player2.CoinReserve1[2];
                                    Coins.GoldCoin += Player2.CoinReserve1[2];
                                }

                            }

                            if (Player2.CoinReserve1[3] != 0) {
                                Player2.CoinReserve1[3] -= Player2.SpecialGreenCoin;
                                if (Player2.GreenCoin - Player2.CoinReserve1[3] >= 0) {
                                    Player2.GreenCoin -= Player2.CoinReserve1[3];
                                    Coins.GreenCoin += Player2.CoinReserve1[3];
                                } else {
                                    Player2.CoinReserve1[3] -= Player2.GreenCoin;
                                    Coins.GreenCoin += Player2.GreenCoin;
                                    Player2.GreenCoin = 0;
                                    Player2.SpecialGoldCoin -= Player2.CoinReserve1[3];
                                    Coins.GoldCoin += Player2.CoinReserve1[3];
                                }
                            }

                            if (Player2.CoinReserve1[4] != 0) {
                                Player2.CoinReserve1[4] -= Player2.SpecialBlackCoin;
                                if (Player2.BlackCoin - Player2.CoinReserve1[4] >= 0) {
                                    Player2.BlackCoin -= Player2.CoinReserve1[4];
                                    Coins.BlackCoin += Player2.CoinReserve1[4];
                                } else {
                                    Player2.CoinReserve1[4] -= Player2.BlackCoin;
                                    Coins.BlackCoin += Player2.BlackCoin;
                                    Player2.BlackCoin = 0;
                                    Player2.SpecialGoldCoin -= Player2.CoinReserve1[4];
                                    Coins.GoldCoin += Player2.CoinReserve1[4];
                                }
                            }

                            Player2.Score += Player2.ScoreReserve1;

                            if (Player2.SpecialCoinReserve1 == "Blue")
                                Player2.SpecialBlueCoin++;
                            else if (Player2.SpecialCoinReserve1 == "Red")
                                Player2.SpecialRedCoin++;
                            else if (Player2.SpecialCoinReserve1 == "Green")
                                Player2.SpecialGreenCoin++;
                            else if (Player2.SpecialCoinReserve1 == "White")
                                Player2.SpecialWhiteCoin++;
                            else
                                Player2.SpecialBlackCoin++;

                            Player2Score.setText(String.valueOf(Player2.Score));
                            Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                    + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                            Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                    + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                    ",gold = " + Player2.SpecialGoldCoin);

                            if (Player2.Score >= 15) {
                                showMessageDialog(null, "PLAYER ONE WON!");
                                System.exit(0);
                            }
                        }
                    }
                }
        });
        Player2.ReserveCard2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn || Player2.SpecialCoinReserve2 == null) {
                    showMessageDialog(null, "you can't buy this card");
                }
                else {
                    boolean sw = true;
                    int CountGoldCoin = 0;
                    if (Player2.CoinReserve2[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Player2.CoinReserve2[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Player2.CoinReserve2[0] &&
                                Player2.RedCoin + Player2.SpecialRedCoin < Player2.CoinReserve2[0]) {
                            CountGoldCoin += (Player2.CoinReserve2[0] - (Player2.RedCoin + Player2.SpecialRedCoin));
                        }
                    }

                    if (Player2.CoinReserve2[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Player2.CoinReserve2[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Player2.CoinReserve2[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Player2.CoinReserve2[1]) {
                            CountGoldCoin += (Player2.CoinReserve2[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Player2.CoinReserve2[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Player2.CoinReserve2[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Player2.CoinReserve2[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin < Player2.CoinReserve2[2]) {
                            CountGoldCoin += (Player2.CoinReserve2[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Player2.CoinReserve2[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Player2.CoinReserve2[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Player2.CoinReserve2[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Player2.CoinReserve2[3]) {
                            CountGoldCoin += (Player2.CoinReserve2[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin));
                        }
                    }

                    if (Player2.CoinReserve2[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Player2.CoinReserve2[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin >= Player2.CoinReserve2[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Player2.CoinReserve2[4]) {
                            CountGoldCoin += (Player2.CoinReserve2[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoin > Player2.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    } else {
                        if (Player2.CoinReserve2[0] != 0) {
                            Player2.CoinReserve2[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Player2.CoinReserve2[0] >= 0) {
                                Player2.RedCoin -= Player2.CoinReserve2[0];
                                Coins.RedCoin += Player2.CoinReserve2[0];
                            } else {
                                Player2.CoinReserve2[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve2[0];
                                Coins.GoldCoin += Player2.CoinReserve2[0];
                            }
                        }

                        if (Player2.CoinReserve2[1] != 0) {
                            Player2.CoinReserve2[1] -= Player2.SpecialBlueCoin;
                            if (Player2.BlueCoin - Player2.CoinReserve2[1] >= 0) {
                                Player2.BlueCoin -= Player2.CoinReserve2[1];
                                Coins.BlueCoin += Player2.CoinReserve2[1];
                            } else {
                                Player2.CoinReserve2[1] -= Player2.BlueCoin;
                                Coins.BlueCoin += Player2.BlueCoin;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve2[1];
                                Coins.GoldCoin += Player2.CoinReserve2[1];
                            }
                        }

                        if (Player2.CoinReserve2[2] != 0) {
                            Player2.CoinReserve2[2] -= Player2.SpecialWhiteCoin;
                            if (Player2.WhiteCoin - Player2.CoinReserve2[2] >= 0) {
                                Player2.WhiteCoin -= Player2.CoinReserve2[2];
                                Coins.WhiteCoin += Player2.CoinReserve2[2];
                            } else {
                                Player2.CoinReserve2[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve2[2];
                                Coins.GoldCoin += Player2.CoinReserve2[2];
                            }

                        }

                        if (Player2.CoinReserve2[3] != 0) {
                            Player2.CoinReserve2[3] -= Player2.SpecialGreenCoin;
                            if (Player2.GreenCoin - Player2.CoinReserve2[3] >= 0) {
                                Player2.GreenCoin -= Player2.CoinReserve2[3];
                                Coins.GreenCoin += Player2.CoinReserve2[3];
                            } else {
                                Player2.CoinReserve2[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve2[3];
                                Coins.GoldCoin += Player2.CoinReserve2[3];
                            }
                        }

                        if (Player2.CoinReserve2[4] != 0) {
                            Player2.CoinReserve2[4] -= Player2.SpecialBlackCoin;
                            if (Player2.BlackCoin - Player2.CoinReserve2[4] >= 0) {
                                Player2.BlackCoin -= Player2.CoinReserve2[4];
                                Coins.BlackCoin += Player2.CoinReserve2[4];
                            } else {
                                Player2.CoinReserve2[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve2[4];
                                Coins.GoldCoin += Player2.CoinReserve2[4];
                            }
                        }

                        Player2.Score += Player2.ScoreReserve2;

                        if (Player2.SpecialCoinReserve2 == "Blue")
                            Player2.SpecialBlueCoin++;
                        else if (Player2.SpecialCoinReserve2 == "Red")
                            Player2.SpecialRedCoin++;
                        else if (Player2.SpecialCoinReserve2 == "Green")
                            Player2.SpecialGreenCoin++;
                        else if (Player2.SpecialCoinReserve2 == "White")
                            Player2.SpecialWhiteCoin++;
                        else
                            Player2.SpecialBlackCoin++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15) {
                            showMessageDialog(null, "PLAYER ONE WON!");
                            System.exit(0);
                        }
                    }
                }
            }
        });
        Player2.ReserveCard3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PlayerTurn || Player2.SpecialCoinReserve3 == null) {
                    showMessageDialog(null, "you can't buy this card");
                }
                else {
                    boolean sw = true;
                    int CountGoldCoin = 0;
                    if (Player2.CoinReserve3[0] != 0) {
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin < Player2.CoinReserve3[0]) {
                            sw = false;
                        }
                        if (Player2.RedCoin + Player2.SpecialGoldCoin + Player2.SpecialRedCoin >= Player2.CoinReserve3[0] &&
                                Player2.RedCoin + Player2.SpecialRedCoin < Player2.CoinReserve3[0]) {
                            CountGoldCoin += (Player2.CoinReserve3[0] - (Player2.RedCoin + Player2.SpecialRedCoin));
                        }
                    }

                    if (Player2.CoinReserve3[1] != 0) {
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin < Player2.CoinReserve3[1]) {
                            sw = false;
                        }
                        if (Player2.BlueCoin + Player2.SpecialGoldCoin + Player2.SpecialBlueCoin >= Player2.CoinReserve3[1] &&
                                Player2.BlueCoin + Player2.SpecialBlueCoin < Player2.CoinReserve3[1]) {
                            CountGoldCoin += (Player2.CoinReserve3[1] - (Player2.BlueCoin + Player2.SpecialBlueCoin));
                        }
                    }

                    if (Player2.CoinReserve3[2] != 0) {
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin < Player2.CoinReserve3[2]) {
                            sw = false;
                        }
                        if (Player2.WhiteCoin + Player2.SpecialGoldCoin + Player2.SpecialWhiteCoin >= Player2.CoinReserve3[2] &&
                                Player2.WhiteCoin + Player2.SpecialWhiteCoin < Player2.CoinReserve3[2]) {
                            CountGoldCoin += (Player2.CoinReserve3[2] - (Player2.WhiteCoin + Player2.SpecialWhiteCoin));
                        }
                    }

                    if (Player2.CoinReserve3[3] != 0) {
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin < Player2.CoinReserve3[3]) {
                            sw = false;
                        }
                        if (Player2.GreenCoin + Player2.SpecialGoldCoin + Player2.SpecialGreenCoin >= Player2.CoinReserve3[3] &&
                                Player2.GreenCoin + Player2.SpecialGreenCoin < Player2.CoinReserve3[3]) {
                            CountGoldCoin += (Player2.CoinReserve3[3] - (Player2.GreenCoin + Player2.SpecialGreenCoin));
                        }
                    }

                    if (Player2.CoinReserve3[4] != 0) {
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin < Player2.CoinReserve3[4]) {
                            sw = false;
                        }
                        if (Player2.BlackCoin + Player2.SpecialGoldCoin + Player2.SpecialBlackCoin >= Player2.CoinReserve3[4] &&
                                Player2.BlackCoin + Player2.SpecialBlackCoin < Player2.CoinReserve3[4]) {
                            CountGoldCoin += (Player2.CoinReserve3[4] - (Player2.BlackCoin + Player2.SpecialBlackCoin));
                        }
                    }


                    if (!sw || CountGoldCoin > Player2.SpecialGoldCoin) {
                        showMessageDialog(null, "you can't buy this card");
                    } else {
                        if (Player2.CoinReserve3[0] != 0) {
                            Player2.CoinReserve3[0] -= Player2.SpecialRedCoin;
                            if (Player2.RedCoin - Player2.CoinReserve3[0] >= 0) {
                                Player2.RedCoin -= Player2.CoinReserve3[0];
                                Coins.RedCoin += Player2.CoinReserve3[0];
                            } else {
                                Player2.CoinReserve3[0] -= Player2.RedCoin;
                                Coins.RedCoin += Player2.RedCoin;
                                Player2.RedCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve3[0];
                                Coins.GoldCoin += Player2.CoinReserve3[0];
                            }
                        }

                        if (Player2.CoinReserve3[1] != 0) {
                            Player2.CoinReserve3[1] -= Player2.SpecialBlueCoin;
                            if (Player2.BlueCoin - Player2.CoinReserve3[1] >= 0) {
                                Player2.BlueCoin -= Player2.CoinReserve3[1];
                                Coins.BlueCoin += Player2.CoinReserve3[1];
                            } else {
                                Player2.CoinReserve3[1] -= Player2.BlueCoin;
                                Coins.BlueCoin += Player2.BlueCoin;
                                Player2.BlueCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve3[1];
                                Coins.GoldCoin += Player2.CoinReserve3[1];
                            }
                        }

                        if (Player2.CoinReserve3[2] != 0) {
                            Player2.CoinReserve3[2] -= Player2.SpecialWhiteCoin;
                            if (Player2.WhiteCoin - Player2.CoinReserve3[2] >= 0) {
                                Player2.WhiteCoin -= Player2.CoinReserve3[2];
                                Coins.WhiteCoin += Player2.CoinReserve3[2];
                            } else {
                                Player2.CoinReserve3[2] -= Player2.WhiteCoin;
                                Coins.WhiteCoin += Player2.WhiteCoin;
                                Player2.WhiteCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve3[2];
                                Coins.GoldCoin += Player2.CoinReserve3[2];
                            }

                        }

                        if (Player2.CoinReserve3[3] != 0) {
                            Player2.CoinReserve3[3] -= Player2.SpecialGreenCoin;
                            if (Player2.GreenCoin - Player2.CoinReserve3[3] >= 0) {
                                Player2.GreenCoin -= Player2.CoinReserve3[3];
                                Coins.GreenCoin += Player2.CoinReserve3[3];
                            } else {
                                Player2.CoinReserve3[3] -= Player2.GreenCoin;
                                Coins.GreenCoin += Player2.GreenCoin;
                                Player2.GreenCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve3[3];
                                Coins.GoldCoin += Player2.CoinReserve3[3];
                            }
                        }

                        if (Player2.CoinReserve3[4] != 0) {
                            Player2.CoinReserve3[4] -= Player2.SpecialBlackCoin;
                            if (Player2.BlackCoin - Player2.CoinReserve3[4] >= 0) {
                                Player2.BlackCoin -= Player2.CoinReserve3[4];
                                Coins.BlackCoin += Player2.CoinReserve3[4];
                            } else {
                                Player2.CoinReserve3[4] -= Player2.BlackCoin;
                                Coins.BlackCoin += Player2.BlackCoin;
                                Player2.BlackCoin = 0;
                                Player2.SpecialGoldCoin -= Player2.CoinReserve3[4];
                                Coins.GoldCoin += Player2.CoinReserve3[4];
                            }
                        }

                        Player2.Score += Player2.ScoreReserve3;

                        if (Player2.SpecialCoinReserve3 == "Blue")
                            Player2.SpecialBlueCoin++;
                        else if (Player2.SpecialCoinReserve3 == "Red")
                            Player2.SpecialRedCoin++;
                        else if (Player2.SpecialCoinReserve3 == "Green")
                            Player2.SpecialGreenCoin++;
                        else if (Player2.SpecialCoinReserve3 == "White")
                            Player2.SpecialWhiteCoin++;
                        else
                            Player2.SpecialBlackCoin++;

                        Player2Score.setText(String.valueOf(Player2.Score));
                        Player2CoinCounter.setText("red = " + Player2.RedCoin + ",green = " + Player2.GreenCoin + ",blue = "
                                + Player2.BlueCoin + ",white = " + Player2.WhiteCoin + ",black = " + Player2.BlackCoin);
                        Player2SpecialCoinCounter.setText("red = " + Player2.SpecialRedCoin + ",green = " + Player2.SpecialGreenCoin + ",blue = "
                                + Player2.SpecialBlueCoin + ",white = " + Player2.SpecialWhiteCoin + ",black = " + Player2.SpecialBlackCoin +
                                ",gold = " + Player2.SpecialGoldCoin);

                        if (Player2.Score >= 15) {
                            showMessageDialog(null, "PLAYER ONE WON!");
                            System.exit(0);
                        }
                    }
                }
            }
        });



        Player2Table.add(player2);
        Player2Table.add(Score2);
        Player2Table.add(Player2Score);
        Player2Table.add(Coins2);
        Player2Table.add(Player2CoinCounter);
        Player2Table.add(SpecialCoins2);
        Player2Table.add(Player2SpecialCoinCounter);
        Player2Table.add(ReserveCards2);
        Player2Table.add(PlayerTwoReserveCards);

        CenterPanel.add(Player2Table , BorderLayout.SOUTH);

            add(CenterPanel , BorderLayout.CENTER);
            setVisible(true);



        }

        public static void main(String[] args) {
            new Main ();



        }
    }


