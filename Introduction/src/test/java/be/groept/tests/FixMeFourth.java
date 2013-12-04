package be.groept.tests;

import java.util.ArrayList;
import java.util.Collection;
import org.testng.annotations.Test;

import be.groept.generics.Base1;

@Test
public class FixMeFourth {

	public void testGenerics() {

		// TODO FIRST -----> Uncomment and FIX the raw type warning, DO NOT continue before this is fixed
		// the unused warning may remain it will go away when you continue

		// Collection collection = new ArrayList();

		// -- NO INHERITANCE
		// TODO SECOND -------> Uncomment and make it work, rewrite message signature if needed

		// thisWillNotWork(collection);

		// -- LOWER BOUNDS
		Collection<Base1> upperboundCollection = new ArrayList<Base1>();
		upperboundCollection.add(new Base1());
		// TODO THIRD --------> Make it work, rewrite message signature if needed
		// thisWillNotWorkEither(upperboundCollection);

	}

	public void thisWillNotWork(Collection<Object> collection) {
	}

	public void thisWillNotWorkEither(Collection<?> collection) {
		// collection.add(new Base2());
	}
}