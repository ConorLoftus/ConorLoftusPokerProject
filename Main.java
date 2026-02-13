import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] lines = fileData.split("\n");

        Hand[] allHands = new Hand[lines.length];

        int z =0;
        for (String line : lines) {
            String[] numbers = line.split("[,|]");
            int[] values = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].equals("King")) {
                    numbers[i] = String.valueOf(13);
                    values[i] = Integer.parseInt(numbers[i]);
                } else if (numbers[i].equals("Ace")) {
                    numbers[i] = String.valueOf(14);
                    values[i] = Integer.parseInt(numbers[i]);
                } else if (numbers[i].equals("Queen")) {
                    numbers[i] = String.valueOf(12);
                    values[i] = Integer.parseInt(numbers[i]);
                } else if (numbers[i].equals("Jack")) {
                    numbers[i] = String.valueOf(11);
                    values[i] = Integer.parseInt(numbers[i]);
                } else {
                    values[i] = Integer.parseInt(numbers[i]);
                }
            }
            Hand hand = new Hand(values);
            allHands[z] = hand;
            z++;
        }

        int total = 0;
        for (int i = 0; i < allHands.length; i++) {
            int rank = Hand.determineRank(allHands[i],allHands);
            total+=allHands[i].wager*rank;
        }
        System.out.println("Number of five of a kind hands: " + Hand.getFiveOfKind());
        System.out.println("Number of full house hands: " + Hand.getFullHouse());
        System.out.println("Number of four of a kind hands: " + Hand.getFourOfKind());
        System.out.println("Number of three of a kind hands: " + Hand.getThreeOfKind());
        System.out.println("Number of two pair hands: " + Hand.getTwoPair());
        System.out.println("Number of one pair hands: " + Hand.getOnePair());
        System.out.println("Number of high card hands: " + Hand.getHighCard());
        System.out.println("Total Bid Value: " + total);
    }
}
