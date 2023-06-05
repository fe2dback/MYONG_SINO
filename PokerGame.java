class PokerGame {
    static boolean isGameOn = true;

    public void Poker() 
    {
        Cards cards = new Cards();

        cards.Shuffle();
        //cards.showCards();
        cards.Distribute("Poker");
        //cards.CompareHands();
        
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
