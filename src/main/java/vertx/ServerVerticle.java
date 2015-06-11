package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.TimeoutHandler;

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
	 * Setup routers.
	 */
	protected Router setupRouter() {
		router = Router.router(vertx);

		router
			.route()
			.handler(TimeoutHandler.create(5000));

		router
			.route(HttpMethod.GET, "/foo")
			.handler(new FooHandler());

		router
			.route(HttpMethod.GET, "/bar")
			.handler(new BarHandler());

		return router;
	}

	protected Router router;
	protected HttpServer server;

}