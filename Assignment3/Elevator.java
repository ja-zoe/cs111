
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
        int passcode;
        
        try {
            passcode = Integer.parseInt(args[3]);
        } catch (Exception e) {
            passcode = -1;
        }

        int elevatorOneFloor = 1;
        int elevatorTwoFloor = 1;

        while (requests > 0) {
            int currentFloorRequest = requests % 10;
            if (currentFloorRequest > floors - restrictedFloors) {
                if (hasAccess(passcode, floors, currentFloorRequest)) {
                    if (elevatorOneFloor == elevatorTwoFloor) {
                        System.out.println("1 " + currentFloorRequest);
                        elevatorOneFloor = currentFloorRequest;
                    } else {
                        int elevatorOneDistance = Math.abs(elevatorOneFloor - currentFloorRequest);
                        int elevatorTwoDistance = Math.abs(elevatorTwoFloor - currentFloorRequest);
                        if (elevatorOneDistance < elevatorTwoDistance) {
                            System.out.println("1 " + currentFloorRequest);
                            elevatorOneFloor = currentFloorRequest;
                        } else {
                            System.out.println("2 " + currentFloorRequest);
                            elevatorTwoFloor = currentFloorRequest;
                        }
                    }
                    System.out.println("Granted");
                } else {
                    System.out.println("Denied");
                }
            } else {
                if (elevatorOneFloor == elevatorTwoFloor) {
                    System.out.println("1 " + currentFloorRequest);
                    elevatorOneFloor = currentFloorRequest;
                } else {
                    int elevatorOneDistance = Math.abs(elevatorOneFloor - currentFloorRequest);
                    int elevatorTwoDistance = Math.abs(elevatorTwoFloor - currentFloorRequest);
                    if (elevatorOneDistance < elevatorTwoDistance) {
                        System.out.println("1 " + currentFloorRequest);
                        elevatorOneFloor = currentFloorRequest;
                    } else {
                        System.out.println("2 " + currentFloorRequest);
                        elevatorTwoFloor = currentFloorRequest;
                    }
                }
            }

            requests = requests / 10;
        }
    }

    public static boolean hasAccess(int password, int floors, int requestedFloor) {
        if (password % floors == requestedFloor | (password % floors == 0 & requestedFloor == floors)) {
            return true;
        }
        return false;
    }
}
