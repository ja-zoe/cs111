
/*************************************************************************
 *  Compilation:  javac Elevator.java
 *  Execution:    java Elevator 'number of floors' 'floor requests' 'number of restricted floors' 'optional passcode'
 *
 *  @author Pooja Kedia
 *  @author Vidushi Jindal
 *
 *************************************************************************/
public class Elevator {
    
    public static void main(String[] args) {
        int floors = Integer.parseInt(args[0]);
        int requests = Integer.parseInt(args[1]);
        int restrictedFloors = Integer.parseInt(args[2]);
        int passcode = -1;
        
        if(args.length > 3) {
            passcode = Integer.parseInt(args[3]);
            if (passcode < 0) {
                return;
            }
        }


        if (restrictedFloors < 0 | requests < 0 | requests < 0) {
            return;
        }

        int elevatorOneFloor = 1;
        int elevatorTwoFloor = 1;

        while (requests > 0) {
            int currentFloorRequest = requests % 10;
            requests = requests / 10;
            int elevatorOneDistance = Math.abs(elevatorOneFloor - currentFloorRequest);
            int elevatorTwoDistance = Math.abs(elevatorTwoFloor - currentFloorRequest);
            if (elevatorOneDistance <= elevatorTwoDistance) {
                elevatorOneFloor = currentFloorRequest;
                System.out.println("1 " + currentFloorRequest);
            } else {
                elevatorTwoFloor = currentFloorRequest;
                System.out.println("2 " + currentFloorRequest);
            }
            if (currentFloorRequest > floors - restrictedFloors) {
                if (hasAccess(passcode, floors, currentFloorRequest)) {
                    System.out.println("Granted");
                } else {
                    System.out.println("Denied");
                }
            } 
        }
    }

    public static boolean hasAccess(int password, int floors, int requestedFloor) {
        if (password % floors == requestedFloor || (password % floors == 0 && requestedFloor == floors)) {
            return true;
        }
        return false;
    }
}
