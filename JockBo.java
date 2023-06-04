class JockBo {
    static int CountNum(Player player)
    {
        int count = 0;

        for(int i = 0; i < 5; i++)
        {
            for(int j = i; j < 5; j++)
            {
                if(player.card[i].number == player.card[j].number)
                {
                    if(i != j) count++;
                }
            }
        }
        return count;
    }

    static int FindSameNo(Player player)
    {
        int max = 0;

        for (int i = 0; i < player.card.length; i++)
        {
            for (int j = 0; j < player.card.length; j++)
            {
                if (player.card[i].number == player.card[j].number && i != j)
                {
                    if(max < player.card[i].number) max = player.card[i].number;
                }
            }        
        }
        return max;       
    }

    public static int IsOnePair(Player player)
    {
        int count = CountNum(player);
        if(count == 1)
        {
            int sameNumber = FindSameNo(player); 
            return sameNumber; 
        }
        else return 0;
    }

    public static int IsTwoPair(Player player)
    {
        int count = CountNum(player);
        if(count == 2)
        {
            int sameNumber = FindSameNo(player); 
            return sameNumber; 
        }
        else return 0;
    }

    public static int IsTriple(Player player)
    {
        int count = CountNum(player);
        if(count == 3)
        {
            int sameNumber = FindSameNo(player); 
            return sameNumber; 
        }
        else return 0;
    }

    public static int IsStraight(Player player)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if (player.card[i].number == player.card[j].number && i != j)
                {
                    return 0;
                }
            }
        }
        int max = player.card[0].number;
        int min = player.card[0].number;

        for(int i = 1; i < player.card.length; i++)
        {
            if(max < player.card[i].number) max = player.card[i].number;
            if(min > player.card[i].number) min = player.card[i].number;
        }
          
        if(max - min == 4) return max;
        else return 0;  
    }

    public static int IsFlush(Player player)
    {
        for(int i = 1; i < player.card.length; i++)
        {
            if(player.card[0].suit != player.card[i].suit) return 0;
        }
        return 1;
    }

    public static int IsFullHouse(Player player)
    {
        int count = CountNum(player);

        if (count == 4)
        {
            return 1;
        }
        else return 0;
    }

    public static int IsStraightFlush(Player player)
    {
        int s = IsStraight(player);
        int f = IsFlush(player);
        if (s + f == 2)
        {
            return 1;
        }
        else return 0;
    }

    public static int IsPoker(Player player)
    {
        int count = CountNum(player);

        if (count == 6)
        {
            int sameNumber = FindSameNo(player);
            return sameNumber;
        }
        else return 0;
    }

    public static int IsNoPair(Player player)
    {
        int max = player.card[0].number;
        for (int i = 1; i < player.card.length; i++)
        {
            if (max < player.card[i].number)
            {
                max = player.card[i].number;
            }
        }
        return max;       
    }

    
}
