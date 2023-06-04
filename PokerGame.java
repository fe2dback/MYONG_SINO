class PokerGame {
    static boolean isGameOn = true;

    public void Poker(int bet) 
    {
        Cards cards = new Cards();

        cards.Shuffle();
        cards.showCards();
        cards.Distribute();
        cards.CompareHands(bet);
        
    }

    /*
     * do
     * {
     * cards.Distribute();
     * cards.Shuffle();
     * System.out.println();
     * //System.out.flush();
     * }
     * while(isGameOn);
     */

}
