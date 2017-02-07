/**
 * 
 */
package rmscott.fantasy.thread;

import rmscott.fantasy.bean.Player;

/**
 * @author rmscott
 *
 */
public class PlayerNotifier implements Runnable {
	static final String RUN_METHOD = "PlayerNotifier.run() : ";

	private Player player;

	public PlayerNotifier(Player pPlayer) {
		this.player = pPlayer;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " started");
		StringBuilder sb = new StringBuilder(RUN_METHOD);
		sb.append(threadName);
		sb.append(" - started - ");
		sb.append(new java.util.Date());
		System.out.println(sb);
		
		try {
			Thread.sleep(1000);
			synchronized (this.player) {
				sb = new StringBuilder(RUN_METHOD);
				sb.append(threadName);
				sb.append(" - Notifier work done - ");
				sb.append(new java.util.Date());
				System.out.println(sb);
				this.player.notify();
				// this.player..notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	} // end of run()
}
