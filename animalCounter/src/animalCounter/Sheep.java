package animalCounter;

public class Sheep extends Animal {
	
	// Super Class Instantiation
	public Sheep(Integer initial_Count) {
		super(initial_Count);
	}
	
	@Override
	public void resetCounter() {
		count = 0;
	}
	
	@Override
	public Integer getCount() {
		return count;
	}
	
	@Override
	public void incrementCount(Animal otherAnimal) {
		
		// Increment Count
		count += 2;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}