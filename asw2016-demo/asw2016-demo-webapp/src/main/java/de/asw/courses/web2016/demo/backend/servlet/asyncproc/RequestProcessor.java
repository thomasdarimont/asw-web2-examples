package de.asw.courses.web2016.demo.backend.servlet.asyncproc;

enum RequestProcessor {

	INSTANCE;

	String process(String input) {
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return System.currentTimeMillis() + " processed: " + input;
	}
}
