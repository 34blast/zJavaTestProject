/**
 * RMSCOTT - prototyping
 */
package rmscott.fantasy.bean;

import java.io.Serializable;

import rmscott.util.StringValidator;

public class Person implements Comparable<Person>, Serializable {

	private static final long serialVersionUID = 6587059318861246693L;

	static final int US_MEASURES = 1;
	static final int METRIC_MEASURES = 2;

	private String id = null;
	private String firstName = null;
	private String middleName = null;
	private String lastName = null;

	/**
	 * Gets the property id
	 * 
	 * @return String
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the property id
	 * 
	 * @param pId
	 *            - variable containing the new value for id to set
	 */
	public void setId(String pId) {
		this.id = pId;
	}

	/**
	 * Gets the property firstName
	 * 
	 * @return String
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets the property firstName
	 * 
	 * @param pFirstName
	 *            - variable containing the new value for firstName to set
	 */
	public void setFirstName(String pFirstName) {
		this.firstName = pFirstName;
	}

	/**
	 * Gets the property lastName
	 * 
	 * @return String
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets the property lastName
	 * 
	 * @param pLastName
	 *            - variable containing the new value for lastName to set
	 */
	public void setLastName(String pLastName) {
		this.lastName = pLastName;
	}
	
	/**
	 * Gets the property middleName
	 * 
	 * @return String
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * Sets the property middleName
	 * 
	 * @param pMiddleName
	 *            - variable containing the new value for middleName to set
	 */
	public void setMiddleName(String pMiddleName) {
		this.middleName = pMiddleName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Person other = (Person) obj;
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		
		if (middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!middleName.equals(other.middleName)) {
			return false;
		}

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Person pOther) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		Person otherPerson = null;

		// this optimization is usually worthwhile, and can
		// always be added
		if (this == pOther)
			return EQUAL;

		if (!(pOther instanceof Person)) {
			return BEFORE;
		} else {
			otherPerson = pOther;
		}

		String oneClassName = this.getClass().getName();
		String twoClassName = pOther.getClass().getName();
		if( !oneClassName.equals(twoClassName)) {
			return AFTER;
		}
		

		int comparision = 0;
		comparision = StringValidator.compareTo(this.id, otherPerson.id);
		if (comparision != EQUAL) {
			return comparision;
		}

		comparision = StringValidator.compareToIgnoreCase(this.lastName, otherPerson.lastName);
		if (comparision != EQUAL) {
			return comparision;
		}

		comparision = StringValidator.compareToIgnoreCase(this.firstName, otherPerson.firstName);
		if (comparision != EQUAL) {
			return comparision;
		}

		comparision = StringValidator.compareToIgnoreCase(this.middleName, otherPerson.middleName);
		if (comparision != EQUAL) {
			return comparision;
		}

		// all comparisons have yielded equality
		// verify that compareTo is consistent with equals (optional)
		assert this.equals(pOther) : "compareTo inconsistent with equals.";

		return EQUAL;

	} // end of compareTo

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Person [id=");
		sb.append(this.id);
		sb.append(", firstName=");
		sb.append(this.firstName);
		sb.append(", lastName=");
		sb.append(this.lastName);
		sb.append(", middleName=");
		sb.append(this.middleName);
		sb.append("]");

		return sb.toString();

	}

}
