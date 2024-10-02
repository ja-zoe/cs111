
/*************************************************************************
 *  Compilation:  javac FloorIsLava.java
 *  Execution:    java FloorIsLava n
 *
 *  @author Shane Haughton, Maaz Mansuri
 *
 **************************************************************************/

public class FloorIsLava {

    public static void main (String[] args ) {
        int inputNum = Integer.parseInt(args[0]);

        if (inputNum == 0) {
            return;
        }

        // Print even numbers in ascending order
        for (int i = 2; i <= inputNum; i+=2) {
            System.out.println(i);
        }

        int descentStart = inputNum;

        // Determine if input number is even, in which case, we adjust the start number of descent (negatively increment by 1)
        if (descentStart % 2 == 0) {
            descentStart -= 1;
        }

        // Print descent
        for (int i = descentStart; i > 0; i -= 2) {
            System.out.println(i);
        }
    }
}
