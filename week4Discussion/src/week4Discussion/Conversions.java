package week4Discussion;

public class Conversions {
	
	private static Float speedFactor = 1.60934f;
	
	public static Float convertSpeed_MPH_KPH(Float inputSpeed) {
		return (float)(inputSpeed * speedFactor);
	}
	
	public static Float convertSpeed_KPH_MPH(Float inputSpeed) {
		return (float)(inputSpeed / speedFactor);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
