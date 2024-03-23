import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main (){
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

        Icon GreenMachine = new ImageIcon("D:/programming projects/Amusement Park/image/GreenMachine.PNG");
        JButton GreenSlotMachine = new JButton(GreenMachine);
        GreenSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(GreenSlotMachine);


        Icon RedMachine = new ImageIcon("D:/programming projects/Amusement Park/image/RedMachine.PNG");
        JButton RedSlotMachine = new JButton(RedMachine);
        RedSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(RedSlotMachine);


        Icon BlueMachine = new ImageIcon("D:/programming projects/Amusement Park/image/BlueMachine.PNG");
        JButton BlueSlotMachine = new JButton(BlueMachine);
        BlueSlotMachine.setBackground(Color.WHITE);
        LeftPanel.add(BlueSlotMachine);


        add (LeftPanel , BorderLayout.PAGE_START);

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