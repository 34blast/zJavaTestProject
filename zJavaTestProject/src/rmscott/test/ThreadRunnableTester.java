/**
 * 
 */
package rmscott.test;

import java.util.ArrayList;
import java.util.List;

import rmscott.fantasy.bean.Player;
import rmscott.fantasy.thread.PlayerNotifier;
import rmscott.fantasy.thread.PlayerWaiter;

/**
 * @author rmscott
 *
 */
public class ThreadRunnableTester {

	static final public String TEST_PLAYER_METHOD = "ThreadTester.testPlayerRunnable() : ";
	static final public String MAIN_METHOD = "ThreadTester.main() : ";

	public ThreadRunnableTester() {

	}

	public void testPlayerRunnable() {
		Player player = ThreadRunnableTester.initializePlayer("-1-");

		PlayerWaiter waiter1 = new PlayerWaiter(player);
		new Thread(waiter1, "waiter1").start();

		PlayerWaiter waiter2 = new PlayerWaiter(player);
		new Thread(waiter2, "waiter2").start();

		PlayerNotifier notifier = new PlayerNotifier(player);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");

	}

	static Player initializePlayer(String pUniqueVar) {
		Player player = new Player();
		player.setId(pUniqueVar);
		player.setFirstName("firstName");
		player.setLastName("lastName");
		player.setMiddleName("middleName");
		player.setPosition("WR");
		player.setRating(88.0f);
		player.setLastUpdated(System.currentTimeMillis());
		
		return player;
	}

	static List<Player> initializePlayers(String pUniqueVar, int pCount) {
		List<Player> players = new ArrayList<Player>();
		for (int idx = 0; idx < pCount; idx++) {
			String uniqueId = pUniqueVar + idx;
			players.add(ThreadRunnableTester.initializePlayer(uniqueId));
		}
		return players;
	}

	static public void printPersons(List<Player> pPlayers, String pText) {
		System.out.println(pText);
		System.out.println("-----------------------------------------");
		int len = pPlayers.size();
		for (int idx = 0; idx < len; idx++) {
			Player player = pPlayers.get(idx);
			System.out.println(player);
		}
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadRunnableTester tester = new ThreadRunnableTester();
		tester.testPlayerRunnable();
	}

}
