package vertx;

public class Runner {

	public static void main(String[] args) {

		AppServer appServer = new AppServer();

		appServer.start();

		try {
			Thread.sleep(Long.MAX_VALUE);
		}
		catch (InterruptedException ignore) {
		}
	}
}