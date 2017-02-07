package rmscott.fantasy.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rmscott.fantasy.bean.Person;
import rmscott.util.StringValidator;

public class PersonThread extends Thread {

	static final String CONSTRUCTOR_METHOD = "PlayerWaiter.PersonThread() : ";
	static final String RUN_METHOD = "PersonThread.run() : ";

	static private List<Person> allPersons = new ArrayList<Person>();
	static private Map<String, List<Person>> workingMap = new HashMap<String, List<Person>>();

	synchronized static public List<Person> getPersons() {
		return allPersons;
	}
	synchronized static public void addToList(Person pPerson) {
		System.out.println("Adding Person : " + pPerson.getId());
		PersonThread.allPersons.add(pPerson);
	}

	synchronized static public void removeFromList(Person pPerson) {
		System.out.println("Removing Person : " + pPerson.getId());
		PersonThread.allPersons.remove(pPerson);
	}

	public PersonThread(String pThreadName, List<Person> pPersons) {
		super(pThreadName);
		PersonThread.workingMap.put(pThreadName, pPersons);
		StringBuilder sb = new StringBuilder(CONSTRUCTOR_METHOD);
		sb.append("PersonThread created ");
		sb.append(StringValidator.EOL);
		sb.append(this);
		System.out.println(sb);
		start();
	}

	/**
	 * Remove persons with no middle name from the array
	 */
	public void run() {
		System.out.println("IN Run Method, thread name : " + this.getName());
		try {
			List<Person> threadList = workingMap.get(this.getName());
			if( threadList == null || threadList.size() < 1) return;
			for (Person p : threadList) {
				if (!StringValidator.isEmpty(p.getMiddleName())) {
					PersonThread.addToList(p);
					System.out.println("added : " + p.getId());
				}
				sleep(100);
			}
		} catch (InterruptedException e) {
			StringBuilder sb = new StringBuilder(RUN_METHOD);
			sb.append("interrupted : ");
			System.out.println(sb);
			System.out.println("my thread interrupted");
		}
		StringBuilder sb = new StringBuilder(RUN_METHOD);
		sb.append("thread over");
		System.out.println(sb);
	}

}
