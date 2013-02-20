package mocking;

public class One {
	
	private Two two;

	public One(Two two) {
		this.two = two;
	}
	
	public void go(String name) {
		if(!two.doGo("Hello, " + name + "!")) {
			throw new Error("Could not add message to the database!"); 
		}
	}

	
}
