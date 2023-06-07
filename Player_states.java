class Player_states {
    private static int Money = 1_000_000;
    private static String Name = "";
    private static int stack = 0;
    private static int bet_stack = 0;

    public int CheckMoney() {
        return this.Money;
    }

    public void SetName(String name) {
        this.Name = name;
    }

    public void SetStack()
    {
        this.stack = 0;
    }
    public void SetBetStack()
    {
        this.bet_stack = 0;
    }

    public void print_money() {

        System.out.println("────────────────────");
        System.out.println(this.Money + " won");
        System.out.println("────────────────────");

    }
    
    public void bet(int bet, String data, int players) {
        Money -= bet;
        stack++;
        bet_stack += bet;
        if (data == "Player") {
            if(stack >= 2)
            {
                Money += (bet_stack * players);
                System.out.println("\n" + CheckMoney() + "\n+" + (bet_stack * players));
            }
            else if(stack < 2)
            {
                Money += (bet * players);
                System.out.println("\n" + CheckMoney() + "\n+" + (bet * players));
            }
            

        } else if (data == "Com") {
            if(stack >= 2)
            {
                System.out.println("\n" + CheckMoney() + "\n-" + bet_stack);
            }
            else if(stack < 2)
            {
                System.out.println("\n" + CheckMoney() + "\n-" + bet);
            }
            
        }
        
    }
}