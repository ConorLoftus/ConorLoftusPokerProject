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
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] lines = fileData.split("\n");

        int lineNumber = 0;

        for (String line : lines) {
            String[] numbers = line.split("[,|]");
            int[] values = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].equals("King")){
                    numbers[i] = String.valueOf(13);
                    values[i] = Integer.parseInt(numbers[i]);
                }
                else if (numbers [i].equals("Ace")){
                    numbers[i] = String.valueOf(14);
                    values[i] = Integer.parseInt(numbers[i]);
                }
                else if (numbers [i].equals("Queen")){
                    numbers[i] = String.valueOf(12);
                    values[i] = Integer.parseInt(numbers[i]);
                }
                else if (numbers[i].equals("Jack")){
                    numbers[i] = String.valueOf(11);
                    values[i] = Integer.parseInt(numbers[i]);
                }
                else {
                    values[i] = Integer.parseInt(numbers[i]);
                }

                lineNumber++;

                Hand[] allHands = new Hand[lineNumber];





//put into hand class
            for (int k = 0; k<values.length - 1; k++){
                int cardInstance = 0;
                int currentCard = values[k];
                for (int j = k+1; j<values.length-k; j++){
                    if (currentCard == values[j]){
                        cardInstance++;
                        System.out.println(cardInstance);
                    }

                }
            }
            }
            System.out.println(Arrays.toString(numbers));
        }
    }
}





