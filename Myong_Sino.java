import java.util.Scanner;


public class Myong_Sino
{
    static Player_states states = new Player_states();
    static Scanner input = new Scanner(System.in);
    static PokerGame Poker = new PokerGame();
    static BlackJackGame BlackJack = new BlackJackGame();
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
            states.SetStack();
            states.SetBetStack();
            System.out.println("[1]포커\n");
            System.out.println("[2]블랙잭\n");
            System.out.println("[3]현금 보기\n\n\n");
            System.out.println("[0]종료");
            int u = input.nextInt();
            switch (u)
            {
                
                case 3:
                states.print_money();
                await(2);
                clearScreen();
                break;
                case 2:
                BlackJack_on();
                //await(1);
                //clearScreen();
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
        Poker.Poker();
        
    }

    static void BlackJack_on()
    {
        BlackJack.BlackJack();
        
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