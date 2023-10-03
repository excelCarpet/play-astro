import java.io.*;

public class scores {

    private String name;
    private int score;

    public static void main(String[] args) {
        scores[] scores = new scores[10];
        String inputFileName = "scores.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {

            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < 10) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    scores scoreObj = new scores(name, score);
                    scores[index] = scoreObj;
                    index++;
                }
            }

            // Calculate the average, largest, and smallest scores
            int sum = 0;
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < index; i++) {
                int currentScore = scores[i].getScore();
                sum += currentScore;

                if (currentScore > largest) {
                    largest = currentScore;
                }

                if (currentScore < smallest) {
                    smallest = currentScore;
                }
            }

            double average = (double) sum / index;

            // Write statistics to the output CSV file
            writer.write(index + "," + average + "," + largest + "," + smallest);
            writer.newLine();

            // Write the contents of the array to the output CSV file
            for (int i = 0; i < index; i++) {
                writer.write(scores[i].getName() + "," + scores[i].getScore());
                writer.newLine();
            }

            System.out.println("The stuff was written to output.csv");
        } catch (IOException e) {
            System.err.println("Shit, an error occurred: " + e.getMessage());
        }
    }



    public scores() {
        // Default constructor
    }

    public scores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getters and setters for name and score
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
