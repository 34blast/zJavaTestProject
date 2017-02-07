/**
 * Richard M. Scott prototyping code
 */
package rmscott.fantasy.bean;

import java.util.Comparator;

import rmscott.util.StringValidator;

/**
 * @author rmscott
 *
 */
public class PersonNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person pOne, Person pTwo) {
		final int EQUAL = 0;

		// this optimization is usually worthwhile, and can
		// always be added
		if (pOne == pTwo)
			return EQUAL;

		int comparision = StringValidator.compareToIgnoreCase(pOne.getLastName(), pTwo.getLastName());
		if (comparision != EQUAL) {
			return comparision;
		}

		comparision = StringValidator.compareToIgnoreCase(pOne.getFirstName(), pTwo.getFirstName());
		if (comparision != EQUAL) {
			return comparision;
		}

		comparision = StringValidator.compareTo(pOne.getId(), pTwo.getId());
		if (comparision != EQUAL) {
			return comparision;
		}

		// all comparisons have yielded equality
		// verify that compareTo is consistent with equals (optional)
		assert pOne.equals(pTwo) : "compareTo inconsistent with equals.";

		return EQUAL;

	} // end of compare
}
