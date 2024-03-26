package CardsPackage ;
public class ThirdLevelCards{
    public final String [][]  ColorOfCoinThird  = {{"RED","BLUE"},{"BLACK","WHITE"},{"GREEN","BLUE"},{"RED","BLUE"},{"BLACK","WHITE"},{"GREEN","BLUE"},{"WHITE","RED"},
            {"WHITE","RED"},{"GREEN","BLACK"},{"RED","BLUE"},{"BLUE","GREEN"},{"GREEN","BLACK"},{"RED","BLUE"},{"BLUE","GREEN"},{"BLUE","WHITE"}};

    public final int [][] CountOfCoinThird = {{3,4},{4,3},{5,2},{2,5},{4,4},{5,5},{5,3},{3,5},{2,6},{6,2},{5,4},{5,4},{3,6},{6,3},{4,6}};

    public final int [] Score = {3,4,5,5,3,4,5,3,4,3,4,5,4,5,3};
    public int  [] ColorAndCountThird = new int [5]; // red = 0 , blue = 1 , white = 2 , green = 3 , black = 4
    public int ScoreThird ;
    public String CardThird ;
    public String ColorSpecialCoinThird; // for odd numbers is Green and for even numbers is blue
    public static int CountThird = 0;
    public static int CounterThird1, CounterThird2, CounterThird3, CounterThird4 ;

    public ThirdLevelCards (){
        if ( ColorOfCoinThird [CountThird][0] == "RED") {
            ColorAndCountThird[0] = CountOfCoinThird[CountThird][0];
            CardThird ="RED="+ColorAndCountThird[0]+",";
        }
        else if ( ColorOfCoinThird [CountThird][0] == "BLUE") {
            ColorAndCountThird[1] = CountOfCoinThird[CountThird][0];
            CardThird ="BLUE="+ColorAndCountThird[1]+",";
        }
        else if ( ColorOfCoinThird [CountThird][0] == "WHITE") {
            ColorAndCountThird[2] = CountOfCoinThird[CountThird][0];
            CardThird ="WHITE="+ColorAndCountThird[2]+",";
        }
        else if ( ColorOfCoinThird [CountThird][0] == "GREEN") {
            ColorAndCountThird[3] = CountOfCoinThird[CountThird][0];
            CardThird ="GREEN="+ColorAndCountThird[3]+",";
        }
        else {
            ColorAndCountThird[4] = CountOfCoinThird[CountThird][0];
            CardThird ="BLACK="+ColorAndCountThird[4]+",";
        }

        if ( ColorOfCoinThird [CountThird][1] == "RED") {
            ColorAndCountThird[0] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+"RED="+ColorAndCountThird[0];
        }
        else if ( ColorOfCoinThird [CountThird][1] == "BLUE") {
            ColorAndCountThird[1] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+"BLUE="+ColorAndCountThird[1];
        }
        else if ( ColorOfCoinThird [CountThird][1] == "WHITE") {
            ColorAndCountThird[2] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+"WHITE="+ColorAndCountThird[2];
        }
        else if ( ColorOfCoinThird [CountThird][1] == "GREEN") {
            ColorAndCountThird[3] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+"GREEN="+ColorAndCountThird[3];
        }
        else {
            ColorAndCountThird[4] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+"BLACK="+ColorAndCountThird[4];
        }



        this.ScoreThird = this.Score [CountThird];

        if (CountThird % 2 == 0){
            this.ColorSpecialCoinThird = "Red";
        }
        else {
            this.ColorSpecialCoinThird = "Black";
        }

        CountThird ++ ;

    }

}
