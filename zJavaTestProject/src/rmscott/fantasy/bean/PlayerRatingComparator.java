
/**
 * RMSCOTT - prototyping
 */
package rmscott.fantasy.bean;

import java.util.Comparator;

import rmscott.util.StringValidator;

public class PlayerRatingComparator implements Comparator<Player> {

	/**
	 * Sort by highest ranking then by other parameters
	 */
	@Override
	public int compare(Player pOne, Player pTwo) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		// this optimization is usually worthwhile, and can
		// always be added
		if (pOne == pTwo) {
			return EQUAL;
		}

		int comparision = 0;
		
		Float oneRating = new Float(pOne.getRating());
		Float twoRating = new Float(pTwo.getRating());
		comparision = twoRating.compareTo(oneRating);
		if (comparision != EQUAL) {
			return comparision;
		}
		
		comparision = StringValidator.compareToIgnoreCase(pOne.getPosition(), pTwo.getPosition());
		if (comparision != EQUAL) {
			return comparision;
		}

		PersonNameComparator superComparator = new PersonNameComparator();
		comparision = superComparator.compare(pOne, pTwo);
		if (comparision != EQUAL) {
			return comparision;
		}

		if 	( pOne.getLastUpdated() < pTwo.getLastUpdated()) return BEFORE;
		if 	( pOne.getLastUpdated() > pTwo.getLastUpdated()) return AFTER;

		// all comparisons have yielded equality
		// verify that compareTo is consistent with equals (optional)
		assert pOne.equals(pTwo) : "compareTo inconsistent with equals.";

		return EQUAL;

	} // end of compare

}
