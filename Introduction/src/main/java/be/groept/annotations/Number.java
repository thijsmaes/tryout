package be.groept.annotations;

public class Number {
	private final int number;
	private final String name;

	public Number(int number) {
		this.number = number;
		name = makeName();
	}

	protected String makeName() {
		return "" + number;
	}

	public final String toString() {
		return name;
	}
}