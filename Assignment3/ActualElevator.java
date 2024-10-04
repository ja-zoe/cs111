
/*************************************************************************
 *  Compilation:  javac Elevator.java
 *  Execution:    java Elevator 'number of floors' 'floor requests' 'number of restricted floors' 'optional passcode'
 *
 *  @author Pooja Kedia
 *  @author Vidushi Jindal
 *
 *************************************************************************/
public class ActualElevator {
    
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

            if (currentFloorRequest > floors - restrictedFloors) {
                if (hasAccess(passcode, floors, currentFloorRequest)) {
                    int[] elevatorAndFloor = moveElevator(elevatorOneFloor, elevatorTwoFloor, currentFloorRequest);
                    if (elevatorAndFloor[0] == 1) {
                        elevatorOneFloor = elevatorAndFloor[1];
                    } else {
                        elevatorTwoFloor = elevatorAndFloor[1];
                    }
                    System.out.println("Granted");
                } else {
                    System.out.println("Denied");
                }
            } else {
                int[] elevatorAndFloor = moveElevator(elevatorOneFloor, elevatorTwoFloor, currentFloorRequest);
                if (elevatorAndFloor[0] == 1) {
                    elevatorOneFloor = elevatorAndFloor[1];
                } else {
                    elevatorTwoFloor = elevatorAndFloor[1];
                }            
            }
            requests = requests / 10;
        }
    }

    public static int[] moveElevator(int elevatorOneFloor, int elevatorTwoFloor, int currentFloorRequest) {
        int[] elevatorAndFloor = new int[2];

        if (elevatorOneFloor == elevatorTwoFloor) {
            System.out.println("1 " + currentFloorRequest);
            elevatorAndFloor[0] = 1;
            elevatorAndFloor[1] = currentFloorRequest;
        } else {
            int elevatorOneDistance = Math.abs(elevatorOneFloor - currentFloorRequest);
            int elevatorTwoDistance = Math.abs(elevatorTwoFloor - currentFloorRequest);
            if (elevatorOneDistance < elevatorTwoDistance) {
                System.out.println("1 " + currentFloorRequest);
                elevatorAndFloor[0] = 1;
                elevatorAndFloor[1] = currentFloorRequest;
            } else {
                System.out.println("2 " + currentFloorRequest);
                elevatorAndFloor[0] = 2;
                elevatorAndFloor[1] = currentFloorRequest;
            }
        }
        return elevatorAndFloor;
    }

    public static boolean hasAccess(int password, int floors, int requestedFloor) {
        if (password % floors == requestedFloor | (password % floors == 0 & requestedFloor == floors)) {
            return true;
        }
        return false;
    }
}
