import java.util.Scanner;


public class Myong_Sino
{
    static Player_states states = new Player_states();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) 
    {
        gameManager();
    }

    static void gameManager()
    {
        boolean isGameOn = true;
        while (isGameOn == true)
        {
            System.out.println("[1]블랙잭");
            System.out.println("[2]현금 보기");
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
                states.win();
                await(1);
                clearScreen();
                break;
                case 0:
                isGameOn = false;
                break;
                default:
                break;
                
    
            }
        }
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