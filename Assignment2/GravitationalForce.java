/*
 * Write your program inside the main method to compute the 
 * Gravitational Force according to the assignment description.
 * 
 * To compile:
 *        javac GravitationalForce.java
 * To execute:
 *        java GravitationalForce 36000.0 1080.0 50.0
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */

public class GravitationalForce {

    public static void main(String[] args) {
        // Read command line inputs for mass one, mass two, and distance between the two masses
        double massOne = Double.parseDouble(args[0]);
        double massTwo = Double.parseDouble(args[1]);
        double distance = Double.parseDouble(args[2]);

        // Set constant g equal to the gravitational constant (this is a fundamental constant derived from physics)
        double g = 6.6743e-11;

        // Calculate gravitational force with given equation
        double gravitationalForce = g * (massOne * massTwo) / (distance * distance);
        
        // Print result
        System.out.println(gravitationalForce);
    }
}
