class Player_money
{
    public int money = 1000000;

    public int CheckMoney()
    {
        return money;
    }

    public void win()
    {
        this.money += 10000;
    }

}