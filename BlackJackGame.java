public class BlackJackGame {
    public void BlackJack() 
    {
        Cards cards = new Cards();

        cards.Shuffle();
        //cards.showCards();
        cards.Distribute("BlackJack");
        //cards.CompareHands();
        
    }
}
