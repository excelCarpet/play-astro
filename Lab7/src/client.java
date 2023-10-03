import java.io.*;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get the input file name from the user
        System.out.print("Enter the name of the input file: ");
        String inputFileName = scanner.nextLine();

        // Get the output file name from the user
        System.out.print("Enter the name of the output file: ");
        String outputFileName = scanner.nextLine();

        try {
            // Open the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

            // Open the output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            int lineNumber = 1;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            // Read and write lines from the input file
            while ((line = reader.readLine()) != null) {
                // Write the line number and the line content to the output file
                writer.write(lineNumber + ": " + line);
                writer.newLine();

                // Update counts
                lineCount++;
                String[] words = line.split("\\s+"); // "\\s+" means "one or more whitespace characters"
                wordCount += words.length;
                charCount += line.length();

                lineNumber++;
            }

            // Close the input and output files
            reader.close();
            writer.close();

            System.out.println("File copied successfully. Yeeehaw!!");
            System.out.println("Shaun");
            System.out.println("Output file: " + outputFileName);
            System.out.println("Total lines: " + lineCount);
            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters: " + charCount);
        } catch (IOException e) {
            System.err.println("Hot damn! Looks like an error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


