import java.util.Scanner;


public class Myong_Sino
{
    
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int t = 1000;
        Player_money money = new Player_money();
        int show = money.CheckMoney();
        while (true)
        {
            int u = input.nextInt();
            switch (u)
            {
                case 1:
                lobby(show);
                await(3);
                clearScreen();
                break;
                case 2:
                money.win();
                await(1);
                clearScreen();
                break;
                default:
                break;
                
    
            }
        }
        
    }

    static void lobby(int show)
    {
        
        System.out.println("┌────────────────────┐");
        System.out.println("│" + show+ "             │");
        System.out.println("└────────────────────┘");
        
    }

    public static void clearScreen() {
        for (int i = 0; i < 80; i++)
          System.out.println(" ");
      }

    static void await(int second)
    {
        try{
            Thread.sleep(second*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}