/**
 * RMSCOTT - prototyping
 */
package rmscott.fantasy.bean;

import java.io.Serializable;

import rmscott.util.StringValidator;

/**
 * @author rmscott
 *
 */
public class Player extends Person implements Comparable<Person>, Serializable {
	private static final long serialVersionUID = 1800843872271145513L;

	private String position = null;
	private float rating = 0;
	private long lastUpdated = 0;

	/**
	 * Gets the property position
	 * 
	 * @return String
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Sets the property position
	 * 
	 * @param pPosition
	 *            - variable containing the new value for position to set
	 */
	public void setPosition(String pPosition) {
		this.position = pPosition;
	}

	/**
	 * Gets the property rating
	 * 
	 * @return float
	 */
	public float getRating() {
		return this.rating;
	}

	/**
	 * Sets the property rating
	 * 
	 * @param pRating
	 *            - variable containing the new value for rating to set
	 */
	public void setRating(float pRating) {
		this.rating = pRating;
	}

	/**
	 * Getter for last update.
	 * 
	 * @return
	 */
	public long getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Setter for last update.
	 * 
	 * @param pLastUPdated
	 */
	public void setLastUpdated(long pLastUPdated) {
		this.lastUpdated = pLastUPdated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.position == null) ? 0 : this.position.hashCode());
		result = prime * result + Float.floatToIntBits(this.rating);
		result = prime * result + Long.valueOf(this.lastUpdated).hashCode();

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (this.position == null) {
			if (other.position != null)
				return false;
		} else if (!this.position.equals(other.position))
			return false;
		if (Float.floatToIntBits(this.rating) != Float.floatToIntBits(other.rating))
			return false;
		if (this.lastUpdated != other.lastUpdated)
			return false;
		return true;
	}

	@Override
	public int compareTo(Person pOther) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		Player otherPlayer = null;

		// this optimization is usually worthwhile, and can
		// always be added
		if (this == pOther)
			return EQUAL;

		if (pOther instanceof Player) {
			otherPlayer = (Player) pOther;
		} else {
			return BEFORE;
		}
		int comparision = 0;

		comparision = super.compareTo(pOther);
		if (comparision != EQUAL) {
			return comparision;
		}

		comparision = StringValidator.compareToIgnoreCase(this.position, otherPlayer.position);
		if (comparision != EQUAL) {
			return comparision;
		}

		Float oneRating = new Float(this.getRating());
		Float twoRating = new Float(otherPlayer.getRating());
		comparision = twoRating.compareTo(oneRating);
		if (comparision != EQUAL) {
			return comparision;
		}

		if 	( this.lastUpdated < otherPlayer.lastUpdated) return BEFORE;
		if 	( this.lastUpdated > otherPlayer.lastUpdated) return AFTER;
	    
		// all comparisons have yielded equality
		// verify that compareTo is consistent with equals (optional)
		assert this.equals(pOther) : "compareTo inconsistent with equals.";

		return EQUAL;

	} // end of compareTo

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Player [position=");
		sb.append(this.position);
		sb.append(", rating=");
		sb.append(rating);
		sb.append("]");
		sb.append(StringValidator.EOL);
		sb.append("    ");
		sb.append(super.toString());

		return sb.toString();
	}

}
