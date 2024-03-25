package CardsPackage;
public class SecondLevelCards {

    public final String [][]  ColorOfCoinSecond  = {{"RED","BLUE"},{"BLACK","WHITE"},{"GREEN","BLUE"},{"RED","BLUE"},{"BLACK","WHITE"},{"GREEN","BLUE"},{"WHITE","RED"},
            {"WHITE","RED"},{"GREEN","BLACK"},{"RED","BLUE"},{"BLUE","GREEN"},{"GREEN","BLACK"},{"RED","BLUE"},{"BLUE","GREEN"},{"BLUE","WHITE"}};

    public final int [][] CountOfCoinSecond = {{2,4},{4,2},{3,3},{3,4},{4,3},{5,2},{2,5},{4,4},{5,3},{3,5},{2,6},{6,2},{2,4},{2,4},{3,4}};

    public final int [] Score = {2,3,4,2,4,2,3,2,4,3,3,2,4,2,3};
    public int  [] ColorAndCountSecond = new int [5]; // red = 0 , blue = 1 , white = 2 , green = 3 , black = 4
    public int ScoreSecond ;
    public String CardSecond ;
    public String ColorSpecialCoinSecond; // for odd numbers is Green and for even numbers is blue
    public static int CountSecond = 0;
    public static int CounterSecond1, CounterSecond2, CounterSecond3, CounterSecond4 ;

    public SecondLevelCards (){
        if ( ColorOfCoinSecond [CountSecond][0] == "RED") {
            ColorAndCountSecond[0] = CountOfCoinSecond[CountSecond][0];
            CardSecond ="RED="+ColorAndCountSecond[0]+",";
        }
        else if ( ColorOfCoinSecond [CountSecond][0] == "BLUE") {
            ColorAndCountSecond[1] = CountOfCoinSecond[CountSecond][0];
            CardSecond ="BLUE="+ColorAndCountSecond[1]+",";
        }
        else if ( ColorOfCoinSecond [CountSecond][0] == "WHITE") {
            ColorAndCountSecond[2] = CountOfCoinSecond[CountSecond][0];
            CardSecond ="WHITE="+ColorAndCountSecond[2]+",";
        }
        else if ( ColorOfCoinSecond [CountSecond][0] == "GREEN") {
            ColorAndCountSecond[3] = CountOfCoinSecond[CountSecond][0];
            CardSecond ="GREEN="+ColorAndCountSecond[3]+",";
        }
        else {
            ColorAndCountSecond[4] = CountOfCoinSecond[CountSecond][0];
            CardSecond ="BLACK="+ColorAndCountSecond[4]+",";
        }

        if ( ColorOfCoinSecond [CountSecond][1] == "RED") {
            ColorAndCountSecond[0] = CountOfCoinSecond[CountSecond][1];
            CardSecond=CardSecond+"RED="+ColorAndCountSecond[0];
        }
        else if ( ColorOfCoinSecond [CountSecond][1] == "BLUE") {
            ColorAndCountSecond[1] = CountOfCoinSecond[CountSecond][1];
            CardSecond=CardSecond+"BLUE="+ColorAndCountSecond[1];
        }
        else if ( ColorOfCoinSecond [CountSecond][1] == "WHITE") {
            ColorAndCountSecond[2] = CountOfCoinSecond[CountSecond][1];
            CardSecond=CardSecond+"WHITE="+ColorAndCountSecond[2];
        }
        else if ( ColorOfCoinSecond [CountSecond][1] == "GREEN") {
            ColorAndCountSecond[3] = CountOfCoinSecond[CountSecond][1];
            CardSecond=CardSecond+"GREEN="+ColorAndCountSecond[3];
        }
        else {
            ColorAndCountSecond[4] = CountOfCoinSecond[CountSecond][1];
            CardSecond=CardSecond+"BLACK="+ColorAndCountSecond[4];
        }



        this.ScoreSecond = this.Score [CountSecond];

        if (CountSecond % 2 == 0){
            this.ColorSpecialCoinSecond = "Red";
        }
        else {
            this.ColorSpecialCoinSecond = "Black";
        }

        CountSecond ++ ;

    }

}
