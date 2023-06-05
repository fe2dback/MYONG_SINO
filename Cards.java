import java.util.Random;
import java.util.Scanner;

enum Suit { S, D, H, C };

class Card {
    public Suit suit;
    public int number;
}

class Cards 
{
    static String player_stats = "";
    static String dealer_stats = "";

    public static Card[] card = new Card[52];
    static Player_states player_states = new Player_states();
    static {
        for (int i = 0; i < card.length; i++) {
            card[i] = new Card();
            card[i].suit = Suit.values()[i / 13];
            card[i].number = i % 13 + 1;
        }
    }
    
    
    public void showCards() {
        for (int i = 0; i < card.length; i++) {
            System.out.print(card[i].suit + " " + String.format("%02d", card[i].number) + ", ");
            if (i % 13 == 12) {
                System.out.println();
            }
        }
        System.out.println("----------------------------------------");
    }
    

    public void Shuffle()
    {
        Random random = new Random();
        for(int i = 0; i < 100; i++)
        {
            int r1 = random.nextInt(52);
            int r2 = random.nextInt(52);

            Card temp = card[r1];
            card[r1] = card[r2];
            card[r2] = temp;
        }
    }

    public void Distribute()
    {
        Player[] player = new Player[5];
        for(int i = 0; i < player.length; i++)
        {
            player[i] = new Player();
        }
        int k = 0;
        int bet = 0;

        for(int i = 0; i < player.length; i++)
        {
            if(i == 0)
            {
                System.out.print("player : ");
            }
            for(int j = 0; j < player[i].card.length; j++)
            {
                player[i].card[j] = new Card();
                player[i].card[j] = card[k];
                k++;
                if(i == 0) System.out.print(player[i].card[j].suit + " " + String.format("%02d", player[i].card[j].number) + ", ");
            }
            if(i == 0)
            {
                System.out.println(": " + CheckCard(player[i]));
                bet = Bet();
            }
            System.out.println();
        }
        CompareHands(player, bet);
    }

    private int Bet()
    {
        Scanner input = new Scanner(System.in);
        int bet = 0;
        

        System.out.print("베팅할 금액 : ");
        bet = input.nextInt();
        if(bet > player_states.CheckMoney())
        {
            System.out.println("need more money");
            Bet();
        }
        else if(bet == player_states.CheckMoney())
        {
            System.out.println("All In");
            return bet;
        }
        else if(bet < player_states.CheckMoney())
        {
            return bet;
        }
        return 0;
    }

    private String CheckCard(Player player)
    {

        int c1 = JockBo.IsOnePair(player);
        if(c1 != 0) return c1 + " OnePair";

        int c2 = JockBo.IsTwoPair(player);
        if(c2 != 0) return c2 + " TwoPair";

        int c3 = JockBo.IsTriple(player);
        if(c3 != 0) return c3 + " Triple";

        int c4 = JockBo.IsStraight(player);
        if(c4 != 0) return "Straight"; //PokerGame.isGameOn = false;

        int c5 = JockBo.IsFlush(player);
        if(c5 != 0) return "Flush"; //PokerGame.isGameOn = false;

        int c6 = JockBo.IsFullHouse(player);
        if(c6 != 0) return "FullHouse"; //PokerGame.isGameOn = false;

        int c7 = JockBo.IsPoker(player);
        if(c7 != 0) return "StraightFlush"; //PokerGame.isGameOn = false;

        int c8 = JockBo.IsStraightFlush(player);
        if(c8 != 0) return "StraightFlush";  //PokerGame.isGameOn = false;

        int c9 = JockBo.IsNoPair(player);
        if(c9 != 0) return c9 + " NoPair";

        return "test";
    }

    public void CompareHands(Player[] player, int bet) {
        // Assign cards to the dealer and player
        /*
        for (int i = 0; i < dealer.card.length; i++) {
            player.card[i] = card[i + dealer.card.length];
        }
        */

        // Calculate the hand ranks for the dealer and player
        int[] rank = calculateHandRank(player);
        String[] playerJockbo = CheckCard(player[0]).split(" ");
        int playerHighCard = Integer.parseInt(playerJockbo[0]);
        int comHighCard = 0;
        boolean check = true;

        // Compare the hand ranks and determine the winner
        String winner;
        for(int i = 1; i < rank.length; i++)
        {
            if(rank[0] > rank[i]) check = true;
            else if(rank[0] < rank[i])
            {
                check = false;
                break;
            }
            else
            {
                String[] comJockbo = CheckCard(player[i]).split(" ");
                comHighCard = Integer.parseInt(comJockbo[0]);

                if(playerHighCard > comHighCard) check = true;
                else if(playerHighCard < comHighCard) check = false;
            }
        }

        if(check == true)
        {
            winner = "Player";
        }
        else
        {
            winner = "Com";
        }

        for(int i = 0; i < player.length; i++)
        {
            if(i == 0)
            {
                System.out.print("Player : ");
            }
            else
            {
                System.out.print("Com" + String.format("%02d", i) + " : ");
            }
            for(int j = 0; j < player[i].card.length; j++)
            {
                System.out.print(player[i].card[j].suit + " " + String.format("%02d", player[i].card[j].number) + ", ");
            }
            System.out.print(": " + CheckCard(player[i]));
            System.out.println();
        }
        /*
        if (dealerRank > playerRank) {
            winner = "Dealer";
        } else if (dealerRank < playerRank) {
            winner = "Player";
        } else {
            winner = "Draw";
        }
        */
        Player_states states = new Player_states();

        // Display the result
        System.out.println("\n\n승자: " + winner);
        states.bet(bet, winner);
        System.out.println("\n현재 보유 금액 : " + states.CheckMoney());
        Myong_Sino.await(3);
        Scanner wait = new Scanner(System.in);
        String waitt = wait.nextLine();
        Myong_Sino.clearScreen();
    }

    private int[] calculateHandRank(Player[] player) {
        int rank = 0;
        int[] playerRank = new int[player.length];

        for(int i = 0; i < player.length; i++)
        {
            if (JockBo.IsOnePair(player[i]) != 0) rank = 2;
            else if (JockBo.IsTwoPair(player[i]) != 0) rank = 3;
            else if (JockBo.IsTriple(player[i]) != 0) rank = 4;
            else if (JockBo.IsStraight(player[i]) != 0) rank = 5;
            else if (JockBo.IsFlush(player[i]) != 0) rank = 6;
            else if (JockBo.IsFullHouse(player[i]) != 0) rank = 7;
            else if (JockBo.IsPoker(player[i]) != 0) rank = 8;
            else if (JockBo.IsStraightFlush(player[i]) != 0) rank = 9;
            else if (JockBo.IsNoPair(player[i]) != 0) rank = 1;
            
            playerRank[i] = rank;
        }            

        return playerRank;
    }
}
    

