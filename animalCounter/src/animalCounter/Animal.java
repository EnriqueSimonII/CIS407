package animalCounter;

public abstract class Animal {
	
	// Instance Variable
	protected Integer count;
	
	// Class Creation
	public Animal(Integer initial_Count) {
		count = initial_Count;
	}
	
	// Methods
	public abstract void resetCounter();
	public abstract Integer getCount();
	public abstract void incrementCount(Animal otherAnimal);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
