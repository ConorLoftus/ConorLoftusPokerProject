import java.util.Arrays;
public class Hand {

    private int[] hand;
    private int handType;
    private int[] handCards;
    int wager;

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
        this.wager = hand[5];
        this.handCards = Arrays.copyOf(hand, 5);
    }

    public static int determineRank(Hand hand, Hand[] allHands) {
        int rank = 1;
        for (int i = 0; i < allHands.length; i++) {
            Hand otherHand = allHands[i];
            if (allHands[i] == hand) {
                continue;
            }
            if (hand.determineStrength(hand, otherHand)) {
                rank++;
            }
        }
        return rank;
    }

    public boolean determineStrength(Hand oneHand, Hand other) {
        if (oneHand.handType > other.handType) {
            return true;
        }
        if (oneHand.handType < other.handType) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (oneHand.handCards[i] > other.handCards[i]) {
                return true;
            }
            if (oneHand.handCards[i] < other.handCards[i]) {
                return false;
            }
        }
        return false;
    }
    public static int handType(int[] hand) {
        int handType = 0;
        int cardInstance = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            int currentCard = hand[i];
            for (int j = i + 1; j < 5; j++) {
                if (currentCard == hand[j]) {
                    cardInstance++;
                }
            }
        }
        if (cardInstance == 10) {
            handType = 7;
            fiveOfKind++;
        }
        if (cardInstance == 6) {
            handType = 6;
            fourOfKind++;
        }
        if (cardInstance == 4) {
            handType = 5;
            fullHouse++;
        }
        if (cardInstance == 3) {
            handType = 4;
            threeOfKind++;
        }
        if (cardInstance == 2) {
            handType = 3;
            twoPair++;
        }
        if (cardInstance == 1) {
            handType = 2;
            onePair++;
        }
        if (cardInstance == 0) {
            handType = 1;
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
