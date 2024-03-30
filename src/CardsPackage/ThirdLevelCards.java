package CardsPackage ;
public class ThirdLevelCards{
    public final String [][]  ColorOfCoinThird  = {{"RED","BLUE","BLACK"},{"BLACK","WHITE","GREEN"},{"GREEN","BLUE","WHITE"},
            {"RED","BLUE","GREEN"},{"RED","BLUE","BLACK"},{"BLACK","WHITE","GREEN"},{"GREEN","BLUE","WHITE"},{"RED","BLUE","GREEN"},
            {"RED","BLUE","GREEN"},{"RED","BLUE","BLACK"},{"BLACK","WHITE","GREEN"},{"GREEN","BLUE","WHITE"},{"RED","BLUE","GREEN"},
            {"RED","BLUE","BLACK"},{"BLACK","WHITE","GREEN"}};

    public final int [][] CountOfCoinThird = {{1,2,4},{2,1,4},{2,2,3},{2,3,3},{3,3,3},{2,4,3},{4,3,3},{1,2,4},{2,1,4},{2,2,3},{2,3,3},{3,3,3},{2,4,3},{4,3,3},{3,3,3}};

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
            CardThird =ColorAndCountThird[0]+"RED"+",";
        }
        else if ( ColorOfCoinThird [CountThird][0] == "BLUE") {
            ColorAndCountThird[1] = CountOfCoinThird[CountThird][0];
            CardThird =ColorAndCountThird[1]+"BLUE"+",";
        }
        else if ( ColorOfCoinThird [CountThird][0] == "WHITE") {
            ColorAndCountThird[2] = CountOfCoinThird[CountThird][0];
            CardThird =ColorAndCountThird[2]+"WHITE"+",";
        }
        else if ( ColorOfCoinThird [CountThird][0] == "GREEN") {
            ColorAndCountThird[3] = CountOfCoinThird[CountThird][0];
            CardThird =ColorAndCountThird[3]+"GREEN"+",";
        }
        else {
            ColorAndCountThird[4] = CountOfCoinThird[CountThird][0];
            CardThird =ColorAndCountThird[4]+"BLACK"+",";
        }

        if ( ColorOfCoinThird [CountThird][1] == "RED") {
            ColorAndCountThird[0] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+ColorAndCountThird[0]+"RED"+",";
        }
        else if ( ColorOfCoinThird [CountThird][1] == "BLUE") {
            ColorAndCountThird[1] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+ColorAndCountThird[1]+"BLUE"+",";
        }
        else if ( ColorOfCoinThird [CountThird][1] == "WHITE") {
            ColorAndCountThird[2] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+ColorAndCountThird[2]+"WHITE"+",";
        }
        else if ( ColorOfCoinThird [CountThird][1] == "GREEN") {
            ColorAndCountThird[3] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+ColorAndCountThird[3]+"GREEN"+",";
        }
        else {
            ColorAndCountThird[4] = CountOfCoinThird[CountThird][1];
            CardThird=CardThird+ColorAndCountThird[4]+"BLACK"+",";
        }

        if ( ColorOfCoinThird [CountThird][2] == "RED") {
            ColorAndCountThird[0] = CountOfCoinThird[CountThird][2];
            CardThird=CardThird+ColorAndCountThird[0]+"RED";
        }
        else if ( ColorOfCoinThird [CountThird][2] == "BLUE") {
            ColorAndCountThird[1] = CountOfCoinThird[CountThird][2];
            CardThird=CardThird+ColorAndCountThird[1]+"BLUE";
        }
        else if ( ColorOfCoinThird [CountThird][2] == "WHITE") {
            ColorAndCountThird[2] = CountOfCoinThird[CountThird][2];
            CardThird=CardThird+ColorAndCountThird[2]+"WHITE";
        }
        else if ( ColorOfCoinThird [CountThird][2] == "GREEN") {
            ColorAndCountThird[3] = CountOfCoinThird[CountThird][2];
            CardThird=CardThird+ColorAndCountThird[3]+"GREEN";
        }
        else {
            ColorAndCountThird[4] = CountOfCoinThird[CountThird][2];
            CardThird=CardThird+ColorAndCountThird[4]+"BLACK";
        }


        this.ScoreThird = this.Score [CountThird];

        if (CountThird % 2 == 0){
            this.ColorSpecialCoinThird = "White";
        }
        else {
            this.ColorSpecialCoinThird = "Green";
        }

        CountThird ++ ;

    }

}
