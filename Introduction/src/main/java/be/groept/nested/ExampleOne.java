package be.groept.nested;

public class ExampleOne {
	private String name;

	public class InnerClass {
		public String getName() {
			return name;
		}
	}

	public static void main() {
		// From a non existing instance of the outer class
		InnerClass innerClass = new ExampleOne().new InnerClass();

		// From a existing instance of the outer class
		ExampleOne exampleOne = new ExampleOne();
		innerClass = exampleOne.new InnerClass();
	}
}
