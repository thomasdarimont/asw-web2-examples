package de.asw.java.training2016.basics;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExamples {

	public static void main(String[] args) {

		System.out.println("Warte!");

		try {
			// Alternative 1 (Sprechende API)
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Alternative 2: (Java Standard)
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// Alternative 3 (Advanced Java)
		// LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));

		System.out.println("Fertig!");
	}
}
