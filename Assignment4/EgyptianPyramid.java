
/**
 * Compilation: javac EgyptianPyramid.java
 * Execution:   java EgyptianPyramid 'size of grid' 'number of initial blocks'
 * 
 * @author Ayla Muminovic
 * @author Kushi Sharma
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 */
public class EgyptianPyramid {
    
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int bricks = Integer.parseInt(args[1]);
        String[][] finalArray = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] currentRow = new String[size]; 
            for (int j = 0; j < size; j++) {
                if (j < i || (size - i) <= j) {
                    currentRow[j] = "=";
                } else {
                    if (bricks > 0) {
                        currentRow[j] = "X";
                        bricks--;
                    } else {
                        currentRow[j] = "=";
                    }
                }
            }
            finalArray[i] = currentRow;
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                System.out.print(finalArray[i][j]);
            }     
            System.out.println();       
        }
        System.out.println(bricks + " Bricks Remaining");
    }
}
