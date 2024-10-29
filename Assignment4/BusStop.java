/*
 * Write your program inside the main method to find the order
 * which the bus the student needs to take will arrive
 * according to the assignemnt description. 
 *
 * To compile:
 *        javac BusStop.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class BusStop {

    public static void main(String[] args) {
        int argsLength = args.length;
        char theBus = args[argsLength - 1].charAt(0);
        for (int i = 0; i < argsLength - 1; i++) {
            char currentBus = args[i].charAt(0);
            if (currentBus == theBus) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}
