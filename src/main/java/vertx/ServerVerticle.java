package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.TimeoutHandler;

public class ServerVerticle extends AbstractVerticle {

	public ServerVerticle(int verticleId) {
		this.verticleId = verticleId;

		System.out.println("ServerVerticle #" + verticleId);
	}

	@Override
	public void start() {
		HttpServerOptions httpServerOptions = new HttpServerOptions();

		httpServerOptions.setCompressionSupported(true);

		server = vertx.createHttpServer(httpServerOptions);

		setupRoutes();

		server
			.requestHandler(AppServer.ref.router::accept)
			.listen(8080, event -> {
			if (!event.succeeded()) {
				System.out.println("Error starting server " + event.cause());
			}
		});

		System.out.println("ServerVerticle: " + verticleId + " started on "
			+ Thread.currentThread().getId() + " [" + Thread.currentThread().getName() + "]");
	}

	/**
	 * Setup routers.
	 */
	protected Router setupRoutes() {
		//router = Router.router(vertx);
		Router router = AppServer.ref.router;

		router.route().failureHandler(routingContext -> {
			System.out.println("## ERROR " + routingContext.statusCode());

			Throwable throwable = routingContext.failure();

			if (throwable != null) {
				throwable.printStackTrace();
			}
		});

		router
			.route()
			.handler(TimeoutHandler.create(5000));

		router
			.route(HttpMethod.GET, "/foo")
			.handler(new FooHandler());

		router
			.route(HttpMethod.GET, "/foo2")
			.handler(new Foo2Handler());

		router
			.route(HttpMethod.GET, "/foo3")
			.handler(new Foo3Handler());

//		router
//			.route(HttpMethod.GET, "/bar")
//			.handler(new BarHandler());

		return router;
	}

	protected HttpServer server;

	private final int verticleId;
}