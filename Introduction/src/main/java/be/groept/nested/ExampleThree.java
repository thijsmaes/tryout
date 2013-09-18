package be.groept.nested;

import java.io.Serializable;

public class ExampleThree {
	private String text = "text";

	public void someMethod() {
		class LocalInnerClass implements Interface, Serializable {
			public LocalInnerClass() {
				System.err.println("Im the constructor");
				System.err.println("I can access:" + text);
			}

			public void method() {
			}
		}
		LocalInnerClass instance = new LocalInnerClass();
	}

	public void someOtherMethod(Interface i) {
		// InnerClass not known here
	}
}

interface Interface {
	public void method();
}