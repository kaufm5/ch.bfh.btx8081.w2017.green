package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.TimerTask;

public class ReminderTask extends TimerTask {

		int loop = 5;
		 
		public void run() {
			if (loop > 0) {
				System.out.format("Knock Knock..!\n");
				loop--;
			} else {
				System.out.format("\nThat's it.. Done..!");
				ReminderModel.timer.cancel();
			}
		}

}
