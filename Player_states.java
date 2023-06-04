class Player_states
{
    private static int money = 1_000_000;

    public int CheckMoney()
    {
        return this.money;
    }

    public void win()
    {
        money += 100000000;
    }

    public void print_money()
    {
        
        System.out.println("────────────────────");
        System.out.println(this.money + " won");
        System.out.println("────────────────────");
        
    }
}