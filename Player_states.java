class Player_states
{
    private static int Money = 1_000_000;
    private static String Name = "";
    public int CheckMoney()
    {
        return this.Money;
    }

    public void SetName(String name)
    {
        this.Name = name;
    }

    public void win()
    {
        Money += 10000;
    }

    public void print_money()
    {
        
        System.out.println("────────────────────");
        System.out.println(this.Money + " won");
        System.out.println("────────────────────");
        
    }

    public void bet(int bet, String data)
    {
        if(data == "Player")
        {
            Money += bet;
        }
        else if(data == "Com")
        {
            Money -= bet;
        }
    }
}