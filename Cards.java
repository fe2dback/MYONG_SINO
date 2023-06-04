import java.util.Random;

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
        Player[] player = new Player[2];
        for(int i = 0; i < player.length; i++)
        {
            player[i] = new Player();
        }
        int k = 0;

        for(int i = 0; i < player.length; i++)
        {
            if(i == 0)
            {
                System.out.print("dealer : ");
            }
            else
            {
                System.out.print("player : ");
            }
            for(int j = 0; j < player[i].card.length; j++)
            {
                player[i].card[j] = new Card();
                player[i].card[j] = card[k];
                k++;

                System.out.print(player[i].card[j].suit + " " + String.format("%02d", player[i].card[j].number) + ", ");
            }
            System.out.print(": " + CheckCard(player[i]));
            System.out.println();
        }
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

    public void CompareHands(int bet) {
        Player dealer = new Player();
        Player player = new Player();

        // Assign cards to the dealer and player
        for (int i = 0; i < dealer.card.length; i++) {
            dealer.card[i] = card[i];
            player.card[i] = card[i + dealer.card.length];
        }

        // Calculate the hand ranks for the dealer and player
        int dealerRank = calculateHandRank(dealer);
        int playerRank = calculateHandRank(player);

        // Compare the hand ranks and determine the winner
        String winner;
        if (dealerRank > playerRank) {
            winner = "Dealer";
        } else if (dealerRank < playerRank) {
            winner = "Player";
        } else {
            winner = "Draw";
        }

        // Display the result
        System.out.println("Winner: " + winner);
        Player_states states = new Player_states();
        states.bet(bet, winner);
        Myong_Sino.await(3);
        Myong_Sino.clearScreen();
    }

    private int calculateHandRank(Player player) {
        int rank = 0;

        if (JockBo.IsOnePair(player) != 0) {
            rank = 1;
        } else if (JockBo.IsTwoPair(player) != 0) {
            rank = 2;
        } else if (JockBo.IsTriple(player) != 0) {
            rank = 3;
        } else if (JockBo.IsStraight(player) != 0) {
            rank = 4;
        } else if (JockBo.IsFlush(player) != 0) {
            rank = 5;
        } else if (JockBo.IsFullHouse(player) != 0) {
            rank = 6;
        } else if (JockBo.IsPoker(player) != 0) {
            rank = 7;
        } else if (JockBo.IsStraightFlush(player) != 0) {
            rank = 8;
        } else if (JockBo.IsNoPair(player) != 0) {
            rank = 9;
        }

        return rank;
    }
}
    

