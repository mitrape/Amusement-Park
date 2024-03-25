package CardsPackage;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class FirstLevelCards {
    public final String [][]  ColorOfCoinFirst  = {{"RED","BLUE"},{"BLACK","WHITE"},{"GREEN","BLUE"},{"WHITE","RED"},{"GREEN","BLACK"},{"RED","BLUE"},
            {"BLUE","GREEN"},{"RED","BLUE"},{"BLACK","WHITE"},{"GREEN","BLUE"},{"WHITE","RED"},{"GREEN","BLACK"},{"RED","BLUE"},{"BLUE","GREEN"},{"BLUE","WHITE"}};

    public final int [][] CountOfCoinFirst = {{2,2},{3,2},{2,3},{1,3},{3,1},{1,4},{4,1},{2,4},{4,2},{3,3},{2,2},{3,2},{2,3},{1,3},{3,1}};

    public final int [] Score = {0,1,1,0,0,0,0,1,0,1,0,1,1,1,1};
    public int  [] ColorAndCountFirst = new int [5]; // red = 0 , blue = 1 , white = 2 , green = 3 , black = 4
    public int ScoreFirst ;
    public String CardFirst ;
    public String ColorSpecialCoinFirst; // for odd numbers is Green and for even numbers is blue
    public static int CountFirst = 0;
    public static int CounterFirst1,CounterFirst2, CounterFirst3, CounterFirst4 ;

    public FirstLevelCards (){
        if ( ColorOfCoinFirst [CountFirst][0] == "RED") {
            ColorAndCountFirst[0] = CountOfCoinFirst[CountFirst][0];
            CardFirst ="RED="+ColorAndCountFirst[0]+",";
        }
        else if ( ColorOfCoinFirst [CountFirst][0] == "BLUE") {
            ColorAndCountFirst[1] = CountOfCoinFirst[CountFirst][0];
            CardFirst ="BLUE="+ColorAndCountFirst[1]+",";
        }
        else if ( ColorOfCoinFirst [CountFirst][0] == "WHITE") {
            ColorAndCountFirst[2] = CountOfCoinFirst[CountFirst][0];
            CardFirst ="WHITE="+ColorAndCountFirst[2]+",";
        }
        else if ( ColorOfCoinFirst [CountFirst][0] == "GREEN") {
            ColorAndCountFirst[3] = CountOfCoinFirst[CountFirst][0];
            CardFirst ="GREEN="+ColorAndCountFirst[3]+",";
        }
        else {
            ColorAndCountFirst[4] = CountOfCoinFirst[CountFirst][0];
            CardFirst ="BLACK="+ColorAndCountFirst[4]+",";
        }

        if ( ColorOfCoinFirst [CountFirst][1] == "RED") {
            ColorAndCountFirst[0] = CountOfCoinFirst[CountFirst][1];
            CardFirst=CardFirst+"RED="+ColorAndCountFirst[0];
        }
        else if ( ColorOfCoinFirst [CountFirst][1] == "BLUE") {
            ColorAndCountFirst[1] = CountOfCoinFirst[CountFirst][1];
            CardFirst=CardFirst+"BLUE="+ColorAndCountFirst[1];
        }
        else if ( ColorOfCoinFirst [CountFirst][1] == "WHITE") {
            ColorAndCountFirst[2] = CountOfCoinFirst[CountFirst][1];
            CardFirst=CardFirst+"WHITE="+ColorAndCountFirst[2];
        }
        else if ( ColorOfCoinFirst [CountFirst][1] == "GREEN") {
            ColorAndCountFirst[3] = CountOfCoinFirst[CountFirst][1];
            CardFirst=CardFirst+"GREEN="+ColorAndCountFirst[3];
        }
        else {
            ColorAndCountFirst[4] = CountOfCoinFirst[CountFirst][1];
            CardFirst=CardFirst+"BLACK="+ColorAndCountFirst[4];
        }

        this.ScoreFirst = this.Score [CountFirst];

        if (CountFirst % 2 == 0){
            this.ColorSpecialCoinFirst = "Blue";
        }
        else {
            this.ColorSpecialCoinFirst = "Green";
        }

        CountFirst ++ ;

    }

}
