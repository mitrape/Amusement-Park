package CardsPackage;
public class ZeroLevelCards {
    public String Color1 ;
    public String Color2 ;
    public int Count1 ;
    public int Count2 ;
    public int Score ;
    public final String [] [] ColorOfCoinOfPrizeClaw = {{"RED","BLUE","BLACK"},{"WHITE","GREEN","RED"}};
    public final int [] [] CountOfCoinOfPrizeClaw = {{4,5,6},{4,5,6}};
    public final int [] ScoreOfPrizeClaw = {3,4,3};
    public static int Count = 0;
    public int countCard ;

    public ZeroLevelCards (){
        this.Color1 = ColorOfCoinOfPrizeClaw[0][Count];
        this.Color2 = ColorOfCoinOfPrizeClaw[1][Count];
        this.Count1 = CountOfCoinOfPrizeClaw[0][Count];
        this.Count2 = CountOfCoinOfPrizeClaw[1][Count];
        this.Score = ScoreOfPrizeClaw [Count];
        this.countCard = Count;
        Count++;
    }

}
