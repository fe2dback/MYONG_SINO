class Player_state {
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

    public void SetStack() {
        this.stack = 0;
        this.bet_stack = 0;
    }

    public void SetBetStack() {
        
    }

    public void print_money() {
        System.out.println(Name + " have money");
        System.out.println("────────────────────");
        System.out.println(this.Money + " won");
        System.out.println("────────────────────");

    }

    public void bet(int bet, String data, int players) {
        if (bet != 0 || bet == CheckMoney()) {
            Money -= bet;
            stack++;
            bet_stack += bet;
        }
        if(bet == CheckMoney() && data == "")
        {
            Money += bet;
        }
        if (data == "Player") {
            if (stack >= 2) {
                Money += (bet_stack * players) - bet;
                System.out.println("\n" + CheckMoney() + "\n++" + bet_stack);
            } else if (stack < 2) {
                Money += (bet * players);
                System.out.println("\n" + CheckMoney() + "\n+" + bet_stack);
            }

        } else if (data == "Com") 
        {
            System.out.println("\n" + CheckMoney() + "\n-" + bet_stack);

        }

        if(Money <= 0)
        {
            Myong_Sino.clearScreen();
            System.out.println("파산 하셨습니다\n" + Money);
            System.exit(0);
        }

    }
}