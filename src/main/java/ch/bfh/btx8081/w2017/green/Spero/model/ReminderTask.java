package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.TimerTask;

public class ReminderTask extends TimerTask {

		public String name;
		private int loop = 5;
		
		ReminderTask(String name){
			this.name = name;
			run();
		}
		 
		public void run() {
			if (loop > 0) {
				System.out.println("Einnehmen: " + name);
				loop--;
			} else {
				System.out.format("\nThat's it.. Done..!");
				ReminderModel.timer.cancel();
			}
		}

}
