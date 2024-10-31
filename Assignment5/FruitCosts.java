/**
 * FruitCosts
 * 
 * This program reads a list of fruits and their costs from a file provided as a command-line argument.
 * It then finds the two fruits with the lowest costs and prints their names and costs,
 * along with the total cost of these two fruits.
 * 
 * @author Srimathi Vadivel
 * @author Sarah Benedicto
 */
public class FruitCosts {
    /**
     * Main function to execute the program
     * 
     * @param args command-line arguments, where args[0] is the file name to read from
     */
    public static void main(String[] args) {

        // Opens the file specified in args[0] for reading input
        StdIn.setFile(args[0]);

        // Read the number of fruits from the file
        int nbrFruits = StdIn.readInt();

        // Initialize arrays to store the names and costs of the fruits
        String[] fruitNames = new String[nbrFruits];
        double[] fruitCosts = new double[nbrFruits];

        // Populate the arrays with fruit names and costs from the input file
        for (int i = 0; i < nbrFruits; i++) {
            fruitNames[i] = StdIn.readString(); // Read the name of the fruit
            fruitCosts[i] = StdIn.readDouble(); // Read the cost of the fruit
        }

        // Variables to store the names and costs of the two lowest cost fruits
        String lowestName = "";
        double lowestValue = 0;
        String secondLowestName = "";
        double secondLowestValue = 0;

        // Initial comparison between the first two fruits to determine the initial lowest and second lowest costs
        if (fruitCosts[0] <= fruitCosts[1]) {
            lowestValue = fruitCosts[0];
            lowestName = fruitNames[0];

            secondLowestValue = fruitCosts[1];
            secondLowestName = fruitNames[1];
        } else {
            lowestValue = fruitCosts[1];
            lowestName = fruitNames[1];

            secondLowestValue = fruitCosts[0];
            secondLowestName = fruitNames[0];
        }

        // Iterate through the remaining fruits to find the two with the lowest costs
        for (int i = 2; i < nbrFruits; i++) {
            double currentValue = fruitCosts[i];
            String currentName = fruitNames[i];

            // If the current cost is lower than the lowest cost, update both lowest and second lowest
            if (currentValue < lowestValue) {
                secondLowestValue = lowestValue;
                secondLowestName = lowestName;
                
                lowestValue = currentValue;
                lowestName = currentName;

            // If the current cost is lower than the second lowest but not lower than the lowest, update second lowest
            } else if (currentValue < secondLowestValue) {
                secondLowestValue = currentValue;
                secondLowestName = currentName;
            }
        }

        // Calculate the total cost of the two lowest cost fruits
        double total = lowestValue + secondLowestValue;

        // Print the names and costs of the two lowest cost fruits, formatted to two decimal places
        System.out.println(lowestName + " " + String.format("%.2f", lowestValue));
        System.out.println(secondLowestName + " " + String.format("%.2f", secondLowestValue));
        System.out.println("Total" + " " + String.format("%.2f", total));
    }
}
