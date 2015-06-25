package vertx;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;

import java.util.concurrent.CompletableFuture;

public class AppServer {

	public static AppServer ref;

	public AppServer() {
		ref = this;

		VertxOptions vertxOptions = new VertxOptions();

		this.vertx = Vertx.vertx(vertxOptions);
		this.router = Router.router(vertx);
	}

	public void start() {
		CompletableFuture<Void> serversFuture = deployServerVerticles(10);
		serversFuture.join();

		serversFuture = deployBarVerticles(10);
		serversFuture.join();

		System.out.println("Server is up and ready");
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

	protected CompletableFuture<Void> deployBarVerticles(int numberOfBarVerticles) {
		CompletableFuture<Void>[] allFutures =
			new CompletableFuture[numberOfBarVerticles];

		for (int verticleId = 0; verticleId < numberOfBarVerticles; verticleId++) {
			Verticle verticle = new BarVerticle();

			CompletableFuture<Void> deployFuture = new CompletableFuture<>();

			allFutures[verticleId] = deployFuture;

			vertx.deployVerticle(verticle, event -> {
					deployFuture.complete(null);
				}
			);
		}

		return CompletableFuture.allOf(allFutures);
	}

	public final Router router;
	public final Vertx vertx;

}