package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Broadcaster implements Serializable {
	static ExecutorService executorService = Executors.newSingleThreadExecutor();
	private static final Set<BroadcastListener> listeners = new LinkedHashSet<BroadcastListener>();

	public interface BroadcastListener {
		void receiveBroadcast(String message);
	}

	public static synchronized void register(BroadcastListener listener) {
		Broadcaster.listeners.add(listener);
	}

	public static synchronized void unregister(BroadcastListener listener) {
		Broadcaster.listeners.remove(listener);
	}

	public static synchronized boolean isRegisered(BroadcastListener listener) {
		return Broadcaster.listeners.contains(listener);
	}

	public static synchronized void broadcast(final String message) {
		for (final BroadcastListener listener : Broadcaster.listeners) {
			Broadcaster.executorService.execute(new Runnable() {
				@Override
				public void run() {
					listener.receiveBroadcast(message);
				}
			});
		}
	}
}