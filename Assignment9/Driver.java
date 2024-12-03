public class Driver {
    /**
     * Navigate to the RURacing directory and compile the files using the following:
     * Compilation: javac -d bin *.java
     * Execution: java -cp bin Driver
     */
    public static void main(String[] args) {
        // Compilation: javac -d bin src/ruracing/Driver.java
        // Execution: java -cp bin ruracing.Driver
        // use -ea option when running, helps verify test cases

        // You will be responsible for implementing the methods in RURacing.java
        // To test your implementation you must create your own test cases
        // and verify that your implementation is correct. All methods will be
        // tested through RURacing.methodName() calls.
        String trackFile = "track0.in";
        int[] points = RURacing.readTrackFile(trackFile);
        char[][] raceway = RURacing.createRaceway(points);
        RURacing.printMap(raceway);
        RURacing.racer4(raceway);
    }
}
