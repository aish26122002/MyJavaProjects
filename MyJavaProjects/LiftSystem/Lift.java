public class Lift {
	private static int counter = 0;
    private int liftId;
    private int lastPosition;
    private int position;
    private int numOfPPL;
    
    public Lift() {
        this.liftId = ++counter;  
        this.position = 0;
        this.numOfPPL = 0;
    }
    
	public int getLiftId() {
		return liftId;
	}
	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}
	public int getLastPosition() {
		return lastPosition;
	}
	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getNumOfPPL() {
		return numOfPPL;
	}
	public void setNumOfPPL(int numOfPPL) {
		this.numOfPPL = numOfPPL;
	}
}
