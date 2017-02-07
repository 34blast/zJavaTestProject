/**
 * 
 */
package rmscott.test;

import java.util.ArrayList;
import java.util.List;

import rmscott.fantasy.bean.Person;
import rmscott.fantasy.thread.PersonThread;

/**
 * @author rmscott
 *
 */
public class ThreadTester {

	static final public String TEST_PERSON_METHOD = "ThreadTester.testPersonThread() : ";
	static final public String MAIN_METHOD = "ThreadTester.main() : ";

	public ThreadTester() {

	}


	public void testPersonThread() {
		List<Person> personsOne = ThreadTester.initializePersons("-1-", 20);
		List<Person> personsTwo = ThreadTester.initializePersons("-2-", 10);
		List<Person> personsThree = ThreadTester.initializePersons("-3-", 20);
		List<Person> personsFour = ThreadTester.initializePersons("-4-", 10);
		List<Person> personsFive = ThreadTester.initializePersons("-5-", 10);
		PersonThread thread1 = new PersonThread("thread1", personsOne);
		PersonThread thread2 = new PersonThread("thread2", personsTwo);
		PersonThread thread3 = new PersonThread("thread3", personsThree);
		PersonThread thread4 = new PersonThread("thread4", personsFour);
		PersonThread thread5 = new PersonThread("thread5", personsFive);
		try {
			while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive() || thread5.isAlive()  ) {
				StringBuilder sb = new StringBuilder(TEST_PERSON_METHOD);
				sb.append("Main thread will be alive till the child thread is live, sleep now : ");
				System.out.println(sb.toString());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			StringBuilder sb = new StringBuilder(TEST_PERSON_METHOD);
			sb.append("Main thread interrupted : ");
			System.out.println(sb.toString());
		}
		StringBuilder sb = new StringBuilder(TEST_PERSON_METHOD);
		sb.append("Main thread run is over : ");
		sb.append(new java.util.Date());
		System.out.println();
		ThreadTester.printPersons(PersonThread.getPersons(), "Modified List");
	}

	static List<Person> initializePersons(String pUniqueVar, int pCount) {
		List<Person> persons = new ArrayList<Person>();
		Person person = null;
		for (int idx = 0; idx < pCount; idx++) {
			person = new Person();
			String uniqueId = pUniqueVar + idx;
			person.setId(uniqueId);
			person.setFirstName("firstName" + uniqueId);
			person.setLastName("lastName" + uniqueId);
			if ((idx % 2) == 0) {
				person.setMiddleName("middleName" + uniqueId);
			}
			persons.add(person);
		}
		return persons;
	}

	static public void printPersons(List<Person> pPersons, String pText) {
		System.out.println(pText);
		System.out.println("-----------------------------------------");
		int len = pPersons.size();
		for (int idx = 0; idx < len; idx++) {
			Person person = pPersons.get(idx);
			System.out.println(person);
		}
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadTester tester = new ThreadTester();
		tester.testPersonThread();
	}

}
