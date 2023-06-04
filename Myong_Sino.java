import java.util.Scanner;


public class Myong_Sino
{
    static Player_states states = new Player_states();
    static Scanner input = new Scanner(System.in);
    static PokerGame Poker = new PokerGame();
    public static void main(String[] args) 
    {
        start();
        gameManager();
    }

    static void start()
    {
        System.out.print("What's your Name? : ");
        String name = input.nextLine();
        states.SetName(name);
        clearScreen();
        System.out.println("Welcome! "+name);
        await(3);
        clearScreen();
    }

    static void gameManager()
    {
        boolean isGameOn = true;
        while (isGameOn == true)
        {
            System.out.println("[1]블랙잭\n");
            System.out.println("[2]현금 보기\n\n\n");
            System.out.println("[0]종료");
            int u = input.nextInt();
            switch (u)
            {
                
                case 2:
                states.print_money();
                await(2);
                clearScreen();
                break;
                case 1:
                Poker_on();
                //await(1);
                //clearScreen();
                break;
                case 0:
                isGameOn = false;
                break;
                default:
                break;
                
    
            }
        }
    }

    static void Poker_on()
    {
        int bet = 0;
        System.out.print("베팅할 금액 : ");
        bet = input.nextInt();
        Poker.Poker(bet);
        
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