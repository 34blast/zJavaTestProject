/**
 * 
 */
package rmscott.fantasy.thread;

import rmscott.fantasy.bean.Player;

/**
 * @author rmscott
 *
 */
public class PlayerWaiter implements Runnable {
	static final String RUN_METHOD = "PlayerWaiter.run() : ";

	private Player player = null;

	public PlayerWaiter(Player pPlayer) {
		this.player = pPlayer;
	}

	public void run() {

		String threadName = Thread.currentThread().getName();
		try {
			synchronized (this.player) {
				StringBuilder sb = new StringBuilder(RUN_METHOD);
				sb.append(threadName);
				sb.append(" - waiting to get notified at time: ");
				sb.append(new java.util.Date());
				System.out.println(sb);
                player.wait();
			}
			
		} catch (InterruptedException e) {
			StringBuilder sb = new StringBuilder(RUN_METHOD);
			sb.append("my thread interrupted");
			sb.append(" : ");
			sb.append(new java.util.Date());
			System.out.println(sb);
		}
		StringBuilder sb = new StringBuilder(RUN_METHOD);
		sb.append("mythread run is over");
		sb.append(" : ");
		sb.append(new java.util.Date());
		System.out.println(sb);
		
	} // end of run
}
