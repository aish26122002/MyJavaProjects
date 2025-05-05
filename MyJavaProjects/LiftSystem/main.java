import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class main {
	public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        LiftOperations liftOperations = new liftmanagement();
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift()); 
        lifts.add(new Lift()); 
        lifts.add(new Lift()); 
        
        System.out.println("Enter Lift ID:");
        
        int selectedLiftId = scanner.nextInt();
        
        Lift selectedLift = null;
        for (Lift lift : lifts) {
            if (lift.getLiftId() == selectedLiftId) {
                selectedLift = lift;
                break;
            }
        }

        if (selectedLift == null) {
            System.out.println("Invalid Lift ID! Defaulting to Lift 1.");
            selectedLift = lifts.get(0); 
        }
        
        liftOperations.liftTurnOn(selectedLift);
        System.out.print("Enter number of floors in building: ");
        int totalFloors = scanner.nextInt();

        while (true) { 
            System.out.print("\nEnter number of people waiting: ");
            int numOfPeople = scanner.nextInt();
            
            if (numOfPeople == 0) {
                System.out.println("Lift has stopped...");
                break; 
            }
            
            List<Integer> destinations = new ArrayList<>();
            
            for (int i = 0; i < numOfPeople; i++) {
                System.out.println("Person " + " " + (i+1));
                int floor = scanner.nextInt();
                if (floor >= 0 && floor <= totalFloors) {
                    destinations.add(floor);
                } else {
                    System.out.println("Invalid floor! Try again.");
                    i--; 
                }
            }
            
            while (!destinations.isEmpty()) {
               int currentPosition = selectedLift.getPosition();
                int nearestFloor = destinations.get(0);
                int minDistance = Math.abs(currentPosition - nearestFloor);
                
                for (int floor : destinations) {
                    int distance = Math.abs(currentPosition - floor);
                    if (distance < minDistance) {
                        nearestFloor = floor;
                        minDistance = distance;
                    }
                }
                
                liftOperations.moveTo(selectedLift, nearestFloor);
                destinations.remove(Integer.valueOf(nearestFloor));
                System.out.println("Dropping at floor: " + nearestFloor);
            }
        }
        liftOperations.liftTurnOff(selectedLift);
        scanner.close();
	}
}
	



