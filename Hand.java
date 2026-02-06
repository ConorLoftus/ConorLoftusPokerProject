
public class Hand {
    private int[] hand;
    private String handType;


    public static int fiveOfKind = 0;
    public static int fourOfKind = 0;
    public static int fullHouse = 0;
    public static int threeOfKind = 0;
    public static int twoPair = 0;
    public static int onePair = 0;
    public static int highCard = 0;


    public Hand(int[] hand) {
        this.hand = hand;
        this.handType = Hand.handType(hand);
        int wager = hand[4];
    }


    public static String handType(int[] hand) {
        String handType = "";
        int cardInstance = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            int currentCard = hand[i];
            for (int j = i + 1; j < hand.length; j++) {
                if (currentCard == hand[j]) {
                    cardInstance++;
                }
            }
        }
        if (cardInstance == 10){
            handType = "Five of a kind";
            fiveOfKind++;
        }
        if (cardInstance == 6){
            handType = "Four of a kind";
            fourOfKind++;
        }
        if (cardInstance == 4){
            handType = "Full House";
            fullHouse++;
        }
        if (cardInstance == 3){
            handType = "Three of a kind";
            threeOfKind++;
        }
        if (cardInstance == 2){
            handType = "Two pair";
            twoPair++;
        }
        if (cardInstance == 1){
            handType = "One Pair";
            onePair++;
        }
        if (cardInstance == 0){
            handType = "High Card";
            highCard++;
        }
        return handType;
    }


    public static int getFiveOfKind(){
        return fiveOfKind;
    }
    public static int getFourOfKind(){
        return fourOfKind;
    }
    public static int getFullHouse(){
        return fullHouse;
    }
    public static int getThreeOfKind(){
        return threeOfKind;
    }
    public static int getTwoPair(){
        return twoPair;
    }
    public static int getOnePair(){
        return onePair;
    }
    public static int getHighCard(){
        return highCard;
    }
}
