package be.groept.nested;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ExampleTwo {
	private String text = "text";

	public void someMethod(final String someVar) {
		final String someOtherText = "someOtherText";

		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			{
				System.err.println("I'm the initualizer, acting as constructor ! "
						+ "However I cannot accept any variables. But thats not required, "
						+ "since the anonymous inner class can reference instance variables "
						+ "of the enclosing class variables declared final by the construct "
						+ "creating the anonymous inner class.");
			}

			public void actionPerformed(ActionEvent e) {
				System.err.println(text);
				System.err.println(someOtherText);
				System.err.println(someVar);
			}
		});
	}
}
