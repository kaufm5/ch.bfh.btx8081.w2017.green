package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Broadcaster implements Serializable {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public interface BroadcastListener {
	void receiveBroadcast(String message);
    }

    private static LinkedList<BroadcastListener> listeners = new LinkedList<BroadcastListener>();

    public static synchronized void register(BroadcastListener listener) {
	Broadcaster.listeners.add(listener);
    }

    public static synchronized void unregister(BroadcastListener listener) {
	Broadcaster.listeners.remove(listener);
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