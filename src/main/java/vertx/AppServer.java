package vertx;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.concurrent.CompletableFuture;

public class AppServer {
	public AppServer() {
		VertxOptions vertxOptions = new VertxOptions();

		this.vertx = Vertx.vertx(vertxOptions);
	}

	public void start() {
		CompletableFuture<Void> serversFuture = deployServerVerticles(10);

		serversFuture.join();

		System.out.println("Server is up");
	}

	@SuppressWarnings("unchecked")
	protected CompletableFuture<Void> deployServerVerticles(int numberOfServerVerticles) {

		CompletableFuture<Void>[] allFutures =
			new CompletableFuture[numberOfServerVerticles];

		for (int verticleId = 0; verticleId < numberOfServerVerticles; verticleId++) {
			Verticle verticle = new ServerVerticle(verticleId);

			CompletableFuture<Void> deployFuture = new CompletableFuture<>();

			allFutures[verticleId] = deployFuture;

			vertx.deployVerticle(verticle, event -> {
					deployFuture.complete(null);
				}
			);
		}

		return CompletableFuture.allOf(allFutures);
	}

	private final Vertx vertx;
}