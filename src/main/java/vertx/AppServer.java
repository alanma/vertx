package vertx;

import io.vertx.core.DeploymentOptions;
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
		CompletableFuture<Void> serversFuture = deployServerVerticles();

		serversFuture.join();

		System.out.println("Server is up");
	}

	@SuppressWarnings("unchecked")
	protected CompletableFuture<Void> deployServerVerticles() {

		int numberOfServerVerticles = 10;

		CompletableFuture<Void>[] allFutures =
			new CompletableFuture[numberOfServerVerticles];

		int verticleId = 0;

		while (numberOfServerVerticles-- > 0) {
			DeploymentOptions deploymentOptions = new DeploymentOptions();

			Verticle verticle = new ServerVerticle(++verticleId);

			CompletableFuture<Void> deployFuture = new CompletableFuture<>();

			allFutures[numberOfServerVerticles] = deployFuture;

			vertx.deployVerticle(verticle, deploymentOptions, event -> {
					deployFuture.complete(null);
				}
			);
		}

		return CompletableFuture.allOf(allFutures);
	}

	private final Vertx vertx;
}