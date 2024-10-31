/**
 * CharacterCounter
 * 
 * This program reads characters from a file specified by the first command line argument
 * and counts the occurrences of each character using an array of size 128.
 * It then writes the results to an output file specified by the second command line argument.
 * The output includes: character, ASCII value, number of occurrences, and frequency percentage.
 * 
 * @author Mary Buist
 * @author Anna Lu
 */
public class CharacterCounter {

    public static void main(String[] args) {

        // Opens the input file for reading. The file name is specified by args[0].
        // Uses StdIn.readChar() to read characters from the file.
        StdIn.setFile(args[0]);

        // Opens the output file for writing. The file name is specified by args[1].
        // Uses StdOut.println(), StdOut.print(), or StdOut.printf() to write to the file.
        StdOut.setFile(args[1]);
        
        // Array to store the count of each character. Index corresponds to ASCII values (0-127).
        int[] finalArray = new int[128];

        // Variable to keep track of the total number of characters read from the file.
        int length = 0;

        // Read characters from the input file until there are no more characters.
        while (StdIn.hasNextChar()) {
            // Read the current character.
            char currentChar = StdIn.readChar();

            // Get the ASCII value of the character.
            int asciiValue = (int) currentChar;

            // Increment the count for this character in the finalArray.
            finalArray[asciiValue] += 1;

            // Increment the total character count.
            length += 1;
        }

        // Loop through the ASCII values from 32 to 126 (printable characters).
        for (int i = 32; i <= 126; i++) {
            // Convert the ASCII value back to the corresponding character.
            char currentChar = (char) i;

            // Get the number of times this character appeared in the file.
            int occurences = finalArray[i];

            // Calculate the frequency percentage of this character.
            double frequency = (double) occurences / (double) length * 100;

            // Output the character, ASCII value, occurrences, and frequency to the output file.
            StdOut.println(currentChar + "," + i + "," + occurences + "," + frequency);
        }
    }
}
