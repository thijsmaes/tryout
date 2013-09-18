package be.groept.nested;

public class ExampleFour {
	private String text = "text";

	public void someMethod() {
		StaticNestedClass staticNestedClassOne = new StaticNestedClass();
		staticNestedClassOne.setSomeNumber(1);
		StaticNestedClass staticNestedClassTwo = new StaticNestedClass();
		staticNestedClassTwo.setSomeNumber(2);

		System.err.println(staticNestedClassOne.getSomeNumber());
		System.err.println(staticNestedClassTwo.getSomeNumber());
	}

	protected static class StaticNestedClass {
		private int someNumber;

		public int getSomeNumber() {
			return someNumber;
		}

		public void setSomeNumber(int someNumber) {
			this.someNumber = someNumber;
		}

		public void getText() {
			// This doensn't work --> return text;
		}
	}

	public static void main(String args[]) {
		ExampleFour instance = new ExampleFour();
		instance.someMethod();

		new StaticNestedClass();
	}
}
