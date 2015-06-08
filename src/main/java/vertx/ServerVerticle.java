package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;

public class ServerVerticle extends AbstractVerticle {

	@Override
	public void start() {
		HttpServerOptions httpServerOptions = new HttpServerOptions();

		httpServerOptions.setCompressionSupported(true);

		server = vertx.createHttpServer(httpServerOptions);

		setupRouter();

		server
			.requestHandler(router::accept)
			.listen(8080, event -> {
				if (!event.succeeded()) {
					System.out.println("Error starting server " + event.cause());
				}
			});
	}

	/**
	 * Setup routers, based on configuration.
	 */
	protected Router setupRouter() {
		router = Router.router(vertx);

		router
			.route(HttpMethod.GET, "/admin")
			.blockingHandler(new AdminHandler());

		return router;
	}

	protected Router router;
	protected HttpServer server;

}