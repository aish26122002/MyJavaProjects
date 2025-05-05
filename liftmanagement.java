public class liftmanagement implements LiftOperations {

	@Override
	public void moveTo(Lift lift, int destinationFloor) {
		if (lift.getPosition() == destinationFloor) {
	        System.out.println("Lift ID: " + lift.getLiftId() + " is already at Floor " + destinationFloor);
	    } else {
	        System.out.println("Lift ID: " + lift.getLiftId() + " is moving from Floor " + lift.getPosition() + " to Floor " + destinationFloor);
	        lift.setLastPosition(lift.getPosition());
	        lift.setPosition(destinationFloor);
	    }
	}
	@Override
	public void liftTurnOn(Lift lift) {
		System.out.println("Lift ID: " + lift.getLiftId() + " is now ON.");
	}
	@Override
	public void liftTurnOff(Lift lift) {
		System.out.println("Lift ID: " + lift.getLiftId() + " is now OFF.");
	}
}
	
